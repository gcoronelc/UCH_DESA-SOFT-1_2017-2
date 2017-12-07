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

	<form action="guardaInmueble.htm" method="post" id="mostrar">
		
		<div class="col-sm-12">
			<label for="usr">TIPO INMUEBLE:</label>
			<select class="form-control" name="tipoinmueble">
				    <option value="00">Seleccione</option>
				    <c:forEach items="${tipoinmuebles}" var="r">
				      <option value="${r}">${r}</option>
				    </c:forEach>
			</select>
		</div>
		
		<div class="col-sm-12">
		  <label for="usr">DNI:</label>
		  <input type="text" class="form-control" name="dni" placeholder="Dni">
		</div>
		
		<div class="col-sm-12">
			<label for="usr">TORRE:</label>
			<select class="form-control" name="torre" id="comboTorre">
				    <option value="00">Seleccione</option>
				    <c:forEach items="${torres}" var="r">
				      <option value="${r}">${r}</option>
				    </c:forEach>
			</select>
		</div>
		
		<div class="col-sm-12">
			<label for="usr">PISO:</label>
			<select class="form-control" name="piso" id="comboPiso">
				    <option value="00">Seleccione</option>
			</select>
		</div>
		
		<div class="col-sm-12">
		  <label for="usr">DESCRIPCIÓN:</label>
		  <input type="text" class="form-control" name="descripcion" placeholder="Descripción">
		</div>
		
		<center>
			<div class="col-sm-12">
				<br>
				<input class="btn btn-danger" type="submit" value="Registrar inmueble" />
			</div>
		</center>
			
	</form>
	
	<script type="text/javascript">
	
	
	$("#comboTorre").change(fnConsultar);
	
	function fnConsultar(){
		
		var data = $("#mostrar").serialize();
		$.post("consultarPiso.htm",data,function(data){
			
			
			var lista = $.parseJSON(data);
			
		  	$("#comboPiso").html("");
			$.each(lista, function (index, r) {
				
				var row = "<option>";
				row += r.DESCRIPCION;
				row += "</option>";
				
				$("#comboPiso").append( row );
				
			});
			
		});
		
		
	}
	
	</script>
</body>
</html>