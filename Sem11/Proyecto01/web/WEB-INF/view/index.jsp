<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>APP</title>
    </head>

    <body>
      <h1>APP</h1>
      <p>Por: Gustavo Coronel</p>
      <form method="post" action="consultar.htm">
        
        <label>Ciclo: </label>
        <input type="text" name="ciclo" />
        <input type="submit" value="Consultar" />
        
      </form>
      
      <h2>Resultado</h2>
      
      <p>${mensaje}</p>
      
      <c:if test="${lista != null}">
        
        <table>
          <tr>
            <th>COD.CURSO</th>
            <th>NOM.CURSO</th>
            <th>SECCIONES</th>
            <th>VAC.PROG.</th>
            <th>MATRICULADOS</th>
            <th>INGRESOS</th>
            <th>PAGO PROF.</th>
            <th>UTILIDAD</th>
          </tr>
          
          <c:forEach items="${lista}" var="r">
            
            <tr>
              <td>${r.idcurso}</td>
              <td>${r.nomcurso}</td>
              <td>${r.secciones}</td>
              <td>${r.vactotal}</td>
              <td>${r.matriculados}</td>
              <td>${r.ingresos}</td>
              <td>${r.pagoprof}</td>
              <td>${r.utilidad}</td>
            </tr>
            
            
          </c:forEach>
          
        </table>
        
        
      </c:if>
      
    </body>
</html>
