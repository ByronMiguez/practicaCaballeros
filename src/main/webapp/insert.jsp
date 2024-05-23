<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Index Caballeros</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <a href="PanelCaballero" class="btn btn-primary mb-3">Inicio</a>
    <div class="row">
        <div class="col">
            <div class="card p-4">
                <h2 class="card-title text-center mb-4">Crear Caballero</h2>
                <form action="CreateCaballero" method="post">
                    <div class="mb-3">
                        <label for="nombre" class="form-label">Nombre:</label>
                        <input type="text" class="form-control" id="nombre" name="nombre">
                    </div>
                    <div class="mb-3">
                        <label for="fuerza" class="form-label">Fuerza:</label>
                        <input type="number" class="form-control" id="fuerza" name="fuerza">
                    </div>
                    <div class="mb-3">
                        <label for="experiencia" class="form-label">Experiencia:</label>
                        <input type="number" class="form-control" id="experiencia" name="experiencia">
                    </div>
                    <div class="mb-3">
                        <label for="foto" class="form-label">Foto:</label>
                        <input type="text" class="form-control" id="foto" name="foto">
                    </div>
                    <div class="mb-3">
                        <label for="arma_id" class="form-label">Arma:</label>
                        <input type="number" class="form-control" id="arma_id" name="arma_id">
                    </div>
                    <div class="mb-3">
                        <label for="escudo_id" class="form-label">Escudo:</label>
                        <input type="number" class="form-control" id="escudo_id" name="escudo_id">
                    </div>
                    <button type="submit" class="btn btn-primary" name="Guardar">Guardar</button>
                </form>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
