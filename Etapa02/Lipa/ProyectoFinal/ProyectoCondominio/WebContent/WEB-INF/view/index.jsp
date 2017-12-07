<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript" src='<c:url value="alertaschidas/sweetalert-dev.js" />'></script>

<link rel="stylesheet" type="text/css" href='<c:url value="alertaschidas/sweetalert.css" />'>

<link rel="stylesheet" type="text/css" href='<c:url value="fonts/OleoScript-Regular.ttf" />'>

<link rel="stylesheet" type="text/css" href='<c:url value="bootstrap/bootstrap.min.css" />'>

<link rel="stylesheet" type="text/css" href='<c:url value="css/style.css" />'>

<title>Demo MVC</title>
</head>
<body style="background-image: url(imagen/condominio.jpg);">

	<div class="container formulario">
		<div class="row">
	       	<div class="col-xs-4 col-xs-offset-4  ">
	           	<img src='<c:url value="imagen/login.png" />' class="logo center-block" />
	        </div>
	    </div>
	    
	    <c:if test="${ error != null }">
	    <div class="egcc_error">${error}</div>
	    </c:if>
    
	    <div class="espaciado"></div>
	    
	    <div class="row">
			<fieldset class="col-xs-10 col-xs-offset-1">
				<legend class="hidden-xs">
			            <h3>CONDOSOFT</h3>
			    </legend>
			    
		      	<form method="post" action="ingresar.htm">
		      		<div class="form-group">
							<label class="col-xs-12" for="usuario"><h4>Usuario</h4></label>

			                <div class="col-xs-10 col-xs-offset-1">
			                    <input class="form-control Input" name="usuario" required autofocus>
			                </div>
	                    </div>

	                    <div class="form-group">
	                    	<label class="col-xs-12" for="password"><h4>Clave</h4></label>

	                 		<div class="col-xs-10 col-xs-offset-1">
	                    		<input type="password" id="password" class="form-control Input" name="clave" required>
	                        </div>
	                    </div>
	                    
	                    <div class="form-group">
	                        <button type="submit" class="btn btn-danger center-block">Ingresar</button>
	                    </div>
		      	</form>
			</fieldset>
	    </div>
	</div>
	
</body>
</html>