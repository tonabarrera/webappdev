<%-- 
    Document   : verAlumno
    Created on : 23-Feb-2019, 13:40:18
    Author     : tonatihu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Ver Alumno</title>
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
                
                <div class="row">
                    <div class="col-lg-1"></div>
                    <div class="col-lg-10">
                        <div class="wrapper wrapper-content animated fadeInUp">
                            <div class="ibox">
                                <div class="ibox-content">
                                    <div class="row">
                                        <div class="col-lg-12">
                                            <div class="m-b-md">
                                                <a href="EliminarAlumno?id=${alumno.noBoleta}" 
                                                   class="btn btn-danger btn-s pull-right">
                                                    Eliminar Alumno
                                                </a>
                                                <h2>Datos del Alumno</h2>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-lg-10">
                                            <dl>
                                                <dt style="font-size: 1.5em">Nombre del alumno: </dt>
                                                <dd style="font-size: 1.2em">${alumno.nombre}</dd>
                                                <dt style="font-size: 1.5em">Apellido paterno del alumno: </dt>
                                                <dd style="font-size: 1.2em">${alumno.apPaterno}</dd>
                                                <dt style="font-size: 1.5em">Apellido materno del alumno: </dt>
                                                <dd style="font-size: 1.2em">${alumno.apMaterno}</dd>
                                                <dt style="font-size: 1.5em">No de Boleta: </dt>
                                                <dd style="font-size: 1.2em">${alumno.noBoleta}</dd>
                                                <dt style="font-size: 1.5em">Correo Electronico: </dt>
                                                <dd style="font-size: 1.2em">${alumno.email}</dd>
                                                <dt style="font-size: 1.5em">Carrera: </dt>
                                                <dd style="font-size: 1.2em">${alumno.carrera.nombre}</dd>
                                            </dl>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-1"></div>
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
