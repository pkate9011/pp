<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" page import="java.sql.*;"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@ page import="java.sql.*;" %>
<%! int hno;
String hname,address; %>
<%
try{
	Class.forName("org.postgresql.Driver");
	System.out.println("Driver laoded in memory****");
	Connection con=DriverManager.getConnection("jdbc:postgresql://localhost/java","mansi","mansi123");
	System.out.println("Con ok****");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select * from patient");
%>
<table border="1" width="40%"> 
<tr>
 <td>Patient No</td> <td>Name</td> 
<td>Address</td> </tr> 
<% while(rs.next()) { %> 
<tr><td><%= rs.getInt("pno") %></td> 
<td><%= rs.getString("pname") %></td>
 <td><%= rs.getString("address") %> </tr>
<td><%= rs.getString("age") %> </tr>
<td><%= rs.getString("disease") %> </tr>
 <%
}
con.close();
}catch(Exception e)
{
out.println(e);
}
%>

</body>
</html>