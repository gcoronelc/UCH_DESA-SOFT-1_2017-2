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
  <label>TORRES:</label><br/>
  <div class="row">
  <div class="col-3">
  <form method="post" action="consultarEstadoFinanciero.htm" id="form4">
  <select name="torre" id="comb4" class="form-control">
    <option value="00">Seleccione</option>
    <c:forEach items="${torres}" var="r">
      <option value="${r}">${r}</option>
    </c:forEach>
  </select>
  </form>
  </div>
  </div>
  
  <h1>CONSULTA</h1>
  <table class="table table-hover">
  <thead>
  <tr>
    <th>TORRE</th>
    <th>PISO</th>
    <th>CONTROL</th>
    <th>FECHA DE PAGO</th>
    <th>IMPORTE</th>
    <th>INMUEBLE</th>
    <th>PERSONA</th>
    <th>DESCRIPCION</th>
    <th>ESTADO</th>
  </tr>
  </thead>
  <tbody id="tabla">
  </tbody>
</table>
</div>

<script type="text/javascript">
	
	
$("#comb4").change(estadoFinancieroConsultar);

function estadoFinancieroConsultar(){
	
	var data = $("#form4").serialize();
	$.post("consultarEstadoFinanciero.htm",data,function(data){
		
		
		var lista = $.parseJSON(data);
		
		
		$("#tabla").html("");
		$.each(lista, function (reporteEstadoFinanciero, r) {
			
			var row = "<tr>";
			row += "<td>" + r.TORRE + "</td>";
			row += "<td>" + r.PISO + "</td>";
			row += "<td>" + r.CONTROL + "</td>";
			row += "<td>" + r.FECHAPAGO + "</td>";
			row += "<td>" + r.IMPORTE + "</td>";
			row += "<td>" + r.INMUEBLE + "</td>";
			row += "<td>" + r.PERSONA + "</td>";
			row += "<td>" + r.DESCRIPCION + "</td>";
			row += "<td>" + r.ESTADO + "</td>";
			row += "</tr>";
			
			$("#tabla").append( row );
			
		});
		
	});
	
	
}


</script>
</body>
</html>