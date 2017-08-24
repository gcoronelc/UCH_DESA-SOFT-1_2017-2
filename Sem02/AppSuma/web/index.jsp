<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SUMA</title>
</head>
<body>
  <h1>SUMA</h1>
  
  <form method="post" action="SumaController">
    
    <label>N�mero 1:</label>
    <input name="n1" type="text" /><br/>
    
    <label>N�mero 2:</label>
    <input name="n2" type="text" /><br/>
    
    <input type="submit" value="Procesar" />
  
  </form>
  
  <% if( request.getAttribute("error") != null){ %>
  <div>
    <h2>ERROR</h2>
    <p style="color:red;"><%= request.getAttribute("error") %></p>
  </div>
  <% } %>
  
  <% if( request.getAttribute("suma") != null){ %>
  <div>
    <h2>RESULTADO</h2>
    <p>N�mero 1: <%= request.getAttribute("n1") %></p>
    <p>N�mero 2: <%= request.getAttribute("n2") %></p>
    <p>Suma: <%= request.getAttribute("suma") %></p>
  </div>
  <% } %>
  
</body>
</html>