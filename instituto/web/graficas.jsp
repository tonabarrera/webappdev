<%-- 
    Document   : graficas
    Created on : 10-Mar-2019, 00:03:12
    Author     : tonatihu
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
                                    <h4>Cantidad de Alumnos por Carrera</h4>
                                </div>
                                <div class="ibox-content center-block">
                                    <div class="table-responsive">
                                        <table class="table table-striped">
                                            <thead>
                                                <tr>
                                                    <th>Nombre</th>
                                                    <th>Cantidad de estudiantes</th>
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
                                            class="center-block" style="max-width: 100%; max-height: 100%;" />
                                    </div>
                                    <div class="row">
                                        <a class="btn btn-primary" href="graficas?accion=generar">
                                            Mandar PDF a mi correo
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
