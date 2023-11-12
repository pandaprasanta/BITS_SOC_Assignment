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
<table width="490" bgcolor="green" align="center">
<tr>
<th>
<a href="http://localhost:1010/Spring3HibernateIntegration/hom">Home</a><th>
<a href="http://localhost:1010/Spring3HibernateIntegration/search">Search</a><th>
<a href="http://localhost:1010/Spring3HibernateIntegration/hom">Logout</a>
</tr>
</table>
<center>Pet Information</center>
<form:form action="pay" method="Post" commandName="pet1">
<table  align="center" bgcolor="#999933" width="490">
<tr>
<th>Enter PetName:<td><form:input path="petName" />
<tr>
 <th>Enter PetCategory:<td><form:input path="petCategory"/>
<tr>
<th>Enter Petlength:<td><form:input path="length"/>
<tr>
<th>Enter Petbreadth:<td><form:input path="breadth" />
<tr>
<th>Enter Petheight:<td><form:input path="height" />
<tr>
<tr>
<th>Enter UserRef_No:<td><input type="text" name="user">
<tr>
<tr>
<th>Total Price You need to Pay:<td><c:out value="${binPrice.price}"></c:out>

<tr>
<th colspan="3" align="center"><input type="submit" value="Payment">
</table>	
</form:form> 

</body>
</html>