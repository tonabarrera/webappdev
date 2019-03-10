<%-- 
    Document   : listaAlumnos
    Created on : 10-Mar-2019, 15:17:16
    Author     : tonatihu
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ver Alumnos</title>
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
                                    <h5>Lista de Alumnos</h5>
                                </div>
                            </div>
                            <div class="ibox-content">
                                    <div class="table-responsive">
                                        <table class="table table-striped">
                                            <thead>
                                                <tr>
                                                    <th colspan="6"></th>
                                                    <th colspan="1">Acciones</th>
                                                </tr>
                                                <tr>
                                                    <th>Boleta</th>
                                                    <th>Nombre</th>
                                                    <th>Apellido Paterno</th>
                                                    <th>Apellido Materno</th>
                                                    <th>Email</th>
                                                    <th>Carrera</th>
                                                    <th>Eliminar</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${alumnos}" var="alumno">
                                                    <tr class="icons-box">
                                                        <td>${alumno.boleta}</td>
                                                        <td>${alumno.nombre}</td>
                                                        <td>${alumno.apPaterno}</td>
                                                        <td>${alumno.apMaterno}</td>
                                                        <td>${alumno.email}</td>
                                                        <td>${alumno.carrera.nombre}</td>
                                                        <td class="text-center">
                                                            <a href="alumnos?action=eliminar&id=${alumno.id}">
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
                
                <%@include file="WEB-INF/jspf/footer.jspf" %>
            </div>
        </div>
            
        <%@include file="WEB-INF/jspf/jsLibraries.jspf" %>
    </body>
</html>
