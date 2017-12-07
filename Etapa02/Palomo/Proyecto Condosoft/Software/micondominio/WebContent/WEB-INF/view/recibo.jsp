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
				<form class="form-horizontal" action="registraRecibo.htm"
					method="POST">
					<div class="col-lg-12 box-form" align="center">

						<div class="form-group">
							<label class="control-label col-xs-3">Tipo de obligacion:</label>
							<div class="col-xs-6">
								<select name="cbopropietario" class="form-control">

									<option value="0">Seleccione obligacion</option>
									<option value="2">Agua</option>
									<option value="3">Otros</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-xs-3">Codigo :</label>
							<div class="col-xs-2">
								<input type="text" class="form-control"
									placeholder="Ingrese codigo" name="codigo">
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-xs-3">Año:</label>
							<div class="col-xs-6">
								<select name="cbopropietario" class="form-control">

									<option value="0">Seleccione año</option>
									<option value="2017">2017</option>
									<option value="2018">2018</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-xs-3">Mes :</label>
							<div class="col-xs-6">
								<select name="cbopropietario" class="form-control">
									<option value="0">Seleccione mes</option>
									<option value="1">Enero</option>
									<option value="2">Febrero</option>
									<option value="3">Marzo</option>
									<option value="4">Abril</option>
									<option value="5">Mayo</option>
									<option value="6">Junio</option>
									<option value="7">Julio</option>
									<option value="8">Agosto</option>
									<option value="9">Setiembre</option>
									<option value="10">Octubre</option>
									<option value="11">Noviembre</option>
									<option value="12">Diciembre</option>
								</select>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-xs-3">Fecha de
								Vencimiento :</label>
							<div class="col-xs-2">
								<input type="text" class="form-control"
									placeholder="Ingrese fecha" name="codigo">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-xs-3">Imorte :</label>
							<div class="col-xs-2">
								<input type="text" class="form-control"
									placeholder="Ingrese fecha" name="codigo">
							</div>
						</div>

					</div>
	
			<br>
			<div class="form-group" align="center">
				<div class="col-xs-offset-3 col-xs-6">
					<input type="submit" class="btn btn-primary" value="Guardar">
					<input type="reset" class="btn btn-default" value="Limpiar">
					<input class="btn btn-primary" type="button"
						onclick="history.back()" name="atrás" value="volver atrás">
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