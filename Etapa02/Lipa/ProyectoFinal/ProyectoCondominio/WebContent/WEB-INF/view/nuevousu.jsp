<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
	<title>Insert title here</title>
	</head>
<body>
	<div class="egcc_cabecera">
      <jsp:include page="cabecera.jsp"/>
    </div>
    
    <div class="egcc_menu">
      <jsp:include page="menu.jsp"/>
    </div>
	<BR>
	<BR>
	<BR>
	<BR>
	<!-- PÁGINA -->

	<form action="registraUsuario.htm" method="post" id="mostrar">
		
		<div class="col-sm-12">
		  <label for="usr">NOMBRE:</label>
		  <input type="text" class="form-control" name="nombre" placeholder="Nombre">
		</div>
		
		<div class="col-sm-12">
		  <label for="usr">APELLIDOS:</label>
		  <input type="text" class="form-control" name="apellidos" placeholder="Apellidos">
		</div>
		
		<div class="col-sm-12">
		  <label for="usr">DNI:</label>
		  <input type="text" class="form-control" name="dni" placeholder="Dni">
		</div>
		
		<div class="col-sm-12">
		  <label for="usr">TELÉFONO:</label>
		  <input type="text" class="form-control" name="telefono" placeholder="Teléfono">
		</div>
		
		<div class="col-sm-12">
		  <label for="usr">DIRECCIÓN:</label>
		  <input type="text" class="form-control" name="direccion" placeholder="Dirección">
		</div>
		
		<div class="col-sm-12">
		  <label for="usr">E-MAIL:</label>
		  <input type="text" class="form-control" name="email" placeholder="E-mail">
		</div>
		
		<div class="col-sm-12">
			<label for="usr">TIPO PERSONA:</label>
			<select class="form-control" name="tipopersona">
				    <option value="00">Seleccione</option>
				    <c:forEach items="${tpersonas}" var="r">
				      <option value="${r}">${r}</option>
				    </c:forEach>
			</select>
		</div>
		
		<div class="col-sm-12">
			<label for="usr">TIPO USUARIO:</label>
			<select class="form-control" name="tipousuario">
				    <option value="00">Seleccione</option>
				    <c:forEach items="${tusuarios}" var="r">
				      <option value="${r}">${r}</option>
				    </c:forEach>
			</select>
		</div>
		
		<div class="col-sm-12">
		  <label for="usr">USUARIO:</label>
		  <input type="text" class="form-control" name="usuario" placeholder="Usuario">
		</div>
		
		<div class="col-sm-12">
		  <label for="usr">CLAVE:</label>
		  <input type="password" class="form-control" name="clave" placeholder="Clave">
		</div>
		
		<center>
			<div class="col-sm-12">
				<br>
				<input class="btn btn-danger" type="submit" value="Registrar usuario" />
			</div>
		</center>
			
	</form>
</body>
</html>