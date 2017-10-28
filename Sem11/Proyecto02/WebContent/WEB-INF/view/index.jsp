<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <h1>MEJORES CURSOS</h1>
  <label>Periodo:</label><br/>
  <form method="post" action="consultar.htm">
  <select name="periodo">
    <c:forEach items="${periodos}" var="r">
      <option value="${r}">${r}</option>
    </c:forEach>
  </select>
  <input type="submit" value="Consultar">
  </form>
  
  <h1>RESULTADO</h1>
  <table>
  <tr>
    <th>PERIODO</th>
    <th>CICLO</th>
    <th>IDCURSO</th>
    <th>NOMCURSO</th>
    <th>SECCIONES</th>
    <th>MATRICULADOS</th>
  </tr>
  <c:forEach items="${mejoresCursos}" var="r">
  <tr>
    <td>${r.periodo}</td>
    <td>${r.ciclo}</td>
    <td>${r.idcurso}</td>
    <td>${r.nomcurso}</td>
    <td>${r.secciones}</td>
    <td>${r.matriculados}</td>
  </tr>
  </c:forEach>
</table>

  
  
  
  
</body>
</html>