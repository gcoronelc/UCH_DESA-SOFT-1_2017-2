<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src='<c:url value="/jquery/jquery.js" />'></script>
<title>DEMO</title>
</head>
<body>
  <h1>MEJORES CURSOS</h1>
  <label>Periodo:</label><br/>
  <form method="post" action="consultar.htm" id="form1">
  <select name="periodo">
    <c:forEach items="${periodos}" var="r">
      <option value="${r}">${r}</option>
    </c:forEach>
  </select>
  <input type="button" id="btnConsultar" value="Consultar">
  </form>
  
  <h1>RESULTADO</h1>
  <table>
  <thead>
  <tr>
    <th>PERIODO</th>
    <th>CICLO</th>
    <th>IDCURSO</th>
    <th>NOMCURSO</th>
    <th>SECCIONES</th>
    <th>MATRICULADOS</th>
  </tr>
  </thead>
  <tbody id="tabla">
  </tbody>
</table>

<script type="text/javascript">


$("#btnConsultar").click(fnConsultar);

function fnConsultar(){
	
	var data = $("#form1").serialize();
	$.post("consultar.htm",data,function(data){
		
		var lista = $.parseJSON(data);
		$("#tabla").html("");
		$.each(lista, function (index, r) {
			
			var row = "<tr>";
			row += "<td>" + r.periodo + "</td>";
			row += "<td>" + r.ciclo + "</td>";
			row += "<td>" + r.idcurso + "</td>";
			row += "<td>" + r.nomcurso + "</td>";
			row += "<td>" + r.secciones + "</td>";
			row += "<td>" + r.matriculados + "</td>";
			row += "</tr>";
			
			$("#tabla").append( row );
			
		});
		
	});
	
	
}


</script>  
  
  
  
</body>
</html>