import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

public class Slip13_a
{
    public static void main(String[] args) throws Exception 
    {
        String jdbc_url = "jdbc:postgresql://localhost/java";      
        String user = "mansi";                               
        String pwd = "mansi123";
        Class.forName("org.postgresql.Driver");      

        Connection con = DriverManager.getConnection(jdbc_url, user, pwd);
        DatabaseMetaData dbms = con.getMetaData();
        ResultSet rs = dbms.getTables(null, null, null, new String[]{"TABLE"});
        System.out.println("List of Tables:");
        while (rs.next()) {
            String tblName = rs.getString("TABLE_NAME");
            System.out.println("Table:" + tblName);
        }
        con.close();
    }
}