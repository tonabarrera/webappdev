<%-- 
    Document   : listaMaterias
    Created on : 10-Mar-2019, 00:02:53
    Author     : tonatihu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ver Materias</title>
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
                                    <h5>Lista de Materias</h5>
                                </div>
                            </div>
                            <div class="ibox-content">
                                    <div class="table-responsive">
                                        <table class="table table-striped">
                                            <thead>
                                                <tr>
                                                    <th colspan="4"></th>
                                                    <th colspan="1">Acciones</th>
                                                </tr>
                                                <tr>
                                                    <th>Nombre</th>
                                                    <th>Descripción</th>
                                                    <th>Carrera</th>
                                                    <th>Profesor</th>
                                                    <th>Eliminar</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${materias}" var="materia">
                                                <tr class="icons-box">
                                                    <td>${materia.nombre}</td>
                                                    <td>${materia.descripcion}</td>
                                                    <td>${materia.carrera.nombre}</td>
                                                    <td>${materia.profesor.nombre}</td>
                                                    <td class="text-center">
                                                        <a href="alumnos?action=eliminar&id=${materia.id}">
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
