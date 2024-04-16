



import java.sql.*;import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class slip27A extends JFrame {
// database connection details
static final String DB_URL = "jdbc:postgresql://localhost/bcs";
static final String DB_USER = "bcs";
static final String DB_PASSWORD = "bcs123";
public slip27A() {
super("College Details");
// create a JTable
JTable table = new JTable();
// set column names for the table
String[] columnNames = {"CID", "CName", "Address", "Year"};
// create a default table model with the column names
DefaultTableModel model = new DefaultTableModel(columnNames, 0);
// add data to the table model
try {
// create a database connection
Connection conn = DriverManager.getConnection(DB_URL, DB_USER,DB_PASSWORD);// create a statement
System.out.print("con ok");
Statement stmt = conn.createStatement();
// execute a query to get college details
ResultSet rs = stmt.executeQuery("SELECT * FROM college");
// add each row to the table model
while (rs.next()) {
String cid = rs.getString("CID");
String cname = rs.getString("CName");
String address = rs.getString("Address");
int year = rs.getInt("Year");
model.addRow(new Object[] { cid, cname, address, year });
}
// close the result set, statement and connection
rs.close();
stmt.close();
conn.close();
} catch (SQLException e) {
e.printStackTrace();
}
// set the table model to the JTable
table.setModel(model);// create a scroll pane for the table
JScrollPane scrollPane = new JScrollPane(table);
// add the scroll pane to the frame
getContentPane().add(scrollPane);
// set frame properties
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLocationRelativeTo(null);
pack();
setVisible(true);
}
public static void main(String[] args) {
new slip27A();
}
}




/*

SQL  file

sudo -u postgres psql

postgres=# create database bcs;

postgres=# \c bcs

bcs=# create user bcs with password 'bcs123';

bcs=# create table college(cid int primary key,cname varchar(50),address varchar(50),year int);

bcs=# insert into college values(3,'vishal','pune',2023);

bcs=# select * from college;

bcs=# grant all privileges on college to bcs;




*/









