package AdminPages;

import javax.swing.*;
import java.awt.*;

public class NavigationBar extends JFrame {
    JPanel navBar;
    JLabel home,logOut;
    JComboBox marks,student,facilitator;
    public NavigationBar(){
        this.setLayout(new BorderLayout());
        navBar = new JPanel();
        navBar.setBackground(Color.blue);
        navBar.setPreferredSize(new Dimension(100,70));
        this.add(navBar,BorderLayout.NORTH);
        navBar.setLayout(new FlowLayout(FlowLayout.TRAILING));


        home = new JLabel("Home");
        home.setVerticalTextPosition(JLabel.CENTER);
        home.setForeground(Color.white);
        home.setPreferredSize(new Dimension(70,30));
        home.setFont(new Font("Times New Roman", Font.BOLD,20));

        String[] arr = {"Add Marks","View Marks"};
        marks = new JComboBox(arr);
//        marks.setVerticalAlignment(JLabel.CENTER);
        marks.setForeground(Color.white);
        marks.setBackground(Color.blue);
        marks.setPreferredSize(new Dimension(120,30));
        marks.setFont(new Font("Times New Roman", Font.BOLD,20));

        String[] arr1 = {"Add Student","View Student"};
        student = new JComboBox(arr1);
//        student.setVerticalAlignment(JLabel.CENTER);
        student.setForeground(Color.white);
        student.setBackground(Color.blue);
        student.setPreferredSize(new Dimension(120,30));
        student.setFont(new Font("Times New Roman", Font.BOLD,20));

        String[] arr3 = {"Add Facilitator","View Facilitator"};
        facilitator = new JComboBox(arr3);
//        facilitator.setVerticalAlignment(JLabel.CENTER);
        facilitator.setForeground(Color.white);
        facilitator.setBackground(Color.blue);
        facilitator.setPreferredSize(new Dimension(140,30));
        facilitator.setFont(new Font("Times New Roman", Font.BOLD,20));

        logOut = new JLabel("Log Out");
        logOut.setVerticalAlignment(JLabel.CENTER);
        logOut.setForeground(Color.white);
        logOut.setPreferredSize(new Dimension(100,30));
        logOut.setFont(new Font("Times New Roman", Font.BOLD,20));

        navBar.add(home);
        navBar.add(marks);
        navBar.add(student);
        navBar.add(facilitator);
        navBar.add(logOut);


    }
}
