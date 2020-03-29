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
		<%
			
		%>
		<h2 class="mt-4 ml-4 font-weight-bold">Car List</h2>
		<div class="col-12 mt-3 mb-2 table-responsive">
			<table class="table table-hover table-striped table-bordered">
				<thead>
					<tr class="bg-warning">
						<td colspan="7">
							<div class="row ml-2 mt-3 mb-2 d-flex justify-content-between">
								<h2 class="float-left align-self-center">Filters:</h2>
								<div class="form-group col-2 align-self-center">
									<select class="form-control" id="filterMake">
										<option value="null">-By Make (Any)-</option>
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
									<select class="form-control" id="filterYear">
										<option value="null">-By Year (Any)-</option>
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
									<%
										Long carcount = (Long) request.getAttribute("total");
									%>
									<%
										if (carcount == 0) {
									%>The result has <b>no</b> cars<%
										} else if (carcount == 1) {
									%>The result has <b>1</b> car<%
										} else {
									%>
									The result has <b><%=carcount%> </b> cars
									<%
 	}
 %>
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
							<button type="button" class="btn btn-default botonVer" id="<%=c.getPk()%>">
								<span class="glyphicon glyphicon-eye-open"></span>
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
			<%
				String year = (String) request.getAttribute("year");
			if (year != null && !year.equals("null")) {
				if (year.equals("0")) {
					year = "null";
				}
			}
			String make = (String) request.getAttribute("make");

			String pageActual = (String) request.getAttribute("page");

			int pagei = 0;
			if (pageActual != null) {
				pagei = Integer.valueOf(pageActual);
			}

			int prev = -1;
			int next = -1;
			if (pagei > 0) {
				prev = pagei - 1;
			}
			next = pagei + 1;

			long lastpage = carcount / 10;

			if (carcount <= 10) {

			} else {
			%>


			<div aria-label="Page navigation example">
				<ul class="pagination ml-2">
					<li class="page-item<%if (pagei <= 0) {%> disabled <%}%>"><a
						class="page-link <%if (pagei > 0) {%>text-warning font-weight-bold<%}%>"
						href="<%if (year == null && make == null && pagei > 0) {%>./cars?action=pagination&page=0
						<%} else if (year != null && make != null && pagei > 0) {%>./cars?action=pagination&filterYear=
						<%=year%>&filterMake=<%=make%>&page=0 <%}%>"
						<%if (pagei <= 0) {%> tabindex="-1" aria-disabled="true" <%}%>>&lt;&lt;</a></li>
					<li class="page-item <%if (prev < -1) {%> disabled <%}%>"><a
						class="page-link <%if (prev > -1) {%>text-warning font-weight-bold<%}%>"
						<%if (prev > -1) {%>
						href="<%if (year == null && make == null) {%>./cars?action=pagination&page=<%=prev%>
						<%} else if (year != null && make != null) {%>./cars?action=pagination&filterYear=
						<%=year%>&filterMake=<%=make%>&page=<%=prev%><%}%>"
						<%}%> <%if (prev < -1) {%> tabindex="-1" aria-disabled="true"
						<%}%>>&lt;</a></li>
					<%
						if (prev - 2 < -1) {
					} else {
					%>
					<li class="page-item"><a class="page-link text-warning"
						href="<%if (year == null && make == null) {%>./cars?action=pagination&page=<%=pagei - 2%>
						<%} else if (year != null && make != null) {%>./cars?action=pagination&filterYear=
						<%=year%>&filterMake=<%=make%>&page=<%=pagei - 2%><%}%>"><%=pagei - 2%></a></li>
					<%
						}
					%>
					<%
						if (prev - 1 < -1) {
					} else {
					%>
					<li class="page-item"><a class="page-link text-warning"
						href="<%if (year == null && make == null) {%>./cars?action=pagination&page=<%=pagei - 1%>
						<%} else if (year != null && make != null) {%>./cars?action=pagination&filterYear=
						<%=year%>&filterMake=<%=make%>&page=<%=pagei - 1%><%}%>"><%=pagei - 1%></a></li>
					<%
						}
					%>
					<li class="page-item"><a
						class="page-link text-warning font-weight-bold" href=""><u><%=pagei%></u></a></li>
					<%
						if (next > lastpage) {

					} else {
					%>
					<li class="page-item"><a class="page-link text-warning"
						href="<%if (year == null && make == null) {%>./cars?action=pagination&page=<%=pagei + 1%>
						<%} else if (year != null && make != null) {%>./cars?action=pagination&filterYear=
						<%=year%>&filterMake=<%=make%>&page=<%=pagei + 1%><%}%>"><%=pagei + 1%></a></li>
					<%
						}
					%>
					<%
						if (next + 1 > lastpage) {

					} else {
					%>
					<li class="page-item"><a class="page-link text-warning"
						href="<%if (year == null && make == null) {%>./cars?action=pagination&page=<%=pagei + 2%>
						<%} else if (year != null && make != null) {%>./cars?action=pagination&filterYear=
						<%=year%>&filterMake=<%=make%>&page=<%=pagei + 2%><%}%>"><%=pagei + 2%></a></li>
					<%
						}
					%>
					<li class="page-item<%if (pagei == lastpage) {%> disabled <%}%>"><a
						class="page-link <%if (pagei < lastpage) {%>text-warning font-weight-bold<%}%>"
						href="<%if (year == null && make == null && pagei < lastpage) {%>./cars?action=pagination&page=<%=next%>
						<%} else if (year != null && make != null && pagei < lastpage) {%>./cars?action=pagination&filterYear=
						<%=year%>&filterMake=<%=make%>&page=<%=next%> <%}%>"
						<%if (pagei == lastpage) {%> tabindex="-1" aria-disabled="true"
						<%}%>>&gt;</a></li>
					<li class="page-item<%if (pagei == lastpage) {%> disabled <%}%>"><a
						class="page-link <%if (pagei < lastpage) {%>text-warning font-weight-bold<%}%>"
						href="<%if (year == null && make == null && pagei < lastpage) {%>./cars?action=pagination&page=<%=lastpage%>
						<%} else if (year != null && make != null && pagei < lastpage) {%>./cars?action=pagination&filterYear=
						<%=year%>&filterMake=<%=make%>&page=<%=lastpage%> <%}%>"
						<%if (pagei == lastpage) {%> tabindex="-1" aria-disabled="true"
						<%}%>>&gt;&gt;</a></li>
				</ul>
			</div>
			<%
				}
			%>
		</div>
		<input type="hidden" name="page" id="page" value="<%=pagei%>" /> <input
			type="hidden" name="makeFilterValue" id="makeFilterValue"
			value="<%=make%>" /> <input type="hidden" name="yearFilterValue"
			id="yearFilterValue" value="<%=year%>" />
	</div>

	<script>
	
		$(document)
				.ready(
						function() {
							$('#filterYear')
									.change(
											function() {
												var valor = $(this).children(
														"option:selected")
														.val();
												location.href = './cars?action=pagination&filterYear='
														+ valor
														+ '&filterMake='
														+ $('#makeFilterValue')
																.val()
														+ '&page=0';
											});

							$('#filterMake')
									.change(
											function() {
												var valor = $(this).children(
														"option:selected")
														.val();
												location.href = './cars?action=pagination&filterYear='
														+ $('#yearFilterValue')
																.val()
														+ '&filterMake='
														+ valor + '&page=0';
											});
							
							<%if(year != null){ %>
								$("#filterYear option[value=<%=year%>]").attr('selected', 'selected');
							<%}%>
							<%if(make != null){ %>
							$("#filterMake option[value='<%=make%>']").attr('selected', 'selected');
						<%}%>
						});
		
		$('.botonVer').click(function() {
			var id = this.id;
			location.href = './cars?action=pagination&filterYear=<%=year%>&filterMake=<%=make%>&page=<%=pagei%>&id='+id;
							});


	</script>
</body>
</html>