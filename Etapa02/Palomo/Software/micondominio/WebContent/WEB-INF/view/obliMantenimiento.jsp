<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap-theme.min.css">


<script src='<c:url value="/js/jquery.js" />'></script>
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
			<div class="panel-body">
				<form id="form1">
					<input type="hidden" name="tipo" value="2" />
					<table class="table table-hover" id="testTable"
						summary="Code page support in different versions of MS Windows."
						rules="groups" frame="hsides">
						<thead>
							<tr>
								<td>Periodo</td>
								<td>Mes</td>
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
							</tr>
						</tbody>
					</table>
				</form>
				<h2>Obligaciones</h2>
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
		<input id="btnGrabar" class="egcc_btn_default topspace" type="button" value="Grabar" />
	</div>
			</div>
		</div>
	</div> 

	
	<script>
	
	fnCargarTabla();
	
	$("#btnGrabar").click(function(){
		var data = $("#form1").serialize();
		$.post("grabarObliMant.htm",data,function(response){
			
			var objJson =  $.parseJSON(response);
			
			if( objJson.code == 1 ){
				fnCargarTabla();
				alert("Proceso ejecutado correctamente.");
			} else {
				alert(objJson.mensaje);
			}
			
			
		});
	});
	
	$("#periodo").change(fnCargarTabla);
	
	$("#mes").change(fnCargarTabla);
	
	function fnCargarTabla(){
		
		$("#divGrabar").hide();
		$("#tabla").html("");
		var data = $("#form1").serialize();
		
		$.post("leerObligaciones.htm", data, function(dataJson){
		
			var lista = $.parseJSON(dataJson);
			
			if( lista.length == 0 ) {
				
				$.post("generaObligaciones.htm", data, function(dataJson){
					var lista = $.parseJSON(dataJson);
					mostrarList(lista);
					$("#divGrabar").show();
				});
				
			} else {
				mostrarList(lista);	
			}
			
		});
		
	}
	
	function mostrarList(lista){
	   $.each(lista, function (index, r) {
            
            var row = "<tr>";
            row += "<td>" + r.id + "</td>";
            row += "<td>" + r.inmueble + "</td>";
            row += "<td>" + r.codigo + "</td>";
            row += "<td>" + r.torre + "</td>";
            row += "<td>" + r.piso + "</td>";
            row += "<td>" + r.descripcion + "</td>";
            row += "<td>" + r.nomobligacion + "</td>";
            row += "<td>" + r.anio + "</td>";
            row += "<td>" + r.mes + "</td>";
            row += "<td>" + r.importe + "</td>";
            row += "<td>" + r.vencimiento + "</td>";
            row += "<td>" + r.pagada + "</td>";
            row += "</tr>";
            
            $("#tabla").append( row );
            
        });
	}

	</script>


</body>

</html>