
import java.sql.*;
public class Slip16_b
{
public static void main(String[] args) 
{
try
{
Class.forName("org.postgresql.Driver");
System.out.println("Driver laoded in memory****");
Connection con=DriverManager.getConnection("jdbc:postgresql://localhost/slip1","mansi","mansi123");
System.out.println("Con ok****");
int tno = 11;
String tname = "John Doe";
String subject = "JAVA";
String insertQuery = "INSERT INTO Teacher (TNo, TName, Subject) VALUES (?,?,?)";
PreparedStatement ps = con.prepareStatement(insertQuery);
ps.setInt(1,tno);
ps.setString(2, tname);
ps.setString(3, subject);
int rowsinserted = ps.executeUpdate();
if (rowsinserted > 0) 
{
System.out.println("Data inserted successfully!");
}
tno = 133;
tname = "James Smith";
subject = "JAVA";
ps.setInt(1, tno);
ps.setString(2, tname);
ps.setString(3, subject);
rowsinserted = ps.executeUpdate();
if (rowsinserted > 0 )
{
System.out.println("Data inserted successfully!");
}
tno=144;
tname = "Julie Brown";
subject= "JAVA";
ps.setInt(1, tno);
ps.setString(2, tname);
ps.setString(3, subject);
rowsinserted = ps. executeUpdate();
if (rowsinserted > 0 )
{
System.out.println("Data inserted successfully!");
}
tno = 105;
tname = "Jack Smith"; subject= "PYTHON";
ps.setInt(1, tno);
ps.setString(2, tname);
ps.setString(3, subject);
rowsinserted = ps.executeUpdate();
if (rowsinserted > 0 )
{
System.out.println("Data inserted successfully!");
}
String selectQuery = "SELECT * FROM Teacher WHERE Subject = ?";
PreparedStatement psSelect = con.prepareStatement(selectQuery);
psSelect.setString(1, "JAVA");
ResultSet rs = psSelect.executeQuery();
while (rs.next()) 
  {

System.out.println("Teacher number:" + rs.getInt("TNo")); System.out.println("Teacher name:" + rs.getString("TName"));

System.out.println("Subject: " + rs.getString("Subject"));


rs.close();

psSelect.close();

ps.close();

con.close();
  }
	}
  catch(Exception e)
  {
	  System.out.println("SQL ERROR====>"+e);
	 }

}
}



