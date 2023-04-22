package StudentPages;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class StudentViewFacilitator extends JPanel{
    private JTable table;
    DefaultTableModel tableModel;
    private JScrollPane scrollPane;

    public StudentViewFacilitator(){
        String[] columnNames = {"FID", "Name", "Username", "PhoneNo", "Email", "Subject"};

        // Initialize the tablemodel here
        tableModel = new DefaultTableModel(columnNames, 0);
        // Create a table and set the table model
        JTable table = new JTable(tableModel);

        // Create a scroll pane and add the table to it
        scrollPane = new JScrollPane(table);

        // Add the scroll pane to the frame
        add(scrollPane);
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

        // Set background color of the container to white
        setBackground(new Color(229, 190, 236));
    }
    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public JTable getTable() {
        return table;
    }
}
