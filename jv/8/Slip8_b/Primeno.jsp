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
int n=Integer.parseInt(request.getParameter("t1"));
out.println("give number is :"+n);
int d=2;
while(d<n)
{
	if(n%d==0)
	{
		out.println("<br>"+n+"is not prime no.");
		break;
	}
	else
		d++;
}
if(n==d)
{
	out.println("<br>"+n+"is prime no.");
}


%><font size=18 color=red><%= n %></font>
</body>
</html>