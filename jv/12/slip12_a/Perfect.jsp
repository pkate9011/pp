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
int sum=0;
for(int i=1;i<n;i++)
{
	if(n%i==0)
	{
		sum=sum+i;
	}
}
if(sum==n)
{
	out.println("<br>"+n+"is perfect no.");
	
}
else
{
	out.println("<br>"+n+"is not perfect");

}%>

</body>
</html>