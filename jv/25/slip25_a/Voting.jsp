<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String name=request.getParameter("name");
int age=Integer.parseInt(request.getParameter("age"));
if(age>=18)
{
	out.println(name + " : Allowed to vote");
	
}
else
{
	out.println(name + " : Not Allowed to vote");
	
}
%>

</body>
</html>