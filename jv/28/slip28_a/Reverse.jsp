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
//StringBuilder reversedString = new StringBuilder(inputString);
String inputString = request.getParameter("inputString");
if(inputString!=null && !inputString.isEmpty())
{
	String reversedString=new StringBuilder(inputString).reverse().toString();
	 out.println("Original String:"+inputString+"<br>");
	 out.println("Reversed String:"+reversedString+"<br>");


}

%>
</body>
</html>