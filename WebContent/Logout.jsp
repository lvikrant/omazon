<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="commonstyle.css" >
<title>LogOut</title>
</head>
<body>
<%session.invalidate(); %>
<table class ="layout" border="0" width="90%" align="center">
	<tr>

		<td align="center">
			<h2 class="heading2">Omazon</h2>
		</td>
	</tr>
	<tr>
	<th align="center">Logout Page</th>
	</tr>
	</table>
<table width="60%" border="0" align="Center">
<tr>
<td align="center">You have successfully logout! </td>
</tr>
<tr>
<td align="center">
<a href="Login.html">Back to Login page </a>
</td>
</tr>
</table>
</body>
</html>