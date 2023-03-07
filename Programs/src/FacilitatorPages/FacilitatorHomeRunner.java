package FacilitatorPages;

import Reusable.FacilitatorNavigationBar;

import javax.swing.*;
import java.awt.*;

public class FacilitatorHomeRunner extends JPanel {
    public FacilitatorHomeRunner(){
        FacilitatorNavigationBar menu  = new FacilitatorNavigationBar();
        this.add(menu, BorderLayout.NORTH);
    }
}
