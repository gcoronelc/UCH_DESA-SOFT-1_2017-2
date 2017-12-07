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
  
  <label>INMUEBLES:</label><br/>
  <div class="row">
  <div class="col-3">
  <form method="post" action="alquilarAuditorio.htm" id="form">
  <select name="auditorio" id="combox" class="form-control">
    <option value="00">Seleccione</option>
    <c:forEach items="${auditorios}" var="r">
      <option value="${r}">${r}</option>
    </c:forEach>
  </select>
  </form>
  </div>
  </div>
  		<div class="form-group">
			<label for="usr">PISO:</label>
			<table>
				<tbody id="tabla">
				</tbody>
			</table>
		</div>
		
		<div class="form-group">
			<label for="usr">TORRE:</label>
			<table>
				<tbody id="tabla2">
				</tbody>
			</table>
		</div>
		
        <div class="form-group">
		  <label for="usr">DNI PROPIETARIO:</label>
		  <input type="text" class="form-control" name="dni" placeholder="dni">
		</div>
		
		<div class="form-group">
		  <label for="usr">MONTO:</label>
		  <input type="text" class="form-control" name="monto" placeholder="monto">
		</div>
		
		<div class="form-group">
		  <label for="usr">DESCRIPCION:</label>
		  <input type="text" class="form-control" name="descripcion" placeholder="descripción">
		</div>
		
		<center>
			<input class="btn btn-danger" type="submit" 
			value="Registrar Alquiler" />
		</center>  
</div>		
<script type="text/javascript">
	
	
$("#combox").change(llenarPiso);

function llenarPiso(){
	
	var data = $("#form").serialize();
	$.post("consultaPiso.htm",data,function(data){
		
		var lista = $.parseJSON(data);
					
		$("#tabla").html("");
		
		$.each(lista, function (index, r) {
		      
			  var row = "<tr>";
			  row += "<td>" + r.PISO + "</td>";
		      row += "</tr>";
		      
		      $("#tabla").append( row );
		      
		    });			
	});
			
}

$("#combox").change(llenarTorre);

function llenarTorre(){
	
	var data = $("#form").serialize();
	$.post("consultaTorre.htm",data,function(data){
		
		var lista = $.parseJSON(data);
					
		$("#tabla2").html("");
		
		$.each(lista, function (index, r) {
		      
			var row = "<tr>";
			  row += "<td>" + r.TORRE + "</td>";
		      row += "</tr>";
		      
		      $("#tabla2").append( row );
		      
		    });			
	});
			
}
	

</script>
</body>
</html>