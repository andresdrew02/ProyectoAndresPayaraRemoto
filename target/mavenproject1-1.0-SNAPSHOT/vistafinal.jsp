<%-- 
    Document   : vistafinal
    Created on : 27-feb-2023, 20:27:13
    Author     : andres
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vista final</title>
        <link rel="stylesheet" href="./global.css"/>
    </head>
    <body>
        <h1>Listado de paises</h1>
        <c:out value="${excepcion}"></c:out>
        <c:if test="${listadoPaises == null || listadoPaises.size() <= 0}">
            <h1>No se han encontrado paises</h1>
        </c:if>
        <c:if test="${listadoPaises != null && listadoPaises.size() >= 1}">
            <table>
                <thead>
                    <tr>
                    <th>Nombre</th>
                    <th>Continente</th>
                    <th>Población</th>
                    <th>Año de independencia</th>
                </tr>
                </thead>
                <c:forEach items="${listadoPaises}" var="pais">
                    <tr>
                        <td><c:out value="${pais.getName()}"></c:out></td>
                        <td><c:out value="${pais.getContinent()}"></c:out></td>
                        <td><c:out value="${pais.getPoblation()}"></c:out></td>
                        <td><c:out value="${pais.getIndpyear()}"></c:out></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </body>
</html>
