import AdminPages.*;
import FacilitatorPages.*;
import Frames.MyFrame;
import Modules.Facilitator;
import Modules.Student;
import Reusable.*;
import StudentPages.StudentHomeRunner;
import StudentPages.StudentViewFacilitator;
import StudentPages.StudentViewMarks;
import StudentPages.StudentViewStudent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainRunner {
    static Connection conn;
    static RefreshButton refreshButton;

    public static void main(String[] s) {

        //these are panel classes obtained from different packages
        MyFrame frame = new MyFrame();
        frame.setLayout(new BorderLayout());
        LoginWindow login = new LoginWindow();
        frame.add(login);
        AdminNavigationBar adminNavbar = new AdminNavigationBar();
        FacilitatorNavigationBar facilitatorNavbar = new FacilitatorNavigationBar();
        StudentNavigationBar studentNavbar = new StudentNavigationBar();
//        studentNavbar.add(refreshButton);
//        adminNavbar.add(refreshButton);
//        facilitatorNavbar.add(refreshButton);
//        studentNavbar.add(refreshButton);


        //these are the objects of the admin panel
        AdminHomeRunner adminHome = new AdminHomeRunner();
        AdminAddFacilitatorRunner adminAddFacilitator = new AdminAddFacilitatorRunner();
        AdminViewFacilitatorRunner adminViewFacilitator = new AdminViewFacilitatorRunner();
        AdminAddStudentRunner adminAddStudent = new AdminAddStudentRunner();
        AdminViewStudentRunner adminViewStudent = new AdminViewStudentRunner();
        AdminViewMarksRunner adminViewMarks = new AdminViewMarksRunner();
        AdminUpdateFacilitatorRunner adminUpdateFacilitator = new AdminUpdateFacilitatorRunner();
        AdminUpdateStudentRunner adminUpdateStudent = new AdminUpdateStudentRunner();
        AdminUpdateMarksRunner adminUpdateMarks = new AdminUpdateMarksRunner();

        //these are the objects of the facilitator panel
        FacilitatorHomeRunner facilitatorHome = new FacilitatorHomeRunner();
        FacilitatorViewFacilitator facilitatorViewFacilitator = new FacilitatorViewFacilitator();
        FacilitatorViewStudent facilitatorViewStudent = new FacilitatorViewStudent();
        FacilitatorViewMarks facilitatorViewMarks = new FacilitatorViewMarks();
        FacilitatorUpdateMarksRunner facilitatorUpdateMarks = new FacilitatorUpdateMarksRunner();
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
        JLabel aphoneDetail = adminHome.getPhoneDetail();
        JLabel aemailDetail = adminHome.getEmailDetail();


        //these are the detail obtained from the facilitatorhomerunner
        JLabel fnameDetail = facilitatorHome.getNameDetail();
        JLabel fuserDetail = facilitatorHome.getUserDetail();
        JLabel fpositionDetail = facilitatorHome.getPositionDetail();
        JLabel fphoneDetail = facilitatorHome.getPhoneDetail();
        JLabel femailDetail = facilitatorHome.getEmailDetail();

        //these are the detail obtained from the studenthomerunner
        JLabel snameDetail = studentHome.getNameDetail();
        JLabel suserDetail = studentHome.getUserDetail();
        JLabel spositionDetail = studentHome.getPositionDetail();
        JLabel sphoneDetail = studentHome.getPhoneDetail();
        JLabel semailDetail = studentHome.getEmailDetail();

        //these are the menu item obtained from the adminavigationbar
        JMenu ahome = adminNavbar.getHome();
        JMenu alogout = adminNavbar.getLogout();
        JMenuItem aaddfacilitator = adminNavbar.getAddFacilitator();
        JMenuItem aviewFacilitator = adminNavbar.getViewFacilitator();
        JMenuItem aaddStudent = adminNavbar.getAddStudent();
        JMenuItem aviewStudent = adminNavbar.getViewStudent();
        JMenuItem aViewMarks = adminNavbar.getViewMarks();

        //these are the menu item obtained from the faciliatornavigation bar
        JMenu fhome = facilitatorNavbar.getHome();
        JMenu flogout = facilitatorNavbar.getLogout();
        JMenuItem fviewFacilitator = facilitatorNavbar.getViewFacilitator();
        JMenuItem fviewStudent = facilitatorNavbar.getViewStudent();
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
        LetUsConnect connect = new LetUsConnect();




        //actionlistener on clicking the login button
        AtomicInteger id_value = new AtomicInteger();
        AtomicReference<String> name_value = new AtomicReference<>();
        AtomicReference<String> user_value = new AtomicReference<>();
        AtomicReference<String> pass_value = new AtomicReference<>();
        AtomicReference<String> usertype = new AtomicReference<>();
        AtomicReference<String> phone_value = new AtomicReference<>();
        AtomicReference<String> email_value = new AtomicReference<>();
        signInBtn.addActionListener(e -> {
            Student student;
            Facilitator facilitator;
            try {
                conn = connect.getConnection();
                String sql = "SELECT * FROM user";
                Statement stmt = conn.createStatement();
                ResultSet result = stmt.executeQuery(sql);
                boolean foundMatch = false;
                while (result.next()) {
                    id_value.set(Integer.parseInt(result.getString("Id")));
                    name_value.set(result.getString("Name"));
                    user_value.set(result.getString("username"));
                    pass_value.set(result.getString("password"));
                    usertype.set(result.getString("usertype"));
                    phone_value.set(result.getString("PhoneNo"));
                    email_value.set(result.getString("Email"));
                    String password = new String(pass.getPassword());
                    String username = user.getText();
                    if (Objects.equals(user_value.get(), username) && Objects.equals(pass_value.get(), password) && Objects.equals(usertype.get(), "admin")) {
                        user.setText("");
                        pass.setText("");
                        anameDetail.setText(name_value.get());
                        auserDetail.setText(user_value.get());
                        apositionDetail.setText(usertype.get());
                        aphoneDetail.setText(phone_value.get());
                        aemailDetail.setText(email_value.get());
                        frame.getContentPane().removeAll();
                        frame.getContentPane().add(adminNavbar, BorderLayout.NORTH);
                        frame.getContentPane().add(adminHome, BorderLayout.CENTER);
                        frame.getContentPane().revalidate();
                        frame.getContentPane().repaint();
                        foundMatch = true;
                    } else if (Objects.equals(user_value.get(), username) && Objects.equals(pass_value.get(), password) && Objects.equals(usertype.get(), "facilitator")) {
                        user.setText("");
                        pass.setText("");
                        facilitator = new Facilitator(id_value.get(), name_value.get(), user_value.get(), pass_value.get(), phone_value.get(), email_value.get());
                        fnameDetail.setText(facilitator.getName());
                        fuserDetail.setText(facilitator.getUsername());
                        fpositionDetail.setText(usertype.get());
                        fphoneDetail.setText(facilitator.getPhoneNumber());
                        femailDetail.setText(facilitator.getEmail());
                        frame.getContentPane().removeAll();
                        frame.getContentPane().add(facilitatorNavbar, BorderLayout.NORTH);
                        frame.getContentPane().add(facilitatorHome, BorderLayout.CENTER);
                        frame.getContentPane().revalidate();
                        frame.getContentPane().repaint();
                        foundMatch = true;

                    } else if (Objects.equals(user_value.get(), username) && Objects.equals(pass_value.get(), password) && Objects.equals(usertype.get(), "student")) {
                        user.setText("");
                        pass.setText("");
                        student = new Student(id_value.get(), name_value.get(), user_value.get(), pass_value.get(), phone_value.get(), email_value.get());
                        snameDetail.setText(student.getName());
                        suserDetail.setText(student.getUsername());
                        spositionDetail.setText(usertype.get());
                        sphoneDetail.setText(student.getPhoneNumber());
                        semailDetail.setText(student.getEmail());
                        frame.getContentPane().removeAll();
                        frame.getContentPane().add(studentNavbar, BorderLayout.NORTH);
                        frame.getContentPane().add(studentHome, BorderLayout.CENTER);
                        frame.getContentPane().add(studentViewMarks,BorderLayout.SOUTH);
                        frame.getContentPane().revalidate();
                        frame.getContentPane().repaint();
                        foundMatch = true;
                    }

                }
                if (!foundMatch) {
                    user.setText("");
                    pass.setText("");
                    JOptionPane.showMessageDialog(frame, "Username or password incorrect", "Error Message", JOptionPane.ERROR_MESSAGE);
                }
                stmt.close();
                result.close();
                conn.close();
            } catch (SQLException err) {
                System.out.println(err);
            }
        });


        //event on entering the enter button in login window
        user.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    pass.requestFocus();
                }
            }
        });

        pass.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (user.getText().trim().isEmpty()) {
                        user.requestFocus();
                    } else {
                        Student student;
                        Facilitator facilitator;

                        try {
                            conn = connect.getConnection();
                            String sql = "SELECT * FROM user";
                            Statement stmt = conn.createStatement();
                            ResultSet result = stmt.executeQuery(sql);
                            boolean foundMatch = false;
                            while (result.next()) {
                                id_value.set(Integer.parseInt(result.getString("Id")));
                                name_value.set(result.getString("Name"));
                                user_value.set(result.getString("username"));
                                pass_value.set(result.getString("password"));
                                usertype.set(result.getString("usertype"));
                                phone_value.set(result.getString("PhoneNo"));
                                email_value.set(result.getString("Email"));
                                String password = new String(pass.getPassword());
                                String username = user.getText();
                                if (Objects.equals(user_value.get(), username) && Objects.equals(pass_value.get(), password) && Objects.equals(usertype.get(), "admin")) {
                                    user.setText("");
                                    pass.setText("");
                                    anameDetail.setText(name_value.get());
                                    auserDetail.setText(user_value.get());
                                    apositionDetail.setText(usertype.get());
                                    aphoneDetail.setText(phone_value.get());
                                    aemailDetail.setText(email_value.get());
                                    frame.getContentPane().removeAll();
                                    frame.getContentPane().add(adminNavbar, BorderLayout.NORTH);
                                    frame.getContentPane().add(adminHome, BorderLayout.CENTER);
                                    frame.getContentPane().revalidate();
                                    frame.getContentPane().repaint();
                                    foundMatch = true;
                                } else if (Objects.equals(user_value.get(), username) && Objects.equals(pass_value.get(), password) && Objects.equals(usertype.get(), "facilitator")) {
                                    user.setText("");
                                    pass.setText("");
                                    facilitator = new Facilitator(id_value.get(), name_value.get(), user_value.get(), pass_value.get(), phone_value.get(), email_value.get());
                                    fnameDetail.setText(facilitator.getName());
                                    fuserDetail.setText(facilitator.getUsername());
                                    fpositionDetail.setText(usertype.get());
                                    fphoneDetail.setText(facilitator.getPhoneNumber());
                                    femailDetail.setText(facilitator.getEmail());
                                    frame.getContentPane().removeAll();
                                    frame.getContentPane().add(facilitatorNavbar, BorderLayout.NORTH);
                                    frame.getContentPane().add(facilitatorHome, BorderLayout.CENTER);
                                    frame.getContentPane().revalidate();
                                    frame.getContentPane().repaint();
                                    foundMatch = true;

                                } else if (Objects.equals(user_value.get(), username) && Objects.equals(pass_value.get(), password) && Objects.equals(usertype.get(), "student")) {
                                    user.setText("");
                                    pass.setText("");
                                    student = new Student(id_value.get(), name_value.get(), user_value.get(), pass_value.get(), phone_value.get(), email_value.get());
                                    snameDetail.setText(student.getName());
                                    suserDetail.setText(student.getUsername());
                                    spositionDetail.setText(usertype.get());
                                    sphoneDetail.setText(student.getPhoneNumber());
                                    semailDetail.setText(student.getEmail());
                                    frame.getContentPane().removeAll();
                                    frame.getContentPane().add(studentNavbar, BorderLayout.NORTH);
                                    frame.getContentPane().add(studentHome, BorderLayout.CENTER);
                                    frame.getContentPane().add(studentViewMarks,BorderLayout.SOUTH);
                                    frame.getContentPane().revalidate();
                                    frame.getContentPane().repaint();
                                    foundMatch = true;
                                }

                            }
                            if (!foundMatch) {
                                user.setText("");
                                pass.setText("");
                                JOptionPane.showMessageDialog(frame, "Username or password incorrect", "Error Message", JOptionPane.ERROR_MESSAGE);
                            }
                            stmt.close();
                            result.close();
                            conn.close();
                        } catch (SQLException err) {
                            System.out.println(err);
                        }
                    }
                }
            }
        });

        //event on clicking add facilitator in admin section

        aaddfacilitator.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.getContentPane().add(adminNavbar, BorderLayout.NORTH);
            frame.getContentPane().add(adminAddFacilitator, BorderLayout.CENTER);
            frame.getContentPane().revalidate();
            frame.getContentPane().repaint();
        });
        //event on clicking view facilitator in admin section
        aviewFacilitator.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.getContentPane().add(adminNavbar, BorderLayout.NORTH);
            frame.getContentPane().add(adminViewFacilitator, BorderLayout.CENTER);
            frame.getContentPane().add(adminUpdateFacilitator, BorderLayout.EAST);
            frame.getContentPane().revalidate();
            frame.getContentPane().repaint();
        });
        //event on clicking add student in admin section
        aaddStudent.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.getContentPane().add(adminNavbar, BorderLayout.NORTH);
            frame.getContentPane().add(adminAddStudent, BorderLayout.CENTER);
            frame.getContentPane().revalidate();
            frame.getContentPane().repaint();
        });
        //event on clicking view student in admin section
        aviewStudent.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.getContentPane().add(adminNavbar, BorderLayout.NORTH);
            frame.getContentPane().add(adminViewStudent, BorderLayout.CENTER);
            frame.getContentPane().add(adminUpdateStudent, BorderLayout.EAST);
            frame.getContentPane().revalidate();
            frame.getContentPane().repaint();
        });

        //event on clicking view marks in admin section
        aViewMarks.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.getContentPane().add(adminNavbar, BorderLayout.NORTH);
            frame.getContentPane().add(adminViewMarks, BorderLayout.CENTER);
            frame.getContentPane().add(adminUpdateMarks, BorderLayout.EAST);
            frame.getContentPane().revalidate();
            frame.getContentPane().repaint();
        });

        //event on clicking home in the admin section
        ahome.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(adminNavbar, BorderLayout.NORTH);
                frame.getContentPane().add(adminHome, BorderLayout.CENTER);
                frame.getContentPane().add(adminViewMarks,BorderLayout.SOUTH);
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
        fviewFacilitator.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.getContentPane().add(facilitatorNavbar, BorderLayout.NORTH);
            frame.getContentPane().add(facilitatorViewFacilitator, BorderLayout.CENTER);
            frame.getContentPane().revalidate();
            frame.getContentPane().repaint();
        });
        //event on clicking view student in facilitator section
        fviewStudent.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.getContentPane().add(facilitatorNavbar, BorderLayout.NORTH);
            frame.getContentPane().add(facilitatorViewStudent, BorderLayout.CENTER);
            frame.getContentPane().revalidate();
            frame.getContentPane().repaint();
        });

        //event on clicking view student in admin section
        aviewStudent.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.getContentPane().add(facilitatorNavbar, BorderLayout.NORTH);
            frame.getContentPane().add(facilitatorViewStudent, BorderLayout.CENTER);
            frame.getContentPane().revalidate();
            frame.getContentPane().repaint();
        });
        //event on clicking view marks in facilitator section
        fViewMarks.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.getContentPane().add(facilitatorNavbar, BorderLayout.NORTH);
            frame.getContentPane().add(facilitatorViewMarks, BorderLayout.CENTER);
            frame.getContentPane().add(facilitatorUpdateMarks,BorderLayout.EAST);
            frame.getContentPane().revalidate();
            frame.getContentPane().repaint();
        });

        //event on clicking home in the facilitator section
        fhome.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(facilitatorNavbar, BorderLayout.NORTH);
                frame.getContentPane().add(facilitatorHome, BorderLayout.CENTER);
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
                frame.getContentPane().add(studentNavbar, BorderLayout.NORTH);
                frame.getContentPane().add(studentHome, BorderLayout.CENTER);
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
        sviewFacilitator.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.getContentPane().add(studentNavbar, BorderLayout.NORTH);
            frame.getContentPane().add(studentViewFacilitator, BorderLayout.CENTER);
            frame.getContentPane().revalidate();
            frame.getContentPane().repaint();
        });
        //event on clicking view student in student section
        sviewStudent.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.getContentPane().add(studentNavbar, BorderLayout.NORTH);
            frame.getContentPane().add(studentViewStudent, BorderLayout.CENTER);
            frame.getContentPane().revalidate();
            frame.getContentPane().repaint();
        });
        //event on clicking view marks in student section
        sviewMarks.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.getContentPane().add(studentNavbar, BorderLayout.NORTH);
            frame.getContentPane().add(studentViewMarks, BorderLayout.CENTER);
            frame.getContentPane().revalidate();
            frame.getContentPane().repaint();
        });


        JButton assubmitbutton = adminAddStudent.getSubmitButton();
        JTextField asnameField = adminAddStudent.getNameField();
        JTextField asusernameField = adminAddStudent.getUsernameField();
        JTextField aspasswordField = adminAddStudent.getPasswordField();
        JTextField asPhoneField = adminAddStudent.getPhoneField();
        JTextField asemailField = adminAddStudent.getEmailField();
        JTextField asparentField = adminAddStudent.getParentField();
        assubmitbutton.addActionListener(e -> {
            String name = asnameField.getText();
            String username = asusernameField.getText();
            String password = aspasswordField.getText();
            String phoneNo = asPhoneField.getText();
            String email = asemailField.getText();
            String parentName = asparentField.getText();
            PreparedStatement stmt = null;
            PreparedStatement stmt1 = null;
            PreparedStatement stmt2 = null;
            // Regular expression pattern for email validation
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";

            // Create a Pattern object and compile the regular expression
            Pattern pattern = Pattern.compile(emailRegex);

            // Match the input string with the regular expression pattern
            Matcher matcher = pattern.matcher(email);

            if (name.equals("") || username.equals("") || password.equals("") || phoneNo.equals("") || email.equals("") || parentName.equals("")) {

                JOptionPane.showMessageDialog(frame, "Fields cannot be empty.", "Empty", JOptionPane.WARNING_MESSAGE);
            } else {
                if (matcher.matches()) {
                    try {
                        conn = connect.getConnection();
                        stmt = conn.prepareStatement("INSERT INTO user(username,password,usertype,Name,PhoneNo,Email) VALUES(?,?,?,?,?,?) ", Statement.RETURN_GENERATED_KEYS);
                        stmt.setString(1, username);
                        stmt.setString(2, password);
                        stmt.setString(3, "student");
                        stmt.setString(4, name);
                        stmt.setString(5, phoneNo);
                        stmt.setString(6, email);
                        stmt.executeUpdate();

                        stmt1 = conn.prepareStatement("INSERT INTO student(username,Name,PhoneNo,Email,ParentName) VALUES(?,?,?,?,?)");
                        stmt1.setString(1, username);
                        stmt1.setString(2, name);
                        stmt1.setString(3, phoneNo);
                        stmt1.setString(4, email);
                        stmt1.setString(5, parentName);
                        stmt1.executeUpdate();

                        stmt2 = conn.prepareStatement("INSERT INTO marks(username) VALUES(?)");
                        stmt2.setString(1, username);
                        stmt2.executeUpdate();

                        asnameField.setText("");
                        asusernameField.setText("");
                        aspasswordField.setText("");
                        asPhoneField.setText("");
                        asemailField.setText("");
                        asparentField.setText("");
                        JOptionPane.showMessageDialog(frame, "Student inserted into the database", "Insertion Successful.", JOptionPane.INFORMATION_MESSAGE);
                        conn.close();
                        stmt1.close();
                        stmt.close();
                        stmt2.close();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    } finally {
                        if (stmt != null) {
                            try {
                                stmt.close();
                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Not a valid email.", "Not Valid", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //admin view student
        DefaultTableModel tableModelA = adminViewStudent.getTableModel();
        JTable tableA = adminViewStudent.getTable();
        JButton removeBtnS = adminViewStudent.getRemoveBtn();
        JButton updateBtnS = adminViewStudent.getUpdateBtn();
        JButton updateBtnAS = adminUpdateStudent.getSubmitBtn();
        Statement stmt = null;
        try {
            conn = connect.getConnection();
            String sql = "SELECT * FROM student";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);


            // Iterate over the result set and add the data to the table model
            while (rs.next()) {
                int sid = rs.getInt("SID");
                String name = rs.getString("Name");
                String username = rs.getString("Username");
                String phoneNo = rs.getString("PhoneNo");
                String email = rs.getString("Email");
                String parentName = rs.getString("ParentName");
                String[] vals = {String.valueOf(sid), name, username, phoneNo, email, parentName};
                tableModelA.addRow(vals);
            }
            conn.close();
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //remove button to delete the data
        removeBtnS.addActionListener(e -> {
            int selectedRow = tableA.getSelectedRow();
            if (selectedRow != -1) {
                String username = (String) tableA.getValueAt(selectedRow, 2);
                try {
                    conn = connect.getConnection();
                    String SQLDeleteUserTable = "DELETE FROM user WHERE username =? ";
                    String SQLDeleteStudentTable = "DELETE FROM student WHERE username=?";
                    String SQLDeleteMarksTable = "DELETE FROM marks WHERE username=?";
                    PreparedStatement preparedStatementUserTable = conn.prepareStatement(SQLDeleteUserTable);
                    PreparedStatement preparedStatementStudentTable = conn.prepareStatement(SQLDeleteStudentTable);
                    PreparedStatement preparedStatementMarksTable = conn.prepareStatement(SQLDeleteMarksTable);
                    preparedStatementUserTable.setString(1, username);
                    preparedStatementStudentTable.setString(1, username);
                    preparedStatementMarksTable.setString(1, username);
                    int rowsAffected1 = preparedStatementUserTable.executeUpdate();
                    int rowsAffected2 = preparedStatementStudentTable.executeUpdate();
                    int rowsAffected3 = preparedStatementMarksTable.executeUpdate();

                    if (rowsAffected1 > 0 || rowsAffected2 > 0 || rowsAffected3 > 0) {
                        JOptionPane.showMessageDialog(frame, "Content deleted successfully.");
                        tableModelA.removeRow(selectedRow);
                        conn.close();
                    } else {
                        JOptionPane.showMessageDialog(frame, "Content not found for the given ID.");
                    }
                    preparedStatementUserTable.close();
                    preparedStatementStudentTable.close();
                    preparedStatementMarksTable.close();
                    conn.close();
                } catch (SQLException error) {
                    throw new RuntimeException(error);
                }
            } else {
                JOptionPane.showMessageDialog(frame, "No content selected");
            }
        });
        JTextField nameTextField = adminUpdateStudent.getNameTextField();
        JTextField emailTextField = adminUpdateStudent.getEmailTextField();
        JTextField numberTextField = adminUpdateStudent.getPhoneNumberTextField();
        JTextField parentNameTextField = adminUpdateStudent.getParentNameTextField();
        JLabel usernameLabel = adminUpdateStudent.getUsernameLabel();

        //update button to transfer the data
        updateBtnS.addActionListener(e -> {
            int selectedRow = tableA.getSelectedRow();
            if (selectedRow != -1) {
                String name = (String) tableA.getValueAt(selectedRow, 1);
                String username = (String) tableA.getValueAt(selectedRow, 2);
                String phoneNumber = (String) tableA.getValueAt(selectedRow, 3);
                String email = (String) tableA.getValueAt(selectedRow, 4);
                String parentName = (String) tableA.getValueAt(selectedRow, 5);
                nameTextField.setText(name);
                usernameLabel.setText(username);
                emailTextField.setText(email);
                numberTextField.setText(phoneNumber);
                parentNameTextField.setText(parentName);
            } else {
                JOptionPane.showMessageDialog(frame, "No content selected");
            }
        });
        //submit button for updating
        updateBtnAS.addActionListener(e -> {
            try {
                conn = connect.getConnection();
                String SQLUpdateUserTable = "UPDATE user SET Name=?,PhoneNo=?,Email=? WHERE username=?";
                String SQLUpdateStudentTable = "UPDATE student SET Name=?,ParentName=?,PhoneNo=?,Email=? WHERE username=?";
                PreparedStatement preparedStatementUpdateUserTable = conn.prepareStatement(SQLUpdateUserTable);
                preparedStatementUpdateUserTable.setString(1, nameTextField.getText());
                preparedStatementUpdateUserTable.setString(2, numberTextField.getText());
                preparedStatementUpdateUserTable.setString(3, emailTextField.getText());
                preparedStatementUpdateUserTable.setString(4, usernameLabel.getText());
                System.out.println("hello");
                PreparedStatement preparedStatementUpdateStudentTable = conn.prepareStatement(SQLUpdateStudentTable);
                preparedStatementUpdateStudentTable.setString(1, nameTextField.getText());
                preparedStatementUpdateStudentTable.setString(2, parentNameTextField.getText());
                preparedStatementUpdateStudentTable.setString(3, numberTextField.getText());
                preparedStatementUpdateStudentTable.setString(4, emailTextField.getText());
                preparedStatementUpdateStudentTable.setString(5, usernameLabel.getText());
                int rowsAffected1 = preparedStatementUpdateUserTable.executeUpdate();
                int rowsAffected2 = preparedStatementUpdateStudentTable.executeUpdate();
                if (rowsAffected1 > 0 || rowsAffected2 > 0) {
                    JOptionPane.showMessageDialog(frame, "Updated successfully");
                    tableA.repaint();
                }
                nameTextField.setText("");
                numberTextField.setText("");
                emailTextField.setText("");
                usernameLabel.setText("");
                parentNameTextField.setText("");

                preparedStatementUpdateStudentTable.close();
                preparedStatementUpdateUserTable.close();
                conn.close();

            } catch (SQLException error) {
                JOptionPane.showMessageDialog(frame, "Updation error");
            }
        });


        //admin view facilitator
        DefaultTableModel tableModelAF = adminViewFacilitator.getTableModel();
        JTable tableAF = adminViewFacilitator.getTable();
        JButton removeBtnF = adminViewFacilitator.getRemoveBtn();
        JButton updateBtnF = adminViewFacilitator.getUpdateBtn();
        JButton updateBtnAF = adminUpdateFacilitator.getSubmitBtn();

        try {
            conn = connect.getConnection();
            String sql = "SELECT * FROM facilitator";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Iterate over the result set and add the data to the table model
            while (rs.next()) {
                int sid = rs.getInt("FID");
                String name = rs.getString("Name");
                String username = rs.getString("username");
                String phoneNo = rs.getString("PhoneNo");
                String email = rs.getString("Email");
                String subName = rs.getString("SubName");
                String[] vals = {String.valueOf(sid), name, username, phoneNo, email, subName};
                tableModelAF.addRow(vals);
            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //delete data from facilitator
        removeBtnF.addActionListener(e -> {
            int selectedRow = tableAF.getSelectedRow();
            if (selectedRow != -1) {
                String name = (String) tableAF.getValueAt(selectedRow, 1);
                String username = (String) tableAF.getValueAt(selectedRow, 2);
                String phoneNumber = (String) tableAF.getValueAt(selectedRow, 3);
                String email = (String) tableAF.getValueAt(selectedRow, 4);
                String subName = (String) tableAF.getValueAt(selectedRow, 5);
                try {
                    conn = connect.getConnection();
                    String SQLDeleteUserTable = "DELETE FROM user WHERE username =? ";
                    String SQLDeleteFacilitatorTable = "DELETE FROM facilitator WHERE username=?";
                    PreparedStatement preparedStatementUserTable = conn.prepareStatement(SQLDeleteUserTable);
                    PreparedStatement preparedStatementFacilitatorTable = conn.prepareStatement(SQLDeleteFacilitatorTable);
                    preparedStatementUserTable.setString(1, username);
                    preparedStatementFacilitatorTable.setString(1, username);
                    int rowsAffected1 = preparedStatementUserTable.executeUpdate();
                    int rowsAffected2 = preparedStatementFacilitatorTable.executeUpdate();

                    if (rowsAffected1 > 0 || rowsAffected2 > 0) {
                        JOptionPane.showMessageDialog(frame, "Content deleted successfully.");
                        tableModelAF.removeRow(selectedRow);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Content not found for the given ID.");
                    }
                    preparedStatementFacilitatorTable.close();
                    preparedStatementUserTable.close();
                    conn.close();
                } catch (SQLException error) {
                    throw new RuntimeException(error);
                }
            } else {
                JOptionPane.showMessageDialog(frame, "No content selected");
            }
        });

        //transfer data to the facilitator update
        JTextField nameTextFieldF = adminUpdateFacilitator.getNameTextField();
        JTextField emailTextFieldF = adminUpdateFacilitator.getEmailTextField();
        JTextField numberTextFieldF = adminUpdateFacilitator.getPhoneNumberTextField();
        JComboBox<String> subNameTextFieldF = adminUpdateFacilitator.getSubNameTextField();
        JLabel usernameLabelF = adminUpdateFacilitator.getUsernameLabel();
        updateBtnF.addActionListener(e -> {
            int selectedRow = tableAF.getSelectedRow();
            if (selectedRow != -1) {
                String name = (String) tableAF.getValueAt(selectedRow, 1);
                String username = (String) tableAF.getValueAt(selectedRow, 2);
                String phoneNumber = (String) tableAF.getValueAt(selectedRow, 3);
                String email = (String) tableAF.getValueAt(selectedRow, 4);
                String subName = (String) tableAF.getValueAt(selectedRow, 5);
                nameTextFieldF.setText(name);
                usernameLabelF.setText(username);
                emailTextFieldF.setText(email);
                numberTextFieldF.setText(phoneNumber);
                subNameTextFieldF.setSelectedItem(subName);
            } else {
                JOptionPane.showMessageDialog(frame, "No content selected");
            }
        });

        //submit button for updating in facilitator
        updateBtnAF.addActionListener(e -> {
            try {
                conn = connect.getConnection();
                String SQLUpdateUserTable = "UPDATE user SET Name=?,PhoneNo=?,Email=? WHERE username=?";
                String SQLUpdateFacilitatorTable = "UPDATE facilitator SET Name=?,SubName=?,PhoneNo=?,Email=? WHERE username=?";
                PreparedStatement preparedStatementUpdateUserTable = conn.prepareStatement(SQLUpdateUserTable);
                preparedStatementUpdateUserTable.setString(1, nameTextFieldF.getText());
                preparedStatementUpdateUserTable.setString(2, numberTextFieldF.getText());
                preparedStatementUpdateUserTable.setString(3, emailTextFieldF.getText());
                preparedStatementUpdateUserTable.setString(4, usernameLabelF.getText());
                PreparedStatement preparedStatementUpdateFacilitatorTable = conn.prepareStatement(SQLUpdateFacilitatorTable);
                preparedStatementUpdateFacilitatorTable.setString(1, nameTextFieldF.getText());
                preparedStatementUpdateFacilitatorTable.setString(2, subNameTextFieldF.getSelectedItem().toString());
                preparedStatementUpdateFacilitatorTable.setString(3, numberTextFieldF.getText());
                preparedStatementUpdateFacilitatorTable.setString(4, emailTextFieldF.getText());
                preparedStatementUpdateFacilitatorTable.setString(5, usernameLabelF.getText());

                int rowsAffected1 = preparedStatementUpdateUserTable.executeUpdate();
                int rowsAffected2 = preparedStatementUpdateFacilitatorTable.executeUpdate();
                if (rowsAffected1 > 0 || rowsAffected2 > 0) {
                    JOptionPane.showMessageDialog(frame, "Updated successfully");
                    tableAF.repaint();
                }
                nameTextFieldF.setText("");
                numberTextFieldF.setText("");
                emailTextFieldF.setText("");
                usernameLabelF.setText("");
                subNameTextFieldF.setSelectedItem("Physics");
                preparedStatementUpdateUserTable.close();
                preparedStatementUpdateFacilitatorTable.close();
                conn.close();
            } catch (SQLException error) {
                JOptionPane.showMessageDialog(frame, "Updation error");
            }
        });

        //admin add facilitator
        JButton afsubmitbutton = adminAddFacilitator.getSubmitButton();
        JTextField afnameField = adminAddFacilitator.getNameField();
        JTextField afusernameField = adminAddFacilitator.getUsernameField();
        JTextField afpasswordField = adminAddFacilitator.getPasswordField();
        JTextField afPhoneField = adminAddFacilitator.getPhoneField();
        JTextField afemailField = adminAddFacilitator.getEmailField();
        JComboBox<String> afsubField = adminAddFacilitator.getSubField();
        afsubmitbutton.addActionListener(e -> {
            String name = afnameField.getText();
            String username = afusernameField.getText();
            String password = afpasswordField.getText();
            String phoneNo = afPhoneField.getText();
            String email = afemailField.getText();
            Object subName = afsubField.getSelectedItem();
            System.out.println(subName);
            System.out.println();
            PreparedStatement stmt12 = null;
            PreparedStatement stmt1 = null;
            // Regular expression pattern for email validation
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";

            // Create a Pattern object and compile the regular expression
            Pattern pattern = Pattern.compile(emailRegex);

            // Match the input string with the regular expression pattern
            Matcher matcher = pattern.matcher(email);

            if (name.equals("") || username.equals("") || password.equals("") || phoneNo.equals("") || email.equals("") || subName.equals("")) {
                JOptionPane.showMessageDialog(frame, "Fields cannot be empty.", "Empty", JOptionPane.WARNING_MESSAGE);
            } else {
                if (matcher.matches()) {
                    try {
                        conn = connect.getConnection();
                        stmt12 = conn.prepareStatement("INSERT INTO user(username,password,usertype,Name,PhoneNo,Email) VALUES(?,?,?,?,?,?) ");
                        stmt12.setString(1, username);
                        stmt12.setString(2, password);
                        stmt12.setString(3, "facilitator");
                        stmt12.setString(4, name);
                        stmt12.setString(5, phoneNo);
                        stmt12.setString(6, email);
                        stmt12.executeUpdate();

                        stmt1 = conn.prepareStatement("INSERT INTO facilitator(username,Name,PhoneNo,Email,SubName) VALUES(?,?,?,?,?)");
                        stmt1.setString(1, username);
                        stmt1.setString(2, name);
                        stmt1.setString(3, phoneNo);
                        stmt1.setString(4, email);
                        stmt1.setString(5, subName.toString());
                        stmt1.executeUpdate();

                        afnameField.setText("");
                        afusernameField.setText("");
                        afpasswordField.setText("");
                        afPhoneField.setText("");
                        afemailField.setText("");
                        afsubField.setSelectedItem("Physics");
                        JOptionPane.showMessageDialog(frame, "Facilitator inserted into the database", "Insertion Successful.", JOptionPane.INFORMATION_MESSAGE);
                        stmt12.close();
                        stmt1.close();
                        conn.close();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    } finally {
                        if (stmt12 != null) {
                            try {
                                stmt12.close();
                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Not a valid email.", "Not Valid", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        //view marks in admin section
        JTable tableAM = adminViewMarks.getTable();
        DefaultTableModel tableModelAM = adminViewMarks.getTableModel();
        JButton updateBtnM = adminViewMarks.getEditBtn();
        JButton updateBtnAM = adminUpdateMarks.getSubmitButton();
        try {
            conn = connect.getConnection();
            String sql = "SELECT * FROM marks";
            PreparedStatement preparedStatementValidateUserLookMark = conn.prepareStatement(sql);
            ResultSet rs = preparedStatementValidateUserLookMark.executeQuery();
            while (rs.next()) {
                String username = rs.getString("username");
                String physics = rs.getString("physics");
                String chemistry = rs.getString("chemistry");
                String biology = rs.getString("biology");
                String maths = rs.getString("maths");
                String nepali = rs.getString("nepali");
                String english = rs.getString("english");
                String totalMarks = rs.getString("totalMarks");
                String percent = rs.getString("percent");
                String rank = rs.getString("rank");
                String[] vals = {username, physics, chemistry, biology, maths, nepali, english, totalMarks, percent, rank};
                tableModelAM.addRow(vals);
            }
            rs.next();
            preparedStatementValidateUserLookMark.close();
            conn.close();
        } catch (SQLException e1) {
            throw new RuntimeException(e1);
        }

        //transfer data in the marks section of admin
        JLabel usernameFieldM = adminUpdateMarks.getUsernameField();
        JTextField physicsFieldM = adminUpdateMarks.getPhysicsField();
        JTextField chemistryFieldM = adminUpdateMarks.getChemistryField();
        JTextField biologyFieldM = adminUpdateMarks.getBiologyField();
        JTextField mathsFieldM = adminUpdateMarks.getMathField();
        JTextField nepaliFieldM = adminUpdateMarks.getNepaliField();
        JTextField englishFieldM = adminUpdateMarks.getEnglishField();

        updateBtnM.addActionListener(e -> {
            int selectedRow = tableAM.getSelectedRow();
            if (selectedRow != -1) {
                String username = (String) tableAM.getValueAt(selectedRow, 0);
                String physicsNumber = (String) tableAM.getValueAt(selectedRow, 1);
                String chemistryNumber = (String) tableAM.getValueAt(selectedRow, 2);
                String biologyNumber = (String) tableAM.getValueAt(selectedRow, 3);
                String mathsNumber = (String) tableAM.getValueAt(selectedRow, 4);
                String nepaliNumber = (String) tableAM.getValueAt(selectedRow, 5);
                String englishNumber = (String) tableAM.getValueAt(selectedRow, 6);
                usernameFieldM.setText(username);
                physicsFieldM.setText(physicsNumber);
                chemistryFieldM.setText(chemistryNumber);
                biologyFieldM.setText(biologyNumber);
                mathsFieldM.setText(mathsNumber);
                nepaliFieldM.setText(nepaliNumber);
                englishFieldM.setText(englishNumber);
            } else {
                JOptionPane.showMessageDialog(frame, "No Content Selected.");
            }
        });

        //submit button for updating marks in admin
        updateBtnAM.addActionListener(e -> {
            try {
                conn = connect.getConnection();
                String SQLMarksUpdateTable = "UPDATE marks SET physics=?,chemistry=?,biology=?,maths=?,nepali=?,english=? WHERE username =?";
                PreparedStatement preparedStatementUpdateMarksTable = conn.prepareStatement(SQLMarksUpdateTable);
                preparedStatementUpdateMarksTable.setString(1, physicsFieldM.getText());
                preparedStatementUpdateMarksTable.setString(2, chemistryFieldM.getText());
                preparedStatementUpdateMarksTable.setString(3, biologyFieldM.getText());
                preparedStatementUpdateMarksTable.setString(4, mathsFieldM.getText());
                preparedStatementUpdateMarksTable.setString(5, nepaliFieldM.getText());
                preparedStatementUpdateMarksTable.setString(6, englishFieldM.getText());
                preparedStatementUpdateMarksTable.setString(7,usernameFieldM.getText());
                int rowsAffected = preparedStatementUpdateMarksTable.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(frame, "Update Successfully");
                    tableAM.repaint();
                }
                usernameFieldM.setText("");
                physicsFieldM.setText("");
                chemistryFieldM.setText("");
                biologyFieldM.setText("");
                mathsFieldM.setText("");
                nepaliFieldM.setText("");
                englishFieldM.setText("");
                preparedStatementUpdateMarksTable.close();
                conn.close();
            } catch (SQLException error) {
                JOptionPane.showMessageDialog(frame, "Updation error");
            }
        });


        //view student in facilitator
        DefaultTableModel tableModelF = facilitatorViewStudent.getTableModel();
        JTable tableF = facilitatorViewStudent.getTable();

        try {
            conn = connect.getConnection();
            String sql = "SELECT * FROM student";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Iterate over the result set and add the data to the table model
            while (rs.next()) {
                int sid = rs.getInt("SID");
                String name = rs.getString("Name");
                String username = rs.getString("Username");
                String phoneNo = rs.getString("PhoneNo");
                String email = rs.getString("Email");
                String parentName = rs.getString("ParentName");
                String[] vals = {String.valueOf(sid), name, username, phoneNo, email, parentName};
                tableModelF.addRow(vals);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //view facilitator in facilitator
        DefaultTableModel tableModelFF = facilitatorViewFacilitator.getTableModel();
        JTable tableFF = facilitatorViewFacilitator.getTable();
        try {
            conn = connect.getConnection();
            String sql = "SELECT * FROM facilitator";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Iterate over the result set and add the data to the table model
            while (rs.next()) {
                int sid = rs.getInt("FID");
                String name = rs.getString("Name");
                String username = rs.getString("Username");
                String phoneNo = rs.getString("PhoneNo");
                String email = rs.getString("Email");
                String subName = rs.getString("SubName");
                String[] vals = {String.valueOf(sid), name, username, phoneNo, email, subName};
                tableModelFF.addRow(vals);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //view marks in facilitator section
        JTable tableFM = facilitatorViewMarks.getTable();
        DefaultTableModel tableModelFM = facilitatorViewMarks.getTableModel();
        JButton updateBtnEM = facilitatorViewMarks.getEditBtn();
        JButton updateBtnFM = facilitatorUpdateMarks.getSubmitButton();
        try {
            conn = connect.getConnection();
            String sql = "SELECT * FROM marks";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                    String username = rs.getString("username");
                    String physics = rs.getString("physics");
                    String chemistry = rs.getString("chemistry");
                    String biology = rs.getString("biology");
                    String maths = rs.getString("maths");
                    String nepali = rs.getString("nepali");
                    String english = rs.getString("english");
                    String totalMarks = rs.getString("totalMarks");
                    String percent = rs.getString("percent");
                    String rank = rs.getString("rank");
                    String[] vals = {username, physics, chemistry, biology, maths, nepali, english, totalMarks, percent, rank};
                    tableModelFM.addRow(vals);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e1) {
            throw new RuntimeException(e1);
        }

        //transfer data in the marks section in facilitator section
        JLabel usernameFieldFM = facilitatorUpdateMarks.getUsernameField();
        JTextField physicsFieldFM = facilitatorUpdateMarks.getPhysicsField();
        JTextField chemistryFieldFM = facilitatorUpdateMarks.getChemistryField();
        JTextField biologyFieldFM = facilitatorUpdateMarks.getBiologyField();
        JTextField mathsFieldFM = facilitatorUpdateMarks.getMathField();
        JTextField nepaliFieldFM = facilitatorUpdateMarks.getNepaliField();
        JTextField englishFieldFM = facilitatorUpdateMarks.getEnglishField();
        updateBtnEM.addActionListener(e->{
            int selectedRow = tableFM.getSelectedRow();
            if(selectedRow != -1){
                String username = (String) tableFM.getValueAt(selectedRow, 0);
                String physicsNumber = (String) tableFM.getValueAt(selectedRow, 1);
                String chemistryNumber = (String) tableFM.getValueAt(selectedRow, 2);
                String biologyNumber = (String) tableFM.getValueAt(selectedRow, 3);
                String mathsNumber = (String) tableFM.getValueAt(selectedRow, 4);
                String nepaliNumber = (String) tableFM.getValueAt(selectedRow, 5);
                String englishNumber = (String) tableFM.getValueAt(selectedRow, 6);
                usernameFieldFM.setText(username);
                physicsFieldFM.setText(physicsNumber);
                chemistryFieldFM.setText(chemistryNumber);
                biologyFieldFM.setText(biologyNumber);
                mathsFieldFM.setText(mathsNumber);
                nepaliFieldFM.setText(nepaliNumber);
                englishFieldFM.setText(englishNumber);
            } else {
                JOptionPane.showMessageDialog(frame, "No Content Selected.");
            }

        });

        //submit the udpated data in the facilitator section
        updateBtnFM.addActionListener(e->{
            try {
                conn = connect.getConnection();
                String SQLMarksUpdateTable = "UPDATE marks SET physics=?,chemistry=?,biology=?,maths=?,nepali=?,english=? WHERE username =?";
                PreparedStatement preparedStatementUpdateMarksTable = conn.prepareStatement(SQLMarksUpdateTable);
                preparedStatementUpdateMarksTable.setString(1, physicsFieldFM.getText());
                preparedStatementUpdateMarksTable.setString(2, chemistryFieldFM.getText());
                preparedStatementUpdateMarksTable.setString(3, biologyFieldFM.getText());
                preparedStatementUpdateMarksTable.setString(4, mathsFieldFM.getText());
                preparedStatementUpdateMarksTable.setString(5, nepaliFieldFM.getText());
                preparedStatementUpdateMarksTable.setString(6, englishFieldFM.getText());
                preparedStatementUpdateMarksTable.setString(7,usernameFieldFM.getText());
                int rowsAffected = preparedStatementUpdateMarksTable.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(frame, "Update Successfully");
                    tableAM.repaint();
                }
                usernameFieldFM.setText("");
                physicsFieldFM.setText("");
                chemistryFieldFM.setText("");
                biologyFieldFM.setText("");
                mathsFieldFM.setText("");
                nepaliFieldFM.setText("");
                englishFieldFM.setText("");
                preparedStatementUpdateMarksTable.close();
                conn.close();
            } catch (SQLException error) {
                JOptionPane.showMessageDialog(frame, "Updation error");
            }
        });


        //view student in student section
        DefaultTableModel tableModelSS = studentViewStudent.getTableModel();
        JTable tableSS = studentViewStudent.getTable();
        try {
            conn = connect.getConnection();
            String sql = "SELECT * FROM student";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Iterate over the result set and add the data to the table model
            while (rs.next()) {
                int sid = rs.getInt("SID");
                String name = rs.getString("Name");
                String username = rs.getString("Username");
                String phoneNo = rs.getString("PhoneNo");
                String email = rs.getString("Email");
                String parentName = rs.getString("ParentName");
                String[] vals = {String.valueOf(sid), name, username, phoneNo, email, parentName};
                tableModelSS.addRow(vals);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //view facilitator in student section
        DefaultTableModel tableModelSF = studentViewFacilitator.getTableModel();
        JTable tableSF = adminViewFacilitator.getTable();
        try {
            conn = connect.getConnection();
            String sql = "SELECT * FROM facilitator";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Iterate over the result set and add the data to the table model
            while (rs.next()) {
                int sid = rs.getInt("FID");
                String name = rs.getString("Name");
                String username = rs.getString("Username");
                String phoneNo = rs.getString("PhoneNo");
                String email = rs.getString("Email");
                String subName = rs.getString("SubName");
                String[] vals = {String.valueOf(sid), name, username, phoneNo, email, subName};
                tableModelSF.addRow(vals);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        //view marks in student section
        DefaultTableModel tableModelSM = studentViewMarks.getTableModel();
        JTable tableSM = adminViewMarks.getTable();
        try {
            conn = connect.getConnection();
            String sql = "SELECT * FROM marks";
            PreparedStatement preparedStatementViewMarksValidated = conn.prepareStatement(sql);
            ResultSet rs = preparedStatementViewMarksValidated.executeQuery();

            while (rs.next()) {
                    String username = rs.getString("username");
                    String physics = rs.getString("physics");
                    String chemistry = rs.getString("chemistry");
                    String biology = rs.getString("biology");
                    String maths = rs.getString("maths");
                    String nepali = rs.getString("nepali");
                    String english = rs.getString("english");
                    String totalMarks = rs.getString("totalMarks");
                    String percent = rs.getString("percent");
                    String rank = rs.getString("rank");
                    String[] vals = {username, physics, chemistry, biology, maths, nepali, english, totalMarks, percent, rank};
                    tableModelSM.addRow(vals);
            }
            rs.close();
            preparedStatementViewMarksValidated.close();
            conn.close();

        } catch (SQLException e1) {
            throw new RuntimeException(e1);
        }

        //refresh button clicking to refresh all table

//        JButton refreshBtn = refreshButton.getRefreshBtn();
//        refreshBtn.addActionListener(e->{
//            tableAM.repaint();
//            tableAF.repaint();
//            tableA.repaint();
//            tableFM.repaint();
//            tableFF.repaint();
//            tableSF.repaint();
//            tableSF.repaint();
//            tableSM.repaint();
//            tableSS.repaint();
//        });

        frame.setVisible(true);

    }

}
