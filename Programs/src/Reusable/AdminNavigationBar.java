package Reusable;


import javax.swing.*;

public class AdminNavigationBar extends JMenuBar{
    public AdminNavigationBar() {
//        JMenuBar menu = new JMenuBar();

        JMenu home = new JMenu("Home");
        JMenu facilitator = new JMenu("Facilitator");
        JMenu student = new JMenu("Student");
        JMenu marks = new JMenu("Marks");
        JMenu logout = new JMenu("Log Out");


        JMenuItem addFacilitator = new JMenuItem("Add Facilitator");
        JMenuItem viewFacilitator = new JMenuItem("View Facilitator");

        JMenuItem addStudent = new JMenuItem("Add Student");
        JMenuItem viewStudent = new JMenuItem("View Student");

        JMenuItem addMarks = new JMenuItem("Add Marks");
        JMenuItem viewMarks = new JMenuItem("View Marks");

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

    }
}
