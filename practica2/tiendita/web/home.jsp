<%--
  Created by IntelliJ IDEA.
  User: tonatihu
  Date: 3/11/19
  Time: 9:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tiendita</title>
    <%@include file="WEB-INF/jspf/headTag.jspf" %>
</head>
<body class="">
<div id="wrapper">
    <%@include file="WEB-INF/jspf/nav.jspf" %>

    <div id="page-wrapper" class="gray-bg">
        <%@include file="WEB-INF/jspf/header.jspf" %>

        <div class="wrapper wrapper-content">
            <div class="middle-box text-center animated">
                <h2 class="font-bold">Bienvenido</h2>
                <div class="error-desc">
                    Un cordial y amistoso saludo a toda la razita que la sigue cotorreando
                </div>
            </div>
        </div>

        <%@include file="WEB-INF/jspf/footer.jspf" %>
    </div>
</div>

<%@include file="WEB-INF/jspf/jsLibraries.jspf" %>
</body>
</html>
