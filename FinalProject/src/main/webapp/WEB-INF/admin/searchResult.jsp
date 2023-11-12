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
<img  src="images/bannerImages.jpg">
<br>

<table width="490" bgcolor="green">
<tr>
<th>
<a href="http://localhost:1010/Spring3HibernateIntegration/hom">Home</a><th>
<a href="http://localhost:1010/Spring3HibernateIntegration/search">Search</a>
<th><a href="http://localhost:1010/Spring3HibernateIntegration/hom">Logout</a>
</tr>
</table>

<form:form action="bookBin/add" method="post" commandName="bin">
<c:if test="${not empty showbins}">
<table id="x3"  align="center" bgcolor="#CCCCCC" width="490">
<tr>
<th>BINID<th>BINNAME<th>BINSIZE<th>BINPRICE<th>BINQUANTITY<th>PICK
<tr>	
<c:forEach var="bin1" items="${showbins}">
<tr bgcolor="#FFCC99">
<td><c:out value="${bin1.binId}"/>
<td><c:out value="${bin1.binName}"/>
<td><c:out value="${bin1.binSize}"/>
<td><c:out value="${bin1.quantity}"/>
<td><c:out value="${bin1.price}"/><td><%-- <input type="checkbox" value="${bin1.binId}" name="x"> --%><input type="radio" value="${bin1.binId}" name="x">
<br>
</c:forEach>
</table>
</c:if>
<input type="submit" value="book">
</form:form>

<%-- <c:if test="${not empty showbins}">
<form name="frm" action="bookBin/add" method="POST">
<input type="submit" value="Book">
</form>
</c:if>
 --%>
 </center>
</body>
</html>