package AdminPages;

import Frames.MyFrame;
import Reusable.AdminNavigationBar;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class AdminAddFacilitatorRunner extends JPanel {

    public AdminAddFacilitatorRunner() {
        AdminNavigationBar menu = new AdminNavigationBar();
        this.add(menu, BorderLayout.NORTH);
    }

}
