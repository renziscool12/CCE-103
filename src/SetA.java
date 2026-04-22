import javax.swing.*;
import java.awt.*;

public class SetA extends JFrame {
    JTextField nameField, ageField;
    JRadioButton maleButton, femaleButton, otherButton;
    JComboBox<String> civilStatusComboBox;
    JCheckBox sports, music, reading, traveling, gaming;
    JButton submitButton;

    SetA() {
        setTitle("Personal Information Form");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0; // First row
        add(new JLabel("Name:"), gbc); // Label for Name
        nameField = new JTextField(20); // Text field for Name input
        gbc.gridx = 1; // Move to the next column
        add(nameField, gbc);

        // Age Section
        gbc.gridx = 0;
        gbc.gridy = 1; // Second row
        add(new JLabel("Age:"), gbc); // Label for Age
        ageField = new JTextField(20); // Text field for Age input
        gbc.gridx = 1; // Move to the next column
        add(ageField, gbc);

        // Gender Section
        gbc.gridx = 0;
        gbc.gridy = 2; // Third row
        add(new JLabel("Gender:"), gbc); // gender label
        JPanel genderPanel = new JPanel();
        maleButton = new JRadioButton("Male");
        femaleButton = new JRadioButton("Female");
        otherButton = new JRadioButton("Other");

        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);
        genderPanel.add(otherButton);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        genderGroup.add(otherButton);
        gbc.gridx = 1; // Move to the next column
        add(genderPanel, gbc);

        // Civil Status Section
        String[] civilStatusOptions = { "Single", "Married", "Divorced", "Widowed" };
        civilStatusComboBox = new JComboBox<>(civilStatusOptions);

        gbc.gridx = 0;
        gbc.gridy = 3; // Fourth row
        add(new JLabel("Civil Status:"), gbc); // Civil Status label
        gbc.gridx = 1; // Move to the next column
        add(civilStatusComboBox, gbc);

        // Hobbies Section
        gbc.gridx = 0;
        gbc.gridy = 4; // Fifth row
        add(new JLabel("Hobbies:"), gbc); // Hobbies label
        JPanel hobbiesPanel = new JPanel();
        sports = new JCheckBox("Sports");
        music = new JCheckBox("Music");
        reading = new JCheckBox("Reading");
        traveling = new JCheckBox("Traveling");
        gaming = new JCheckBox("Gaming");

        hobbiesPanel.add(sports);
        hobbiesPanel.add(music);
        hobbiesPanel.add(reading);
        hobbiesPanel.add(traveling);
        hobbiesPanel.add(gaming);

        gbc.gridx = 1; // Move to the next column
        gbc.gridy = 4; // Stay in the same row
        add(hobbiesPanel, gbc);

        submitButton = new JButton("Submit");
        gbc.gridx = 1; // Move to the next column
        gbc.gridy = 5; // Move to the next row
        add(submitButton, gbc);

        submitButton.addActionListener(e -> {
            String name = nameField.getText();
            String ageText = ageField.getText();
            String gender = maleButton.isSelected() ? "Male"
                    : femaleButton.isSelected() ? "Female" : otherButton.isSelected() ? "Other" : "Not specified";
            String civilStatus = (String) civilStatusComboBox.getSelectedItem();
            StringBuilder hobbies = new StringBuilder();
            if (sports.isSelected())
                hobbies.append("Sports ");
            if (music.isSelected())
                hobbies.append("Music ");
            if (reading.isSelected())
                hobbies.append("Reading ");
            if (traveling.isSelected())
                hobbies.append("Traveling ");
            if (gaming.isSelected())
                hobbies.append("Gaming ");

            int age;
            try {
                age = Integer.parseInt(ageText); // Attempt to parse age input as an integer
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid age.", "Input Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Validate age input
            if (age < 0) {
                JOptionPane.showMessageDialog(this, "Age cannot be negative.", "Input Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (age > 120) {
                JOptionPane.showMessageDialog(this, "Please enter a realistic age.", "Input Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            JOptionPane.showMessageDialog(this,
                    "Name: " + name + "\nAge: " + age + "\nGender: " + gender + "\nCivil Status: " + civilStatus
                            + "\nHobbies: " + hobbies.toString(),
                    "Submitted Information", JOptionPane.INFORMATION_MESSAGE);

        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new SetA();
    }
}
