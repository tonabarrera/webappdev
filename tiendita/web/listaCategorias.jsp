<%-- 
    Document   : listarCategorias
    Created on : 21-Feb-2019, 09:45:50
    Author     : tonatihu
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Lista Categorias</title>
        <%@include file="WEB-INF/jspf/headTag.jspf" %>
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
                                                    <th colspan="3"></th>
                                                    <th cospan="" class="text-center">Acciones</th>
                                                </tr>
                                                <tr>
                                                    <th>Id</th>
                                                    <th>Nombre</th>
                                                    <th>Descripción</th>
                                                    <th>Editar</th>
                                                    <th>Eliminar</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${categorias}" var="categoria">
                                                    <tr>
                                                        <td><c:out value="${categoria.id}"></c:out></td>
                                                        <td><c:out value="${categoria.nombre}"></c:out></td>
                                                        <td><c:out value="${categoria.descripcion}"></c:out></td>
                                                        <td>
                                                            <a href="?accion=editar&id=${categoria.id}">
                                                                <i class="fa fa-edit" style="font-size: 2rem"></i>
                                                            </a>
                                                        </td>
                                                        <td>
                                                            <a href="?accion=eliminar&id=${categoria.id}">
                                                                <i class="fa fa-trash" style="font-size: 2rem"></i>
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
            
        <%@include file="WEB-INF/jspf/jsFiles.jspf" %>
    </body>
</html>
