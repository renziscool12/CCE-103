import javax.swing.*;
import java.awt.*;

public class SetB extends JFrame {
    JTextField employeeNameField, basicSalaryField;
    JComboBox<String> jobPositionStatus;
    JCheckBox sss, pagIbig, philHealth;
    JButton computeButton;

    SetB() {
        setTitle("Salary Computation System");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Employee Name:"), gbc);
        employeeNameField = new JTextField(20);
        gbc.gridx = 1;
        add(employeeNameField, gbc);

        String[] jobPosition = { "Manager", "Developer", "Technician", "Clerk" };
        jobPositionStatus = new JComboBox<>(jobPosition);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Job Position:"), gbc);
        gbc.gridx = 1;
        add(jobPositionStatus, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Basic Salary:"), gbc);
        basicSalaryField = new JTextField(20);
        gbc.gridx = 1;
        add(basicSalaryField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("Deductions:"), gbc);
        JPanel deductionPanel = new JPanel();
        sss = new JCheckBox("SSS");
        pagIbig = new JCheckBox("Pag-Ibig");
        philHealth = new JCheckBox("PhilHealth");

        deductionPanel.add(sss);
        deductionPanel.add(pagIbig);
        deductionPanel.add(philHealth);

        ButtonGroup button = new ButtonGroup();

        button.add(sss);
        button.add(pagIbig);
        button.add(philHealth);

        gbc.gridx = 1;
        gbc.gridy = 4;
        add(deductionPanel, gbc);

        computeButton = new JButton("COMPUTE");
        gbc.gridx = 1;
        gbc.gridy = 5;
        add(computeButton, gbc);

        computeButton.addActionListener(e -> {
            String name = employeeNameField.getText();
            String jobPositionCheck = (String) jobPositionStatus.getSelectedItem();
            String basicSalary = basicSalaryField.getText();
            StringBuilder deducts = new StringBuilder();

            if (sss.isSelected()) {
                deducts.append("SSS");
            }

            if (pagIbig.isSelected()) {
                deducts.append("Pag-Ibig");
            }

            if (philHealth.isSelected()) {
                deducts.append("PhilHealth");
            }

            if (name.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Name cannot be empty", "Empty Name", JOptionPane.ERROR_MESSAGE);
            }

            double salary;
            try {
                salary = Double.parseDouble(basicSalary);

                if (salary < 0) {
                    JOptionPane.showMessageDialog(this, "Salary cannot be below zero", "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Number Only", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double deduction = 0;

            if (sss.isSelected()) {
                deduction += salary * 0.005;
            }

            if (pagIbig.isSelected()) {
                deduction += salary * 0.03;
            }

            if (philHealth.isSelected()) {
                deduction += salary * 0.02;
            }

            double finalSalary = salary - deduction;

            JOptionPane.showMessageDialog(this,
                    "Name: " + name + "\nJob Position: " + jobPositionCheck + "\nBasic Salary: " + basicSalary
                            + "\nDeducts: " + deducts + "\nTotal Salary After Deduction: " + finalSalary);
        });
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SetB());
    }
}