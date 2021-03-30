<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Loan is granted</h2>
<%
session=request.getSession();
String name=session.getAttribute("name").toString();
String email=session.getAttribute("email").toString();

out.println(name);
out.println(email);
 %>
</body>
</html>