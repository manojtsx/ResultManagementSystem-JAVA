package AdminPages;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class AdminAddStudentRunner extends JPanel {
    private JLabel nameLabel, usernameLabel, passwordLabel, phoneLabel, emailLabel, classLabel, subjectLabel;
    private JTextField nameField, usernameField, passwordField, phoneField, emailField, classField, subjectField;
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

            classLabel = new JLabel("Class:");
            add(classLabel);
            classField = new JTextField(20);
            add(classField);

            subjectLabel = new JLabel("Subject:");
            add(subjectLabel);
            subjectField = new JTextField(20);
            add(subjectField);

            submitButton = new JButton("Submit");
            add(submitButton);



            submitButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
            });
        }
    }


