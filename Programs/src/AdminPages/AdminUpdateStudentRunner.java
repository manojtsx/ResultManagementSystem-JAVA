package AdminPages;

import javax.swing.*;
import java.awt.*;

public class AdminUpdateStudentRunner extends JPanel {
    private final JTextField nameTextField;
    private final JTextField emailTextField;
    private final JTextField phoneNumberTextField;
    private final JTextField parentNameTextField;
    private final JLabel usernameLabel;
    private final JButton submitBtn;

    public AdminUpdateStudentRunner() {
        setLayout(new GridLayout(6, 2)); // 6 rows, 2 columns

        // Name field
        add(new JLabel("Name: "));
        nameTextField = new JTextField();
        add(nameTextField);

        // Username label
        add(new JLabel("Username"));
        usernameLabel = new JLabel();
        add(usernameLabel);


        // Phone number field
        add(new JLabel("Phone Number: "));
        phoneNumberTextField = new JTextField();
        add(phoneNumberTextField);

        // Email field
        add(new JLabel("Email: "));
        emailTextField = new JTextField();
        add(emailTextField);

        // Sub-name field
        add(new JLabel("Parent-name: "));
        parentNameTextField = new JTextField();
        add(parentNameTextField);

        //submit button
        submitBtn = new JButton("Submit");
        add(submitBtn);

        setPreferredSize(new Dimension(600, this.getPreferredSize().height));
        // Set background color of the container to white
        setBackground(new Color(229, 190, 236));
    }

    public JTextField getNameTextField() {
        return nameTextField;
    }

    public JTextField getEmailTextField() {
        return emailTextField;
    }

    public JTextField getPhoneNumberTextField() {
        return phoneNumberTextField;
    }

    public JTextField getParentNameTextField() {
        return parentNameTextField;
    }

    public JLabel getUsernameLabel() {
        return usernameLabel;
    }

    public JButton getSubmitBtn() {
        return submitBtn;
    }
}
