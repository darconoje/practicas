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
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css"
	rel="stylesheet">
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
					style="background-image: url('img/home.png'); width: 50px; height: 50px;"></h1></a>

			<button type="button" class="navbar-toggler" data-toggle="collapse"
				data-target="#navbarCollapse">

				<span class="navbar-toggler-icon"></span>

			</button>

			<div class="collapse navbar-collapse" id="navbarCollapse">

				<div class="navbar-nav">

					<a href="#"
						class="nav-item nav-link active font-weight-bold text-uppercase"
						data-toggle="tooltip" data-placement="bottom" title="">Cars</a> <a
						href="#" class="nav-item nav-link text-white"
						data-toggle="tooltip" data-placement="bottom" title="">Makes</a> <a
						href="#" class="nav-item nav-link text-white"
						data-toggle="tooltip" data-placement="bottom" title="">Users</a>

				</div>

				<div class="navbar-nav ml-auto">

					<div class="input-group">

						<div class="btn-group" role="group">

							<button type="button" class="btn btn-light" data-toggle="tooltip"
								data-placement="bottom" title="Ir a la pagina de registro">Sign
								In</button>

							<button type="button" class="btn btn-light mr-2"
								data-toggle="tooltip" data-placement="bottom" title="Loguearte">Login</button>

						</div>

					</div>

				</div>

				<form class="form-inline" action="">

					<div class="input-group">

						<div class="input-group-prepend">

							<span class="input-group-text"><span
								class="glyphicon glyphicon-user"></span></span>

						</div>

						<input type="text" class="form-control" data-toggle="popover"
							title="Login de usuario"
							data-content="Aqui tienes que poner el nombre de tu usuario."
							placeholder="Username">

						<div class="input-group-prepend">

							<span class="input-group-text"><span
								class="glyphicon glyphicon-lock"></span></span>

						</div>

						<input type="password" class="form-control" data-toggle="popover"
							title="Contraseña de usuario"
							data-content="Aqui tienes que poner la contraseña de tu usuario."
							placeholder="Password">
					</div>

				</form>
		</nav>

		<h2 class="mt-4 ml-4">Car List</h2>
		<div class="col-12 mt-3 mb-2 table-responsive">
			<table class="table table-hover table-striped table-bordered">
				<thead>
					<tr class="bg-warning">
						<td colspan="7">
							<div class="row ml-2 mt-3 mb-2 d-flex justify-content-between">
								<h2 class="float-left align-self-center">Filters:</h2>
								<div class="form-group col-2 align-self-center">
									<select class="form-control" id="sel1">
										<option value="">-By Make-</option>
										<%
											List<String> makes = (List<String>) request.getAttribute("makes");
					
											if (makes != null) {
					
												for (String m : makes) {
										%>
											<option value="<%=m%>"><%=m%></option>
										<%
											}
					
										}
										%>											
									</select>
								</div>
								<div class="form-group col-2 align-self-center">
									<select class="form-control" id="sel2">
										<option value="">-By Year-</option>
										<%
											List<Integer> years = (List<Integer>) request.getAttribute("years");
					
											if (years != null) {
					
												for (Integer y : years) {
										%>
											<option value="<%=y%>"><%=y%></option>
										<%
											}
					
										}
										%>										
									</select>
								</div>
								<h5 class="align-self-center">
									The result has <b><%=request.getAttribute("total") %></b> cars
								</h5>
								<form class="form-inline mr-2 align-self-center">
									<input class="form-control mr-sm-2" type="search"
										placeholder="Search" aria-label="Search">
									<button class="btn btn-outline-dark mr-5" type="submit">Search</button>
								</form>
							</div>


						</td>
					</tr>
					<tr class="table-warning text-center">
						<th scope="col">ID</th>
						<th scope="col">Model</th>
						<th scope="col">Make</th>
						<th scope="col">Year</th>
						<th scope="col">Classification</th>
						<th scope="col">Fuel type</th>
						<th scope="col">Actions</th>
					</tr>
				</thead>
				<tbody class="text-center">
					<%
						List<Car> cars = (List<Car>) request.getAttribute("cars");

					if (cars != null) {

						for (Car c : cars) {
					%>
					<tr>
						<th><%=c.getPk()%></th>
						<td><%=c.getIdentification().getId()%></td>
						<td><%=c.getIdentification().getMake()%></td>
						<td><%=c.getIdentification().getYear()%></td>
						<td><%=c.getIdentification().getClassification()%></td>
						<td><%=c.getFuelinformation().getFueltype()%></td>
						<td>
							<button type="button" class="btn btn-default">
								<span class="glyphicon glyphicon-eye-open"></span>
							</button>
							<button type="button" class="btn btn-default">
								<span class="glyphicon glyphicon-pencil"></span>
							</button>
							<button type="button" class="btn btn-default">
								<span class="glyphicon glyphicon-trash"></span>
							</button>
						</td>
					</tr>
					<%
						}

					}
					%>
				</tbody>
			</table>
			<div aria-label="Page navigation example">
				<ul class="pagination ml-2">
					<li class="page-item"><a
						class="page-link text-warning font-weight-bold" href="#"
						tabindex="-1">First</a></li>
					<li class="page-item"><a
						class="page-link text-warning font-weight-bold" href="#">1</a></li>
					<li class="page-item"><a class="page-link text-warning"
						href="#">2</a></li>
					<li class="page-item"><a class="page-link text-warning"
						href="#">3</a></li>
					<li class="page-item"><a class="page-link text-warning"
						href="#">4</a></li>
					<li class="page-item"><a class="page-link text-warning"
						href="#">5</a></li>
					<li class="page-item"><a
						class="page-link text-warning text-warning font-weight-bold"
						href="#">Last</a></li>
				</ul>
			</div>
		</div>

	</div>
</body>
</html>