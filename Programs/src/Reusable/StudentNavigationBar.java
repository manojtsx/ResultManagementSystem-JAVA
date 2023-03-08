package Reusable;

import javax.swing.*;

public class StudentNavigationBar extends JMenuBar {
    JMenu home, logout;
    JMenuItem viewFacilitator, viewStudent, viewMarks;

    public StudentNavigationBar() {
        home = new JMenu("Home");
        JMenu facilitator = new JMenu("Facilitator");
        JMenu student = new JMenu("Student");
        JMenu marks = new JMenu("Marks");
        logout = new JMenu("Log Out");

        viewFacilitator = new JMenuItem("View Facilitator");

        viewStudent = new JMenuItem("View Student");

        viewMarks = new JMenuItem("View Marks");

        facilitator.add(viewFacilitator);

        student.add(viewStudent);

        marks.add(viewMarks);
        this.setBounds(0, 0, 700, 40);
        this.add(home);
        this.add(facilitator);
        this.add(student);
        this.add(marks);
        this.add(logout);
    }

    public JMenu getHome() {
        return home;
    }
    public JMenu getLogout(){
        return logout;
    }
    public JMenuItem getViewFacilitator(){
        return viewFacilitator;
    }
    public JMenuItem getViewStudent(){
        return viewStudent;
    }
    public JMenuItem getViewMarks(){
        return viewMarks;
    }
}
