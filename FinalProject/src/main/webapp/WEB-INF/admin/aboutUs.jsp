<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="js/jquery.1.3.1.js"></script>
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script> 
<script type="text/javascript" src="js/jquery.cycle.all.min.js"></script>

<link href="css/style.css" rel="stylesheet" type="text/css"/>
<title>Insert title here</title>
<link href="css/style.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript">
$(document).ready(
	     function()
		 {
			$('#animate').click(
			function()
			{
			  frm.userId.focus();
	        }
		 );
	});
</script>
</head>
<body>
<div id="main">
 <header>
     <banner>
        	<img src="images/bannerImages2.jpg">
      </banner> 
   <nav>
      <ul>
      <li><a href="http://localhost:1010/Spring3HibernateIntegration/hom" id="home">Home</a></li>
      <li><a href="http://localhost:1010/Spring3HibernateIntegration/pro" id="prof">Profile</a></li>
      <li class="active"><a href="http://localhost:1010/Spring3HibernateIntegration/abt">AboutUs</a></li>
      <li><a href="#">SearchBin</a></li>
      <li><a href="http://localhost:1010/Spring3HibernateIntegration/log" id="animate">Login</a></li>
      <li><a href="http://localhost:1010/Spring3HibernateIntegration/con">ContactUs</a></li>
      </ul>
   </nav>
  </header>
 <br>
<div id="content">
<section>
<div id="x1">
<div id="x">
 <div id="marq">
     <marquee behavior="scroll" direction="up" height="350px">
     <img src="images/bins/1.jpg"><br>
     <img src="images/bins/2.jpg"><br>
     <img src="images/bins/18.jpg"><br>
     <img src="images/bins/10.jpg"><br>
     <img src="images/bins/9.jpg">
     </marquee>
</div>
</div>
<div id="y">
<div id="add">
<div class="pics" id="vdo" style="text-align:justify">
<h2>Welcome to Pratian Technologies</h2>
Pratian technologies is a technology company which has
offerings in the areas of technology training,e-Learning 
solutions, consulting/mentoring services and software 
development. Pratian is backed by an excellent team of 
Software Developers, Subject Matter Experts and Consultants
who bring in the depth and richness of their knowledge into
every project/assignment Regardless of whether you are looking
for one of the services we offer, or a combination of everything
we offer, rest assured that you have come to the right place.
We have the skills, experience, reputation and solid testimonials
From the most discerning clients which sets us a class apart from 
our nearest competitors.
</div>

<div id="adds">
<div id="up">
    <div id="hrd">NOTICE</div>
    <h4>1. Book bin before 3 hour.</h4>
    <h4>2. Cancel bin before 2 hour.</h4><br>
</div>
<hr color="white" width="20px">	
<div id="wn">
    <div id="login">Login</div>
    <form:form action="userlogin/check" method="POST">
    <table>
    <tr>
    <th>UserId</th><td><input type="text" name="userId"></td>
    </tr>
    <tr>
    <th>Password</th><td><input type="password" name="pass"></td>
    </tr>
    <tr>
    <th colspan="3"><input type="submit" value="Login" class="abc"></th>
    </tr>
    </table>
    </form:form>
</div>
</div>
</div>
</div>
</div>

<div class="clear"></div>
</section>
</div>
<hr color="black" width="1000">
<footer>
<p>All Right Reserved &copy; Pratian<sup>&reg;</sup>com</p>
</footer>
</div>
</body>
</html>