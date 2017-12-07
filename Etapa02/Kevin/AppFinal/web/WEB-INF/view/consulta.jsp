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
        <title>Consulta</title>
        <link rel="icon" href="<c:url value="/resources/images/logo.png" />" type="image/x-icon" />
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css" />">
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/datatables.min.css" />">
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/consulta.css" />">
    </head>
    <body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#"> <img src="<c:url value="/resources/images/logo.png" />"  class="logo_menu"></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="cuota.htm" />">Cuota</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="registro.htm" />">Registrar <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
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
                <h5><i class="fa fa-search" aria-hidden="true"></i> Consultar</h5>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col-12">
                        <label for="tmovimiento">Tipo de Movimiento: 
                            <br>
                            <span class="aviso">
                                (Puedes realizar la busqueda por el nombre del tipo de Movimiento o el codigo de un inmueble<strong>:</strong>
                                Pago de Mantenimiento, OF-101, etc...).
                            </span>
                        </label>
                    </div>
                </div>
                <div class="row">
                    <div class="col-3">
                        <form id="form">
                            <div class="row">
                                <div class="col-10">
                                    <div class="form-group">
                                        <input type="text" class="form-control" id="tmovimiento" name="tmovimiento" aria-describedby="periodoHelp" placeholder="ejemplo: Pago de Mantenimiento">
                                        <!--small id="cicloHelp" class="form-text text-muted">debe ingresar .</small>-->
                                    </div>
                                </div>
                                <div class="col-2">
                                    <div>
                                        <button type="button" id="consultarmov" class="btn btn-primary">Consultar</button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <br>
                <div class="row">
                    <div class="col-md-12">
                        <table class="table" id="tabla_consulta" style="display: none">
                            <thead>
                                <tr>
                                    <th>COD.INM</th>
                                    <th>DESCCRIPCION</th>
                                    <th>TORRE</th>
                                    <th>F.PEND</th>
                                    <th>F.VENCE</th>
                                    <th>IMP.PEND</th>
                                    <th>NOM.MOVIM</th>
                                    <th>ACCION</th>
                                    <th>FECHA</th>
                                    <th>IMPORTE</th>
                                    <th>RESPONSABLE</th>
                                </tr>
                            </thead>
                            <tbody id="salida_consulta">

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/resources/js/datatables.min.js" />"></script>
    <script src="<c:url value="/resources/js/consulta.js" />"></script>
    <script src="https://use.fontawesome.com/d2ae5d3866.js"></script>
</body>
</html>
