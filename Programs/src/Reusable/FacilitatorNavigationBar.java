package Reusable;

import javax.swing.*;
import java.awt.*;

public class FacilitatorNavigationBar extends JMenuBar {
    JMenu home, logout;
    JMenuItem viewFacilitator, viewStudent, viewMarks;

    public FacilitatorNavigationBar() {
        home = new JMenu("Home");
        JMenu facilitator = new JMenu("Facilitator");
        JMenu student = new JMenu("Student");
        JMenu marks = new JMenu("Marks");
        logout = new JMenu("Log Out");

        viewFacilitator = new JMenuItem("View Facilitator");

        viewStudent = new JMenuItem("View Student");

        viewMarks = new JMenuItem("Update Marks");

        facilitator.add(viewFacilitator);

        student.add(viewStudent);

        marks.add(viewMarks);
        this.setBounds(0, 0, 700, 40);
        this.add(home);
        this.add(facilitator);
        this.add(student);
        this.add(marks);
        this.add(logout);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBackground(new Color(42, 47, 79));
        home.setForeground(Color.white);
        student.setForeground(Color.white);
        facilitator.setForeground(Color.white);
        marks.setForeground(Color.white);
        logout.setForeground(Color.white);
        setPreferredSize(new Dimension(screenSize.width,60));
        // Set custom UIManager for JMenuItem to change background color
        UIManager.put("MenuItem.background", new Color(145, 127, 179));
    }


    public JMenuItem getViewFacilitator() {
        return viewFacilitator;
    }


    public JMenuItem getViewStudent() {
        return viewStudent;
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

