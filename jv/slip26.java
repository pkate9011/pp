package slip;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class slip26 {
   
    private static final String URL = "jdbc:postgresql://localhost/java";
    private static final String USER = "mansi";
    private static final String PASSWORD = "mansi123";

  
    private static Connection connection;

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java DeleteEmployeeDetails <employeeID>");
            return;
        }

        int employeeID = Integer.parseInt(args[0]);

        try {
           
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

          
            String sql = "DELETE FROM employees WHERE ENo = ?";

           
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, employeeID);

           
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Employee details deleted successfully.");
            } else {
                System.out.println("No employee found with ID: " + employeeID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
               
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


// database tables************************************
CREATE TABLE employees (
	    ENo INT PRIMARY KEY,
	    EName VARCHAR(50),
	    Salary DECIMAL(10, 2)
	);


********************
INSERT INTO employees (ENo, EName, Salary) VALUES
(1, 'John Doe', 50000.00),
(2, 'Jane Smith', 60000.00),
(3, 'Alice Johnson', 55000.00);






