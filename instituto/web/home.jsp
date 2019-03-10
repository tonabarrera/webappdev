<%-- 
    Document   : home
    Created on : 09-Mar-2019, 19:33:39
    Author     : tonatihu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <%@include file="WEB-INF/jspf/headTag.jspf" %>
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
            
        <%@include file="WEB-INF/jspf/jsLibraries.jspf" %>
    </body>
</html>
