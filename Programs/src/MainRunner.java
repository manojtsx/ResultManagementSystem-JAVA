import AdminPages.AdminHomeRunner;
import FacilitatorPages.FacilitatorHomeRunner;
import Frames.MyFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Objects;

public class MainRunner {
    public static void main(String s[]) {
        MyFrame frame = new MyFrame();
        LoginWindow login = new LoginWindow();
        AdminHomeRunner adminHome = new AdminHomeRunner();
        FacilitatorHomeRunner facilitatorHome = new FacilitatorHomeRunner();
        frame.add(login);

        JButton signInBtn = login.getButton();
        JTextField user = login.getTextField();
        JPasswordField pass = login.getPasswordField();
        signInBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Connection conn;
                String driver = "com.mysql.cj.jdbc.Driver";
                String db_url = "jdbc:mysql://localhost:3306/rms";
                String db_user = "root";
                String db_pass = "";
                try {
                    Class.forName(driver);
                } catch (ClassNotFoundException err) {
                    System.out.println(err);
                }

                try {
                    conn = DriverManager.getConnection(db_url, db_user, db_pass);
                    System.out.println("connected");
                    String sql = "SELECT * FROM user";
                    Statement stmt = conn.createStatement();
                    ResultSet result = stmt.executeQuery(sql);
                    System.out.println(result);
                    String user_value = null;
                    String pass_value = null;
                    String usertype = null;
                    while (result.next()) {
                        user_value = result.getString("username");
                        pass_value = result.getString("password");
                        usertype = result.getString("usertype");
                        System.out.println(user_value);
                        System.out.println(user.getText());
                        String password = new String(pass.getPassword());
                        if (Objects.equals(user_value, user.getText()) && Objects.equals(pass_value, password) && Objects.equals(usertype,"admin")) {
                            frame.getContentPane().removeAll();
                            frame.getContentPane().add(adminHome);
                            break;
                        } else if (Objects.equals(pass_value,user.getText()) && Objects.equals(pass_value,password) && Objects.equals(usertype,"admin")) {
                            frame.getContentPane().removeAll();
                            frame.getContentPane().add(facilitatorHome);
                        }
                    }
                } catch (SQLException err) {
                    System.out.println(err);
                }
            }
        });

        frame.setVisible(true);
    }
}
