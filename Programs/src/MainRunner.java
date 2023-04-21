import AdminPages.*;
import FacilitatorPages.FacilitatorHomeRunner;
import FacilitatorPages.FacilitatorViewFacilitator;
import FacilitatorPages.FacilitatorViewMarks;
import FacilitatorPages.FacilitatorViewStudent;
import Frames.MyFrame;
import Modules.Facilitator;
import Modules.Student;
import Reusable.AdminNavigationBar;
import Reusable.FacilitatorNavigationBar;
import Reusable.LetUsConnect;
import Reusable.StudentNavigationBar;
import StudentPages.StudentHomeRunner;
import StudentPages.StudentViewFacilitator;
import StudentPages.StudentViewMarks;
import StudentPages.StudentViewStudent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainRunner {
    static Connection conn;

    public static void main(String[] s) {

        //these are panel classes obtained from different packages
        MyFrame frame = new MyFrame();
        frame.setLayout(new BorderLayout());
        LoginWindow login = new LoginWindow();
        frame.add(login);
        AdminNavigationBar adminNavbar = new AdminNavigationBar();
        FacilitatorNavigationBar facilitatorNavbar = new FacilitatorNavigationBar();
        StudentNavigationBar studentNavbar = new StudentNavigationBar();


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
                            int id_value = 0;
                            String name_value = null;
                            String user_value = null;
                            String pass_value = null;
                            String usertype = null;
                            String phone_value = null;
                            String email_value = null;
                            boolean foundMatch = false;
                            while (result.next()) {
                                id_value = Integer.parseInt(result.getString("Id"));
                                name_value = result.getString("Name");
                                user_value = result.getString("username");
                                pass_value = result.getString("password");
                                usertype = result.getString("usertype");
                                phone_value = result.getString("PhoneNo");
                                email_value = result.getString("Email");
                                String password = new String(pass.getPassword());
                                String username = user.getText();
                                if (Objects.equals(user_value, username) && Objects.equals(pass_value, password) && Objects.equals(usertype, "admin")) {
                                    user.setText("");
                                    pass.setText("");
                                    anameDetail.setText(name_value);
                                    auserDetail.setText(user_value);
                                    apositionDetail.setText(usertype);
                                    aphoneDetail.setText(phone_value);
                                    aemailDetail.setText(email_value);
                                    frame.getContentPane().removeAll();
                                    frame.getContentPane().add(adminNavbar, BorderLayout.NORTH);
                                    frame.getContentPane().add(adminHome, BorderLayout.CENTER);
                                    frame.getContentPane().revalidate();
                                    frame.getContentPane().repaint();
                                    foundMatch = true;
                                } else if (Objects.equals(user_value, username) && Objects.equals(pass_value, password) && Objects.equals(usertype, "facilitator")) {
                                    user.setText("");
                                    pass.setText("");
                                    facilitator = new Facilitator(id_value, name_value, user_value, pass_value, phone_value, email_value);
                                    fnameDetail.setText(facilitator.getName());
                                    fuserDetail.setText(facilitator.getUsername());
                                    fpositionDetail.setText(usertype);
                                    fphoneDetail.setText(facilitator.getPhoneNumber());
                                    femailDetail.setText(facilitator.getEmail());
                                    frame.getContentPane().removeAll();
                                    frame.getContentPane().add(facilitatorNavbar, BorderLayout.NORTH);
                                    frame.getContentPane().add(facilitatorHome, BorderLayout.CENTER);
                                    frame.getContentPane().revalidate();
                                    frame.getContentPane().repaint();
                                    foundMatch = true;

                                } else if (Objects.equals(user_value, username) && Objects.equals(pass_value, password) && Objects.equals(usertype, "student")) {
                                    user.setText("");
                                    pass.setText("");
                                    student = new Student(id_value, name_value, user_value, pass_value, phone_value, email_value);
                                    snameDetail.setText(student.getName());
                                    suserDetail.setText(student.getUsername());
                                    spositionDetail.setText(usertype);
                                    sphoneDetail.setText(student.getPhoneNumber());
                                    semailDetail.setText(student.getEmail());
                                    frame.getContentPane().removeAll();
                                    frame.getContentPane().add(studentNavbar, BorderLayout.NORTH);
                                    frame.getContentPane().add(studentHome, BorderLayout.CENTER);
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
                            conn.close();

                        } catch (SQLException err) {
                            System.out.println(err);
                        }
                    }
                }
            }
        });

        //actionlistener on clicking the login button
        signInBtn.addActionListener(e -> {
            Student student;
            Facilitator facilitator;

            try {
                conn = connect.getConnection();
                String sql = "SELECT * FROM user";
                Statement stmt = conn.createStatement();
                ResultSet result = stmt.executeQuery(sql);
                int id_value = 0;
                String name_value = null;
                String user_value = null;
                String pass_value = null;
                String usertype = null;
                String phone_value = null;
                String email_value = null;
                boolean foundMatch = false;
                while (result.next()) {
                    id_value = Integer.parseInt(result.getString("Id"));
                    name_value = result.getString("Name");
                    user_value = result.getString("username");
                    pass_value = result.getString("password");
                    usertype = result.getString("usertype");
                    phone_value = result.getString("PhoneNo");
                    email_value = result.getString("Email");
                    String password = new String(pass.getPassword());
                    String username = user.getText();
                    if (Objects.equals(user_value, username) && Objects.equals(pass_value, password) && Objects.equals(usertype, "admin")) {
                        user.setText("");
                        pass.setText("");
                        anameDetail.setText(name_value);
                        auserDetail.setText(user_value);
                        apositionDetail.setText(usertype);
                        aphoneDetail.setText(phone_value);
                        aemailDetail.setText(email_value);
                        frame.getContentPane().removeAll();
                        frame.getContentPane().add(adminNavbar, BorderLayout.NORTH);
                        frame.getContentPane().add(adminHome, BorderLayout.CENTER);
                        frame.getContentPane().revalidate();
                        frame.getContentPane().repaint();
                        foundMatch = true;
                    } else if (Objects.equals(user_value, username) && Objects.equals(pass_value, password) && Objects.equals(usertype, "facilitator")) {
                        user.setText("");
                        pass.setText("");
                        facilitator = new Facilitator(id_value, name_value, user_value, pass_value, phone_value, email_value);
                        fnameDetail.setText(facilitator.getName());
                        fuserDetail.setText(facilitator.getUsername());
                        fpositionDetail.setText(usertype);
                        fphoneDetail.setText(facilitator.getPhoneNumber());
                        femailDetail.setText(facilitator.getEmail());
                        frame.getContentPane().removeAll();
                        frame.getContentPane().add(facilitatorNavbar, BorderLayout.NORTH);
                        frame.getContentPane().add(facilitatorHome, BorderLayout.CENTER);
                        frame.getContentPane().revalidate();
                        frame.getContentPane().repaint();
                        foundMatch = true;

                    } else if (Objects.equals(user_value, username) && Objects.equals(pass_value, password) && Objects.equals(usertype, "student")) {
                        user.setText("");
                        pass.setText("");
                        student = new Student(id_value, name_value, user_value, pass_value, phone_value, email_value);
                        snameDetail.setText(student.getName());
                        suserDetail.setText(student.getUsername());
                        spositionDetail.setText(usertype);
                        sphoneDetail.setText(student.getPhoneNumber());
                        semailDetail.setText(student.getEmail());
                        frame.getContentPane().removeAll();
                        frame.getContentPane().add(studentNavbar, BorderLayout.NORTH);
                        frame.getContentPane().add(studentHome, BorderLayout.CENTER);
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
                conn.close();
            } catch (SQLException err) {
                System.out.println(err);
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
        Statement stmt2 = null;
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
            conn.close();
            rs.close();
            stmt.close();

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
                tableModelAM.addRow(vals);
            }

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
            } catch (SQLException error) {
                JOptionPane.showMessageDialog(frame, "Updation error");
            }
        });


        //view student in facilitator
        DefaultTableModel tableModelF = facilitatorViewStudent.getTableModel();

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
            conn.close();
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //view facilitator in facilitator
        DefaultTableModel tableModelFF = facilitatorViewFacilitator.getTableModel();
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
            conn.close();
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //view marks in facilitator section
        DefaultTableModel tableModelFM = facilitatorViewMarks.getTableModel();
        try {
            conn = connect.getConnection();
            String sql = "SELECT * FROM marks";
            String sql1 = "SELECT * FROM student";
            stmt = conn.createStatement();
            stmt2 = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ResultSet rs2 = stmt2.executeQuery(sql1);
            while (rs.next()) {
                while (rs2.next()) {
                    String name = rs2.getString("Name");
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
                    String[] vals = {username, name, physics, chemistry, biology, maths, nepali, english, totalMarks, percent, rank};
                    tableModelFM.addRow(vals);
                }
            }
            conn.close();
        } catch (SQLException e1) {
            throw new RuntimeException(e1);
        }


        //view student in student section
        DefaultTableModel tableModelSS = studentViewStudent.getTableModel();
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
            conn.close();
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //view facilitator in student section
        DefaultTableModel tableModelSF = studentViewFacilitator.getTableModel();
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
            conn.close();
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        //view marks in student section
        DefaultTableModel tableModelSM = studentViewMarks.getTableModel();
        try {
            conn = connect.getConnection();
            String sql = "SELECT * FROM marks";
            String sql1 = "SELECT * FROM student";
            stmt = conn.createStatement();
            stmt2 = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ResultSet rs2 = stmt2.executeQuery(sql1);
            while (rs.next()) {
                while (rs2.next()) {
                    String name = rs2.getString("Name");
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
                    String[] vals = {username, name, physics, chemistry, biology, maths, nepali, english, totalMarks, percent, rank};
                    tableModelSM.addRow(vals);
                }
            }
            conn.close();

        } catch (SQLException e1) {
            throw new RuntimeException(e1);
        }

        frame.setVisible(true);

    }
}
