<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap-theme.min.css">

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<div class="container">
	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">condominio</span> <span class="icon-bar"></span>
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class=""></span>
			</button>
			<a class="navbar-brand" href="main.htm"> inicio <span
				class="glyphicon glyphicon-home"> </span>
			</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
			    <li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false"> Procesos <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="obliMantenimiento.htm">Cuota de mantenimiento</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="verCoutaAgua.htm">Cuota de agua</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="matAuditorio.htm">Eventos</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">Obligacion de pagos</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false"> Consultas <span class="caret"></span></a>
					<ul class="dropdown-menu">
					    <li><a href="consultarM.htm">Consulta de Movimientos</a></li>
					    <li role="separator" class="divider"></li>
						<li><a href="buscarTipoPersona.htm">Personas</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">Inmuebles</a></li>
					</ul></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown" role="button" aria-haspopup="true"
				aria-expanded="false"> Gastos de Condominio <span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="#">Servicios publicos</a></li>
					<li role="separator" class="divider"></li>
					<li><a href="#">Mantenimiento de Equipos</a></li>
					<li role="separator" class="divider"></li>
					<li><a href="#">Personal</a></li>
					<li role="separator" class="divider"></li>
					<li><a href="#">Terceros</a></li>
					<li role="separator" class="divider"></li>
					<li><a href="#">Insumos y Materiales</a></li>
				</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false"> Mantenimiento <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="registroPro.htm">Propietarios</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="mantInmueble.htm">Inmueble</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="usuario.htm">Usuario</a></li>
					</ul></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false"> ${usuario.nombre} - ${usuario.apellido}
						<span class="glyphicon glyphicon-user"></span> <span class="caret"></span>
				</a>
					<ul class="dropdown-menu">
						<li><a href="#"> <span class="glyphicon glyphicon-cog"></span>
								editar perfil
						</a></li>
						<li><a href="#"> <span class="glyphicon glyphicon-phone"></span>
								contactar
						</a></li>

						<li><a href="#"> <span
								class="glyphicon glyphicon-exclamation-sign"></span> ayuda
						</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="salir.htm"> <span
								class="glyphicon glyphicon-log-out"></span> salir
						</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
	</nav>

</div>