package Reusable;

import javax.swing.*;

public class FacilitatorNavigationBar extends JMenuBar {
    JMenu home, logout;
    JMenuItem viewFacilitator, viewStudent, addMarks, viewMarks;

    public FacilitatorNavigationBar() {
        home = new JMenu("Home");
        JMenu facilitator = new JMenu("Facilitator");
        JMenu student = new JMenu("Student");
        JMenu marks = new JMenu("Marks");
        logout = new JMenu("Log Out");

        viewFacilitator = new JMenuItem("View Facilitator");

        viewStudent = new JMenuItem("View Student");

        addMarks = new JMenuItem("Add Marks");
        viewMarks = new JMenuItem("View Marks");

        facilitator.add(viewFacilitator);

        student.add(viewStudent);

        marks.add(addMarks);
        marks.add(viewMarks);

        this.add(home);
        this.add(facilitator);
        this.add(student);
        this.add(marks);
        this.add(logout);
    }


    public JMenuItem getViewFacilitator() {
        return viewFacilitator;
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

    public JMenu getHome() {
        return home;
    }

    public JMenu getLogout() {
        return logout;
    }
}

