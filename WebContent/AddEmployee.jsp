<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ //page import="beanClasses.Employee" %>
     <%@ //page import="daoClass.SterlingDAO" %>
     <%@ page import="java.util.Calendar" %>
     <%@ page import="java.util.GregorianCalendar"%>
     <%@ page errorPage = "ErrorPage.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="commonstyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Employee</title>
</head>
<body>
<a href="Logout.jsp">Logout</a>
<%
//server side null validation
String userId=(String)session.getAttribute("ID");
    if(userId==null)
    {
    	throw new Exception("Please Login First");

  }
    
  
int pin=Integer.parseInt(request.getParameter("text_Pin"));
if(request.getParameter("text_Pin")==null )
{
	throw new Exception("Null Field Entered");
}
    
else {
%>

<!--  -->jsp:useBean id="newEmployee" class="beanClasses.Employee"/>
<jsp:setProperty name="newEmployee" property="employeeName" param="text_Name"/>
<jsp:setProperty name="newEmployee" property="dateOfBirth" param="text_DOB"/>
<jsp:setProperty name="newEmployee" property="designation" param="desig"/>
<jsp:setProperty name="newEmployee" property="address" param="txtadd"/>
<jsp:setProperty name="newEmployee" property="pin" param="text_Pin"/>
<jsp:setProperty name="newEmployee" property="telephone" param="text_Ph"/>
<jsp:setProperty name="newEmployee" property="email" param="text_Email"/>
<jsp:setProperty name="newEmployee" property="region" param="city"/>
<%
//SterlingDAO SterDAO=new SterlingDAO();
//int status=SterDAO.saveEmployee(newEmployee);

%>
<p class="heading2" align="center"> Sterling Courier</p>
<table align="center">
<tr><td align="center" colspan="2">
	<p class="heading3"> Employee Added</p>
</td></tr>
<tr><td>
<h2 align="center">Employee Id is <%//=status %></h2>
<%} %>
</td></tr>
</table>
</body>
</html>