package Reusable;

import javax.swing.*;

public class RefreshButton extends JPanel{
    private JButton refreshBtn;
    public RefreshButton(){
        refreshBtn = new JButton("Refresh");
        add(refreshBtn);
    }
    public JButton getRefreshBtn(){return refreshBtn;}

}
