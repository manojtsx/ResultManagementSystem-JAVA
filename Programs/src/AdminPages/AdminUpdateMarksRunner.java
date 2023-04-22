package AdminPages;

import javax.swing.*;
import java.awt.*;

public class AdminUpdateMarksRunner extends JPanel {
    private final JLabel usernameLabel;
    private final JLabel usernameField;
    private final JLabel physicsLabel;
    private final JLabel chemistryLabel;
    private final JLabel biologyLabel;
    private final JLabel mathLabel;
    private final JLabel nepaliLabel;
    private final JLabel englishLabel;
    private final JTextField physicsField;
    private final JTextField chemistryField;
    private final JTextField biologyField;
    private final JTextField mathField;
    private final JTextField nepaliField;
    private final JTextField englishField;
    private final JButton submitButton;

    public AdminUpdateMarksRunner() {

        setLayout(new GridLayout(9, 2));

        usernameLabel = new JLabel("Username:");
        usernameField = new JLabel();
        add(usernameLabel);
        add(usernameField);

        // Create input fields for physics, chemistry, biology, math, Nepali, and English
        physicsLabel = new JLabel("Physics:");
        add(physicsLabel);
        physicsField = new JTextField(20);
        add(physicsField);

        chemistryLabel = new JLabel("Chemistry:");
        add(chemistryLabel);
        chemistryField = new JTextField(20);
        add(chemistryField);

        biologyLabel = new JLabel("Biology:");
        add(biologyLabel);
        biologyField = new JTextField(20);
        add(biologyField);

        mathLabel = new JLabel("Math:");
        add(mathLabel);
        mathField = new JTextField(20);
        add(mathField);

        nepaliLabel = new JLabel("Nepali:");
        add(nepaliLabel);
        nepaliField = new JTextField(20);
        add(nepaliField);

        englishLabel = new JLabel("English:");
        add(englishLabel);
        englishField = new JTextField(20);
        add(englishField);

        // Create submit button
        submitButton = new JButton("Submit");
        add(submitButton);
        // Set background color of the container to white
        setBackground(new Color(229, 190, 236));
    }

    public JLabel getUsernameField() {
        return usernameField;
    }

    public JTextField getPhysicsField() {
        return physicsField;
    }

    public JTextField getChemistryField() {
        return chemistryField;
    }

    public JTextField getBiologyField() {
        return biologyField;
    }

    public JTextField getMathField() {
        return mathField;
    }

    public JTextField getNepaliField() {
        return nepaliField;
    }

    public JTextField getEnglishField() {
        return englishField;
    }

    public JButton getSubmitButton() {
        return submitButton;
    }
}
