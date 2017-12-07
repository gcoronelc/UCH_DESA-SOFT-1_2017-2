<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Login</title>
		
		
		
		<link rel="stylesheet" type="text/css" 
			href='<c:url value="/css/style.css" />'>
			
			
			<!-- Custom Theme files -->
			<link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
			<!-- Custom Theme files -->
			
			<!-- metas -->
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 	
		<meta name="keywords" content="Square login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola web design" />	
			<!-- metas -->
			
	</head>
	<body >
	<!--header start here-->
	<div class="login-form">
				<div class="top-login">
					<span><img src="images/group.png" alt=""/></span>
				</div>
				<h1>Iniciar Sesión</h1>
				<div class="login-top">
				<form action="ingresar.htm" method="POST">
					<div class="login-ic">
						<i ></i>
						<input type="text"  value="User name" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'User name';}" name="usuario"/>
						<div class="clear"> </div>
					</div>
					<div class="login-ic">
						<i class="icon"></i>
						<input type="password"  value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'password';} " name="clave"/>
						<div class="clear"> </div>
					</div>
				
					<div class="log-bwn">
						<input type="submit"  value="Ingresar" >
					</div>
					</form>
				</div>
				<p class="copy">condominio </p>
	</div>		
	<!--header start here-->
	</body>
</html>