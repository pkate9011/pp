import java.io.IOException;

import java.io.PrintWriter;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.SQLException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

public class StudentServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

public void doPost(HttpServletRequest request, HttpServletResponse response)

throws ServletException, IOException {

response.setContentType("text/html;charset=UTF-8"); 
PrintWriter out = response.getWriter();

int seatNo = Integer.parseInt(request.getParameter("seatno"));

String name = request.getParameter("name");

String classname = request.getParameter("classname");
int marks = Integer.parseInt(request.getParameter("marks"));

float percentage = (float)marks/500*100;

String grade = "";

if (percentage >= 90) 
{

grade = "A";

} 
else if (percentage >= 80) {

grade = "B";

} else if (percentage >= 70) {

grade = "C";

} else if (percentage >= 60) {

grade = "D";

} else {

grade = "E";

}
Connection conn = null;

PreparedStatement pstmt = null;

try {

conn =DriverManager.getConnection("jdbc:postgresql://server2/exam71","exam71"," exam71");

pstmt = conn.prepareStatement("INSERT INTO student (seatno, name, classname, marks, percentage, grade) VALUES (?, ?, ?, ?, ?, ?)");

pstmt.setInt(1, seatNo);

pstmt.setString(2, name);

pstmt.setString(3, classname);

pstmt.setInt(4, marks);

pstmt.setFloat(5, percentage);

pstmt.setString(6, grade);

pstmt.executeUpdate();

out.println("<html>");

out.println("<head>");

out.println("titleStudent Details/title>");

out.println("</head>");

out.println("<body>");

out.println("<h2>Student Details:</h2>");

out.println("<p>Seat No: " + seatNo + "</p>");

out.println("<p>Name:" + name + "</p>");

out.println("<p>Class: " + classname + "</p>");

out.println("<p>Total Marks: " + marks + "</p>");

out.println("<p>Percentage:" + percentage + "%</p>");

out.println("<p>Grade: " + grade + "</p>");

out.println("</body>");

out.println("</html>");

} 
catch (SQLException e) 
{

e.printStackTrace();

} finally {

if (pstmt != null) {

try {

pstmt.close();

} catch (SQLException e) {

e.printStackTrace();

}

}

if (conn != null) {

try {

conn.close();

} catch (SQLException e) {

e.printStackTrace();

}

}

}

out.close();

}

}
