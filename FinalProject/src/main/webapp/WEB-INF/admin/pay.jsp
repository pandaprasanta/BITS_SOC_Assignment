<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
a{
   text-decoration: none;
   color:white;
}
</style>
</head>
<body>
<center>
<table width="490" bgcolor="green">
<tr>
<th>
<a href="http://localhost:1010/Spring3HibernateIntegration/hom">Home</a><th>
<a href="http://localhost:1010/Spring3HibernateIntegration/search">Search</a><th>
<a href="http://localhost:1010/Spring3HibernateIntegration/hom">Logout</a>
</tr>
</table>
 Your booking id:${petbooking.bookingId}
 </center>
<center>Payment Operation</center>
<form:form action="paymentDone" method="Post" commandName="payment">
<table  align="center" bgcolor="#999933" width="490">
<tr>
<th>Enter bankName:<td><form:input path="bankName" />
<tr>
 <th>Enter cardNo:<td><form:input path="cardNo"/>
<tr>
<tr>
<th colspan="3" align="center"><input type="submit" value="Proceed">
</table>	
</form:form> 

</body>
</html>