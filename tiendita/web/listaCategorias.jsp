<%-- 
    Document   : listarCategorias
    Created on : 21-Feb-2019, 09:45:50
    Author     : tonatihu
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <table>
            <th>
                <td>Id</td>
                <td>Nombre</td>
                 <td>Descripción</td>
            </th>
            <c:forEach items="${categorias}" var="categoria">
                <tr>
                    <td>${categoria.id}</td>
                    <td>${categoria.nombre}</td>
                    <td>${categoria.descripcion}</td>
                </tr>
            </c:forEach>
        </table>
        
    </body>
</html>
