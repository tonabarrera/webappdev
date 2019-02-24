<%-- 
    Document   : carreraForm
    Created on : 23-Feb-2019, 13:39:32
    Author     : tonatihu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <c:choose> 
            <c:when test="${carrera != null}">
                <title>Editar Carrera</title>
            </c:when>
            <c:otherwise>
                <title>Registrar carrera</title>
            </c:otherwise>
        </c:choose>
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
                    <div class="col-lg-1">
                        <div class="wrapper wrapper-content animated fadeInUp"></div>
                    </div>
                    <div class="col-lg-10">
                        <div class="wrapper wrapper-content animated fadeInUp">
                            <div class="ibox float-e-margins">
                                <div class="ibox-title">
                                    <c:choose> 
                                        <c:when test="${carrera != null}">
                                            <h3>Editar Carrera</h3>
                                        </c:when>
                                        <c:otherwise>
                                            <h3>Registrar carrera</h3>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <div class="ibox-content">
                                    <form action="AgregarCarrera" method="post" class="form-horizontal">
                                        <c:if test="${carrera != null}">
                                            <div class="form-group">
                                                <label class="col-lg-3 control-label">
                                                    Id de la carrera:
                                                </label>
                                                <div class="col-lg-5">
                                                    <input type="text" 
                                                           name="id" required 
                                                           value="${carrera.id}" 
                                                           class="form-control"
                                                           placeholder="Id carrera" readonly/>
                                                </div>
                                            </div>
                                        </c:if>
                                        <div class="form-group">
                                            <label class="col-lg-3 control-label">
                                                Nombre de la carrera:
                                            </label>
                                            <div class="col-lg-5">
                                                <input type="text" 
                                                       name="nombre" required 
                                                       value="${carrera.nombre}" 
                                                       class="form-control"
                                                       placeholder="Nombre"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-lg-3 control-label">
                                                Descipción de la carrera:
                                            </label>
                                            <div class="col-lg-5">
                                                <input type="text" 
                                                       name="descripcion" 
                                                       required value="${carrera.descripcion}" 
                                                       class="form-control"
                                                       placeholder="Descripción"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-lg-3 control-label">
                                                Duración de la carrera:
                                            </label>
                                            <div class="col-lg-5">
                                                <input type="number" 
                                                       name="duracion" 
                                                       required 
                                                       value="${carrera.duracion}" 
                                                       class="form-control"
                                                       placeholder="Duracion"/>
                                            </div>
                                        </div>
                                        <c:choose> 
                                            <c:when test="${carrera != null}">
                                                <input hidden name="tipo" value="cambio">
                                            </c:when>
                                            <c:otherwise>
                                                <input hidden name="tipo" value="alta">
                                            </c:otherwise>
                                        </c:choose>

                                        <div class="form-group">
                                            <div class="col-lg-offset-4 col-lg-8">
                                                <input type="submit" value="Enviar" class="btn btn-primary">
                                            </div>
                                        </div>
                                    </form>
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
