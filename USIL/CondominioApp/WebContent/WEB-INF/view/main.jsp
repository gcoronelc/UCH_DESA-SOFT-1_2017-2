<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<jsp:include page="recursos.jsp"/>

<title>CONDOMINIO APP</title>
</head>
<body>

  <div class="egcc_pagina">
  
    <div class="egcc_cabecera">
      <jsp:include page="cabecera.jsp"/>
    </div>
    
    <div class="egcc_menu">
      <jsp:include page="menu.jsp"/>
    </div>
    
    <div class="egcc_contenido">
      <div style="text-align: center;">
        <img src='<c:url value="img/portada.jpg" />' />
      </div>
    </div>
  
    <div class="egcc_pie">
      <jsp:include page="pie.jsp"/>
    </div>
  
  </div>

</body>
</html>