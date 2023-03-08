import AdminPages.*;
import FacilitatorPages.*;
import Frames.MyFrame;
import Modules.Student;
import Reusable.AdminNavigationBar;
import Reusable.FacilitatorNavigationBar;
import Reusable.StudentNavigationBar;
import StudentPages.StudentHomeRunner;
import StudentPages.StudentViewFacilitator;
import StudentPages.StudentViewMarks;
import StudentPages.StudentViewStudent;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
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
        frame.setLayout(new BorderLayout());
        LoginWindow login = new LoginWindow();
        AdminNavigationBar adminNavbar = new AdminNavigationBar();
        FacilitatorNavigationBar facilitatorNavbar = new FacilitatorNavigationBar();
        StudentNavigationBar studentNavbar = new StudentNavigationBar();

        //these are the objects of the admin panel
        AdminHomeRunner adminHome = new AdminHomeRunner();
        AdminAddFacilitatorRunner adminAddFacilitator = new AdminAddFacilitatorRunner();
        AdminViewFacilitatorRunner adminViewFacilitator = new AdminViewFacilitatorRunner();
        AdminAddStudentRunner adminAddStudent = new AdminAddStudentRunner();
        AdminViewStudentRunner adminViewStudent = new AdminViewStudentRunner();
        AdminAddMarks1Runner adminAddMarks1 = new AdminAddMarks1Runner();
        AdminAddMarks2Runner adminAddMarks2 = new AdminAddMarks2Runner();
        AdminViewMarksRunner adminViewMarks = new AdminViewMarksRunner();

        //these are the objects of the facilitator panel
        FacilitatorHomeRunner facilitatorHome = new FacilitatorHomeRunner();
        FacilitatorViewFacilitator facilitatorViewFacilitator = new FacilitatorViewFacilitator();
        FacilitatorViewStudent facilitatorViewStudent = new FacilitatorViewStudent();
        FacilitatorAddMarks facilitatorAddMarks = new FacilitatorAddMarks();
        FacilitatorViewMarks facilitatorViewMarks = new FacilitatorViewMarks();
        frame.add(login);

