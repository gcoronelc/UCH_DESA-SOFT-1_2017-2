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
        <title>Condominio</title>
        <link rel="icon" href="<c:url value="/resources/images/logo.png" />" type="image/x-icon" />
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css" />">
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/datatables.min.css" />">
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/login.css" />">
    </head>

    <body>

        <div class="container">
            <div class="row">

                <div class="col-md-4 offset-md-4 container_login">
                    <div class="imagen_logo">
                        <img src="<c:url value="/resources/images/logo.png" />" >
                    </div>
                    <c:if test="${ error != null }">
                        <div class="error_login">${error}</div>
                    </c:if>

                    <form method="post" action="ingresar.htm">
                        <div class="form-group">
                            <label for="usuario">Usuario:</label>
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon" id="usuario"><i class="fa fa-user" aria-hidden="true"></i></span>
                                <input type="text" class="form-control" placeholder="usuario" aria-label="usuario" name="usuario" id="usuario" aria-describedby="sizing-addon2">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="clave">Clave:</label>
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon" id="usuario"><i class="fa fa-key" aria-hidden="true"></i></span>
                                <input type="password" class="form-control" placeholder="******" aria-label="clave" name="clave" id="clave"  aria-describedby="sizing-addon2">
                            </div>
                        </div>
                        <div class="form-group text-center">
                            <input class="btn btn-primary" type="submit" 
                                   value="Ingresar" />
                        </div>
                    </form>
                    <div class="container_dedicatoria">
                        <p class="dedicatoria">Docente: Erick Gustavo Coronel</p>
                    </div>
                </div>  
            </div>   

        </div>




        <script src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
        <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
        <script src="<c:url value="/resources/js/datatables.min.js" />"></script>
        <script src="https://use.fontawesome.com/d2ae5d3866.js"></script>
    </body>
</html>
