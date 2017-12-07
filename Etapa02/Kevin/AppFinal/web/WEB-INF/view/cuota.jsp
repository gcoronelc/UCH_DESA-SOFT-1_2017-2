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
        <title>Cuota</title>
        <link rel="icon" href="<c:url value="/resources/images/logo.png" />" type="image/x-icon" />
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
                <li class="nav-item active">
                    <a class="nav-link" href="<c:url value="cuota.htm" />">Cuota</a>
                </li>
                <li class="nav-item">
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
    <div class="container-fluid ">

        <br>
        <div class="card">
            <div class="card-header">
                <div class="row">
                    <div class="col-md-12">
                        <h5><i class="fa fa-calendar" aria-hidden="true"></i> Obligaciones de Mantenimiento</h5>
                    </div>
                </div>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col-md-12">
                        <form id="form1">
                            <input type="hidden" name="tipo" value="2" />
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <select id="periodo" name="periodo" class="form-control">
                                            <option value="2017">2017</option>
                                            <option value="2018">2018</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <select id="mes" name="mes" class="form-control">
                                            <option value="1">Enero</option>
                                            <option value="2">Febrero</option>
                                            <option value="3">Marzo</option>
                                            <option value="4">Abril</option>
                                            <option value="5">Mayo</option>
                                            <option value="6">Junio</option>
                                            <option value="7">Julio</option>
                                            <option value="8">Agosto</option>
                                            <option value="9">Setiembre</option>
                                            <option value="10">Octubre</option>
                                            <option value="11">Noviembre</option>
                                            <option value="12">Diciembre</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <table class="table" id="tabla_cuota">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>INMUEBLE</th>
                                    <th>CODIGO</th>
                                    <th>TORRE</th>
                                    <th>PISO</th>
                                    <th>DESCRIPCION</th>
                                    <th>OBLIGACION</th>
                                    <th>AÑO</th>
                                    <th>MES</th>
                                    <th>IMPORTE</th>
                                    <th>VENCIMIENTO</th>
                                    <th>PAGADA</th>
                                </tr>
                            </thead>

                            <tbody id="tabla">
                            </tbody>

                        </table>
                        <div id="divGrabar" style="display: none;">
                            <input id="btnGrabar" class="egcc_btn_default topspace btn btn-primary" type="button" value="Grabar" />
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/resources/js/datatables.min.js" />"></script>
    <script src="<c:url value="/resources/js/cuota.js" />"></script>
    <script src="https://use.fontawesome.com/d2ae5d3866.js"></script>
</body>
</html>
