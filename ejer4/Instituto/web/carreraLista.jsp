<%-- 
    Document   : carreraLista
    Created on : 23-Feb-2019, 13:39:41
    Author     : tonatihu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Lista de carreras</title>
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
                    <div class="col-lg-12">
                        <div class="wrapper wrapper-content animated fadeInUp">
                            <div class="inbox float-e-margins">
                                <div class="ibox-title">
                                    <h5>Lista de Carreras</h5>
                                </div>
                                <div class="ibox-content">
                                    <div class="table-responsive">
                                        <table class="table table-striped">
                                            <thead>
                                                <tr>
                                                    <th colspan="4"></th>
                                                    <th colspan="3" class="text-center">Acciones</th>
                                                </tr>
                                                <tr>
                                                    <th>Id</th>
                                                    <th>Nombre</th>
                                                    <th>Descripción</th>
                                                    <th>Duración</th>
                                                    <th class="text-center">Ver</th>
                                                    <th class="text-center">Actualizar</th>
                                                    <th class="text-center">Eliminar</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${carreras}" var="carrera">
                                                    <tr class="icons-box">
                                                        <td>${carrera.id}</td>
                                                        <td>${carrera.nombre}</td>
                                                        <td>${carrera.descripcion}</td>
                                                        <td>${carrera.duracion}</td>
                                                        <td class="text-center">
                                                            <a href="VerCarrera?id=${carrera.id}">
                                                                <i class="fa fa-eye text-navy" style="font-size: 2rem"></i>
                                                            </a>
                                                        </td>
                                                        <td class="text-center">
                                                            <a href="EditarCarrera?id=${carrera.id}">
                                                                <i class="fa fa-edit text-navy" style="font-size: 2rem"></i>
                                                            </a>
                                                        </td>
                                                        <td class="text-center">
                                                            <a href="EliminarCarrera?id=${carrera.id}">
                                                                <i class="fa fa-trash text-navy" style="font-size: 2rem"></i>
                                                            </a>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
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
