import java.sql.*;

public class Slip29_a

{

public static void main(String args[]) throws Exception

{

try

{

Statement stmt;

Class.forName("org.postgresql.Driver");
System.out.println("Driver laoded in memory****");
Connection con=DriverManager.getConnection("jdbc:postgresql://localhost/slip1","mansi","mansi123");
System.out.println("Con ok****");

if(con==null)

{

if(con==null)

System.out.println("Connection Failed");

}

else

{

System.out.println("Conncetion Establish sucessfully");

stmt=con.createStatement();

ResultSet rs=stmt.executeQuery("Select * from teacher");


java.sql.ResultSetMetaData rsmd=rs.getMetaData();
int noOfColumns=rsmd.getColumnCount();
System.out.println("Number of Columns="+noOfColumns);


for(int i=1;i<noOfColumns;i++)

{
System.out.println("Column No:" +i);

System.out.println("Column name:"+rsmd.getColumnName(i));

System.out.println("Column Type:"+rsmd.getColumnType(i));

System.out.println("Column Display size:"+rsmd.getColumnDisplaySize(i));

}

con.close();

}

}

catch(Exception e)

{

System.out.println(e);

}

}
}


