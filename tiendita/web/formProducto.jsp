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
    <title>Producto</title>
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
                                <c:when test="${producto != null}">
                                    <h3>Editar Producto</h3>
                                </c:when>
                                <c:otherwise>
                                    <h3>Registrar Producto</h3>
                                </c:otherwise>
                            </c:choose>
                        </div>
                        <div class="ibox-content">
                            <form action="productos?accion=guardar" method="post"
                                  class="form-horizontal">
                                <c:if test="${producto != null}">
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">
                                            Id del Producto:
                                        </label>
                                        <div class="col-sm-10">
                                            <input type="text"
                                                   name="id" required
                                                   value="${producto.productoId}"
                                                   class="form-control"
                                                   placeholder="Id Producto" readonly/>
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
                                               value="${producto.nombre}"
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
                                               required value="${producto.descripcion}"
                                               class="form-control"
                                               placeholder="Descripción"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">
                                        Existencia:
                                    </label>
                                    <div class="col-sm-10">
                                        <input type="number"
                                               name="existencia"
                                               required value="${producto.existencia}"
                                               class="form-control"
                                               placeholder="Existencia"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">
                                        Precio:
                                    </label>
                                    <div class="col-sm-10">
                                        <input type="text"
                                               name="precio"
                                               required value="${producto.precio}"
                                               class="form-control"
                                               placeholder="Precio"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">
                                        Categoria:
                                    </label>
                                    <div class="col-sm-10">
                                        <select name="categoria"
                                                required
                                                class="form-control">
                                            <option value="" disabled
                                                <c:if test="${producto.categoria.categoriaId == 0}">
                                                    selected
                                                </c:if>>
                                                Selecciona una Categoria
                                            </option>
                                            <c:forEach items="${categorias}" var="categoria">
                                                <option value="${categoria.categoriaId}"
                                                        <c:if test="${producto.categoria.categoriaId == categoria.categoriaId}">
                                                            selected
                                                        </c:if>>
                                                        ${categoria.nombre}
                                                </option>
                                            </c:forEach>
                                        </select>
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
