
import java.sql.*;

public class Slip30_b 
{

public static void main(String[] args) 
{



PreparedStatement pstmt = null;

ResultSet rs = null;

try 
{
	Class.forName("org.postgresql.Driver");
	System.out.println("Driver laoded in memory****");
	Connection conn=DriverManager.getConnection("jdbc:postgresql://localhost/slip30","mansi","mansi123");
	System.out.println("Con ok****");

/
String query = "SELECT * FROM teacher";

pstmt = conn.prepareStatement(query,

ResultSet.TYPE_SCROLL_INSENSITIVE,
ResultSet.CONCUR_READ_ONLY);

rs = pstmt.executeQuery();

System.out.println("Forward traversal:");

while (rs.next()) {

System.out.println("TID: " + rs.getInt("tid") + ", TName: " +

rs.getString("tname") + ", Salary:" + rs.getDouble("salary"));

}

System.out.println("\nBackward traversal:");

rs.afterLast();

while (rs.previous()) {

System.out.println("TID: " + rs.getInt("tid") + ", tname: " +

rs.getString("tname") + ", Salary: " + rs.getDouble("salary"));

}

} catch (ClassNotFoundException e) {

e.printStackTrace();

} 
catch (SQLException e) 
{
	e.printStackTrace();
}
}
}


