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
		<h2>Registro de Actividades</h2>
	${msj}
		<form action="registroAtv" method="POST">
			<div class="row">
				<div class="col-sm-4">
					<label>Actividad:</label> <input type="text" class="form-control"
						name="nombre">
				</div>
				<div class="col-sm-4">
					<label>Descripcion:</label> <input type="text" class="form-control"
						name="descripcion">
				</div>
				<div class="col">
					<label>Fecha limite:</label> <input type="date"
						class="form-control" name="fecha" min="${d}">
				</div>
				<div class="col-sm-4">
					<label>Estado:</label> <select name="est" class="form-control">
						<option>Seleccione un estado</option>
						<c:forEach items="${est}" var="v">
							<option value="${v.idEst}">${v.estado}</option>
						</c:forEach>
					</select>
				</div>
				<div class="col-sm-4">
					<label>Usuarios:</label> <select name="usu" class="form-control">
						<option>Seleccione un usuario</option>
						<c:forEach items="${us}" var="u">
							<option value="${u.idUs}">${u.username}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<button type="submit" class="btn btn-primary mt-3">Guardar</button>
		</form>
	</div>

</body>
</html>
