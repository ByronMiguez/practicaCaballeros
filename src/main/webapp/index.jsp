<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Index Caballeros</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-4">
    <a href="CreateCaballero" class="btn btn-primary mb-3">Crear</a>
    
    <table class="table">
        <thead class="thead-dark">
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Fuerza</th>
                <th>Experiencia</th>
                <th>Foto</th>
                <th>Escudo</th>
                <th>Arma</th>
            </tr>
        </thead>
        <tbody>
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
        </tbody>
    </table>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
