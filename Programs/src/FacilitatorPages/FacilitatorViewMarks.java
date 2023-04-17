package FacilitatorPages;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FacilitatorViewMarks extends JPanel {
    private JTable table;
    private DefaultTableModel tableModel;
    private JScrollPane scrollPane;

    public FacilitatorViewMarks() {
        String[] columns = {"Username", "Name", "Physics", "Chemistry", "Biology", "Math", "Nepali", "English", "Total Marks", "Percent", "Rank"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);
        add(scrollPane);
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public JTable getTable() {
        return table;
    }
}

