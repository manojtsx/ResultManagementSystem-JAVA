package AdminPages;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AdminViewFacilitatorRunner extends JPanel {
    private JTable table;
    DefaultTableModel tableModel;
    private JScrollPane scrollPane;

    public AdminViewFacilitatorRunner() {
        String[] columnNames = {"FID", "Name", "Username", "PhoneNo", "Email", "Subject"};

        // Initialize the tablemodel here
        tableModel = new DefaultTableModel(columnNames, 0);
        // Create a table and set the table model
        JTable table = new JTable(tableModel);

        // Create a scroll pane and add the table to it
        scrollPane = new JScrollPane(table);

        // Add the scroll pane to the frame
        add(scrollPane);
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public JTable getTable() {
        return table;
    }
}

