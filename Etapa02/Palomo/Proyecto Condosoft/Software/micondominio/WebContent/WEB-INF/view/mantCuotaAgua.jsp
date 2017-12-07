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


<title>Mantenimiento</title>
</head>
<body background="<c:url value="/images/bb.jpg" />">
	<div class="egcc_menu">
		<jsp:include page="menu.jsp" />
	</div>
	<div class="container">
			<div class="panel panel-default">
			<div class="panel-heading">
				<div class="btn-toolbar" role="toolbar" align="center">

					<table align="center">
						<tr>
							<td><form action="#" method="GET">

									<button type="submit" class="btn btn-default">
										<span class="glyphicon glyphicon-eye-open"></span> Ver
										Obligacion Cuota de Agua
									</button>

								</form></td>&nbsp;&nbsp;
							<td><form action="#" method="GET">
									&nbsp;&nbsp;
									<button type="submit" class="btn btn-default">
										<span class="glyphicon glyphicon-plus"></span> Generar Cuota
									</button>
								</form></td>&nbsp;&nbsp;
								<td><form action="registrarCoutaAgua.htm" method="GET">
									&nbsp;&nbsp;
									<button type="submit" class="btn btn-default">
										<span class="glyphicon glyphicon-plus"></span> Registrar Recibo
									</button>
								</form></td>
							<td>&nbsp;&nbsp;
								<button type="button" class="btn btn-default" id="btnExport"
									onclick="tableToExcel('testTable', 'W3C Example Table')">
									<span class="glyphicon glyphicon-open"></span> Exportar
								</button>

							</td>
						</tr>

					</table>
				</div>
			</div>
		</div>
		<div class="panel panel-default">
			<div class="panel-body">
				<h2>Generar Cuota Agua</h2>
				<table class="table table-hover" id="testTable"
					summary="Code page support in different versions of MS Windows."
					rules="groups" frame="hsides">
					<thead>
						<tr>
							<th>ID</th>
							<th>INMUEBLE</th>
							<th>CODIGO</th>
							<th>TORRE</th>
							<th>PISO</th>
							<th>DESCRIPCION</th>
							<th>OBLIGACION</th>
							<th>AÑO</th>
							<th>MES</th>
							<th>IMPORTE</th>
							<th>VENCIMIENTO</th>
							<th>PAGADA</th>
						</tr>
					</thead>

					<tbody id="tabla">
					</tbody>

				</table>
				<div id="divGrabar" style="display: none;">
					<input id="btnGrabar" class="btn btn-default" type="button"
						value="Grabar" />
				</div>
			</div>
		</div>
	</div>
</body>

</html>