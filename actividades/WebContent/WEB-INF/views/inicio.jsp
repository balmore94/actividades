<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<h2>Registro de Usuario</h2>
	${msj}
		<form action="registroUsuario" method="POST">
			<div class="row">
				<div class="col-sm-4">
					<label>Nombres:</label> <input type="text" class="form-control"
						name="nombre">
				</div>
				<div class="col-sm-4">
					<label>Nombres:</label> <input type="text" class="form-control"
						name="apellidos">
				</div>
				<div class="col-sm-4">
					<label>DUI:</label> <input type="text" class="form-control"
						name="dui">
				</div>
				<div class="col">
					<label>Fecha de Nacimiento:</label> <input type="date"
						class="form-control" name="fecha_na">
				</div>
				<div class="col-sm-4">
					<label>Sexo</label>
					<div class="custom-control custom-radio">
						<input class="custom-control-input" type="radio" id="m"
							name="sexo" value="m"> <label
							class="custom-control-label" for="m">Masculino</label>
					</div>
					<div class="custom-control custom-radio">
						<input class="custom-control-input" type="radio" id="f"
							name="sexo" value="f"> <label
							class="custom-control-label" for="f">Femenino</label>
					</div>

				</div>
				<div class="col-sm-4">
					<label>Username:</label> <input type="text" class="form-control"
						name="username">
				</div>
				<div class="col-sm-4">
					<label>Contraseña:</label> <input type="text" class="form-control"
						name="pass">
				</div>
				<div class="col-sm-4">
					<label>Tipo:</label> <select name="tipou" class="form-control">
						<option>Seleccione un tipo</option>
						<c:forEach items="${tipos}" var="v">
							<option value="${v.idTpu}">${v.tipo}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<button type="submit" class="btn btn-primary mt-3">Guardar</button>
		</form>
	</div>

</body>
</html>
