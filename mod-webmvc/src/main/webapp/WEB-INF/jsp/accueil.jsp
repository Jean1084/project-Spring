
<%--
  Crée par Jean le 15/02/2018
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<html>
<head>
    <title>${titre}</title>
</head>
<body>

<h1 style="color: crimson">
    <spring:url value="/user/liste" var="listeUrl"/>
    <a href="${listeUrl}">Gestion Utilisateurs</a>
</h1>
</body>
</html>
