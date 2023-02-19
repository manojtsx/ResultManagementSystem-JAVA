package AdminPages;

import Frames.MyFrame;
import Reusable.AdminNavigationBar;


import javax.swing.*;
import java.awt.*;

public class AdminViewMarksRunner {
    public static void main(String[] s){
        MyFrame frame = new MyFrame();
        AdminNavigationBar menu = new AdminNavigationBar();
        frame.add(menu, BorderLayout.NORTH);
        frame.setVisible(true);
    }
}
