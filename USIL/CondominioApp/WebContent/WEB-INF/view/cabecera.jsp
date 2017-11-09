<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<table style="width: 100%;">
  <tr>
    <td>
      <img src='<c:url value="img/logo.png" />' />
    </td>
    <td style="text-align: right;">
      Usuario: ${sessionScope.usuario.nombre}, ${sessionScope.usuario.apellido}<br/>
      <a href="salir.htm">Salir</a>
    </td>
  </tr>
</table>




