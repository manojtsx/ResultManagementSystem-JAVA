package AdminPages;

import Frames.MyFrame;
import Reusable.AdminNavigationBar;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class AdminAddFacilitatorRunner {

    public static void main(String[] s) {
        MyFrame frame = new MyFrame();
        AdminNavigationBar menu = new AdminNavigationBar();
        frame.add(menu, BorderLayout.NORTH);
        frame.setVisible(true);

    }

}
