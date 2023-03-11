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


