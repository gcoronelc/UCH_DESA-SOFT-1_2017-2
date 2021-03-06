<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Condominio~ Don Coronel</title>
        <meta name="description" content="Cibertec Description">
        <meta name="author" content="Julio Pari">        
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link id="bootstrap-style" href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/bootstrap-responsive.min.css" rel="stylesheet">
        <link id="base-style" href="css/style.css" rel="stylesheet">
        <link id="base-style-responsive" href="css/style-responsive.css" rel="stylesheet">

        <!--[if lt IE 7 ]>
        <link id="ie-style" href="css/style-ie.css" rel="stylesheet">
        <![endif]-->
        <!--[if IE 8 ]>
        <link id="ie-style" href="css/style-ie.css" rel="stylesheet">
        <![endif]-->
        <!--[if IE 9 ]>
        <![endif]-->
        <!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
          <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
        <link rel="shortcut icon" href="img/favicon.ico">        
    </head>
    <body>
        <%@include file="../includes/overlay.jsp" %>
        <%@include file="../includes/header.jsp" %>
        <div class="container-fluid">
            <div class="row-fluid">
                <%@include file="../includes/mainmenu.jsp" %>
                <div id="content" class="span10">
                    <%@include file="../includes/breadcrumb.jsp" %>
                    
                    <!-- 123456789 -->
                    <div class="row-fluid">		
                        <div class="box span12">
                            <div class="box-header" data-original-title>
                                <h2><i class="icon-user"></i><span class="break"></span>Listado de quejas</h2>
                                <div class="box-icon">
                                    <a href="queja.htm?action=new">Nueva queja</a>
                                </div>
                            </div>
                            <div class="box-content">
                                <table class="table table-striped table-bordered bootstrap-datatable datatable">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>CONDOMINIO</th>
                                            <th>NOMBRE</th>
                                            <th>FECHA</th>
                                            <th>DESCRIPCION</th>
                                            <th>ACCIONES</th>
                                        </tr>
                                    </thead>   
                                    <tbody>
                                        <c:forEach items="${list}" var="q">
                                            <tr>
                                                <td>${q.getId()}</td>
                                                <td class="center">${q.getCondominio().getId()}</td>
                                                <td class="center">${q.getNombre()}</td>
                                                <td class="center">${q.getFecha()}</td>
                                                <td class="center">${q.getDescripcion()}</td>
                                                <td class="center">
                                                   
                                                    <a class="btn btn-info" href="queja.htm?action=get&id=${q.getId()}">
                                                        <i class="icon-edit icon-white"></i>  
                                                    </a>
                                                    <a class="btn btn-danger" href="#">
                                                        <i class="icon-trash icon-white"></i> 
                                                    </a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>            
                            </div>
                        </div>
                    </div>
                    <!-- 123456789 -->  
                    
                    <hr>
                </div>
            </div>
            <div class="clearfix"></div>
            <%@include file="../includes/footer.jsp" %>      
        </div>
        <%@include file="../includes/bottom.jsp" %>
    </body>
</html>