//these are the objects of the student panel
        StudentHomeRunner studentHome = new StudentHomeRunner();
        StudentViewFacilitator studentViewFacilitator = new StudentViewFacilitator();
        StudentViewStudent studentViewStudent = new StudentViewStudent();
        StudentViewMarks studentViewMarks = new StudentViewMarks();


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

        //these are the menu items obtained from the studentnavigation bar
        JMenu shome = studentNavbar.getHome();
        JMenu slogout = studentNavbar.getLogout();
        JMenuItem sviewFacilitator = studentNavbar.getViewFacilitator();
        JMenuItem sviewStudent = studentNavbar.getViewStudent();
        JMenuItem sviewMarks = studentNavbar.getViewMarks();


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
                            frame.getContentPane().add(adminNavbar, BorderLayout.NORTH);
                            frame.getContentPane().add(adminHome,BorderLayout.CENTER);
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
                            frame.getContentPane().add(facilitatorNavbar,BorderLayout.NORTH);
                            frame.getContentPane().add(facilitatorHome,BorderLayout.CENTER);
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
                            frame.getContentPane().add(studentNavbar,BorderLayout.NORTH);
                            frame.getContentPane().add(studentHome,BorderLayout.CENTER);
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
                frame.getContentPane().add(adminNavbar,BorderLayout.NORTH);
                frame.getContentPane().add(adminAddFacilitator,BorderLayout.CENTER);
                frame.getContentPane().revalidate();
                frame.getContentPane().repaint();
            }
        });
        //event on clicking view facilitator in admin section
        aviewFacilitator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(adminNavbar,BorderLayout.NORTH);
                frame.getContentPane().add(adminViewFacilitator,BorderLayout.CENTER);
                frame.getContentPane().revalidate();
                frame.getContentPane().repaint();
            }
        });
        //event on clicking add student in admin section
        aaddStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(adminNavbar,BorderLayout.NORTH);
                frame.getContentPane().add(adminAddStudent,BorderLayout.CENTER);
                frame.getContentPane().revalidate();
                frame.getContentPane().repaint();
            }
        });
        //event on clicking view student in admin section
        aviewStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(adminNavbar,BorderLayout.NORTH);
                frame.getContentPane().add(adminViewStudent,BorderLayout.CENTER);
                frame.getContentPane().revalidate();
                frame.getContentPane().repaint();
            }
        });
        //event on clicking add marks in admin section
        aaddMarks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(adminNavbar,BorderLayout.NORTH);
                frame.getContentPane().add(adminAddMarks1,BorderLayout.CENTER);
                frame.getContentPane().revalidate();
                frame.getContentPane().repaint();
            }
        });
        //event on clicking view marks in admin section
        aViewMarks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(adminNavbar,BorderLayout.NORTH);
                frame.getContentPane().add(adminViewMarks,BorderLayout.CENTER);
                frame.getContentPane().revalidate();
                frame.getContentPane().repaint();
            }
        });

        //event on clicking home in the admin section
        ahome.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(adminNavbar,BorderLayout.NORTH);
                frame.getContentPane().add(adminHome,BorderLayout.CENTER);
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
                frame.getContentPane().add(facilitatorNavbar,BorderLayout.NORTH);
                frame.getContentPane().add(facilitatorViewFacilitator,BorderLayout.CENTER);
                frame.getContentPane().revalidate();
                frame.getContentPane().repaint();
            }
        });

        //event on clicking view student in admin section
        aviewStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(facilitatorNavbar,BorderLayout.NORTH);
                frame.getContentPane().add(facilitatorViewStudent,BorderLayout.CENTER);
                frame.getContentPane().revalidate();
                frame.getContentPane().repaint();
            }
        });
        //event on clicking add marks in facilitator section
        faddMarks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(facilitatorNavbar,BorderLayout.NORTH);
                frame.getContentPane().add(facilitatorAddMarks,BorderLayout.CENTER);
                frame.getContentPane().revalidate();
                frame.getContentPane().repaint();
            }
        });
        //event on clicking view marks in facilitator section
        fViewMarks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(facilitatorNavbar,BorderLayout.NORTH);
                frame.getContentPane().add(facilitatorViewMarks,BorderLayout.CENTER);
                frame.getContentPane().revalidate();
                frame.getContentPane().repaint();
            }
        });

        //event on clicking home in the facilitator section
        fhome.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(facilitatorNavbar,BorderLayout.NORTH);
                frame.getContentPane().add(facilitatorHome,BorderLayout.CENTER);
                frame.getContentPane().revalidate();
                frame.getContentPane().repaint();
            }
        });
        //event on clicking the logout of facilitatorSection
        flogout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(login);
                frame.getContentPane().revalidate();
                frame.getContentPane().repaint();
            }
        });
        //event on clicking the home of student Section
        shome.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(studentNavbar,BorderLayout.NORTH);
                frame.getContentPane().add(studentHome,BorderLayout.CENTER);
                frame.getContentPane().revalidate();
                frame.getContentPane().repaint();
            }
        });
        //event on clicking the logout of studentSection
        slogout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(login);
                frame.getContentPane().revalidate();
                frame.getContentPane().repaint();
            }
        });
        //event on clicking view facilitator in student section
        sviewFacilitator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(studentNavbar,BorderLayout.NORTH);
                frame.getContentPane().add(studentViewFacilitator,BorderLayout.CENTER);
                frame.getContentPane().revalidate();
                frame.getContentPane().repaint();
            }
        });
        //event on clicking view student in student section
        sviewStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(studentNavbar,BorderLayout.NORTH);
                frame.getContentPane().add(studentViewStudent,BorderLayout.CENTER);
                frame.getContentPane().revalidate();
                frame.getContentPane().repaint();
            }
        });
        //event on clicking view marks in student section
        sviewMarks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(studentNavbar,BorderLayout.NORTH);
                frame.getContentPane().add(studentViewMarks,BorderLayout.CENTER);
                frame.getContentPane().revalidate();
                frame.getContentPane().repaint();
            }
        });


        frame.setVisible(true);
    }
}
