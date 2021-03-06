<%--
  Created by IntelliJ IDEA.
  User: tonatihu
  Date: 3/17/19
  Time: 7:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista de Productos</title>
    <%@include file="WEB-INF/jspf/headTag.jspf" %>
</head>
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
                            <h5>Lista de Productos</h5>
                        </div>
                        <div class="ibox-content">
                            <div class="table-responsive">
                                <table class="table table-striped">
                                    <thead>
                                    <tr>
                                        <th colspan="5"></th>
                                        <th colspan="2" class="text-center">Acciones</th>
                                    </tr>
                                    <tr>
                                        <th>Id</th>
                                        <th>Nombre</th>
                                        <th>Descripción</th>
                                        <th>Existencia</th>
                                        <th>Precio</th>
                                        <th>Editar</th>
                                        <th>Eliminar</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${productos}" var="producto">
                                        <tr>
                                            <td><c:out value="${producto.productoId}"/></td>
                                            <td><c:out value="${producto.nombre}"/></td>
                                            <td><c:out value="${producto.descripcion}"/></td>
                                            <td><c:out value="${producto.existencia}"/></td>
                                            <td><c:out value="${producto.precio}"/></td>
                                            <td>
                                                <a href="?accion=editar&id=${producto.productoId}">
                                                    <i class="fa fa-edit"
                                                       style="font-size: 2rem"></i>
                                                </a>
                                            </td>
                                            <td>
                                                <a href="?accion=eliminar&id=${producto.productoId}">
                                                    <i class="fa fa-trash"
                                                       style="font-size: 2rem"></i>
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
