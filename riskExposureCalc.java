package main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class riskExposureCalc {
    private JPanel RiskExposureCalculator;
    private JTextField LOCAvgComponentTF;
    private JTextField NumOfComponentsTF;
    private JTextField CostOfLOC;
    private JTextField RiskProbTF;
    private JLabel numberOfComponentsFromLabel;
    private JButton calculateButton;
    private JLabel ResultTF;
    private JButton clearButton;
    private JTextField DisplayResult;
    private JLabel LOCOfAvgComponents;
    private JLabel costForEachLOC;
    private JLabel RiskProbability;
    private JLabel title;
    private JTextField errorMessage;

    public static void main(String[] args) {
        JFrame frame = new JFrame("riskExposureCalc");
        frame.setContentPane(new riskExposureCalc().RiskExposureCalculator);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public riskExposureCalc() {
        DisplayResult.setEditable(false);
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Double numOfComponents = Double.valueOf(NumOfComponentsTF.getText());
                Double locAvgComponents = Double.valueOf(LOCAvgComponentTF.getText());
                Double costOfLOC = Double.valueOf(CostOfLOC.getText());
                Double riskProbability = Double.valueOf(RiskProbTF.getText());
                if (riskProbability > 1 || riskProbability < 0){
                    errorMessage.setText("Error: Risk Probability must be between 0 and 1!!");
                }
                else if(numOfComponents < 0 || !numOfComponents. || numOfComponents.isEmpty()){ //check that input is positive, not null, and only an integer/double
                    errorMessage.setText("Error: Number of components from scratch must be a positive digit");
                }
                else if(locAvgComponents < 0 || !locAvgComponents.isDigit() || locAvgComponents.isEmpty()){ //check that input is positive, not null, and only an integer/double
                    errorMessage.setText("Error: LOC of an average component must be a positive digit");
                }
                else if(costOfLOC < 0 || !costOfLOC.isDigit() || costOfLOC.isEmpty()){ //check that input is positive, not null, and only an integer/double
                    errorMessage.setText("Error: Cost for each LOC must be a positive digit");
                }
                else{
                Double result = (numOfComponents * locAvgComponents * costOfLOC) * riskProbability;
                DisplayResult.setText(result.toString());
                }
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DisplayResult.setText("");
                errorMessage.setText("");
                NumOfComponentsTF.setText("");
                LOCAvgComponentTF.setText("");
                CostOfLOC.setText("");
                RiskProbTF.setText("");
            }
        });
    }
}
