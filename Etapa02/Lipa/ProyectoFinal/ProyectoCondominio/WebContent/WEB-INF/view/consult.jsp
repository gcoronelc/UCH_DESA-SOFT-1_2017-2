<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<script type="text/javascript" src='<c:url value="/jquery/jquery.js" />'></script>
		<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
		
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
	
	<label>TIPO DE INMUEBLE:</label><br/>
		  
		  <form method="post" action="consultar1.htm" id="form1">
			  <select class="form-control" name="inmueble" id="combito">
			    <option value="00">Seleccione</option>
			    <c:forEach items="${inmuebles}" var="r">
			      <option value="${r}">${r}</option>
			    </c:forEach>
			  </select>
		  <!-- <select name="lipa" id="lipa">
		  <option value="00">Seleccione</option>
		  </select> -->
		  </form>
		  
		  </br>
		  <center><h3>RESULTADOS</h3></center>
		  </br>
		  <table class="table table-bordered">
		  <thead>
		  <tr>
		    <th><center>TIPO MOVIMIENTO</center></th>
		    <th><center>NOMBRE COMPLETO</center></th>
		    <th><center>OBLIGACION</center></th>
		    <th><center>DESCRIPCIÓN</center></th>
		    <th><center>IMPORTE</center></th>
		    <th><center>FECHA</center></th>
		  </tr>
		  </thead>
		  <tbody id="tabla">
		  </tbody>
		</table>
	
	<script type="text/javascript">
	
	
	$("#combito").change(fnConsultar);
	
	function fnConsultar(){
		
		var data = $("#form1").serialize();
		$.post("consultar.htm",data,function(data){
			
			
			var lista = $.parseJSON(data);
			
		  //llenarLipa(lista);
			
			$("#tabla").html("");
			$.each(lista, function (index, r) {
				
				var row = "<tr>";
				row += "<td>" + "<center>" + r.NOMBRE + "</center>" + "</td>";
				row += "<td>" + "<center>" + r.NOMBRECOMPLETO + "</center>" + "</td>";
				row += "<td>" + "<center>" + r.OBLIGACION + "</center>" + "</td>";
				row += "<td>" + "<center>" + r.DESCRIPCION + "</center>" + "</td>";
				row += "<td>" + "<center>" + r.IMPORTE + "</center>" + "</td>";
				row += "<td>" + "<center>" + r.FECHA + "</center>" + "</td>";
				row += "</tr>";
				
				$("#tabla").append( row );
				
			});
			
		});
		
		
	}
	
	function llenarLipa( lista ){
		
		$("#lipa").html("");
		
		$.each(lista, function (index, r) {
		      
		      var row = "<option>";
		      row +=  r.idcurso + " - ";
		      row +=  r.nomcurso;
		      row += "</option>";
		      
		      $("#lipa").append( row );
		      
		    });
		
		
	}
	</script>  
	  
	  
	  
	</body>
	
</html>