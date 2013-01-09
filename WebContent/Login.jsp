<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="beanClass.OmazonUserLogin"%> 
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="commonstyle.css">
<title>Omazon Login</title>
</head>
<body>
<table width="100%" class="layout">
	<tr>
		<td><a href ="Login.html">Login Page</a><br></td>
		<td align="right">
		<a href="Logout.jsp">Logout</a>
		</td>
	</tr>
</table>
<table class ="layout" border="0" width="90%" align="center">
	<tr>
		<td align="center">
	    <p class="heading2">Omazon</p>
	    </td>                                
	</tr>
</table>
<%
try 
{
	/* Employee Id is checked for null and empty string */
	if((request.getParameter("txtname")==null)||((request.getParameter("txtname")).length()==0))
	{
%>

<%-- Forward the request to error page if field is left blank --%>
<jsp:forward page="ErrorPage.jsp" >
<jsp:param value="UserId is mandatory" name="errorMsg"></jsp:param>
</jsp:forward>

<%
	}
	else if((request.getParameter("txtpasswd")==null)||((request.getParameter("txtpasswd")).length()==0))
	{
%>

<%--Forward the request to error page if field is left blank --%>
<jsp:forward page="ErrorPage.jsp" >
<jsp:param value="Password is mandatory" name="errorMsg"></jsp:param>
</jsp:forward>

<%
	}
	else
	{
		String userId = request.getParameter("txtname");
		String password = request.getParameter("txtpasswd");
		OmazonUserLogin omazon = new OmazonUserLogin();
		System.out.println("login.jsp user"+userId);
		String checkPassword = omazon.getPassword(userId);
		System.out.println("login.jsp pass"+checkPassword);
		int role = omazon.checkRole(userId);
		System.out.println("***Role:"+role);
		if(checkPassword != null)
		{
			if(checkPassword.equals(password))
			{
				if(role == 0)
				{
%>
<jsp:forward page="ManagerHomePage.html"></jsp:forward>
<%
				}
				
				if(role == 1)
				{
%>
<jsp:forward page="ClerkHomePage.html"></jsp:forward>
<%
				}
				
				if(role == 2)
				{
%>
<jsp:forward page="DeliveryHomePage.html"></jsp:forward>
<%
				}
				if(role == 3)
				{
%>
<jsp:forward page="CustomerHomePage.html"></jsp:forward>
<%
				}			

			}
			else
			{
%>
<jsp:forward page="ErrorPage.jsp" >
<jsp:param value="Password is incorrect" name="errorMsg"></jsp:param>
</jsp:forward>
<%			
			}
		}
		else
		{
%>
<jsp:forward page="ErrorPage.jsp" >
<jsp:param value="User Id is incorrect" name="errorMsg"></jsp:param>
</jsp:forward>
<%
		}
	}
}
catch(Exception e)
{
	System.out.println("333"+e);	
}
%>
</body>
</html>