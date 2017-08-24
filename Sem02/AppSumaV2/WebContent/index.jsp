<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SUMA</title>
</head>
<body>
  <h1>SUMA</h1>
  
  <form method="post" action="SumaController">
    
    <label>Número 1:</label>
    <input name="n1" type="text" /><br/>
    
    <label>Número 2:</label>
    <input name="n2" type="text" /><br/>
    
    <input type="submit" value="Procesar" />
  
  </form>
  
  
  <c:if test="${ error != null }">
  <div>
    <h2>ERROR</h2>
    <p style="color:red;">${ error }</p>
  </div>
  </c:if>
  
  
  <c:if test="${ suma != null }">
  <div>
    <h2>RESULTADO</h2>
    <p>Número 1: ${n1}</p>
    <p>Número 2: ${n2}</p>
    <p>Suma: ${suma}</p>
  </div>
  </c:if>

  
</body>
</html>