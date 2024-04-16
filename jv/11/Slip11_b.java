
import java.sql.*;
public class Slip11_b
{
	public static void main(String[] args) {

	try {
		Class.forName("org.postgresql.Driver");
	    System.out.println("Driver is loaded");
	    
		Connection con=DriverManager.getConnection("jdbc:postgresql://localhost/java","mansi","mansi123");
		System.out.println("Con ok****");
		Statement stmt=con.createStatement();
		String sql="select * from donar";
		ResultSet rs=stmt.executeQuery(sql);
		ResultSetMetaData d=rs.getMetaData();
		
		System.out.println("Column No"+d.getColumnCount());
		for(int i=1;i<=d.getColumnCount();i++)
		{
			System.out.println("Column Name"+d.getColumnName(i));
			System.out.println("Column Type"+d.getColumnTypeName(i));
			
		}
	}
	catch(Exception e)
	{
		System.out.println("Mysql Reeor--->"+e);
		
	}
}
}