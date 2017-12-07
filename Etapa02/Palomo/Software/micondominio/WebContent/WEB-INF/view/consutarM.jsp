<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap-theme.min.css">


<script src='<c:url value="/js/jquery.js" />'></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
	integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
	integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
	crossorigin="anonymous"></script>


<title>Consulta de Mantenimiento</title>
</head>
<body>
<nav class="navbar navbar-expand-lg color">
  <a class="navbar-brand" href="<c:url value="index.htm"/>">MICONDOMINIO</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="<c:url value="consutarM.htm"/>">consultaMovimiento</a>
      </li>
    </ul>
  </div>
</nav>


<div class="container">
  <h1>CONSULTA DE MOVIMIENTOS</h1>
  <label>INMUEBLE:</label><br/>
  <div class="row">
  <div class="col-3">
  <form method="post" action="consultarMovimiento.htm" id="form3">
  <select name="inmueble" id="combazo" class="form-control">
    <option value="00">Seleccione</option>
    <c:forEach items="${inmuebles}" var="r">
      <option value="${r}">${r}</option>
    </c:forEach>
  </select>
  </form>
  </div>
  </div>
  
  <h1>RESULTADO:</h1>
  <table class="table table-hover table-condensed table-striped">
  <thead>
  <tr>
    <th>TIPOINMUEBLE</th>
    <th>OBLIGACION</th>
    <th>INMUEBLE</th>
    <th>PAGO</th>
    <th>PROPIETARIO</th>
    <th>FECHA</th>
  </tr>
  </thead>
  <tbody id="tabla">
  </tbody>
</table>
</div>

<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/js/edutec.js" />"></script>
</body>
</html>