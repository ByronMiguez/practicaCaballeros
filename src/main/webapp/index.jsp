<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index Caballeros</title>
</head>
<body>

        <table>
        <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Fuerza</th>
                <th>Experiencia</th>
                <th>Foto</th>
                <th>escudo</th>
                <th>arma</th>
        </tr>
        <c:forEach items="${caballeros}" var="caballero">
            <tr>
                <td>${caballero.id}</td>
                <td>${caballero.nombre}</td>
                <td>${caballero.fuerza}</td>
                <td>${caballero.experiencia}</td>
                <td>${caballero.foto}</td>
                <td>${caballero.escudo.nombre}</td>
                <td>${caballero.arma.nombre}</td>
            </tr>
        </c:forEach>
        </table>

</body>
</html>