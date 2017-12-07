<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap-theme.min.css">
<title>incio</title>
</head>
<body background="<c:url value="/images/bb.jpg" />">

	<div class="egcc_menu">
		<jsp:include page="menu.jsp" />
	</div>

	<div class="container">
		<div class="panel panel-default">
			<div class="panel-body">
				<form class="form-horizontal" action="registraUsuario.htm" method="POST">
					<div class="col-lg-12 box-form" align="center">
						<div class="form-group">
							<label class="control-label col-xs-3">Persona:</label>
							<div class="col-xs-6">
								<input type="text" class="form-control"
									placeholder="Ingrese Persona" name="persona">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-xs-3">Usuario:</label>
							<div class="col-xs-6">
								<input type="text" class="form-control"
									placeholder="Ingrese Usuario" name="usuario">
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-xs-3">Clave:</label>
							<div class="col-xs-6">
								<input type="text" class="form-control"
									placeholder="Ingrese Clave" name="clave">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-xs-3">Rol:</label>
							<div class="col-xs-6">
								<input type="text" class="form-control"
									placeholder="Ingrese Rol" name="rol">
							</div>
						</div>
					<br>
					<div class="form-group" align="center">
						<div class="col-xs-offset-3 col-xs-6">
							<input type="submit" class="btn btn-primary" value="Guardar">
							<input type="reset" class="btn btn-default" value="Limpiar">
							<input  class="btn btn-primary" type="button" onclick="history.back()" name="atrás" value="volver atrás">
						</div>
					</div>
				</form>

			</div>
		</div>
	</div>






	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
		integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
		integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
		crossorigin="anonymous"></script>
</body>
</html>