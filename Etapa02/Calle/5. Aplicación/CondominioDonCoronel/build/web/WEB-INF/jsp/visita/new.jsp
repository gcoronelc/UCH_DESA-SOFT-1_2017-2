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
                                <h2><i class="icon-edit"></i><span class="break"></span>Nuevo visita</h2>
                            </div>
                            <div class="box-content">
                                <form:form class="form-horizontal" method="POST" action="visita.htm?action=save" commandName="visitaox">
                                    <fieldset>
                                      <div class="control-group">
                                          <label class="control-label">Departamento</label>
                                          <div class="controls">
                                           <form:select path="departamento.id" class="input-xlarge">
                                              <form:options items="${usaDepa}" itemValue="id" itemLabel="nombre" />
                                            </form:select>
                                           </div>
                                       </div>  
                                      <div class="control-group">
                                          <label class="control-label" for="textinput">Nombre</label>
                                          <div class="controls">
                                              <form:input path="nombres" class="input-xlarge" required=""></form:input>                                              
                                          </div>
                                       </div>
                                          <div class="control-group">
                                          <label class="control-label" for="textinput">Apellido Paterno</label>
                                          <div class="controls">
                                              <form:input path="apellidoPat" class="input-xlarge" required=""></form:input>                                              
                                          </div>
                                        </div>
                                          <div class="control-group">
                                          <label class="control-label" for="textinput">Apellido Materno</label>
                                          <div class="controls">
                                              <form:input path="apellidoMat" class="input-xlarge" required=""></form:input>                                              
                                          </div>
                                          </div>
                                                                                 
                                          <div class="control-group">
                                          <label class="control-label" for="textinput">Dni</label>
                                          <div class="controls">
                                              <form:input path="dni" class="input-xlarge" required=""></form:input>                                              
                                          </div>
                                          </div>
                                        
                                          <div class="control-group">
                                          <label class="control-label" for="textinput">Fecha de Visita</label>
                                          <div class="controls">
                                              <input type="text" class="input-xlarge datepicker" id="termina" name="termina" value="30/11/2013" required="true" />
                                          </div>
                                          </div>
                                        
                                          
                                        <div class="form-actions">
                                            <button type="submit" class="btn btn-primary">Guardar</button>                                            
                                        </div>
                                    </fieldset>
                                </form:form>                     
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