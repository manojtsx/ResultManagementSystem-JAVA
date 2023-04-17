package Reusable;


import javax.swing.*;
import java.awt.*;

public class AdminNavigationBar extends JMenuBar {
    JMenuItem addFacilitator, viewFacilitator, addStudent, viewStudent, addMarks, viewMarks;
    JMenu home, logout;

    public AdminNavigationBar() {

        home = new JMenu("Home");
        JMenu facilitator = new JMenu("Facilitator");
        JMenu student = new JMenu("Student");
        JMenu marks = new JMenu("Marks");
        logout = new JMenu("Log Out");


        addFacilitator = new JMenuItem("Add Facilitator");
        viewFacilitator = new JMenuItem("View Facilitator");

        addStudent = new JMenuItem("Add Student");
        viewStudent = new JMenuItem("View Student");

        addMarks = new JMenuItem("Add Marks");
        viewMarks = new JMenuItem("View Marks");

        facilitator.add(addFacilitator);
        facilitator.add(viewFacilitator);

        student.add(addStudent);
        student.add(viewStudent);

        marks.add(addMarks);
        marks.add(viewMarks);

        this.add(home);
        this.add(facilitator);
        this.add(student);
        this.add(marks);
        this.add(logout);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBackground(Color.BLUE);
        home.setForeground(Color.white);
        student.setForeground(Color.white);
        facilitator.setForeground(Color.white);
        marks.setForeground(Color.white);
        logout.setForeground(Color.white);
        setPreferredSize(new Dimension(screenSize.width,60));
    }

    public JMenuItem getAddFacilitator() {
        return addFacilitator;
    }

    public JMenuItem getViewFacilitator() {
        return viewFacilitator;
    }

    public JMenuItem getAddStudent() {
        return addStudent;
    }

    public JMenuItem getViewStudent() {
        return viewStudent;
    }

    public JMenuItem getAddMarks() {
        return addMarks;
    }

    public JMenuItem getViewMarks() {
        return viewMarks;
    }
    public JMenu getHome(){
        return home;
    }
    public JMenu getLogout(){
        return logout;
    }
}
