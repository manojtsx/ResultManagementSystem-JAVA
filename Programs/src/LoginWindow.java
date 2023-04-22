import javax.swing.*;
import java.awt.*;

public class LoginWindow extends JPanel{
    JButton signInBtn;
    JTextField user;
    JPasswordField pass;

    public LoginWindow() {


        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screensize.getWidth();
        int height = (int) screensize.getHeight();
        this.setLayout(new BorderLayout());
        JPanel panel1 = new JPanel();
        panel1.setBackground(new Color(253, 226, 243));
        panel1.setPreferredSize(new Dimension((int) (width * 0.5), height));

        panel1.setLayout(null);

        JLabel username = new JLabel("Username");
        username.setBounds(60, 140, 500, 30);

        user = new JTextField();
        user.setBounds(60, 180, 500, 30);

        JLabel password = new JLabel("Password");
        password.setBounds(60, 220, 500, 30);

        pass = new JPasswordField();
        pass.setBounds(60, 260, 500, 30);

        signInBtn = new JButton("Sign In");
        signInBtn.setPreferredSize(new Dimension(300, 30));
        signInBtn.setBounds(60, 340, 500, 30);
        signInBtn.setBackground(new Color(42, 47, 79));
        signInBtn.setForeground(Color.white);
        signInBtn.setFont(new Font("Time New Roman", 800, 20));


        panel1.add(username);
        panel1.add(user);
        panel1.add(password);
        panel1.add(pass);
        panel1.add(signInBtn);


        JPanel panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension((int) (width * 0.5), height));
        panel2.setBackground(new Color(42, 47, 79));

        panel2.setLayout(new BorderLayout());
        JLabel signIn = new JLabel("Sign In");
        signIn.setForeground(Color.white);
        signIn.setFont(new Font("Times New Roman", 400, 30));

        panel2.add(signIn, BorderLayout.CENTER);
        signIn.setBounds((int) (width * 0.25), 0, 0, 0);

        this.add(panel1, BorderLayout.LINE_START);
        this.add(panel2, BorderLayout.LINE_END);
        this.setVisible(true);


    }
    public JButton getButton(){
        return signInBtn;
    }
    public JTextField getTextField(){
        return user;
    }
    public JPasswordField getPasswordField(){
        return pass;
    }
}
