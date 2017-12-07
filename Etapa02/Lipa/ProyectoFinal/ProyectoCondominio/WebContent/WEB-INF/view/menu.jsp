<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<br>
<br>
<br>
<br>
<br>
<div class="menu">

	<ul class="nav navbar-nav" style="background-color: #bad7bc;">
		
		<li class="dropdown">
			<a href="<c:url value="main.htm" />" class="dropdown-toggle" data-toggle="dropdown" role="button" style="color: white;">
				<i style="font-size:14px"> GESTIÓN DE PAGOS <span class="caret"></span> </i>
			</a>

			<ul class="dropdown-menu" role="menu">
				<li></li>
				<li><a href="<c:url value="nuevousu.htm" />"> PAGO DE PERSONAL </a></li>
				<li><a href="<c:url value="actu_usu.htm" />"> PAGO DE SERVICIOS PÚBLICOS </a></li>
			</ul>
		</li>
		
		<li class="dropdown">
			<a href="<c:url value="main.htm" />" class="dropdown-toggle" data-toggle="dropdown" role="button" style="color: white;">
				<i style="font-size:14px"> GESTIÓN DE INMUEBLES <span class="caret"></span> </i>
			</a>

			<ul class="dropdown-menu" role="menu">
				<li></li>
				<li><a href="<c:url value="registraInmueble.htm" />"> REGISTRAR INMUEBLE </a></li>
				<li><a href="<c:url value="registraManteInmueble.htm" />"> PAGO DE CUOTA DE INMUEBLE </a></li>
			</ul>
		</li>
		
		<li class="dropdown">
			<a href="<c:url value="main.htm" />" class="dropdown-toggle" data-toggle="dropdown" role="button" style="color: white;">
				<i style="font-size:14px"> GESTIÓN DE USUARIOS <span class="caret"></span> </i>
			</a>

			<ul class="dropdown-menu" role="menu">
				<li></li>
				<li><a href="<c:url value="nuevousu.htm" />"> NUEVO USUARIO </a></li>
				<li><a href="<c:url value="actu_usu.htm" />"> ACTUALIZAR USUARIO </a></li>
				<li><a href="<c:url value="listausu.htm" />"> LISTAR USUARIOS </a></li>
			</ul>
		</li>
		
		<li>
			<a href="<c:url value="obligacion.htm" />" style="color: white">
				<i style="font-size:14px"> GENERAR OBLIGACIONES </i>
			</a>
		</li>
		
		<li class="dropdown">
			<a href="<c:url value="main.htm" />" class="dropdown-toggle" data-toggle="dropdown" role="button" style="color: white;">
				<i style="font-size:14px"> GESTIÓN DE AUDITORIOS <span class="caret"></span> </i>
			</a>

			<ul class="dropdown-menu" role="menu">
				<li></li>
				<li><a href="<c:url value="registroAlquiler.htm" />"> ALQUILAR AUDITORIO </a></li>
				<li><a href="<c:url value="actu_usu.htm" />"> CERRAR ALQUILER </a></li>
			</ul>
		</li>
		
		<li class="dropdown">
			<a href="<c:url value="main.htm" />" class="dropdown-toggle" data-toggle="dropdown" role="button" style="color: white;">
				<i style="font-size:14px"> CONSULTAS Y REPORTES <span class="caret"></span> </i>
			</a>

			<ul class="dropdown-menu" role="menu">
				<li></li>
				<li><a href="<c:url value="reporteCuentaInmueble.htm" />"> CUENTA INMUEBLES </a></li>
				<li><a href="<c:url value="reporteCuentaPropietario.htm" />"> CUENTA PROPIETARIO </a></li>
				<li><a href="<c:url value="reporteMensual.htm" />"> REPORTE MENSUAL </a></li>
				<li><a href="<c:url value="reporteEstadoFinanciero.htm" />"> ESTADO FINANCIERO </a></li>
			</ul>
		</li>
						
	</ul>
	
</div>