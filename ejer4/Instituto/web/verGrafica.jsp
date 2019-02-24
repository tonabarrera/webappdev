<%-- 
    Document   : verGrafica
    Created on : 23-Feb-2019, 13:40:50
    Author     : tonatihu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Ver datos</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="static/css/bootstrap.min.css" rel="stylesheet">
        <link href="static/font-awesome/css/font-awesome.css" rel="stylesheet">
        <link href="static/css/animate.css" rel="stylesheet">
        <link href="static/css/style.css" rel="stylesheet">
    </head>
    <body class="">
        <div id="wrapper">

            <%@include file="WEB-INF/jspf/nav.jspf" %>

            <div id="page-wrapper" class="gray-bg">

                <%@include file="WEB-INF/jspf/header.jspf" %>
                <div class="wrapper wrapper-content animated fadeInRight">
                    <div class="row ">
                        <div class="col-lg-1"></div>
                        <div class="col-lg-10">
                            <div class="ibox float-e-margins">
                                <div class="ibox-title">
                                    <h4>Grafica de pastel</h4>
                                </div>
                                <div class="ibox-content center-block">
                                    <img src="static/img/grafica.png" 
                                         class="center-block" style="max-width: 100%; max-height: 100%;" />
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <%@include file="WEB-INF/jspf/footer.jspf" %>
            </div>
        </div>

        <!-- Mainly scripts -->
        <script src="static/js/jquery-3.1.1.min.js"></script>
        <script src="static/js/bootstrap.min.js"></script>
        <script src="static/js/plugins/metisMenu/jquery.metisMenu.js"></script>
        <script src="static/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

        <!-- Custom and plugin javascript -->
        <script src="static/js/inspinia.js"></script>
        <script src="static/js/plugins/pace/pace.min.js"></script>
    </body>
</html>
