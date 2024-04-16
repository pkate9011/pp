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
        String uid=request.getParameter("id");
        String password=request.getParameter("pass");
        session.setAttribute("session-uid", uid);
        if(uid.equals("bcs") && password.equals("bcs123"))
        {
			response.sendRedirect("success.jsp");
        }
        else
		{
            response.sendRedirect("failed.jsp");
        }
        %>

</body>
</html>