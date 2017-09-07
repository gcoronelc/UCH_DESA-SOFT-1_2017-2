<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MATEMATICA</title>
    </head>
    <body>
        <h1>MATEMATICA</h1>
        <form method="post" action="MateController">
            
            <label>Número 1: </label>
            <input type="text" name="num1" /> <br/>
            
            <label>Número 2: </label>
            <input type="text" name="num2" /> <br/>
            
            <input type="submit" value="Procesar" /> <br/>
            
        </form>
        
        <h1>REPORTE</h1>
        <p>Suma: ${model.suma}</p>
        <p>Resta: ${model.resta}</p>
    </body>
</html>
