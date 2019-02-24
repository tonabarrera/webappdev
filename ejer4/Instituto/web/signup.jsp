<%-- 
    Document   : signup
    Created on : 23-Feb-2019, 13:38:39
    Author     : tonatihu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registro</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="static/css/bootstrap.min.css" rel="stylesheet">
        <link href="static/font-awesome/css/font-awesome.css" rel="stylesheet">
        <link href="static/css/animate.css" rel="stylesheet">
        <link href="static/css/style.css" rel="stylesheet">
    </head>
    <body class="gray-bg">

        <div class="middle-box text-center loginscreen   animated fadeInDown">
            <div>
                <h2>Registrate a instituto</h2>
                <form class="m-t" role="form" action="Signup" method="post">
                    <div class="form-group">
                        <input type="email" class="form-control" placeholder="Correo Electronico" required="" name="email">
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" placeholder="Contraseña" required="" name="password">
                    </div>
                    <button type="submit" class="btn btn-primary block full-width m-b">Registrarse</button>

                    <p class="text-muted text-center"><small>¿Ya tienes una cuenta?</small></p>
                    <a class="btn btn-sm btn-white btn-block" href="Login">Inicia Sesión</a>
                </form>
            </div>
        </div>

        <!-- Mainly scripts -->
        <script src="js/jquery-3.1.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>

</html>
