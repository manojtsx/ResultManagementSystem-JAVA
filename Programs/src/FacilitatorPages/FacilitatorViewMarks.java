package FacilitatorPages;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class FacilitatorViewMarks extends JPanel {
    private JTable table;
    private DefaultTableModel tableModel;
    private JScrollPane scrollPane;

    private JButton editBtn;
    public FacilitatorViewMarks() {
        String[] columns = {"Username", "Physics", "Chemistry", "Biology", "Math", "Nepali", "English", "Total Marks", "Percent", "Rank"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);
        editBtn = new JButton("Update Selected.");
        add(scrollPane);
        add(editBtn);
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
    public JButton getEditBtn(){return editBtn;}
}

