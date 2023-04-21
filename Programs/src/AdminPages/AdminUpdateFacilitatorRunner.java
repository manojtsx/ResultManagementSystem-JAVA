package AdminPages;

import javax.swing.*;
import java.awt.*;

public class AdminUpdateFacilitatorRunner extends JPanel {
    private JTextField nameTextField,phoneNumberTextField,emailTextField;
    JComboBox<String> subNameTextField;
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

        String[] subjects = {"Physics", "Chemistry", "Biology", "Math", "Nepali", "English"};

// Create a JComboBox with the values from the subjects array
        subNameTextField = new JComboBox<>(subjects);
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
    public JComboBox<String> getSubNameTextField(){
        return subNameTextField;
    }
    public JLabel getUsernameLabel(){
        return usernameLabel;
    }
    public JButton getSubmitBtn(){
        return submitBtn;
    }
}
