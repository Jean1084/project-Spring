
<%--
  Crée par Jean le 15/02/2018
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>${titre}</title>
</head>
<body>
<h1>${titrePage}</h1>
<p>
    <a href="/user/ajouter">Ajouter un utilisateur</a>
</p>
<p>
<table>
    <thead>
    <tr>
        <th>Identifiant</th>
        <th>Civilité</th>
        <th>Email</th>
        <th>Prénom</th>
        <th>Nom</th>
        <th>Ddn</th>
        <th>Nationalité</th>
        <th>Statut Marital</th>
        <th>Âge</th>
        <th colspan="2">Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${users != null}">
        <c:forEach var="s" items="${users}">
            <tr>
                <td>${s.id}</td>
                <td>${s.civilite}</td>
                <td>${s.email}</td>
                <td>${s.prenom}</td>
                <td>${s.nom}</td>
                <td>${s.ddn}</td>
                <td>${s.nationalite}</td>
                <td>${s.statutMarital}</td>
                <td>${s.age}</td>
                <td colspan="2">
                    <a href="/user/modifier/${s.id}">Modifier</a>
                    <a href="/user/supprimer/${s.id}">Supprimer</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
    </tbody>
</table>
</p>
</body>
</html>
