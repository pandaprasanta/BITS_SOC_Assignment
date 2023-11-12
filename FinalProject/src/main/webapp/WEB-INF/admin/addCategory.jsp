<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript" src="js/jquery.1.3.1.js"></script>
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script> 
<script type="text/javascript" src="js/jquery.cycle.all.min.js"></script>

<head>
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(
	     function()
		 {
			$('#x2').hide(); 
			$('#x3').hide();
			$('#x1').hide(); 
			$('#add').click(
			function()
			{			
			  $('#x2').show();
			  $('#x3').hide();
			  $('#x1').hide();
	        }
	 );
});
$(document).ready(
	     function()
		 {
			$('#x2').hide(); 
			$('#x3').hide();
			$('#x1').hide(); 
			$('#view').click(
			function()
			{			
   			   $('#x3').show();
			   $('#x2').hide(); 
			   $('#x1').hide();
	        }
	 );
});

$(document).ready(
	     function()
		 {
			$('#x2').hide(); 
			$('#x3').hide();
			$('#x1').hide(); 
			$('#delete').click(
			function()
			{			
			  $('#x1').show();
			  $('#x3').hide();
     		   $('#x2').hide(); 
	        }
	 );
});

</script>
<style>
th{
	color:#FFF;
	width:50px;
	background-color:#000;
}
a{
   color: white;
   text-decoration: none;
}
</style>
</head>
<body>
<center>
<img alt="" src="images/bannerImages.jpg">
</center>
<table width="850" align="center">
<tr>
<th><font face="time new Roman" color="RED">Welcome Admin</font>
<th><a href="http://localhost:1010/Spring3HibernateIntegration/index">Category Operation</a>
<th><a href="http://localhost:1010/Spring3HibernateIntegration/index1">Bin Operation</a>
<th><a href="http://localhost:1010/Spring3HibernateIntegration/hom"><font color="Green">LogOut</font></a>
</table>

<table cellpadding="5" cellspacing="10" width="870" align="center">
<!-- <tr>
<th colspan="3">Category Operation
</tr> -->
<tr>
<th><a href="#" id="add">Add Category</a>
<th><a href="#" id="view">View Category</a>
<th><a href="#" id="delete">Delete Category</a>
</tr>
</table>

<form:form method="post" action="addCategory/add" commandName="category">
<table id="x2" align="center" bgcolor="#999933" width="490">
<tr>
<td align="right"><font face="Time New Roman" color="cyan" size="+1">Enter The CategorySize:</font>
<td align="left"><form:input path="categorySize"/>
<tr>
<td colspan="3" align="center"><input type="submit">
</table>
</form:form>

<table id="x3"  align="center" bgcolor="#CCCCCC" width="490">
<c:forEach var="cat" items="${message}">
<tr bgcolor="#FFCC99">
<td><c:out value="${cat.categoryId}"/></td>
<td><c:out value="${cat.categorySize}"/></td>
</tr>
</c:forEach>
</table>

<form:form action="addCategory/delete" method="post">
<table id="x1"  align="center" bgcolor="#999999" width="490">
<tr>
<td align="right">Category<select name="cat">
<c:forEach var="cat" items="${message}">
 <option value="${cat.categoryId}">${cat.categorySize}</option>
</c:forEach>
</select> 
</td>
<td><input type="submit" value="Delete"></td>
<tr>
</table>
</form:form>

</body>
</html>
