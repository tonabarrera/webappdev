<%-- 
    Document   : listaCarreras
    Created on : 10-Mar-2019, 00:02:45
    Author     : tonatihu
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ver Carreras</title>
        <%@include file="WEB-INF/jspf/headTag.jspf" %>
    </head>
    <body class="">
        <div id="wrapper">
            <%@include file="WEB-INF/jspf/nav.jspf" %>

            <div id="page-wrapper" class="gray-bg">
                <%@include file="WEB-INF/jspf/header.jspf" %>

                <div class="wrapper wrapper-content animated fadeInRight">
                    <div class="row">
                        <div class="col-lg-12">
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
                                                    <th colspan="2" class="text-center">Acciones</th>
                                                </tr>
                                                <tr>
                                                    <th>Id</th>
                                                    <th>Nombre</th>
                                                    <th>Descripción</th>
                                                    <th>Duración</th>
                                                    <th class="text-center">Editar</th>
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
                                                            <a href="carreras?action=editar&id=${carrera.id}">
                                                                <i class="fa fa-edit text-navy" style="font-size: 2rem"></i>
                                                            </a>
                                                        </td>
                                                        <td class="text-center">
                                                            <a href="carreras?action=eliminar&id=${carrera.id}">
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

        <%@include file="WEB-INF/jspf/jsLibraries.jspf" %>
    </body>
</html>
