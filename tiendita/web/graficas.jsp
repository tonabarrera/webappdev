<%--
  Created by IntelliJ IDEA.
  User: tonatihu
  Date: 3/21/19
  Time: 9:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Graficas</title>
    <%@include file="WEB-INF/jspf/headTag.jspf" %>
</head>
<body class="">
<div id="wrapper">
    <%@include file="WEB-INF/jspf/nav.jspf" %>

    <div id="page-wrapper" class="gray-bg">
        <%@include file="WEB-INF/jspf/header.jspf" %>

        <div class="wrapper wrapper-content animated fadeInRight">
            <div class="row ">
                <div class="col-lg-12">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h4>Cantidad de Productos por Categoria</h4>
                        </div>
                        <div class="ibox-content center-block">
                            <div class="table-responsive">
                                <table class="table table-striped">
                                    <thead>
                                    <tr>
                                        <th>Nombre</th>
                                        <th>Cantidad de productos</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${lista}" var="elemento" >
                                        <tr>
                                            <td><c:out value="${elemento.nombre}"/></td>
                                            <td><c:out value="${elemento.cantidad}"/></td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div class="row">
                                <img src="static/img/grafica.png"
                                     class="center-block" style="max-width: 100%; max-height: 100%;"  alt="grafica"/>
                            </div>
                            <div class="row">
                                <a class="btn btn-primary" href="graficas?accion=generar">
                                    Imprimir el PDF
                                </a>
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
