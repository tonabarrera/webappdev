<%--
  Created by IntelliJ IDEA.
  User: tonatihu
  Date: 3/12/19
  Time: 7:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Categoria</title>
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
                                <c:when test="${categoria != null}">
                                    <h3>Editar categoria</h3>
                                </c:when>
                                <c:otherwise>
                                    <h3>Registrar categoria</h3>
                                </c:otherwise>
                            </c:choose>
                        </div>
                        <div class="ibox-content">
                            <form action="categorias?accion=guardar" method="post"
                                  class="form-horizontal">
                                <c:if test="${categoria != null}">
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">
                                            Id de la Categoria:
                                        </label>
                                        <div class="col-sm-10">
                                            <input type="text"
                                                   name="id" required
                                                   value="${categoria.categoriaId}"
                                                   class="form-control"
                                                   placeholder="Id Categoria" readonly/>
                                        </div>
                                    </div>
                                </c:if>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">
                                        Nombre:
                                    </label>
                                    <div class="col-sm-10">
                                        <input type="text"
                                               name="nombre" required
                                               value="${categoria.nombre}"
                                               class="form-control"
                                               placeholder="Nombre"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">
                                        Descipción:
                                    </label>
                                    <div class="col-sm-10">
                                        <input type="text"
                                               name="descripcion"
                                               required value="${categoria.descripcion}"
                                               class="form-control"
                                               placeholder="Descripción"/>
                                    </div>
                                </div>
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
