<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%! int n,rem,r; %>
<% n=Integer.parseInt(request.getParameter("num"));
      if(n<10)
     {
       out.println("Sum of first and last digit is   ");
%><font size=18 color=red><%= n %></font>
<%
     }
    else
    {
      rem=n%10;
      do{
                 r=n%10;
                 n=n/10;
                }while(n>0);
         n=rem+r;
        out.println("Sum of first and last digit is    ");
%><font size=18 color=red><%= n %></font>
<%
     }
%>

</body>
</html>