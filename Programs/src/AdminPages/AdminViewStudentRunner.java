package AdminPages;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class AdminViewStudentRunner extends JPanel {
    private JTable table;
    private DefaultTableModel tableModel;
    private JScrollPane scrollPane;
    private JButton removeBtn,updateBtn;

    public AdminViewStudentRunner() {
        // Create a table model with column names and no data
        String[] columnNames = {"SID", "Name", "Username", "PhoneNo", "Email", "Parent Name"};

        // Initialize the tablemodel here
        tableModel = new DefaultTableModel(columnNames, 0);
        // Create a table and set the table model
        table = new JTable(tableModel);

        // Create a scroll pane and add the table to it
        scrollPane = new JScrollPane(table);

        //create  a remove Button to the panel
        removeBtn = new JButton("Remove Selected");
        updateBtn = new JButton("Update Selected");

        // Add the scroll pane to the frame
        setLayout(new FlowLayout(FlowLayout.LEADING));
        add(scrollPane);
        add(removeBtn);
        add(updateBtn);
        setBorder(new EmptyBorder(10, 10, 10, 10));

        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        table.setRowHeight(30);


        // customize the table header
        JTableHeader header = table.getTableHeader();
        header.setBackground(Color.WHITE);
        header.setForeground(Color.BLACK);
        header.setFont(new Font("SansSerif", Font.BOLD, 16));
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public JTable getTable() {
        return table;
    }

    public JButton getRemoveBtn() {
        return removeBtn;
    }
    public JButton getUpdateBtn(){return updateBtn;}
}


