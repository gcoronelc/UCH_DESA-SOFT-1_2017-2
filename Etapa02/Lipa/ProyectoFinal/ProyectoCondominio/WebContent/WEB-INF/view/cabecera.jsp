<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<nav class="navbar navbar-default navbar-fixed-top" style="background-color: #42c07d">
	
	<div class="container-fluid">
	
		<div class="navbar-header">
				
			<button type="button" class="navbar-toggle collapse" data-toggle="collapse" data-target="#navbar-1">
				<span class="sr-only">Menu</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
	
			<a href="<c:url value="main.htm" />" class="navbar-brand" style="color: white"> 
				<i style="font-size:14px"> CONDOSOTF</i> 
			</a>
			
		</div>
		
		<div style="float: right;">			
			<ul class="nav navbar-nav">
			
				<li>
					<a style="color: white;">
	   					<i class= "fa fa-user-o" style="font-size:14px">
	   						USUARIO: ${sessionScope.usuario.NOMBRE}, ${sessionScope.usuario.APELLIDO}
	   					</i>
					</a>
				</li>
	
				<li>
					<a href="salir.htm" style="color: red;">
						<i style="font-size:14px"> 
							CERRAR SESIÓN 
						</i> 
					</a>
				</li>
													
			</ul>
		</div>
								
	</div>
	
</nav>