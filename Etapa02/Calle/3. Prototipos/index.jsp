<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>DAT ADondeVivir</title>
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
        <%@include file="includes/overlay.jsp" %>
        <%@include file="includes/header.jsp" %>
        <div class="container-fluid">
            <div class="row-fluid">
                <%@include file="includes/mainmenu.jsp" %>
                <div id="content" class="span10">
                    <%@include file="includes/breadcrumb.jsp" %>
                    <%@include file="includes/dashboard.jsp" %>
                    <hr>
                </div>
            </div>
            <div class="clearfix"></div>
            <%@include file="includes/footer.jsp" %>            
        </div>
        <%@include file="includes/bottom.jsp" %>        
    </body>
</html>