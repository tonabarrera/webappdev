<%-- 
    Document   : perfil
    Created on : 09-Mar-2019, 20:11:58
    Author     : tonatihu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Perfil</title>
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
                                <h5>Mi perfil</h5>
                            </div>
                            <div class="ibox-content">
                                <form action="perfil" method="post" class="form-horizontal">
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">
                                            Nombre:
                                        </label>
                                        <div class="col-sm-10">
                                            <input type="text" 
                                                   name="nombre" required 
                                                   value="${alumno.nombre}" 
                                                   class="form-control"
                                                   placeholder="Nombre"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">
                                            Apellido Paterno:
                                        </label>
                                        <div class="col-sm-10">
                                            <input type="text" 
                                                   name="apPaterno" 
                                                   required value="${alumno.apPaterno}" 
                                                   class="form-control"
                                                   placeholder="Apellido Paterno"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">
                                            Apellido Materno:
                                        </label>
                                        <div class="col-sm-10">
                                            <input type="text" 
                                                   name="apMaterno" 
                                                   required 
                                                   value="${alumno.apMaterno}" 
                                                   class="form-control"
                                                   placeholder="Apellido Materno"/>
                                        </div>
                                    </div>
                                    <div class="hr-line-dashed"></div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">
                                            Boleta del alumno:
                                        </label>
                                        <div class="col-sm-10">
                                            <input type="number" 
                                                   name="boleta" required 
                                                   value="${alumno.boleta}" 
                                                   class="form-control"
                                                   placeholder="Boleta" 
                                                   readonly />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">
                                            Carrera:
                                        </label>
                                        <div class="col-sm-10">
                                            <select name="carrera" 
                                                    required 
                                                    class="form-control"
                                                    placeholder="Selecciona una carrera">

                                                <option value="" disabled <c:if test="${alumno.carrera.id == 0}">selected</c:if>>
                                                    Selecciona una carrera
                                                </option>

                                                <c:forEach items="${carreras}" var="carrera">
                                                    <option value="${carrera.id}" <c:if test="${alumno.carrera.id==carrera.id}">selected</c:if>>
                                                        ${carrera.nombre}
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="hr-line-dashed"></div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">
                                            Email:
                                        </label>
                                        <div class="col-sm-10">
                                            <input type="email" 
                                                   name="correo" 
                                                   required 
                                                   value="${alumno.email}" 
                                                   class="form-control"
                                                   placeholder="Email"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">
                                            Username:
                                        </label>
                                        <div class="col-sm-10">
                                            <input type="text" 
                                                   name="username" 
                                                   required 
                                                   value="${alumno.username}" 
                                                   class="form-control"
                                                   placeholder="Nombre de usuario"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">
                                            Constraseña:
                                        </label>
                                        <div class="col-sm-10">
                                            <input type="password" 
                                                   name="password" 
                                                   required 
                                                   value="${alumno.password}" 
                                                   class="form-control"
                                                   placeholder="Contraseña"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="text-center">
                                            <input type="submit" value="Guardar cambios" class="btn btn-primary">
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
