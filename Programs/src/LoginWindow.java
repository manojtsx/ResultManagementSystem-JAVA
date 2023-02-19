import AdminPages.AdminHomeRunner;
import Frames.MyFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginWindow extends JPanel{
    public LoginWindow() {

        MyFrame frame = new MyFrame();
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screensize.getWidth();
        int height = (int) screensize.getHeight();
        this.setLayout(new BorderLayout());
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.white);
        panel1.setPreferredSize(new Dimension((int) (width * 0.5), height));

        panel1.setLayout(null);

        JLabel username = new JLabel("Username");
        username.setBounds(60, 140, 500, 30);

        JTextField user = new JTextField();
        user.setBounds(60, 180, 500, 30);

        JLabel password = new JLabel("Password");
        password.setBounds(60, 220, 500, 30);

        JPasswordField pass = new JPasswordField();
        pass.setBounds(60, 260, 500, 30);

        JButton signInBtn = new JButton("Sign In");
        signInBtn.setPreferredSize(new Dimension(300, 30));
        signInBtn.setBounds(60, 300, 500, 30);
        signInBtn.setBackground(Color.black);
        signInBtn.setForeground(Color.white);
        signInBtn.setFont(new Font("Time New Roman", 800, 20));

        panel1.add(username);
        panel1.add(user);
        panel1.add(password);
        panel1.add(pass);
        panel1.add(signInBtn);


        JPanel panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension((int) (width * 0.5), height));
        panel2.setBackground(Color.blue);

        panel2.setLayout(new BorderLayout());
        JLabel signIn = new JLabel("Sign In");
        signIn.setForeground(Color.white);
        signIn.setFont(new Font("Times New Roman", 400, 30));

        panel2.add(signIn, BorderLayout.CENTER);
        signIn.setBounds((int) (width * 0.25), 0, 0, 0);

        this.add(panel1, BorderLayout.LINE_START);
        this.add(panel2, BorderLayout.LINE_END);
        this.setVisible(true);

        signInBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection conn;
                String db_url = "jdbc:mysql://localhost/result";
                String db_user = "root";
                String db_pass = "";
                try {
                    conn = DriverManager.getConnection(db_url, db_user, db_pass);
                    System.out.println("connected");
                    String sql = "SELECT username FROM user";
                    Statement stmt = conn.createStatement();
                    ResultSet result = stmt.executeQuery(sql);
                    System.out.println(result);
                    String col_value = null;
                    while (result.next()) {
                        col_value = result.getString("username");
                        System.out.println(col_value);
//                        if (user.getText() == col_value) {
//                            System.out.println("Success");
//                        } else {
//                            AdminHomeRunner ah = new AdminHomeRunner();
//
//
//                        }
                    }


                } catch (SQLException err) {
                    System.out.println(err);
                }
            }
        });


    }
}
