<%-- 
    Document   : login
    Created on : 18-Feb-2019, 18:53:00
    Author     : tonatihu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="static/css/bootstrap.min.css" rel="stylesheet">
        <link href="static/font-awesome/css/font-awesome.css" rel="stylesheet">
        <link href="static/css/animate.css" rel="stylesheet">
        <link href="static/css/style.css" rel="stylesheet">
    </head>
    <body>
        <div class="middle-box text-center loginscreen animated fadeInDown">
            <div>
                <h3>Iniciar Sesión</h3>
                <form class="m-t" role="form" action="LoginServlet">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Nombre de usuario" required="">
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" placeholder="password" required="">
                    </div>
                    <input type="submit" class="btn btn-primary block full-width m-b" value="Iniciar Sesión"/>
                    <p class="text-muted text-center"><small>¿No tienes una cuenta?</small></p>
                    <a class="btn btn-sm btn-white btn-block" href="signup.jsp">Registrate</a>
                </form>
            </div>
        </div>
    </body>
</html>
