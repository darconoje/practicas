<%@page import="java.io.UnsupportedEncodingException"%>
<%@page import="java.nio.charset.StandardCharsets"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="com.practicas.model.Car"%>
<%@page import="java.util.List"%>
<%@page import="com.practicas.listeners.SessionListener"%>
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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
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
					<%
					String username = (String) session.getAttribute("username");
					%>
					<div class="row">
										<p class="mr-5">
						Welcome, <b><%=username%></b>. There are <b><span
							id="onlineusers">...</span></b> users online. <a href="./logout"
							id="logout" class="btn btn-lg btn-light ml-3 border border-dark"
							role="button" aria-disabled="true">Log out</a>
					</p>
					</div>
				</div>	

		</nav>
		<%
			
		%>
		<h2 class="mt-4 ml-4 font-weight-bold">Car List</h2>
		<div class="col-12 mt-3 mb-2 table-responsive">
			<table class="table table-hover table-striped table-bordered">
				<thead>
					<tr class="bg-warning">
						<td colspan="8">
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
								<div class="form-group col-2 align-self-center">
									<select class="form-control" id="filterHybrid">
										<option value="null">-By Hybrid (Any)-</option>
										<option value="true">True</option>
										<option value="false">False</option>
									</select>
								</div>
								<div class="form-group col-2 align-self-center">
									<select class="form-control" id="filterClassification">
										<option value="null">-By Classification (Any)-</option>
										<%
											List<String> classifications = (List<String>) request.getAttribute("classifications");

										if (classifications != null) {

											for (String c : classifications) {
										%>
										<option value="<%=c%>"><%=c%></option>
										<%
											}

										}
										%>
									</select>
								</div>
								<h5 class="align-self-center mr-5">
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
							</div>


						</td>
					</tr>
					<tr class="table-warning text-center">
						<th scope="col">ID</th>
						<th scope="col">Model</th>
						<th scope="col">Make
							<button type="button" class="btn btn-default" id="sortMake">
								<span class="glyphicon glyphicon glyphicon-sort"></span>
							</button>
						</th>
						<th scope="col">Year
							<button type="button" class="btn btn-default" id="sortYear">
								<span class="glyphicon glyphicon glyphicon-sort"></span>
							</button>
						</th>
						<th scope="col">Classification</th>
						<th scope="col">Fuel type</th>
						<th scope="col">Hybrid</th>
						<th scope="col">Actions</th>
					</tr>
				</thead>
				<tbody class="text-center">
					<%
						List<Car> cars = (List<Car>) request.getAttribute("cars");

					if (cars != null && cars.size()!=0) {

						for (Car c : cars) {
					%>
					<tr>
						<th><%=c.getPk()%></th>
						<td><%=c.getIdentification().getId()%></td>
						<td><%=c.getIdentification().getMake()%></td>
						<td><%=c.getIdentification().getYear()%></td>
						<td><%=c.getIdentification().getClassification()%></td>
						<td><%=c.getFuelinformation().getFueltype()%></td>
						<td><%=c.getEngineinformation().isHybrid()%></td>
						<td>
							<button type="button" class="btn btn-warning botonVer"
								id="<%=c.getPk()%>">
								<span class="glyphicon glyphicon-eye-open"></span>
							</button>
							<button type="button" class="btn btn-warning">
								<span class="glyphicon glyphicon-trash"></span>
							</button>
						</td>
					</tr>
					<%
						}

					}else{ %> 
					
						<tr><td colspan="8">No matching records found</td></tr> 
					
					<% } %>
						
					
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
			String ishybrid = (String) request.getAttribute("ishybrid");
			String classification = (String) request.getAttribute("classification");
			String sortmake = (String) request.getParameter("sortMake");
			String sortyear = (String) request.getParameter("sortYear");

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

			if (carcount % 10 == 0) {
				lastpage--;
			}

			if (carcount <= 10) {

			} else {
			%>


			<div aria-label="Page navigation example">
				<ul class="pagination ml-2">
					<li class="page-item<%if (pagei <= 0) {%> disabled <%}%>"><a
						class="page-link <%if (pagei > 0) {%>text-warning font-weight-bold<%}%>"
						href="<%if (year == null && make == null && ishybrid == null && classification == null && sortmake == null && sortyear == null
		&& pagei > 0) {%>./cars?action=pagination&page=0
						<%} else if (year != null && make != null && ishybrid != null && classification != null && pagei > 0) {%>./cars?action=pagination&filterYear=
						<%=year%>&filterMake=<%=make%>&filterHybrid=<%=ishybrid%>&filterClassification=<%=classification%>&sortMake=<%=sortmake%>&sortYear=<%=sortyear%>&page=0 <%}%>"
						<%if (pagei <= 0) {%> tabindex="-1" aria-disabled="true" <%}%>>&lt;&lt;</a></li>
					<li class="page-item <%if (prev < -1) {%> disabled <%}%>"><a
						class="page-link <%if (prev > -1) {%>text-warning font-weight-bold<%}%>"
						<%if (prev > -1) {%>
						href="<%if (year == null && make == null && ishybrid == null && classification == null && sortmake == null
			&& sortyear == null) {%>./cars?action=pagination&page=<%=prev%>
						<%} else if (year != null && make != null && ishybrid != null && classification != null) {%>./cars?action=pagination&filterYear=
						<%=year%>&filterMake=<%=make%>&filterHybrid=<%=ishybrid%>&filterClassification=<%=classification%>&sortMake=<%=sortmake%>&sortYear=<%=sortyear%>&page=<%=prev%><%}%>"
						<%}%> <%if (prev < -1) {%> tabindex="-1" aria-disabled="true"
						<%}%>>&lt;</a></li>
					<%
						if (prev - 2 < -1) {
					} else {
					%>
					<li class="page-item"><a class="page-link text-warning"
						href="<%if (year == null && make == null && ishybrid == null && classification == null && sortmake == null
		&& sortyear == null) {%>./cars?action=pagination&page=<%=pagei - 2%>
						<%} else if (year != null && make != null && ishybrid != null && classification != null) {%>./cars?action=pagination&filterYear=
						<%=year%>&filterMake=<%=make%>&filterHybrid=<%=ishybrid%>&filterClassification=<%=classification%>&sortMake=<%=sortmake%>&sortYear=<%=sortyear%>&page=<%=pagei - 2%><%}%>"><%=pagei - 2%></a></li>
					<%
						}
					%>
					<%
						if (prev - 1 < -1) {
					} else {
					%>
					<li class="page-item"><a class="page-link text-warning"
						href="<%if (year == null && make == null && ishybrid == null && classification == null && sortmake == null
		&& sortyear == null) {%>./cars?action=pagination&page=<%=pagei - 1%>
						<%} else if (year != null && make != null && ishybrid != null && classification != null) {%>./cars?action=pagination&filterYear=
						<%=year%>&filterMake=<%=make%>&filterHybrid=<%=ishybrid%>&filterClassification=<%=classification%>&sortMake=<%=sortmake%>&sortYear=<%=sortyear%>&page=<%=pagei - 1%><%}%>"><%=pagei - 1%></a></li>
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
						href="<%if (year == null && make == null && ishybrid == null && classification == null && sortmake == null
		&& sortyear == null) {%>./cars?action=pagination&page=<%=pagei + 1%>
						<%} else if (year != null && make != null && ishybrid != null && classification != null) {%>./cars?action=pagination&filterYear=
						<%=year%>&filterMake=<%=make%>&filterHybrid=<%=ishybrid%>&filterClassification=<%=classification%>&sortMake=<%=sortmake%>&sortYear=<%=sortyear%>&page=<%=pagei + 1%><%}%>"><%=pagei + 1%></a></li>
					<%
						}
					%>
					<%
						if (next + 1 > lastpage) {

					} else {
					%>
					<li class="page-item"><a class="page-link text-warning"
						href="<%if (year == null && make == null && ishybrid == null && classification == null && sortmake == null
		&& sortyear == null) {%>./cars?action=pagination&page=<%=pagei + 2%>
						<%} else if (year != null && make != null && ishybrid != null && classification != null) {%>./cars?action=pagination&filterYear=
						<%=year%>&filterMake=<%=make%>&filterHybrid=<%=ishybrid%>&filterClassification=<%=classification%>&sortMake=<%=sortmake%>&sortYear=<%=sortyear%>&page=<%=pagei + 2%><%}%>"><%=pagei + 2%></a></li>
					<%
						}
					%>
					<li class="page-item<%if (pagei == lastpage) {%> disabled <%}%>"><a
						class="page-link <%if (pagei < lastpage) {%>text-warning font-weight-bold<%}%>"
						href="<%if (year == null && make == null && ishybrid == null && classification == null && sortmake == null && sortyear == null
		&& pagei < lastpage) {%>./cars?action=pagination&page=<%=next%>
						<%} else if (year != null && make != null && ishybrid != null && classification != null && pagei < lastpage
		&& sortmake != null && sortyear != null) {%>./cars?action=pagination&filterYear=
						<%=year%>&filterMake=<%=make%>&filterHybrid=<%=ishybrid%>&filterClassification=<%=classification%>&sortMake=<%=sortmake%>&sortYear=<%=sortyear%>&page=<%=next%> <%}%>"
						<%if (pagei == lastpage) {%> tabindex="-1" aria-disabled="true"
						<%}%>>&gt;</a></li>
					<li class="page-item<%if (pagei == lastpage) {%> disabled <%}%>"><a
						class="page-link <%if (pagei < lastpage) {%>text-warning font-weight-bold<%}%>"
						href="<%if (year == null && make == null && ishybrid == null && classification == null && sortmake == null && sortyear == null
		&& pagei < lastpage) {%>./cars?action=pagination&page=<%=lastpage%>
						<%} else if (year != null && make != null && ishybrid != null && classification != null && pagei < lastpage) {%>./cars?action=pagination&filterYear=
						<%=year%>&filterMake=<%=make%>&filterHybrid=<%=ishybrid%>&filterClassification=<%=classification%>&sortMake=<%=sortmake%>&sortYear=<%=sortyear%>&page=<%=lastpage%> <%}%>"
						<%if (pagei == lastpage) {%> tabindex="-1" aria-disabled="true"
						<%}%>>&gt;&gt;</a></li>
				</ul>
			</div>
			<%
				}
			%>
			<a href="./cars?display=datatable">Datatable Version</a>
		</div>
		<input type="hidden" name="page" id="page" value="<%=pagei%>" /> <input
			type="hidden" name="makeFilterValue" id="makeFilterValue"
			value="<%=make%>" /> <input type="hidden" name="yearFilterValue"
			id="yearFilterValue" value="<%=year%>" /> <input type="hidden"
			name="hybridFilterValue" id="hybridFilterValue" value="<%=ishybrid%>" />
		<input type="hidden" name="classificationFilterValue"
			id="classificationFilterValue" value="<%=classification%>" /> <input
			type="hidden" name="sortYearValue" id="sortYearValue"
			value="<%=sortyear%>" /> <input type="hidden" name="sortMakeValue"
			id="sortMakeValue" value="<%=sortmake%>" />
	</div>

	<%!private static String encodeValue(String value) {
		String url = "";
		try {
			url = URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
		} catch (Exception ex) {

		}
		return url;
	}%>

	<script>
	
		$(document)
				.ready(
						function() {
							
						    setInterval(function(){ 
								$.ajax({
								    url: './cars',
								    type: 'GET',
								    data: 'ajax=onlineusers',
								    success: function(data){
								    	$("#onlineusers").text(data);
								    }
								})
						    }, 3000);

							
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
														+ '&filterHybrid='
														+ $('#hybridFilterValue')
																.val()
														+ '&filterClassification='
														+ $('#classificationFilterValue')
																.val()
														+ '&sortMake=null'
														+ '&sortYear=null'
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
														+ valor 
														+ '&filterHybrid='
														+ $('#hybridFilterValue')
																.val()
														+ '&filterClassification='
														+ $('#classificationFilterValue')
																.val()		
														+ '&sortMake=null'
														+ '&sortYear=null'															
														+ '&page=0';
											});
							
							$('#filterHybrid')
							.change(
									function() {
										var valor = $(this).children(
												"option:selected")
												.val();
										location.href = './cars?action=pagination&filterYear='
												+ $('#yearFilterValue')
														.val()
												+ '&filterMake='
												+ $('#makeFilterValue')
														.val()
												+ '&filterHybrid='
												+ valor
												+ '&filterClassification='
												+ $('#classificationFilterValue')
														.val()	
												+ '&sortMake=null'
												+ '&sortYear=null'												
												+ '&page=0';
									});
							
							$('#filterClassification')
							.change(
									function() {
										var valor = $(this).children(
												"option:selected")
												.val();
										location.href = './cars?action=pagination&filterYear='
												+ $('#yearFilterValue')
														.val()
												+ '&filterMake='
												+ $('#makeFilterValue')
														.val()
												+ '&filterHybrid='
												+ $('#hybridFilterValue')
														.val()
												+ '&filterClassification='
												+ valor			
												+ '&sortMake=null'
												+ '&sortYear=null'											
												+ '&page=0';
									});
							$('#sortYear').click(function(){


								if($('#sortYearValue').val()=='asc'){
									$('#sortYearValue').val("desc");									
								}else if($('#sortYearValue').val()=='desc'){
									$('#sortYearValue').val("null");
								}else{
									$('#sortYearValue').val("asc");
								}

								$('#sortMakeValue').val("null");
								location.href = './cars?action=pagination&filterYear='
									+ $('#yearFilterValue')
											.val()
									+ '&filterMake='
									+ $('#makeFilterValue')
											.val()
									+ '&filterHybrid='
									+ $('#hybridFilterValue')
											.val()
									+ '&filterClassification='
									+ $('#classificationFilterValue')
											.val()	
									+ '&sortMake='
									+ $('#sortMakeValue')
											.val()
									+ '&sortYear='
									+ $('#sortYearValue')
											.val()														
									+ '&page='
									+ $('#page').val();
						});

							$('#sortMake').click(function(){
								if($('#sortMakeValue').val()=='asc'){
									$('#sortMakeValue').val("desc");									
								}else if($('#sortMakeValue').val()=='desc'){
									$('#sortMakeValue').val("null");
								}else{
									$('#sortMakeValue').val("asc");
								}


								$('#sortYearValue').val("null");
								location.href = './cars?action=pagination&filterYear='
									+ $('#yearFilterValue')
											.val()
									+ '&filterMake='
									+ $('#makeFilterValue')
											.val()
									+ '&filterHybrid='
									+ $('#hybridFilterValue')
											.val()
									+ '&filterClassification='
									+ $('#classificationFilterValue')
											.val()	
									+ '&sortMake='
									+ $('#sortMakeValue')
											.val()
									+ '&sortYear='
									+ $('#sortYearValue')
											.val()														
									+ '&page='
									+ $('#page').val();;
						});
						

							
							<%if (year != null) {%>
								$("#filterYear option[value=<%=year%>]").attr('selected', 'selected');
							<%}%>
							<%if (make != null) {%>
								$("#filterMake option[value='<%=make%>']").attr('selected', 'selected');
							<%}%>
							<%if (ishybrid != null) {%>
								$("#filterHybrid option[value='<%=ishybrid%>']").attr('selected', 'selected');
							<%}%>
							<%if (classification != null) {%>
								$("#filterClassification option[value='<%=classification%>']").attr('selected', 'selected');
							<%}%>							
						});
		
		
		$('.botonVer').click(function() {
			var id = this.id;
			location.href = './cars?action=pagination&filterYear=<%=year%>&filterMake=<%=make%>&filterHybrid=<%=ishybrid%>&filterClassification=<%=classification%>&sortMake=<%=sortmake%>&sortYear=<%=sortyear%>&page=<%=pagei%>&id='+id+'&redirect=<%=encodeValue(request.getQueryString())%>';
						});
	</script>
</body>
</html>