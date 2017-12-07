<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script type="text/javascript" src='<c:url value="/jquery/jquery.js" />'></script>
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


<div class="container">
  <label>MES:</label><br/>
  <div class="row">
  <div class="col-3">
  <form method="post" action="consultarReporteMensual.htm" id="form3">
  <select name="mes" id="comb3" class="form-control">
    <option value="00">Seleccione</option>
    <option value="ENERO">ENERO</option>
    <option value="FEBRERO">FEBRERO</option>
    <option value="MARZO">MARZO</option>
    <option value="ABRIL">ABRIL</option>
    <option value="MAYO">MAYO</option>
    <option value="JUNIO">JUNIO</option>
    <option value="JULIO">JULIO</option>
    <option value="AGOSTO">AGOSTO</option>
    <option value="SEPTIEMBRE">SEPTIEMBRE</option>
    <option value="OCTUBRE">OCTUBRE</option>
    <option value="NOVIEMBRE">NOVIEMBRE</option>
    <option value="DICIEMBRE">DICIEMBRE</option>
  </select>
  </form>
  </div>
  </div>
  
  <h1>CONSULTA</h1>
  <table class="table table-hover">
  <thead>
  <tr>
    <th>CONTROL</th>
    <th>FECHA DE PAGO</th>
    <th>IMPORTE</th>
    <th>INMUEBLE</th>
    <th>PERSONA</th>
    <th>DESCRIPCION</th>
  </tr>
  </thead>
  <tbody id="tabla">
  </tbody>
</table>
</div>

<script type="text/javascript">
	
	
$("#comb3").change(reporteMensualConsultar);

function reporteMensualConsultar(){
	
	var data = $("#form3").serialize();
	$.post("consultarReporteMensual.htm",data,function(data){
		
		
		var lista = $.parseJSON(data);
		
		
		$("#tabla").html("");
		$.each(lista, function (reporteMensual, r) {
			
			var row = "<tr>";
			row += "<td>" + r.CONTROL + "</td>";
			row += "<td>" + r.FECHAPAGO + "</td>";
			row += "<td>" + r.IMPORTE + "</td>";
			row += "<td>" + r.INMUEBLE + "</td>";
			row += "<td>" + r.PERSONA + "</td>";
			row += "<td>" + r.DESCRIPCION + "</td>";
			row += "</tr>";
			
			$("#tabla").append( row );
			
		});
		
	});
	
	
}
</script>
</body>
</html>