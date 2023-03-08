package Reusable;

import javax.swing.*;

public class StudentNavigationBar extends JMenuBar {
    public StudentNavigationBar(){
        JMenu home = new JMenu("Home");
        JMenu facilitator = new JMenu("Facilitator");
        JMenu student = new JMenu("Student");
        JMenu marks = new JMenu("Marks");
        JMenu logout = new JMenu("Log Out");

        JMenuItem viewFacilitator = new JMenuItem("View Facilitator");

        JMenuItem viewStudent = new JMenuItem("View Student");

        JMenuItem viewMarks = new JMenuItem("View Marks");

        facilitator.add(viewFacilitator);

        student.add(viewStudent);

        marks.add(viewMarks);

        this.add(home);
        this.add(facilitator);
        this.add(student);
        this.add(marks);
        this.add(logout);
    }
}
