<%--
  Crée par Jean le 15/02/2018
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>${titrePage}</title>
</head>
<body>
<h3>${titre}</h3>
<div>
    <mvc:form method="post" modelAttribute="user">
        <P>
            <mvc:radiobuttons path="civilite" items="${civilite}"/>
        </P>
        <P>
            <mvc:label path="email">Email</mvc:label>
            <mvc:input path="email"/>
        </P>
        <P>
            <mvc:label path="mdp">Mot de passe</mvc:label>
            <mvc:password path="mdp"/>
        </P>
        <P>
            <mvc:label path="mdpRepeat">Repeter le mdp</mvc:label>
            <mvc:password path="mdpRepeat"/>
        </P>
        <P>
            <mvc:label path="prenom">Prénom</mvc:label>
            <mvc:input path="prenom"/>
        </P>
        <P>
            <mvc:label path="nom">Nom</mvc:label>
            <mvc:input path="nom"/>
        </P>
        <P>
            <mvc:label path="ddn">Date de naissance</mvc:label>
            <mvc:input path="ddn"/>
        </P>
        <P>
            <mvc:label path="statutMarital">
                <b>Marié(e) ? </b>
            </mvc:label>
            <mvc:checkbox path="statutMarital" />
        </P>
        <P>
            <mvc:label path="nationalite">
                <b>Nationalité </b>
            </mvc:label>
            <mvc:errors path="nationalite" />
            <mvc:select path="nationalite">
                <mvc:option value="---Nationalité---"/>
                <mvc:options items="${nationalite}"/>
            </mvc:select>
        </P>
        <p>
            <input type="submit" value="Valider" />
            <input type="reset" value="Reset" />
        </p>
    </mvc:form>
</div>
</body>
</html>
