package run;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.compsys704.*;
import java.util.*;

public class GUI implements Runnable {
	private JFrame frame;
	private Map<String, JPanel> modelPanels = new HashMap<>();
	private Map<String, JToggleButton> inputSignals = new HashMap<>();
	private Map<String, JLabel> modelIndicators = new HashMap<>();

	private static final String[][] MODEL_COMPONENTS = {
			{"Conveyor", "Motor"},
			{"Rotary Table", "Motor"},
			{"Capper", "Z-Axis", "Gripper", "Turn"},
			{"Filler", "Valve", "Inlet", "Canister"}
	};

	private static final String[][] MODEL_SIGNALS = {
			{"Conveyor", "bottleAtPos1", "bottleLeftPos5", "motConveyorOnOff"},
			{"Rotary Table", "tableAlignedWithSensor", "move2NextPos", "rotaryTableTrigger"},
			{"Capper", "bottleAtPos4", "gripperZAxisLowered", "gripperZAxisLifted", "gripperTurnHomePos", "gripperTurnFinalPos",
					"cylPos5ZaxisExtend", "gripperTurnRetract", "gripperTurnExtend", "capGripperPos5Extend", "cylClampBottleExtend"},
			{"Filler", "bottleAtPos2", "dosUnitEvac", "dosUnitFilled", "valveInjectorOnOff", "valveInletOnOff", "dosUnitValveRetract", "dosUnitValveExtend"}
	};

	public void run() {
		SwingUtilities.invokeLater(() -> {
			createAndShowGUI();
			new Thread(() -> org.compsys704.CapLoader.main(null)).start();
		});
	}

	private void createAndShowGUI() {
		frame = new JFrame("Automated Bottling System");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 800);
		frame.setLayout(new GridLayout(2, 2, 10, 10));

		for (String[] modelInfo : MODEL_SIGNALS) {
			createModelPanel(modelInfo[0], Arrays.copyOfRange(modelInfo, 1, modelInfo.length));
		}

		frame.setVisible(true);
	}

	private void createModelPanel(String modelName, String[] signals) {
		JPanel panel = new JPanel(new BorderLayout(5, 5));
		panel.setBorder(BorderFactory.createTitledBorder(modelName));

		JPanel componentsPanel = new JPanel(new GridLayout(0, 1, 5, 5));
		for (String[] model : MODEL_COMPONENTS) {
			if (model[0].equals(modelName)) {
				for (int i = 1; i < model.length; i++) {
					JLabel label = new JLabel(model[i] + ": Idle");
					label.setName(model[i]);  // 设置组件名称，用于后续更新状态
					componentsPanel.add(label);
				}
				break;
			}
		}
		panel.add(componentsPanel, BorderLayout.NORTH);

		JPanel signalsPanel = new JPanel(new GridLayout(0, 1, 5, 5));
		for (String signal : signals) {
			if (!isOutputSignal(signal)) {
				JToggleButton toggleButton = new JToggleButton(signal);
				toggleButton.addActionListener(e -> {
					boolean isOn = toggleButton.isSelected();
					System.out.println(signal + " set to " + (isOn ? "ON" : "OFF"));
					processSignal(modelName, signal, isOn);  // 新增的信号处理逻辑
				});
				inputSignals.put(signal, toggleButton);
				signalsPanel.add(toggleButton);
			}
		}
		panel.add(signalsPanel, BorderLayout.CENTER);

		JLabel indicator = new JLabel("Status: OFF");
		indicator.setOpaque(true);
		indicator.setBackground(Color.RED);
		indicator.setHorizontalAlignment(JLabel.CENTER);
		modelIndicators.put(modelName, indicator);
		panel.add(indicator, BorderLayout.SOUTH);

		modelPanels.put(modelName, panel);
		frame.add(panel);
	}

	private void processSignal(String modelName, String signal, boolean isOn) {
		switch (modelName) {
			case "Conveyor":
				if ("bottleAtPos1".equals(signal) || "bottleLeftPos5".equals(signal)) {
					updateOutputSignal("motConveyorOnOff", isOn);
				}
				break;
			case "Rotary Table":
				if ("tableAlignedWithSensor".equals(signal) || "move2NextPos".equals(signal)) {
					updateOutputSignal("rotaryTableTrigger", isOn);
				}
				break;
			case "Capper":
				if (Arrays.asList("bottleAtPos4", "gripperZAxisLowered", "gripperZAxisLifted", "gripperTurnHomePos", "gripperTurnFinalPos").contains(signal)) {
					updateOutputSignal("cylPos5ZaxisExtend", isOn);
					updateOutputSignal("gripperTurnExtend", isOn);
					updateOutputSignal("capGripperPos5Extend", isOn);
					updateOutputSignal("cylClampBottleExtend", isOn);
				}
				break;
			case "Filler":
				if (Arrays.asList("bottleAtPos2", "dosUnitEvac", "dosUnitFilled").contains(signal)) {
					updateOutputSignal("valveInjectorOnOff", isOn);
					updateOutputSignal("valveInletOnOff", isOn);
					updateOutputSignal("dosUnitValveRetract", isOn);
				}
				break;
		}
	}

	public void updateOutputSignal(String signalName, boolean isOn) {
		SwingUtilities.invokeLater(() -> {
			for (String[] modelInfo : MODEL_SIGNALS) {
				String modelName = modelInfo[0];
				if (Arrays.asList(modelInfo).contains(signalName)) {
					JLabel indicator = modelIndicators.get(modelName);
					if (indicator != null) {
						boolean anySignalOn = isOn || Arrays.stream(modelInfo)
								.skip(1)
								.filter(this::isOutputSignal)
								.anyMatch(s -> getInputSignalStatus(s));
						indicator.setText("Status: " + (anySignalOn ? "ON" : "OFF"));
						indicator.setBackground(anySignalOn ? Color.GREEN : Color.RED);
					}
					updateComponentStatus(modelName, signalName, isOn);
					break;
				}
			}
		});
	}

	private void updateComponentStatus(String modelName, String signalName, boolean isOn) {
		JPanel panel = modelPanels.get(modelName);
		if (panel != null) {
			Component[] components = ((JPanel)panel.getComponent(0)).getComponents();
			for (Component comp : components) {
				if (comp instanceof JLabel && ((JLabel) comp).getName().equals(getComponentName(signalName))) {
					((JLabel) comp).setText(getComponentName(signalName) + ": " + (isOn ? "Active" : "Idle"));
					break;
				}
			}
		}
	}

	private boolean isOutputSignal(String signal) {
		return signal.endsWith("OnOff") || signal.startsWith("mot") || signal.equals("rotaryTableTrigger")
				|| signal.startsWith("cyl") || signal.startsWith("gripper") || signal.startsWith("valve");
	}

	private String getComponentName(String signalName) {
		// 这里可以根据实际信号与组件的对应关系返回相应的组件名
		if (signalName.startsWith("mot")) {
			return "Motor";
		} else if (signalName.startsWith("valve")) {
			return "Valve";
		} else if (signalName.startsWith("gripper")) {
			return "Gripper";
		}
		// 根据信号名称自定义更多映射关系
		return signalName;
	}

	public boolean getInputSignalStatus(String signalName) {
		JToggleButton button = inputSignals.get(signalName);
		return button != null && button.isSelected();
	}

	public static void main(String[] args) {
		new GUI().run();
	}
}
