<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap-theme.min.css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.1.min.js"></script>

<script type="text/javascript">
var tableToExcel = (function() {
	  var uri = 'data:application/vnd.ms-excel;base64,'
	    , template = '<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40"><head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head><body><table>{table}</table></body></html>'
	    , base64 = function(s) { return window.btoa(unescape(encodeURIComponent(s))) }
	    , format = function(s, c) { return s.replace(/{(\w+)}/g, function(m, p) { return c[p]; }) }
	  return function(table, name) {
	    if (!table.nodeType) table = document.getElementById(table)
	    var ctx = {worksheet: name || 'Worksheet', table: table.innerHTML}
	    window.location.href = uri + base64(format(template, ctx))
	  }
	})()
</script>

<title>incio</title>

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
							<td><form action="verPropietario.htm" method="POST">

									<button type="submit" class="btn btn-default">
										<span class="glyphicon glyphicon-eye-open"></span> Ver
										Propietario
									</button>

								</form></td>&nbsp;&nbsp;
							<td><form action="nuevo.htm" method="GET">
									&nbsp;&nbsp;
									<button type="submit" class="btn btn-default">
										<span class="glyphicon glyphicon-plus"></span> Nuevo
										Propietario
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
				<table class="table table-hover" id="testTable" summary="Code page support in different versions of MS Windows." rules="groups" frame="hsides">
					<thead>
						<tr  align="center">
							<th>Codigo</th>
							<th>Nombre</th>
							<th>Apellido</th>
							<th>dni</th>
							<th>email</th>
							<th>telefono</th>
							<th>direccion</th>
							<th>accion</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${lista}" var="r">
							<tr>
								<th scope="row">${ r.idpersona }</th>
								<td>${ r.nombre }</td>
								<td>${ r.apellido }</td>
								<td>${ r.dni }</td>
								<td>${ r.email }</td>
								<td>${ r.telefono }</td>
								<td>${ r.direccion }</td>
								<td><a href="#"><span
										class="glyphicon glyphicon-pencil"></span></a> &nbsp;&nbsp;&nbsp;
									<a href="verPropiedades.htm?idpersona=${r.idpersona} "><span
										class="glyphicon glyphicon-stats"></span></a>&nbsp;&nbsp;&nbsp; <a
									href="#"><span class="glyphicon glyphicon-trash"></span></a></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
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