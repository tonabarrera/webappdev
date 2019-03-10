<%-- 
    Document   : login
    Created on : 09-Mar-2019, 15:15:30
    Author     : tonatihu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <%@include file="WEB-INF/jspf/headTag.jspf" %>
    </head>
    <body class="gray-bg">
        <div class="middle-box text-center loginscreen animated fadeInDown">
            <div>
                <h2>Bienvenido a Insituto</h2>
                <h3>Inicio de Sesión</h3>
                <form class="m-t" role="form" action="login" method="post">
                    <div class="form-group">
                        <input type="text" name="username" class="form-control" placeholder="Nombre de usuario" required/>
                    </div>
                    <div class="form-group">
                        <input type="password" name="password" class="form-control" placeholder="Contraseña" required/>
                    </div>
                    <button type="submit" class="btn btn-primary block full-width m-b">
                        Iniciar Sesión
                    </button>

                    <a href="forgotPassword"><small>¿Olvidaste tu contraseña?</small></a>
                    <p class="text-muted text-center"><small>¿No tienes cuenta?</small></p>
                    <a class="btn btn-sm btn-white btn-block" href="signup">Registrate</a>
                </form>
                <p class="m-t"><small>Instituto 2019</small></p>
            </div>
        </div>

        <script src="static/js/jquery-3.1.1.min.js"></script>
        <script src="static/js/bootstrap.min.js"></script>
    </body>
</html>
