<%-- 
                                                                                                     
 o   o                o          o    o                      8                             .oPYo.    
 8  .P                           8    8                      8                             8    8    
o8ob'  .oPYo. o    o o8 odYo.   o8oooo8 o    o .oPYo. o    o 8oPYo. o    o .oPYo. .oPYo.   8         
 8  `b 8oooo8 Y.  .P  8 8' `8    8    8 8    8 .oooo8 8    8 8    8 8    8 .oooo8 Yb..     8         
 8   8 8.     `b..d'  8 8   8    8    8 8    8 8    8 8    8 8    8 8    8 8    8   'Yb.   8    8    
 8   8 `Yooo'  `YP'   8 8   8    8    8 `YooP' `YooP8 `YooP8 8    8 `YooP' `YooP8 `YooP'   `YooP' 88 
:..::..:.....:::...:::....::..:::..:::..:.....::.....::....8 ..:::..:.....::.....::.....::::.....:..:
::::::::::::::::::::::::::::::::::::::::::::::::::::::::ooP'.::::::::::::::::::::::::::::::::::::::::
::::::::::::::::::::::::::::::::::::::::::::::::::::::::...::::::::::::::::::::::::::::::::::::::::::

    Proyecto    : KH-Condominio
    Creacion    : 30-nov-2017, 1:36:18
    Autor       : Kevin Huayhuas Cariapaza
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
        <link rel="icon" href="<c:url value="/resources/images/logo.png" />" type="image/x-icon" />
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css" />">
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/datatables.min.css" />">
    </head>
    <body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#"><img src="<c:url value="/resources/images/logo.png" />"  class="logo_menu"></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="cuota.htm" />">Cuota</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="<c:url value="registro.htm" />">Registrar <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="consulta.htm" />">Consultar</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="salir.htm" />">Salir</a>
                </li>
            </ul>
        </div>
    </nav>
    <div class="container-fluid">
        <br>
        <div class="card">
            <div class="card-header">
                <h5><i class="fa fa-plus-square" aria-hidden="true"></i> Nuevo pago de mantenimiento</h5>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col-md-12">
                        <form id="form">
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="inmueble">Inmueble</label>
                                        <select name="inmueble" class="form-control">
                                            <c:forEach items="${inmuebles}" var="r">
                                                <option value="${r.idinmueble}">${r.codigo} - ${r.descripcion} </option>
                                            </c:forEach>
                                        </select>
                                        <small id="inmuebleHelp" class="form-text text-muted">Seleccione un inmueble.</small>
                                    </div>
                                </div> 
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="obligacion">Obligacion</label>
                                        <select name="obligacion" class="form-control">
                                            <c:forEach items="${obligaciones}" var="r">
                                                <option value="${r.idobligacion}">${r.anio} / ${r.mes} - ${r.idtobligacion}(MANTENIMIENTO) - importe: ${r.importe} </option>
                                            </c:forEach>
                                        </select>
                                        <small id="obligacionHelp" class="form-text text-muted">Seleccione una Obligacion.</small>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="tmovimiento">Tipo de Movimiento</label>
                                        <select name="tmovimiento" class="form-control">
                                            <c:forEach items="${tmovimientos}" var="r">
                                                <option value="${r.idtmovimiento}">${r.nombre} - ${r.accion} </option>
                                            </c:forEach>
                                        </select>
                                        <small id="tmovimientoHelp" class="form-text text-muted">Seleccione un tipo de movimiento. (Si se encuentra ninguno - añadir  Tipos de movimientos a la DB example : Pago de Mantenimiento )</small>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="fecha">Fecha</label>
                                        <input type="date" class="form-control" id="fecha" name="fecha">
                                    </div>
                                </div>  
                            </div>   

                            <div class="form-group">
                                <label for="importe">Importe</label>
                                <input type="text" class="form-control" id="importe" name="importe">
                            </div>
                            <div class="form-group">
                                <label for="descripcion">Descripcion</label>
                                <textarea class="form-control" id="descripcion" name="descripcion"></textarea>
                            </div>
                            <div class="form-group">
                                <label for="audpersona">AudPersona</label>
                                <select name="audpersona" class="form-control">
                                    <c:forEach items="${audpersonas}" var="r">
                                        <option value="${r.idpersona}">${r.dni} - ${r.nombre} ${r.apellido}</option>
                                    </c:forEach>
                                </select>
                                <small id="tmovimientoHelp" class="form-text text-muted">Seleccione un tipo de AudPersona.</small>
                            </div>
                            <button type="submit" id="btnNuevo" class="btn btn-primary" >Nuevo</button>
                            <br>
                        </form>
                        <div id="loading" style="display:none"><img  src="<c:url value="/resources/images/cargando.gif" />"/></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/resources/js/datatables.min.js" />"></script>
    <script src="<c:url value="/resources/js/registro.js" />"></script>
    <script src="https://use.fontawesome.com/d2ae5d3866.js"></script>
</body>
</html>
