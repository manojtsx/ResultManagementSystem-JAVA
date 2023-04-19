package AdminPages;

import javax.swing.*;
import java.awt.*;

public class AdminUpdateFacilitatorRunner extends JPanel {
    private JTextField nameTextField,phoneNumberTextField,emailTextField,subNameTextField;
    private JLabel usernameLabel;
    private JButton submitBtn;
    public AdminUpdateFacilitatorRunner(){
        setLayout(new GridLayout(6,2)); // 6 rows, 2 columns

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
        add(new JLabel("Sub-name: "));
        subNameTextField = new JTextField();
        add(subNameTextField);

        //submit button
        submitBtn = new JButton("Submit");
        add(submitBtn);

        setPreferredSize(new Dimension(600,this.getPreferredSize().height));
    }
    public JTextField getNameTextField(){
        return nameTextField;
    }
    public JTextField getEmailTextField(){
        return emailTextField;
    }
    public JTextField getPhoneNumberTextField(){
        return phoneNumberTextField;
    }
    public JTextField getSubNameTextField(){
        return subNameTextField;
    }
    public JLabel getUsernameLabel(){
        return usernameLabel;
    }
    public JButton getSubmitBtn(){
        return submitBtn;
    }
}
