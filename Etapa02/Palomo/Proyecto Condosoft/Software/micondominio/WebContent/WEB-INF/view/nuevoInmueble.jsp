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
				<form class="form-horizontal" action="registraInmueble.htm" method="POST">
					<div class="col-lg-12 box-form" align="center">

						<div class="form-group">
							<label class="control-label col-xs-3">Piso:</label>
							<div class="col-xs-2">
								<input type="text" class="form-control"
									placeholder="Ingrese Piso" name="piso">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-xs-3">Numero:</label>
							<div class="col-xs-2">
								<input type="text" class="form-control"
									placeholder="Ingrese Numero de habitacion" name="numero">
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-xs-3">Desripcion:</label>
							<div class="col-xs-6">
								<textarea rows="3" class="form-control"
									placeholder="Ingrese descripcion" name="descripcion"></textarea>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-xs-3">persona:</label>
							<div class="col-xs-6">
								<select name="cbopropietario" id="cbopropietario"  class="form-control">
								
									<option value="0">Seleccione Propietario</option>
									<option value="2">CORONEL GUSTAVO</option>
									<option value="3">SALAZAR BARBARA</option>
									<option value="4">DEL AGUILA FIORELLA</option>
									<option value="5">ALFARO CARLOS</option>
									<option value="6">LABAN CYNTHYA</option>
									<option value="7">DIAZ MANUEL</option>
									<option value="8">CONDOR JOSE</option>
								
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-xs-3">Tipo inmueble:</label>
							<div class="col-xs-6">
								<select  name="cbotinmueble" id="cbotinmueble" class="form-control">
									<option value="0">Seleccione Inmueble</option>
									<option value="1">CONDOMINIO</option>
									<option value="2">DEPARTAMENTO</option>
									<option value="3">OFICINA</option>
									<option value="4">COCHERA</option>
									<option value="5">AUDITORIO</option>
								</select>
							</div>
						</div>
						<div class="form-group" >
							<label class="control-label col-xs-3">Torre:</label>
							<div class="col-xs-6">
								<select name="cbotorre" id="cbotorre" class="form-control">
									<option value="0">Seleccione Torre</option>
									<option value="1">TORRE A</option>
									<option value="2">TORRE A</option>
									<option value="3">TORRE A</option>
									<option value="4">TORRE VIRTUAL</option>
								</select>
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