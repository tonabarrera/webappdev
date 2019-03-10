<%-- 
    Document   : formCarrera
    Created on : 10-Mar-2019, 00:02:15
    Author     : tonatihu
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:choose> 
            <c:when test="${PAGINA == 4 }">
                <title>Registrar Carrera</title>
            </c:when>
            <c:otherwise>
                <title>Editar carrera</title>
            </c:otherwise>
        </c:choose>
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
                                    <form action="carreras?action=guardar" method="post" class="form-horizontal">
                                        <c:if test="${carrera != null}">
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">
                                                Id de la carrera:
                                            </label>
                                            <div class="col-sm-10">
                                                <input type="text" 
                                                       name="id" required 
                                                       value="${carrera.id}" 
                                                       class="form-control"
                                                       placeholder="Id carrera" readonly/>
                                            </div>
                                        </div>
                                        </c:if>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">
                                                Nombre de la carrera:
                                            </label>
                                            <div class="col-sm-10">
                                                <input type="text" 
                                                       name="nombre" required 
                                                       value="${carrera.nombre}" 
                                                       class="form-control"
                                                       placeholder="Nombre"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">
                                                Descipción de la carrera:
                                            </label>
                                            <div class="col-sm-10">
                                                <input type="text" 
                                                       name="descripcion" 
                                                       required value="${carrera.descripcion}" 
                                                       class="form-control"
                                                       placeholder="Descripción"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">
                                                Duración de la carrera:
                                            </label>
                                            <div class="col-sm-10">
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

        <%@include file="WEB-INF/jspf/jsLibraries.jspf" %>
    </body>
</html>
