<%-- 
    Document   : login
    Created on : 23-Feb-2019, 13:37:36
    Author     : tonatihu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="static/css/bootstrap.min.css" rel="stylesheet">
        <link href="static/font-awesome/css/font-awesome.css" rel="stylesheet">
        <link href="static/css/animate.css" rel="stylesheet">
        <link href="static/css/style.css" rel="stylesheet">
    </head>
    <body class="gray-bg">

    <div class="middle-box text-center loginscreen animated fadeInDown">
        <div>
            <h2>Iniciar Sesión</h2>
            <form class="m-t" role="form" action="Login" method="post">
                <div class="form-group">
                    <input type="email" class="form-control" placeholder="Correo Electronico" required="" name="email">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="Contraseña" required="" name="password">
                </div>
                <button type="submit" class="btn btn-primary block full-width m-b">Login</button>

                <a href="RecuperarContra"><small>¿Olvidaste tu contraseña?</small></a>
                <p class="text-muted text-center"><small>¿No tienes cuenta?</small></p>
                <a class="btn btn-sm btn-white btn-block" href="Signup">Registrate !ya!</a>
            </form>
        </div>
    </div>

    <!-- Mainly scripts -->
    <script src="./static/js/jquery-3.1.1.min.js"></script>
    <script src="./static/js/bootstrap.min.js"></script>

</body>
</html>
