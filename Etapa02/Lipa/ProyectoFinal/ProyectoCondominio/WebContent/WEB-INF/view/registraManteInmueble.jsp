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

	<form action="registraMante.htm" method="post" id="mostrar">
		
		<div class="form-group">
		  <label for="usr">DNI:</label>
		  <input type="text" class="form-control" name="dni" placeholder="dni" id="dni">
		</div>
		
		<div class="form-group">
			<label for="usr">OBLIGACIÓN:</label>
			<select class="form-control" name="obligacion" id="comboObligacion">
				    <option value="00">Seleccione</option>
				    <c:forEach items="${obligaciones}" var="r">
				      <option value="${r}">${r}</option>
				    </c:forEach>
			</select>
		</div>
		
		<div class="form-group">
			<label for="usr">INMUEBLE:</label>
			<table>
				<tbody id="tabla">
				</tbody>
			</table>
		</div>
		
		<div class="form-group">
			<label for="usr">IMPORTE:</label>
			<table>
				<tbody id="tabla2">
				</tbody>
			</table>
		</div>
		
		<div class="form-group">
			<label for="usr">FECHA DE INICIO:</label>
			<table>
				<tbody id="tabla3">
				</tbody>
			</table>
		</div>
		
		<div class="form-group">
			<label for="usr">FECHA DE VENCIMIENTO:</label>
			<table>
				<tbody id="tabla4">
				</tbody>
			</table>
		</div>
		
		<div class="form-group">
		  <label for="usr">DESCRIPCIÓN:</label>
		  <input type="text" class="form-control" name="descripcion" placeholder="descripción">
		</div>
		<center>
			<input class="btn btn-danger" type="submit" 
			value="Registrar pago" />
		</center>
		
		<!-- 
	   <table>
          <tr>
            <td>OBLIGACIÓN:</td>
            <td><input type="text" class="" name="obligacion"/></td>
          </tr>
          <tr>
            <td>INMUEBLE:</td>
            <td><input type="text" name="inmueble"/></td>
          </tr>
          <tr>
            <td>PERSONA:</td>
            <td><input type="text" name="dni"/></td>
          </tr>
          <tr>
            <td>IMPORTE:</td>
            <td><input type="text" name="importe"/></td>
          </tr>
          <tr>
            <td>DESCRIPCIÓN:</td>
            <td><input type="text" name="descripcion"/></td>
          </tr>
        </table> -->	
	</form>
	
	<script type="text/javascript">
	
	
	$("#dni").change(fnConsultar);
	
	function fnConsultar(){
		
		var data = $("#mostrar").serialize();
		$.post("consultarObli.htm",data,function(data){
			
			
			var lista = $.parseJSON(data);
			
		  //llenarLipa(lista);
			
			$("#comboObligacion").html("");
			$.each(lista, function (index, r) {
				
				var row = "<option>";
				row += r.OBLIGACION;
				row += "</option>";
				
				$("#comboObligacion").append( row );
				
			});
			
		});
		
		
	}
	
	$("#comboObligacion").change(llenarInmueble);
	
	function llenarInmueble(){
		
		var data = $("#mostrar").serialize();
		$.post("consultarInmueble.htm",data,function(data){
			
			var lista = $.parseJSON(data);
						
			$("#tabla").html("");
			
			$.each(lista, function (index, r) {
			      
				  var row = "<tr>";
				  row += "<td>" + r.DESCRIPCION + "</td>";
			      row += "</tr>";
			      
			      $("#tabla").append( row );
			      
			    });			
		});
				
	}
	
	$("#comboObligacion").change(llenarImporte);
	
	function llenarImporte(){
		
		var data = $("#mostrar").serialize();
		$.post("consultarImporte.htm",data,function(data){
			
			var lista = $.parseJSON(data);
						
			$("#tabla2").html("");
			
			$.each(lista, function (index, r) {
			      
				var row = "<tr>";
				  row += "<td>" + r.IMPORTE + "</td>";
			      row += "</tr>";
			      
			      $("#tabla2").append( row );
			      
			    });			
		});
				
	}
	
	$("#comboObligacion").change(llenarFechaI);
	
	function llenarFechaI(){
		
		var data = $("#mostrar").serialize();
		$.post("consultarFechaI.htm",data,function(data){
			
			var lista = $.parseJSON(data);
						
			$("#tabla3").html("");
			
			$.each(lista, function (index, r) {
			      
				var row = "<tr>";
				  row += "<td>" + r.FECHA + "</td>";
			      row += "</tr>";
			      
			      $("#tabla3").append( row );
			      
			    });			
		});
				
	}
	
	$("#comboObligacion").change(llenarFechaF);
	
	function llenarFechaF(){
		
		var data = $("#mostrar").serialize();
		$.post("consultarFechaF.htm",data,function(data){
			
			var lista = $.parseJSON(data);
						
			$("#tabla4").html("");
			
			$.each(lista, function (index, r) {
			      
				var row = "<tr>";
				  row += "<td>" + r.FVENCE + "</td>";
			      row += "</tr>";
			      
			      $("#tabla4").append( row );
			      
			    });			
		});
				
	}
	</script>
	
</body>
</html>