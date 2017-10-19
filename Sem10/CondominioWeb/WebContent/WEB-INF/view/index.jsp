<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Demo MVC</title>
</head>
<body>

	<h1>Hola Gustavo</h1>
	
	<h2>FORMULARIO</h2>
	<form method="post" action="procesar.egcc">
	
		<label>Precio: </label>
		<input type="text" name="precio" /><br/>
	
		<label>Cantidad: </label>
		<input type="text" name="cant" /><br/>
		
		<input type="submit" value="Procesar" /><br/>
		
	</form>
	
	<h2>REPORTE</h2>
	
	<p>INPUT</p>
	<p>Precio: ${panchito.precio}</p>
	<p>Cantidad: ${panchito.cant}</p>
	
	<p>OUTPUT</p>
	<p>Importe: ${panchito.importe}</p>
	<p>Impuesto: ${panchito.impuesto}</p>
	<p>Total: ${panchito.total}</p>
	
</body>
</html>