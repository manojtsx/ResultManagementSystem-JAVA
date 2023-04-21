package StudentPages;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class StudentViewMarks extends JPanel {
    private JTable table;
    DefaultTableModel tableModel;
    private JScrollPane scrollPane;
    public StudentViewMarks(){
        String[] columns = {"Username", "Name", "Physics", "Chemistry", "Biology", "Math", "Nepali", "English", "Total Marks", "Percent", "Rank"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);
        add(scrollPane);
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setPreferredSize(new Dimension(getWidth(), 200));


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
    public DefaultTableModel getTableModel(){
        return tableModel;
    }
    public JTable getTable(){
        return table;
    }
}
