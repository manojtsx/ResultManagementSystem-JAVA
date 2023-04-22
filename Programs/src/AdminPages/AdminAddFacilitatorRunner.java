package AdminPages;

import javax.swing.*;
import java.awt.*;


public class AdminAddFacilitatorRunner extends JPanel {
    private JLabel nameLabel, usernameLabel, passwordLabel, phoneLabel, emailLabel, subLabel;
    private JTextField nameField, usernameField, passwordField, phoneField, emailField;
    private  JComboBox<String> subField;
    private JButton submitButton;



    public AdminAddFacilitatorRunner() {
        this.setLayout(new GridLayout(8, 2, 10, 10));

        nameLabel = new JLabel("Name:");
        add(nameLabel);
        nameField = new JTextField(20);
        add(nameField);

        usernameLabel = new JLabel("Username:");
        add(usernameLabel);
        usernameField = new JTextField(20);
        add(usernameField);

        passwordLabel = new JLabel("Password:");
        add(passwordLabel);
        passwordField = new JPasswordField(20);
        add(passwordField);

        phoneLabel = new JLabel("Phone Number:");
        add(phoneLabel);
        phoneField = new JTextField(20);
        add(phoneField);

        emailLabel = new JLabel("Email:");
        add(emailLabel);
        emailField = new JTextField(20);
        add(emailField);

        subLabel = new JLabel("SubName:");
        add(subLabel);
        String[] subjects = {"Physics", "Chemistry", "Biology", "Math", "Nepali", "English"};

// Create a JComboBox with the values from the subjects array
        subField = new JComboBox<>(subjects);
        add(subField);

        submitButton = new JButton("Submit");
        add(submitButton);

        //create empty borders for the textFields
        nameField.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        usernameField.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        passwordField.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        phoneField.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        emailField.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        subField.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));


// Set font styles
        Font labelFont = new Font("Arial", Font.BOLD, 14);
        Font textFieldFont = new Font("Arial", Font.PLAIN, 14);
        Font buttonFont = new Font("Arial", Font.BOLD, 16);

// Set foreground color for labels
        nameLabel.setForeground(Color.BLUE);
        usernameLabel.setForeground(Color.BLUE);
        passwordLabel.setForeground(Color.BLUE);
        phoneLabel.setForeground(Color.BLUE);
        emailLabel.setForeground(Color.BLUE);
        subLabel.setForeground(Color.BLUE); // Set foreground color for subLabel

// Set foreground color for text fields
        nameField.setForeground(Color.BLACK);
        usernameField.setForeground(Color.BLACK);
        passwordField.setForeground(Color.BLACK);
        phoneField.setForeground(Color.BLACK);
        emailField.setForeground(Color.BLACK);
        subField.setForeground(Color.BLACK); // Set foreground color for subField

// Set background color for text fields
        nameField.setBackground(Color.WHITE);
        usernameField.setBackground(Color.WHITE);
        passwordField.setBackground(Color.WHITE);
        phoneField.setBackground(Color.WHITE);
        emailField.setBackground(Color.WHITE);
        subField.setBackground(Color.WHITE); // Set background color for subField

// Set font for labels and text fields
        nameLabel.setFont(labelFont);
        usernameLabel.setFont(labelFont);
        passwordLabel.setFont(labelFont);
        phoneLabel.setFont(labelFont);
        emailLabel.setFont(labelFont);
        subLabel.setFont(labelFont); // Set font for subLabel

        nameField.setFont(textFieldFont);
        usernameField.setFont(textFieldFont);
        passwordField.setFont(textFieldFont);
        phoneField.setFont(textFieldFont);
        emailField.setFont(textFieldFont);
        subField.setFont(textFieldFont); // Set font for subField

// Set font for submit button
        submitButton.setFont(buttonFont);

// Set foreground and background colors for submit button
        submitButton.setForeground(Color.WHITE);
        submitButton.setBackground(Color.BLUE);

        // Set background color of the container to white
        setBackground(new Color(229, 190, 236));
    }


    public JTextField getNameField() {
        return nameField;
    }

    public JTextField getUsernameField() {
        return usernameField;
    }

    public JTextField getPasswordField() {
        return passwordField;
    }

    public JTextField getPhoneField() {
        return phoneField;
    }

    public JTextField getEmailField() {
        return emailField;
    }

    public JComboBox<String> getSubField() {
        return subField;
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

}
