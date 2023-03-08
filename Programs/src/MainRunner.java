import AdminPages.*;
import FacilitatorPages.*;
import Frames.MyFrame;
import Reusable.AdminNavigationBar;
import Reusable.FacilitatorNavigationBar;
import StudentPages.StudentHomeRunner;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.Objects;

public class MainRunner {
    public static void main(String s[]) {

        //these are panel classes obtained from different packages
        MyFrame frame = new MyFrame();
        LoginWindow login = new LoginWindow();
        AdminNavigationBar adminNavbar = new AdminNavigationBar();
        FacilitatorNavigationBar facilitatorNavbar = new FacilitatorNavigationBar();

        //these are the objects of the admin panel
        AdminHomeRunner adminHome = new AdminHomeRunner();
        AdminAddFacilitatorRunner adminAddFacilitator = new AdminAddFacilitatorRunner();
        AdminViewFacilitatorRunner adminViewFacilitator = new AdminViewFacilitatorRunner();
        AdminAddStudentRunner adminAddStudent = new AdminAddStudentRunner();
        AdminViewStudentRunner adminViewStudent = new AdminViewStudentRunner();
        AdminAddMarks1Runner adminAddMarks1 = new AdminAddMarks1Runner();
        AdminAddMarks2Runner adminAddMarks2 = new AdminAddMarks2Runner();
        AdminViewMarksRunner adminViewMarks = new AdminViewMarksRunner();

        //these are the objects of the facilitaor panel
        FacilitatorHomeRunner facilitatorHome = new FacilitatorHomeRunner();
        FacilitatorViewFacilitator facilitatorViewFacilitator = new FacilitatorViewFacilitator();
        FacilitatorViewStudent facilitatorViewStudent = new FacilitatorViewStudent();
        FacilitatorAddMarks facilitatorAddMarks = new FacilitatorAddMarks();
        FacilitatorViewMarks facilitatorViewMarks = new FacilitatorViewMarks();
        StudentHomeRunner studentHome = new StudentHomeRunner();
        frame.add(login);

//these are the detail obtained from the adminhomerunner
        JButton signInBtn = login.getButton();
        JLabel anameDetail = adminHome.getNameDetail();
        JLabel auserDetail = adminHome.getUserDetail();
        JLabel apositionDetail = adminHome.getPositionDetail();
        JLabel aclassDetail = adminHome.getClassDetail();
        JLabel aphoneDetail = adminHome.getPhoneDetail();
        JLabel aemailDetail = adminHome.getEmailDetail();

//these are the detail obtained from the facilitatorhomerunner
        JLabel fnameDetail = facilitatorHome.getNameDetail();
        JLabel fuserDetail = facilitatorHome.getUserDetail();
        JLabel fpositionDetail = facilitatorHome.getPositionDetail();
        JLabel fclassDetail = facilitatorHome.getClassDetail();
        JLabel fphoneDetail = facilitatorHome.getPhoneDetail();
        JLabel femailDetail = facilitatorHome.getEmailDetail();

//these are the detail obtained from the studenthomerunner
        JLabel snameDetail = studentHome.getNameDetail();
        JLabel suserDetail = studentHome.getUserDetail();
        JLabel spositionDetail = studentHome.getPositionDetail();
        JLabel sclassDetail = studentHome.getClassDetail();
        JLabel sphoneDetail = studentHome.getPhoneDetail();
        JLabel semailDetail = studentHome.getEmailDetail();

//these are the menu item obtained from the adminavigationbar
        JMenu ahome = adminNavbar.getHome();
        JMenu alogout = adminNavbar.getLogout();
        JMenuItem aaddfacilitator = adminNavbar.getAddFacilitator();
        JMenuItem aviewFacilitator = adminNavbar.getViewFacilitator();
        JMenuItem aaddStudent = adminNavbar.getAddStudent();
        JMenuItem aviewStudent = adminNavbar.getViewStudent();
        JMenuItem aaddMarks = adminNavbar.getAddMarks();
        JMenuItem aViewMarks = adminNavbar.getViewMarks();

//these are the menu item obtained from the faciliatornavigation bar
        JMenu fhome = facilitatorNavbar.getHome();
        JMenu flogout = facilitatorNavbar.getLogout();
        JMenuItem fviewFacilitator = facilitatorNavbar.getViewFacilitator();
        JMenuItem fviewStudent = facilitatorNavbar.getViewStudent();
        JMenuItem faddMarks = facilitatorNavbar.getAddMarks();
        JMenuItem fViewMarks = facilitatorNavbar.getViewMarks();


//these are obtained from the login window
        JTextField user = login.getTextField();
        JPasswordField pass = login.getPasswordField();

        //actionlistener on clicking the login button
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
                    String sql = "SELECT * FROM user";
                    Statement stmt = conn.createStatement();
                    ResultSet result = stmt.executeQuery(sql);
                    String name_value = null;
                    String user_value = null;
                    String pass_value = null;
                    String usertype = null;
                    String class_value = null;
                    String phone_value = null;
                    String email_value = null;
                    boolean foundMatch = false;
                    while (result.next()) {
                        name_value = result.getString("Name");
                        user_value = result.getString("username");
                        pass_value = result.getString("password");
                        usertype = result.getString("usertype");
                        class_value = result.getString("Class");
                        phone_value = result.getString("PhoneNo");
                        email_value = result.getString("Email");
                        String password = new String(pass.getPassword());
                        if (Objects.equals(user_value, user.getText()) && Objects.equals(pass_value, password) && Objects.equals(usertype, "admin")) {
                            anameDetail.setText(name_value);
                            auserDetail.setText(user_value);
                            apositionDetail.setText(usertype);
                            aclassDetail.setText(class_value);
                            aphoneDetail.setText(phone_value);
                            aemailDetail.setText(email_value);
                            frame.getContentPane().removeAll();
                            frame.getContentPane().add(adminNavbar);
                            frame.getContentPane().add(adminHome);
                            frame.getContentPane().revalidate();
                            frame.getContentPane().repaint();
                            foundMatch = true;
                        } else if (Objects.equals(user_value, user.getText()) && Objects.equals(pass_value, password) && Objects.equals(usertype, "facilitator")) {
                            fnameDetail.setText(name_value);
                            fuserDetail.setText(user_value);
                            fpositionDetail.setText(usertype);
                            fclassDetail.setText(class_value);
                            fphoneDetail.setText(phone_value);
                            femailDetail.setText(email_value);
                            frame.getContentPane().removeAll();
//                            frame.getContentPane().add();
                            frame.getContentPane().add(facilitatorHome);
                            frame.getContentPane().revalidate();
                            frame.getContentPane().repaint();
                            foundMatch = true;

                        } else if (Objects.equals(user_value, user.getText()) && Objects.equals(pass_value, password) && Objects.equals(usertype, "student")) {
                            snameDetail.setText(name_value);
                            suserDetail.setText(user_value);
                            spositionDetail.setText(usertype);
                            sclassDetail.setText(class_value);
                            sphoneDetail.setText(phone_value);
                            semailDetail.setText(email_value);
                            frame.getContentPane().removeAll();
                            frame.getContentPane().add(studentHome);
                            frame.getContentPane().revalidate();
                            frame.getContentPane().repaint();
                            foundMatch = true;
                        }

                    }
                    if (!foundMatch) {
                        JOptionPane.showMessageDialog(frame,
                                "Username or password incorrect",
                                "Error Message",
                                JOptionPane.ERROR_MESSAGE);
                    }

                } catch (SQLException err) {
                    System.out.println(err);
                }
            }
        });

        //event on clicking add facilitator in admin section

        aaddfacilitator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(adminNavbar);
                frame.getContentPane().add(adminAddFacilitator);
                frame.getContentPane().revalidate();
                frame.getContentPane().repaint();
            }
        });
        //event on clicking view facilitator in admin section
        aviewFacilitator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(adminNavbar);
                frame.getContentPane().add(adminViewFacilitator);
                frame.getContentPane().revalidate();
                frame.getContentPane().repaint();
            }
        });
        //event on clicking add student in admin section
        aaddStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(adminNavbar);
                frame.getContentPane().add(adminAddStudent);
                frame.getContentPane().revalidate();
                frame.getContentPane().repaint();
            }
        });
        //event on clicking view student in admin section
        aviewStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(adminNavbar);
                frame.getContentPane().add(adminViewStudent);
                frame.getContentPane().revalidate();
                frame.getContentPane().repaint();
            }
        });
        //event on clicking add marks in admin section
        aaddMarks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(adminNavbar);
                frame.getContentPane().add(adminAddMarks1);
                frame.getContentPane().revalidate();
                frame.getContentPane().repaint();
            }
        });
        //event on clicking view marks in admin section
        aViewMarks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(adminNavbar);
                frame.getContentPane().add(adminViewMarks);
                frame.getContentPane().revalidate();
                frame.getContentPane().repaint();
            }
        });

        //event on clicking home in the admin section
        ahome.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(adminNavbar);
                frame.getContentPane().add(adminHome);
                frame.getContentPane().revalidate();
                frame.getContentPane().repaint();
            }
        });
        //event on clicking the logout of adminSection
        alogout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(login);
                frame.getContentPane().revalidate();
                frame.getContentPane().repaint();
            }
        });

        //event on clicking view facilitator in facilitator section
        fviewFacilitator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(facilitatorNavbar);
                frame.getContentPane().add(facilitatorViewFacilitator);
                frame.getContentPane().revalidate();
                frame.getContentPane().repaint();
            }
        });

        //event on clicking view student in admin section
        aviewStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(facilitatorNavbar);
                frame.getContentPane().add(facilitatorViewStudent);
                frame.getContentPane().revalidate();
                frame.getContentPane().repaint();
            }
        });
        //event on clicking add marks in admin section
        faddMarks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(facilitatorNavbar);
                frame.getContentPane().add(facilitatorAddMarks);
                frame.getContentPane().revalidate();
                frame.getContentPane().repaint();
            }
        });
        //event on clicking view marks in admin section
        fViewMarks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(facilitatorNavbar);
                frame.getContentPane().add(facilitatorViewMarks);
                frame.getContentPane().revalidate();
                frame.getContentPane().repaint();
            }
        });

        //event on clicking home in the admin section
        fhome.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(facilitatorNavbar);
                frame.getContentPane().add(facilitatorHome);
                frame.getContentPane().revalidate();
                frame.getContentPane().repaint();
            }
        });
        //event on clicking the logout of adminSection
        flogout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(login);
                frame.getContentPane().revalidate();
                frame.getContentPane().repaint();
            }
        });

        frame.setVisible(true);
    }
}
