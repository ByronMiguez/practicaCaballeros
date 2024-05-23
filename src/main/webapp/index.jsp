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

	<c:if test="${msg == 'no'}">
        <div class="alert alert-danger alert-dismissible fade show mx-4" role="alert">
            No se puede insertar el caballero
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>
    <c:if test="${msg == 'ok'}">
        <div class="alert alert-success alert-dismissible fade show mx-4" role="alert">
            Caballero insertado
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>
          
    <a href="CreateCaballero" class="btn btn-primary mb-3">Crear</a>
  
    <button type="button" class="btn btn-secondary mb-3" data-toggle="modal" data-target="#searchModal">Buscar</button>

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


<div class="modal fade" id="searchModal" tabindex="-1" aria-labelledby="searchModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="searchModalLabel">Buscar Caballero</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form action="PanelCaballero" method="get">
                    <div class="form-group">
                        <label for="searchQuery">Nombre del Caballero</label>
                        <input type="text" class="form-control" id="searchQuery" name="searchQuery" placeholder="Introduce el nombre">
                    </div>
                    <button type="submit" class="btn btn-primary">Buscar</button>
                </form>
            </div>
        </div>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
