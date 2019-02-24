<%-- 
    Document   : formAlumno
    Created on : 23-Feb-2019, 13:39:23
    Author     : tonatihu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <c:choose> 
            <c:when test="${alumno != null}">
                <title>Editar Alumno</title>
            </c:when>
            <c:otherwise>
                <title>Registrar Alumno</title>
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
                                        <c:when test="${alumno != null}">
                                            <h3>Editar Alumno</h3>
                                        </c:when>
                                        <c:otherwise>
                                            <h3>Registrar Alumno</h3>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <div class="ibox-content">
                                    <form action="AgregarAlumno" method="post" class="form-horizontal">
                                        <div class="form-group">
                                            <label class="col-lg-3 control-label">
                                                Boleta del alumno:
                                            </label>
                                            <div class="col-lg-5">
                                                <input type="number" 
                                                       name="boleta" required 
                                                       value="${alumno.noBoleta}" 
                                                       class="form-control"
                                                       placeholder="Boleta" 
                                                       <c:if test="${alumno != null}">readonly</c:if> />
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-lg-3 control-label">
                                                    Nombre del alumno:
                                                </label>
                                                <div class="col-lg-5">
                                                    <input type="text" 
                                                           name="nombre" required 
                                                           value="${alumno.nombre}" 
                                                    class="form-control"
                                                    placeholder="Nombre"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-lg-3 control-label">
                                                Apellido Paterno:
                                            </label>
                                            <div class="col-lg-5">
                                                <input type="text" 
                                                       name="apPaterno" 
                                                       required value="${alumno.apPaterno}" 
                                                       class="form-control"
                                                       placeholder="Apellido Paterno"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-lg-3 control-label">
                                                Apellido Materno:
                                            </label>
                                            <div class="col-lg-5">
                                                <input type="text" 
                                                       name="apMaterno" 
                                                       required 
                                                       value="${alumno.apMaterno}" 
                                                       class="form-control"
                                                       placeholder="Apellido Materno"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-lg-3 control-label">
                                                Email:
                                            </label>
                                            <div class="col-lg-5">
                                                <input type="email" 
                                                       name="correo" 
                                                       required 
                                                       value="${alumno.email}" 
                                                       class="form-control"
                                                       placeholder="Email"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-lg-3 control-label">
                                                Carrera:
                                            </label>
                                            <div class="col-lg-5">
                                                <select name="carrera" 
                                                        required 
                                                        class="form-control"
                                                        placeholder="Selecciona una carrera">
                                                    
                                                    <option value="" disabled <c:if test="${alumno == null}">selected</c:if>>
                                                        Selecciona una carrera
                                                    </option>
                                                    
                                                    <c:forEach items="${carreras}" var="carrera">
                                                        <option value="${carrera.id}" <c:if test="{alumno.carrera.id==carrera.id}">selected</c:if>>
                                                            ${carrera.nombre}
                                                        </option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <c:choose> 
                                            <c:when test="${alumno != null}">
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
