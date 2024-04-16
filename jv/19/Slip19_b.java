import java.io.IOException;

import java.io.PrintWriter;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")

public class LoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

response.setContentType("text/html;charset=UTF-8");

PrintWriter out = response.getWriter();

String username = request.getParameter("username");
String username = request.getParameter("password");
try 
{

Class.forName("org.postgresql.Driver");

Connection con =DriverManager.getConnection("jdbc:postgresql://server2/exam71", "exam71", "exam71");

PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE username=? AND password=?");

ps.setString(1, username);

ps.setString(2, password);

ResultSet rs = ps.executeQuery();

if (rs.next()) {

out.println("<h2>Welcome " + username + "</h2>");

} else {

out.println("<h2>Invalid username or password</h2>");

}
con.close();

} catch (Exception e) {

out.println("<h2>Error: " + e.getMessage() + "</h2>");

}

}
}

