package AdminPages;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class AdminAddStudentRunner extends JPanel {
    private JLabel nameLabel, usernameLabel, passwordLabel, phoneLabel, emailLabel,parentLabel;
    private JTextField nameField, usernameField, passwordField, phoneField, emailField, parentField;
    private JButton submitButton;
    public AdminAddStudentRunner() {
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

            parentLabel = new JLabel("Parent:");
            add(parentLabel);
            parentField = new JTextField(20);
            add(parentField);

            submitButton = new JButton("Submit");
            add(submitButton);

        // Create a font with desired styles
        Font labelFont = new Font("Arial", Font.BOLD, 14);
        Font textFieldFont = new Font("Arial", Font.PLAIN, 14);
        Font buttonFont = new Font("Arial", Font.BOLD, 16);

// Set the font for the labels
        nameLabel.setFont(labelFont);
        usernameLabel.setFont(labelFont);
        passwordLabel.setFont(labelFont);
        phoneLabel.setFont(labelFont);
        emailLabel.setFont(labelFont);
        parentLabel.setFont(labelFont);

// Set the font for the text fields
        nameField.setFont(textFieldFont);
        usernameField.setFont(textFieldFont);
        passwordField.setFont(textFieldFont);
        phoneField.setFont(textFieldFont);
        emailField.setFont(textFieldFont);
        parentField.setFont(textFieldFont);


        //set empty border for the text fields
        nameField.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        usernameField.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        passwordField.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        phoneField.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        emailField.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        parentField.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

// Set the font for the submit button
        submitButton.setFont(buttonFont);

        // Set foreground color for labels
        nameLabel.setForeground(Color.BLUE);
        usernameLabel.setForeground(Color.BLUE);
        passwordLabel.setForeground(Color.BLUE);
        phoneLabel.setForeground(Color.BLUE);
        emailLabel.setForeground(Color.BLUE);
        parentLabel.setForeground(Color.BLUE);

// Set foreground color for text fields
        nameField.setForeground(Color.BLACK);
        usernameField.setForeground(Color.BLACK);
        passwordField.setForeground(Color.BLACK);
        phoneField.setForeground(Color.BLACK);
        emailField.setForeground(Color.BLACK);
        parentField.setForeground(Color.BLACK);

// Set background color for text fields
        nameField.setBackground(Color.WHITE);
        usernameField.setBackground(Color.WHITE);
        passwordField.setBackground(Color.WHITE);
        phoneField.setBackground(Color.WHITE);
        emailField.setBackground(Color.WHITE);
        parentField.setBackground(Color.WHITE);

// Set foreground and background colors for the submit button
        submitButton.setForeground(Color.WHITE);
        submitButton.setBackground(Color.BLUE);


    }
        public JTextField getNameField(){
            return nameField;
        }
        public JTextField getUsernameField(){
            return usernameField;
        }
        public JTextField getPasswordField(){
            return passwordField;
        }
        public JTextField getPhoneField(){
            return phoneField;
        }
        public JTextField getEmailField(){
            return emailField;
        }
        public JTextField getParentField(){
        return parentField;
        }
        public JButton getSubmitButton(){
                return submitButton;
        }
    }


