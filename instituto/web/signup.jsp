<%-- 
    Document   : signup
    Created on : 09-Mar-2019, 15:15:56
    Author     : tonatihu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
        <%@include file="WEB-INF/jspf/headTag.jspf" %>
    </head>
    <body class="gray-bg">
        <div class="middle-box text-center loginscreen animated fadeInDown">
            <div>
                <h2>Instituto</h2>
                <p>Crear una cuenta</p>
                <form class="m-t" role="form" action="signup" method="post">
                    <div class="form-group">
                        <input type="text" name="nombre" class="form-control" placeholder="Nombre" required="">
                    </div>
                    <div class="form-group">
                        <input type="text" name="apPaterno" class="form-control" placeholder="Apellido Paterno" required="">
                    </div>
                    <div class="form-group">
                        <input type="text" name="apMaterno" class="form-control" placeholder="Apellido Materno">
                    </div>
                    <div class="form-group">
                        <select name="tipo" class="form-control" required id="selectTipo">
                            <option value="" disabled selected>Tipo de Usuario</option>
                            <option value="1">Alumno</option>
                            <option value="2">Profesor</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <input type="text" name="boleta" 
                               class="form-control hidden" placeholder="Boleta" 
                               id="boleta"/>
                    </div>
                    <div class="form-group">
                        <input type="text" name="username" class="form-control" placeholder="Nombre de Usuario" required="">
                    </div>
                    <div class="form-group">
                        <input type="email" name="email" class="form-control" placeholder="Email" required="">
                    </div>
                    <div class="form-group">
                        <input type="password" name="password" class="form-control" placeholder="Contraseña" required="">
                    </div>
                    <button type="submit" class="btn btn-primary block full-width m-b">
                        Registrarse
                    </button>
                    <p class="text-muted text-center"><small>¿Ya tienes una cuenta?</small></p>
                    <a class="btn btn-sm btn-white btn-block" href="login">Iniciar Sesión</a>
                </form>
                <p class="m-t"><small>Instituto 2019</small> </p>
            </div>
        </div>
        
        <script src="static/js/jquery-3.1.1.min.js"></script>
        <script src="static/js/bootstrap.min.js"></script>
        <script>
            $("#selectTipo").change(function(e) {
                let mensaje = "Boleta";
                if (this.value === "2") {
                    mensaje = "Número de profesor";
                }
                $("#boleta").removeClass("hidden");
                $("#boleta").attr("placeholder", mensaje);
            });
            if ($("#selectTipo").val() === "1") {
                $("#boleta").removeClass("hidden");
                $("#boleta").attr("placeholder", "Boleta");
            } else if ($("#selectTipo").val() === "2") {
                $("#boleta").removeClass("hidden");
                $("#boleta").attr("placeholder", "Número de profesor");
            }
        </script>
    </body>

</html>
