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
										Reservaciones
									</button>

								</form></td>&nbsp;&nbsp;
							<td><form action="#" method="GET">
									&nbsp;&nbsp;
									<button type="submit" class="btn btn-default">
										<span class="glyphicon glyphicon-plus"></span> Generar
										Reservacion
									</button>
								</form></td>&nbsp;&nbsp;

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
				<h2>Mantenimiento de Auditorio</h2>
				<form id="form1">
					<input type="hidden" name="tipo" value="2" />
					<table class="table table-hover" >
						<thead>
							<tr>
								<td>Periodo</td>
								<td>Mes</td>
								<td>Dia</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>
									<div class="form-group">

										<div class="col-xs-6">
											<select id="periodo" name="periodo" class="form-control">

												<option value="0">Seleccione periodo</option>
												<option value="2017">2017</option>
												<option value="2018">2018</option>
											</select>
										</div>
									</div>
								</td>
								<td>
									<div class="form-group">

										<div class="col-xs-6">
											<select id="mes" name="mes" class="form-control">

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
								</td>
								<td>
									<div class="form-group">

										<div class="col-xs-6">
											<select id="mes" name="mes" class="form-control">

												<option value="0">Seleccione dia</option>
												<option value="1">1</option>
												<option value="2">2</option>
												<option value="3">3</option>
												<option value="4">4</option>
												<option value="5">5</option>
												<option value="6">6</option>
												<option value="7">7</option>
												<option value="8">8</option>
												<option value="9">9</option>
												<option value="10">10</option>
												<option value="11">11</option>
												<option value="12">12</option>
												<option value="13">13</option>
												<option value="1">14</option>
												<option value="2">15</option>
												<option value="3">16</option>
												<option value="4">17</option>
												<option value="5">18</option>
												<option value="6">19</option>
												<option value="7">20</option>
												<option value="8">21</option>
												<option value="9">22</option>
												<option value="10">23</option>
												<option value="11">24</option>
												<option value="12">25</option>
												<option value="13">26</option>
												<option value="8">27</option>
												<option value="9">28</option>
												<option value="10">29</option>
												<option value="11">30</option>
												<option value="12">31</option>
											</select>
										</div>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</form>

				<div id="divGrabar" style="display: none;">
					<input id="btnGrabar" class="btn btn-default" type="button"
						value="Grabar" />
				</div>
			</div>
		</div>
	</div>
</body>

</html>