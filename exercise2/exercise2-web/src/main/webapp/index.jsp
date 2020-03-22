<%@page import="com.practicas.model.Car"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<title>Exercise 2</title>
</head>
<body>
	<div class="bs-example">

		<nav class="navbar navbar-expand-md navbar-dark bg-warning">

			<a href="index.jsp" class="navbar-brand"><h1 class="text-hide"
					style="background-image: url('img/home.png'); width: 50px; height: 50px;">GameToday</h1></a>

			<button type="button" class="navbar-toggler" data-toggle="collapse"
				data-target="#navbarCollapse">

				<span class="navbar-toggler-icon"></span>

			</button>

			<div class="collapse navbar-collapse" id="navbarCollapse">

				<div class="navbar-nav">

					<a href="#" class="nav-item nav-link active" data-toggle="tooltip"
						data-placement="bottom" title="">Active</a> <a href="#"
						class="nav-item nav-link" data-toggle="tooltip"
						data-placement="bottom" title="">Link</a> <a href="#"
						class="nav-item nav-link" data-toggle="tooltip"
						data-placement="bottom" title="">Link</a> <a href="#"
						class="nav-item nav-link" data-toggle="tooltip"
						data-placement="bottom" title="">Link</a>

				</div>

				<div class="navbar-nav ml-auto">

					<div class="input-group">

						<div class="btn-group" role="group">

							<button type="button" class="btn btn-light" data-toggle="tooltip"
								data-placement="bottom" title="Ir a la pagina de registro">Registrate</button>

							<button type="button" class="btn btn-light mr-2"
								data-toggle="tooltip" data-placement="bottom" title="Loguearte">Login</button>

						</div>

					</div>

				</div>

				<form class="form-inline" action="">

					<div class="input-group">

						<div class="input-group-prepend">

							<span class="input-group-text">@</span>

						</div>

						<input type="text" class="form-control" data-toggle="popover"
							title="Login de usuario"
							data-content="Aqui tienes que poner el nombre de tu usuario."
							placeholder="Usuario">

					</div>

				</form>
		</nav>

		<h2 class="mt-4 ml-2">Listado de Coches</h2>
		<table
			class="table table-responsive table-hover table-striped table-bordered text-center w-100 p-3">
			<thead>
				<tr class="table-warning">
					<th scope="col">ID</th>
					<th scope="col">Modelo</th>
					<th scope="col">Marca</th>
				</tr>
			</thead>
			<tbody>
				<%
					List<Car> cars = (List<Car>) request.getAttribute("cars");

				if (cars != null) {

					for (Car c : cars) {
				%>
				<tr>
					<th><%=c.getPk()%></th>
					<td><%=c.getIdentification().getId()%></td>
					<td><%=c.getIdentification().getMake()%></td>
				</tr>
				<%
					}

				}
				%>
			</tbody>
		</table>

	</div>
</body>
</html>