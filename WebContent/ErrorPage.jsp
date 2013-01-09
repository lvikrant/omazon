<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link rel="stylesheet" type="text/css" href="commonstyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ERROR!!!</title>
</head>
<body>
<h2 align="center" style="background-color: green"><%=request.getParameter("errorMsg")%></h2>
<!-- Go back to previous page or Go to Home -->
&nbsp;&nbsp;Click
<a href="Login.html"> Click here </a>
to go to Login page !
</body>
</html>
