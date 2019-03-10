<%-- 
    Document   : forgotPassword
    Created on : 09-Mar-2019, 17:40:43
    Author     : tonatihu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recuperar contraseña</title>
        <%@include file="WEB-INF/jspf/headTag.jspf" %>
    </head>
    <body class="gray-bg">
        <div class="passwordBox animated fadeInDown">
            <div class="row">
                <div class="col-md-12">
                    <div class="ibox-content">
                        <h2 class="font-bold">Recuperación de contraseña</h2>
                        <p>Ingresa tu email para recuperar tu contraseña</p>
                        <div class="row">
                            <div class="col-lg-12">
                                <form class="m-t" role="form" action="forgotPassword" method="post">
                                    <div class="form-group">
                                        <input type="email" class="form-control" placeholder="Email" required="" name="email"/>
                                    </div>
                                    <button type="submit" class="btn btn-primary block full-width m-b">Enviar contraseña</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <hr/>
            <div class="row">
                <div class="col-md-6">
                    Instituto
                </div>
                <div class="col-md-6 text-right">
                    <small>2019</small>
                </div>
            </div>
        </div>
    </body>
</html>
