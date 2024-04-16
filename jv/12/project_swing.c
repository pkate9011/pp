package march;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;


public class ProjectTable extends JFrame 
{
    private JTable table;
    private JScrollPane scrollPane;

    public ProjectTable() 
    {
        setTitle("Project Table");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        table = new JTable();
        scrollPane = new JScrollPane(table);
        add(scrollPane);

        fetchProjectData();

        setVisible(true);
    }

    private void fetchProjectData() 
    {
        
        try 
        {
        	//Class.forName("org.postgresql.Driver");
			//System.out.println("Driver laoded memory****");
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost/databasename","user","password");
			//System.out.println("Connection created***");
			Statement stmt=con.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM Projectbsc");

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columns = metaData.getColumnCount();

            String[] columnNames = new String[columns];
            for (int i = 0; i < columns; i++) 
            {
                columnNames[i] = metaData.getColumnName(i + 1);
            }

            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(columnNames);

            while (resultSet.next()) {
                Object[] rowData = new Object[columns];
                for (int i = 0; i < columns; i++) {
                    rowData[i] = resultSet.getObject(i + 1);
                }
                model.addRow(rowData);
            }

            table.setModel(model);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
     {
        //SwingUtilities.invokeLater(ProjectTableDisplay::new);

       SwingUtilities.invokeLater(() -> {
        new ProjectTable();
});

    }
}
