package run;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.compsys704.*;

public class GUI implements Runnable {
	private JFrame frame;
	private JPanel conveyorPanel, rotaryTablePanel, capperPanel, fillerPanel;
	private JToggleButton[] sensorButtons;
	private String[] sensorNames = {
			"bottleAtPos1", "bottleLeftPos5", "tableAlignedWithSensor", "bottleAtPos5",
			"capOnBottleAtPos1", "bottleAtPos2", "bottleAtPos4", "gripperZAxisLowered",
			"gripperZAxisLifted", "gripperTurnHomePos", "gripperTurnFinalPos",
			"dosUnitEvac", "dosUnitFilled", "bottleFull"
	};

	@Override
	public void run() {
		SwingUtilities.invokeLater(this::createAndShowGUI);
	}

	private void createAndShowGUI() {
		frame = new JFrame("ABS Simulation GUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setLayout(new GridLayout(2, 1));

		// Panel for model status
		JPanel modelPanel = new JPanel(new GridLayout(2, 2));
		conveyorPanel = createModelPanel("Conveyor", new String[]{"Motor"});
		rotaryTablePanel = createModelPanel("Rotary Table", new String[]{"Motor"});
		capperPanel = createModelPanel("Capper", new String[]{"Z-Axis", "Gripper", "Turn"});
		fillerPanel = createModelPanel("Filler", new String[]{"Valve", "Inlet", "Canister"});
		modelPanel.add(conveyorPanel);
		modelPanel.add(rotaryTablePanel);
		modelPanel.add(capperPanel);
		modelPanel.add(fillerPanel);
		frame.add(modelPanel);

		// Panel for sensor controls
		JPanel sensorPanel = new JPanel(new GridLayout(0, 4));
		sensorButtons = new JToggleButton[sensorNames.length];
		for (int i = 0; i < sensorNames.length; i++) {
			sensorButtons[i] = new JToggleButton(sensorNames[i]);
			sensorButtons[i].addActionListener(new SensorActionListener(sensorNames[i]));
			sensorPanel.add(sensorButtons[i]);
		}
		frame.add(sensorPanel);

		frame.setVisible(true);
	}

	private JPanel createModelPanel(String name, String[] components) {
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder(name));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		for (String component : components) {
			JLabel label = new JLabel(component + ": Idle");
			panel.add(label);
		}
		return panel;
	}

	private class SensorActionListener implements ActionListener {
		private String sensorName;

		public SensorActionListener(String sensorName) {
			this.sensorName = sensorName;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			JToggleButton button = (JToggleButton) e.getSource();
			boolean isActivated = button.isSelected();
			System.out.println(sensorName + " is " + (isActivated ? "activated" : "deactivated"));
			// Send signal to SystemJ code
			sendSensorSignal(sensorName, isActivated);
		}
	}

	// Method to send sensor signals to SystemJ code
	private void sendSensorSignal(String sensorName, boolean isActivated) {
		// Implement the logic to send signals to SystemJ code

	}

	// Method to update model status
	public void updateModelStatus(String model, String component, String status) {
		SwingUtilities.invokeLater(() -> {
			JPanel panel = getPanelForModel(model);
			if (panel != null) {
				for (Component comp : panel.getComponents()) {
					if (comp instanceof JLabel && ((JLabel) comp).getText().startsWith(component)) {
						((JLabel) comp).setText(component + ": " + status);
						break;
					}
				}
			}
		});
	}

	private JPanel getPanelForModel(String model) {
		switch (model) {
			case "Conveyor": return conveyorPanel;
			case "Rotary Table": return rotaryTablePanel;
			case "Capper": return capperPanel;
			case "Filler": return fillerPanel;
			default: return null;
		}
	}

	// Method to be called by SystemJ code to get sensor status
	public boolean getSensorStatus(String sensorName) {
		for (JToggleButton button : sensorButtons) {
			if (button.getText().equals(sensorName)) {
				return button.isSelected();
			}
		}
		return false;
	}

	public static void main(String[] args) {
		new GUI().run();
	}
}