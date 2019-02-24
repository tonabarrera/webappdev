<%-- 
    Document   : index
    Created on : 23-Feb-2019, 16:10:01
    Author     : tonatihu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Home</title>
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

                <div class="wrapper wrapper-content">
                    <div class="middle-box text-center animated">
                        <h2 class="font-bold">Bienvenido</h2>
                        <div class="error-desc">
                            Un cordial y amistoso saludo a toda la razita que la sigue cotorreando
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
