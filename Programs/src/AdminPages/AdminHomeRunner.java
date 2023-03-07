package AdminPages;

import Frames.MyFrame;
import Reusable.AdminNavigationBar;


import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class AdminHomeRunner extends JPanel {
    public AdminHomeRunner(){
        AdminNavigationBar menu = new AdminNavigationBar();
        this.add(menu, BorderLayout.NORTH);
    }
}

