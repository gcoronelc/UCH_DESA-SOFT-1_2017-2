<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DEMO 01</title>
</head>
<body>
	<h1>MOVIMIENTOS</h1>
	<form method="post" action="Consultar">
		<label>Cuenta</label>
		<input type="text" name="cuenta" />
		<input type="submit" value="Consultar" />
	</form>
	
	<h1>RESULTADO</h1>
	<table>
	
		<thead>
			<tr>
				<th>NRO</th>
				<th>TIPO</th>
				<th>IMPORTE</th>
			</tr>
		</thead>
	
	
		<tbody>
			<c:forEach items="${lista}" var="r">
				<tr>
					<td>${r.movinumero}</td>
					<td>${r.tiponombre}</td>
					<td>${r.moviimporte}</td>
				</tr>
			</c:forEach>			
		</tbody>	
	
	
	</table>
	
</body>
</html>