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
b{
   color:blue;
   font-size: 20px;
}
a{
   text-decoration: none;
   color:white;
}
</style>
</head>
<body>
<center>
<img  src="images/bannerImages.jpg"><br><br><br>
<table width="490" bgcolor="green">
<tr>
<th>
<a href="http://localhost:1010/Spring3HibernateIntegration/hom">Home</a><th>
<a href="http://localhost:1010/Spring3HibernateIntegration/search">Search</a><th>
<a href="http://localhost:1010/Spring3HibernateIntegration/hom">Logout</a>
</tr>
</table>
<form:form action="showSearch/show" method="post">
<b>Please Select The Category: </b><select name="cat">
<c:forEach var="cat" items="${showcategories}">
 <option value="${cat.categoryId}">${cat.categorySize}</option>
</c:forEach>
</select>
<input type="submit" value="search">
</form:form>
</center>
</body>
</html>