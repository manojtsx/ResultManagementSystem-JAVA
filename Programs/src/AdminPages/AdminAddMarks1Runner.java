package AdminPages;

import Frames.MyFrame;
import Reusable.AdminNavigationBar;


import javax.swing.*;
import java.awt.*;

public class AdminAddMarks1Runner {
    public static void main(String[] s) {
        MyFrame frame = new MyFrame();
        AdminNavigationBar menu = new AdminNavigationBar();
        frame.add(menu, BorderLayout.NORTH);

        frame.setVisible(true);
    }
}
