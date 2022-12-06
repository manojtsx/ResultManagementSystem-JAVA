package Frames;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    Dimension screensize  = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int) screensize.getWidth();
    int height = (int) screensize.getHeight();

    public LoginFrame(){
            this.setLayout(new BorderLayout());
            JPanel panel1 = new JPanel();
            panel1.setBackground(Color.white);
            panel1.setPreferredSize(new Dimension((int) (width*0.5),height));
            this.add(panel1,BorderLayout.LINE_START);
            panel1.setLayout(null);

            JLabel username = new JLabel("Username");
            username.setBounds(60,140,500,30);

            JTextField user = new JTextField();
            user.setBounds(60,180,500,30);

            JLabel password = new JLabel("Password");
            password.setBounds(60,220,500,30);

            JPasswordField pass = new JPasswordField();
            pass.setBounds(60,260,500,30);

            JButton signInBtn = new JButton("Sign In");
            signInBtn.setPreferredSize(new Dimension(300,30));
            signInBtn.setBounds(60,300,500,30);
            signInBtn.setBackground(Color.black);
            signInBtn.setForeground(Color.white);
            signInBtn.setFont(new Font("Time New Roman",800,20));

            panel1.add(username);
            panel1.add(user);
            panel1.add(password);
            panel1.add(pass);
            panel1.add(signInBtn);


            JPanel panel2 = new JPanel();
            panel2.setPreferredSize(new Dimension((int) (width*0.5),height));
            panel2.setBackground(Color.blue);
            this.add(panel2,BorderLayout.LINE_END);
            panel2.setLayout(new BorderLayout());
            JLabel signIn = new JLabel("Sign In");
            signIn.setForeground(Color.white);
            signIn.setFont(new Font("Times New Roman",400,30));

            panel2.add(signIn,BorderLayout.CENTER);
            signIn.setBounds((int)(width*0.25),0,0,0);

    }
}