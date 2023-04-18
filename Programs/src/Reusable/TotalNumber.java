package Reusable;

import javax.swing.*;
import java.awt.*;

public class TotalNumber extends JPanel {
    private JPanel totalTeachersPanel, totalStudentsPanel;
    private JLabel totalteachersTitle, totalStudentsTitle;
    private JLabel totalTeachersNumber, totalStudentsNumber;
    public TotalNumber(){
        setLayout(new FlowLayout(FlowLayout.LEADING));

        totalTeachersPanel = new JPanel();
        totalStudentsPanel = new JPanel();

        totalTeachersPanel.setLayout(new GridLayout(2,1));
        totalStudentsPanel.setLayout(new GridLayout(2,1));

        totalteachersTitle = new JLabel("Total Teachers: ");
        totalStudentsTitle = new JLabel("Total Students: ");

        totalTeachersNumber = new JLabel();
        totalStudentsNumber = new JLabel();

        totalTeachersPanel.add(totalteachersTitle);
        totalTeachersPanel.add(totalTeachersNumber);
        totalStudentsPanel.add(totalStudentsTitle);
        totalStudentsPanel.add(totalStudentsNumber);

        add(totalTeachersPanel);
        add(totalStudentsPanel);

    }
    public JLabel setTotalTeachersNumber(){
        return totalTeachersNumber;
    }
    public JLabel setTotalStudentsNumber(){
        return totalStudentsNumber;
    }
}
