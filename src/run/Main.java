package run;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

class CheckBoxActionCallback implements ActionListener {

    private final String signalName;

    public CheckBoxActionCallback(String signalName) {

        this.signalName = signalName;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.printf("%s: %s\n", signalName, ((JCheckBox)e.getSource()).isSelected() ? "ON" : "OFF");
    }
}

public class Main {
    public static JPanel currPanel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Equipment Control");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(599, 400);

        String[] rotaryTableSwitches = {"tableAlignedWithSensor", "bottleAtPos4", "capOnBottleAtPos1"};
        Action[] rotaryActions = new Action[rotaryTableSwitches.length];
        String[] rotaryTableLights = {"rotaryTableTrigger", "rotaryIdle"};
        JPanel panel0 = createPanel("RotaryTable", rotaryTableSwitches, rotaryTableLights, rotaryActions);

        String[] conveyorSwitches = {"bottleAtPos0", "bottleLeftPos5"};
        Action[] conveyorActions = new Action[conveyorSwitches.length];
        String[] conveyorLights = {"motConveyorOnOff"};
        JPanel panel1 = createPanel("Conveyor", conveyorSwitches, conveyorLights, conveyorActions);

        Map<String, String[]> deviceSwitches = new HashMap<>();
        deviceSwitches.put("FillerA", new String[]{"bottleAtPos1A", "dosUnitAEvac", "dosUnitAAtTarget", "bottleAtPos2AFull"});
        deviceSwitches.put("FillerB", new String[]{"bottleAtPos1B", "dosUnitBEvac", "dosUnitBAtTarget", "bottleAtPos2BFull"});
        deviceSwitches.put("FillerC", new String[]{"bottleAtPos1C", "dosUnitCEvac", "dosUnitCAtTarget", "bottleAtPos2CFull"});
        deviceSwitches.put("FillerD", new String[]{"bottleAtPos1D", "dosUnitDEvac", "dosUnitDAtTarget", "bottleAtPos2DFull"});
        deviceSwitches.put("Capper", new String[]{"bottleAtPos3", "gripperZAxisLowered", "gripperZAxisLifted", "gripperTurnHomePos", "gripperTurnFinalPos"});
        // Add other devices here...

        Map<String, String[]> deviceLights = new HashMap<>();
        deviceLights.put("FillerA", new String[]{"valveInjectorAOnOff", "valveInletAOnOff", "dosUnitAValveRetract", "dosUnitAValveExtend", "fillerAIdle"});
        deviceLights.put("FillerB", new String[]{"valveInjectorBOnOff", "valveInletBOnOff", "dosUnitBValveRetract", "dosUnitBValveExtend", "fillerBIdle"});
        deviceLights.put("FillerC", new String[]{"valveInjectorCOnOff", "valveInletCOnOff", "dosUnitCValveRetract", "dosUnitCValveExtend", "fillerCIdle"});
        deviceLights.put("FillerD", new String[]{"valveInjectorDOnOff", "valveInletDOnOff", "dosUnitDValveRetract", "dosUnitDValveExtend", "fillerDIdle"});
        deviceLights.put("Capper", new String[]{"cylPos4ZaxisExtend", "gripperTurnRetract", "gripperTurnExtend", "capGripperPos5Extend", "cylClampBottleExtend", "capperIdle"});
        // Add other devices here...

        Map<String, ActionListener[]> deviceActions = new HashMap<>();
        // ============================== 在这里添加各个按钮的信号的监听函数 ========================================
        // 我这里为了适配，生成的是空数组，到时候需要实现监听函数然后把函数名加到数组里面给注册监听
        deviceActions.put("FillerA", new ActionListener[deviceSwitches.get("FillerA").length]);
        deviceActions.put("FillerB", new ActionListener[deviceSwitches.get("FillerB").length]);
        deviceActions.put("FillerC", new ActionListener[deviceSwitches.get("FillerC").length]);
        deviceActions.put("FillerD", new ActionListener[deviceSwitches.get("FillerD").length]);
        deviceActions.put("Capper", new ActionListener[deviceSwitches.get("Capper").length]);

        for (int i = 0; i < deviceSwitches.get("Capper").length; i++) {
            deviceActions.get("Capper")[i] = new CheckBoxActionCallback(deviceSwitches.get("Capper")[i]);
        }


        Map<String, JPanel> panelMap = new HashMap<>();
        panelMap.put("FillerA", createPanel("FillerA", deviceSwitches.get("FillerA"), deviceLights.get("FillerA"), deviceActions.get("FillerA")));
        panelMap.put("FillerB", createPanel("FillerB", deviceSwitches.get("FillerB"), deviceLights.get("FillerB"), deviceActions.get("FillerB")));
        panelMap.put("FillerC", createPanel("FillerC", deviceSwitches.get("FillerC"), deviceLights.get("FillerC"), deviceActions.get("FillerC")));
        panelMap.put("FillerD", createPanel("FillerD", deviceSwitches.get("FillerD"), deviceLights.get("FillerD"), deviceActions.get("FillerD")));
        panelMap.put("Capper", createPanel("Capper", deviceSwitches.get("Capper"), deviceLights.get("Capper"), deviceActions.get("Capper")));


        JComboBox<String> comboBox = new JComboBox<>(new String[]{"FillerA", "FillerB", "FillerC", "FillerD", "Capper"});
        comboBox.addActionListener(e -> {
            String selectedDevice = (String) comboBox.getSelectedItem();
            if (currPanel != null) frame.remove(currPanel);
            currPanel = panelMap.get(selectedDevice);
            frame.add(currPanel);
            frame.revalidate();
            frame.repaint();
        });

        currPanel = panelMap.get("FillerA");

        frame.setLayout(new GridLayout(4, 1, 5, 5));
        frame.add(panel0);
        frame.add(panel1);
        frame.add(comboBox);
        frame.add(currPanel);

        frame.setVisible(true);
    }

    private static JPanel createPanel(String title, String[] switchNames, String[] lightNames, ActionListener[] actions) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder(title));

        JPanel switcherPanel = new JPanel(new GridLayout(switchNames.length, 0, 5, 5));
        for (int i = 0; i < switchNames.length; i++) {
            String switchName = switchNames[i];

//            JToggleButton switcher = new JToggleButton(switchName);
//            switcher.setBorder(BorderFactory.createEmptyBorder(4, 5, 5, 5));

            JCheckBox boxer = new JCheckBox(switchName);

            if (actions != null && i < actions.length) {
//                switcher.addActionListener(actions[i]);
                boxer.addActionListener(actions[i]);
            }

//            switcherPanel.add(switcher);
            switcherPanel.add(boxer);
        }
        panel.add(switcherPanel, BorderLayout.WEST);

        JPanel lightPanel = new JPanel(new GridLayout(lightNames.length, 0));
        for (String lightName : lightNames) {
            lightPanel.add(new JLabel(lightName));
        }
        panel.add(lightPanel, BorderLayout.EAST);

        return panel;
    }
}