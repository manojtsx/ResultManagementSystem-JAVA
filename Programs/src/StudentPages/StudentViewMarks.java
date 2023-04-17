package StudentPages;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

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
    }
    public DefaultTableModel getTableModel(){
        return tableModel;
    }
    public JTable getTable(){
        return table;
    }
}
