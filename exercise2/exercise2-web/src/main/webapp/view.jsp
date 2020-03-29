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

		<h2 class="mt-4 ml-4 font-weight-bold">Car View</h2>

		<form class="my-4 mx-5 needs-validation" novalidate>

			<h4 class="font-weight-bold">Engine Information</h4>
			<fieldset class="form-group">

				<div class="form-group">
					<label class="mt-2 col-form-label" for="transmission">Transmission:</label>
					<div class="form-row ml-2">
						<select class="custom-select my-1 col-4" id="transmission"
							required>
							<option value="">Choose...</option>
							<%
								List<String> transmissions = (List<String>) request.getAttribute("transmissions");

							if (transmissions != null) {

								for (String t : transmissions) {
							%>
							<option value="<%=t%>"><%=t%></option>
							<%
								}

							}
							%>							
						</select>
						<div class="valid-feedback">
        					Looks good!
      					</div>
						<div class="invalid-feedback">
        					You must choose a valid option
      					</div>      					
					</div>
				</div>

				<div class="form-group">
					<label class="mt-2 col-form-label" for="engineType">Engine
						Type:</label> <input type="text" class="form-control mb-2 col-4"
						id="engineType" required>
					<div class="valid-feedback">
        				Looks good!
      				</div>	
					<div class="invalid-feedback">
        				You must fill this field
      				</div>      				
				</div>

				<h4 class="mt-2">Engine Statistics</h4>
				<fieldset class="form-group">
					<div class="form-group row">
						<div class="col-4">
							<label class="col-4 col-form-label" for="horsepower">Horsepower:</label>
							<input id="horsepower" name="horsepower" type="number"
								class="form-control ml-3" min="1" required>
							<div class="valid-feedback pl-3">
        						Looks good!
      						</div>
							<div class="invalid-feedback pl-3">
        						Must be a number greater than 0
      						</div>      														
						</div>
						<div class="col-4">
							<label class="col-4 col-form-label" for="torque">Torque:</label>
							<input id="torque" name="torque" type="number"
								class="form-control ml-3" min="1" required>
							<div class="valid-feedback pl-3">
        						Looks good!
      						</div>
							<div class="invalid-feedback pl-3">
        						Must be a number greater than 0
      						</div>       														
						</div>
					</div>
				</fieldset>

				<div class="form-group">
					<div class="form-row">
						<label class="mt-2 col-form-label" for="hybrid">Hybrid:</label>
							<div class="form-check ml-1 mt-3">
								<input class="form-check-input valid" type="checkbox" name="hybrid"
									id="hybrid">
							</div> 				
					</div>
				</div>

				<div class="form-group">
					<label class="mt-2 col-form-label" for="numberOfForwardGears">Number
						of Forward Gears:</label>
					<div class="form-row ml-2">
						<select class="custom-select my-1 col-4" id="numberOfForwardGears"
							required>
							<option value="">Choose...</option>
							<%
								List<Integer> forwardgears = (List<Integer>) request.getAttribute("forwardgears");

							if (forwardgears != null) {

								for (Integer fg : forwardgears) {
							%>
							<option value="<%=fg%>"><%=fg%></option>
							<%
								}

							}
							%>							
						</select>
						<div class="valid-feedback">
        					Looks good!
      					</div>
						<div class="invalid-feedback">
        					You must choose a valid option
      					</div>      											
					</div>
				</div>

				<div class="form-group">
					<label class="mt-2 col-form-label" for="driveline">Driveline:</label>
					<div class="form-row ml-2">
						<select class="custom-select my-1 col-4" id="driveline" required>
							<option value="">Choose...</option>
							<%
								List<String> drivelines = (List<String>) request.getAttribute("drivelines");

							if (drivelines != null) {

								for (String d : drivelines) {
							%>
							<option value="<%=d%>"><%=d%></option>
							<%
								}

							}
							%>								
						</select>
						<div class="valid-feedback">
        					Looks good!
      					</div>	
						<div class="invalid-feedback">
        					You must choose a valid option
      					</div>      										
					</div>
				</div>

			</fieldset>

			<h4 class="font-weight-bold">Identification</h4>
			<fieldset class="form-group">

				<div class="form-group">
					<label class="mt-2 col-form-label" for="make">Make:</label>
					<div class="form-row ml-2">
						<select class="custom-select my-1 col-4" id="make" required>
							<option value="">Choose...</option>
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
						<div class="valid-feedback">
        					Looks good!
      					</div>	
						<div class="invalid-feedback">
        					You must choose a valid option
      					</div>      										
					</div>
				</div>

				<div class="form-group">
					<label class="mt-2 col-form-label" for="modelYear">Model
						Year:</label> <input type="text" class="form-control mb-2 col-4"
						id="modelYear" required>
						<div class="valid-feedback">
        					Looks good!
      					</div>
						<div class="invalid-feedback">
        					You must fill this field
      					</div>      											
				</div>

				<div class="form-group">
					<label class="mt-2 col-form-label" for="model">Model:</label> <input
						type="text" class="form-control mb-2 col-4" id="model" required>
					<div class="valid-feedback">
        				Looks good!
      				</div>		
					<div class="invalid-feedback">
        				You must fill this field
      				</div>      								
				</div>

				<div class="form-group">
					<label class="mt-2 col-form-label" for="classification">Classification:</label>
					<div class="form-row ml-2">
						<select class="custom-select my-1 col-4" id="classification"
							required>
							<option value="">Choose...</option>
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
						<div class="valid-feedback">
        					Looks good!
      					</div>
						<div class="invalid-feedback">
        					You must choose a valid option
      					</div>      											
					</div>
				</div>

				<div class="form-group">
					<label class="mt-2 col-form-label" for="year">Year:</label>
					<div class="form-row ml-2">
						<select class="custom-select my-1 col-4" id="year" required>
							<option value="">Choose...</option>
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
						<div class="valid-feedback">
        					Looks good!
      					</div>	
						<div class="invalid-feedback">
        					You must choose a valid option
      					</div>      										
					</div>
				</div>

			</fieldset>

			<h4 class="font-weight-bold">Dimensions</h4>
			<fieldset class="form-group">

				<div class="form-group">
					<label class="mt-2 col-form-label" for="width">Width:</label> <input
						type="number" class="form-control mb-2 col-4" id="width" min="1"
						required>
					<div class="valid-feedback">
        				Looks good!
      				</div>
					<div class="invalid-feedback">
        				Must be a number greater than 0
      				</div>      										
				</div>

				<div class="form-group">
					<label class="mt-2 col-form-label" for="length">Length:</label> <input
						type="number" class="form-control mb-2 col-4" id="length" min="1"
						required>
					<div class="valid-feedback">
        				Looks good!
      				</div>
					<div class="invalid-feedback">
        				Must be a number greater than 0
      				</div>      										
				</div>

				<div class="form-group">
					<label class="mt-2 col-form-label" for="height">Height:</label> <input
						type="number" class="form-control mb-2 col-4" id="height" min="1"
						required>
					<div class="valid-feedback">
        				Looks good!
      				</div>	
					<div class="invalid-feedback">
        				Must be a number greater than 0
      				</div>      									
				</div>

			</fieldset>

			<h4 class="font-weight-bold">Fuel Information</h4>
			<fieldset class="form-group">

				<div class="form-group">
					<label class="mt-2 col-form-label" for="highwayMpg">Highway
						Mpg:</label> <input type="number" class="form-control mb-2 col-4"
						id="highwayMpg" min="1" required>
					<div class="valid-feedback">
        				Looks good!
      				</div>
					<div class="invalid-feedback">
        				Must be a number greater than 0
      				</div>        										
				</div>

				<div class="form-group">
					<label class="mt-2 col-form-label" for="cityMph">City Mph:</label>
					<input type="number" class="form-control mb-2 col-4" id="cityMph"
						min="1" required>
					<div class="valid-feedback">
        				Looks good!
      				</div>
					<div class="invalid-feedback">
        				Must be a number greater than 0
      				</div>       										
				</div>

				<div class="form-group">
					<label class="mt-2 col-form-label" for="fuelType">Fuel
						Type:</label>
					<div class="form-row ml-2">
						<select class="custom-select my-1 col-4" id="fuelType" required>
							<option value="">Choose...</option>
							<%
								List<String> fueltypes = (List<String>) request.getAttribute("fueltypes");

							if (fueltypes != null) {

								for (String ft : fueltypes) {
							%>
							<option value="<%=ft%>"><%=ft%></option>
							<%
								}

							}
							%>							
						</select>
						<div class="valid-feedback">
        					Looks good!
      					</div>		
						<div class="invalid-feedback">
        					You must choose a valid option
      					</div>      									
					</div>
				</div>

			</fieldset>
			
			<div class="form-row ml-2 mt-4">
				<button type="submit" class="btn btn-lg btn-warning" id="submit">Update</button>
				<button type="button" class="btn btn-lg btn-warning ml-4" id="back">Back</button>		
			</div>

		</form>

		<%
			String id = (String) request.getAttribute("id");
		String pagei = (String) request.getAttribute("page");
		String filterMake = (String) request.getAttribute("filterMake");
		String filterYear = (String) request.getAttribute("filterYear");
		Car car = (Car) request.getAttribute("car");
		
		String carTransmission = (String) car.getEngineinformation().getTransmission();
		String carEngineType = (String) car.getEngineinformation().getEnginetype();
		String carHorsepower = String.valueOf(car.getEngineinformation().getEnginestatistics().getHorsepower());
		String carTorque = String.valueOf(car.getEngineinformation().getEnginestatistics().getTorque());
		String carHybrid = String.valueOf(car.getEngineinformation().isHybrid());
		String carForwardGears = String.valueOf(car.getEngineinformation().getNumberofforwardgears());
		String carDriveline = (String) car.getEngineinformation().getDriveline();
		String carMake = (String) car.getIdentification().getMake();
		String carModelYear = (String) car.getIdentification().getModelyear();
		String carModel = (String) car.getIdentification().getId();
		String carClassification = (String) car.getIdentification().getClassification();
		String carYear = String.valueOf(car.getIdentification().getYear());
		String carWidth = String.valueOf(car.getDimensions().getWidth());
		String carLength = String.valueOf(car.getDimensions().getLength());
		String carHeight = String.valueOf(car.getDimensions().getHeight());
		String carHighwayMpg = String.valueOf(car.getFuelinformation().getHighwaympg());
		String carCityMph = String.valueOf(car.getFuelinformation().getCitymph());
		String carFuelType = (String) car.getFuelinformation().getFueltype();
		%>

	</div>

	<script>
		$(document).ready(function(){
			$("#transmission option[value='<%=carTransmission%>']").attr('selected', 'selected');	
			$("#engineType").val('<%=carEngineType%>');
			$("#horsepower").val('<%=carHorsepower%>');
			$("#torque").val('<%=carTorque%>');
			$("#numberOfForwardGears option[value='<%=carForwardGears%>']").attr('selected', 'selected');
			$("#driveline option[value='<%=carDriveline%>']").attr('selected', 'selected');	
			$("#make option[value='<%=carMake%>']").attr('selected', 'selected');
			$("#modelYear").val('<%=carModelYear%>');
			$("#model").val('<%=carModel%>');
			$("#classification option[value='<%=carClassification%>']").attr('selected', 'selected');
			$("#year option[value='<%=carYear%>']").attr('selected', 'selected');
			$("#width").val('<%=carWidth%>');
			$("#length").val('<%=carLength%>');
			$("#height").val('<%=carHeight%>');
			$("#highwayMpg").val('<%=carHighwayMpg%>');
			$("#cityMph").val('<%=carCityMph%>');
			$("#fuelType option[value='<%=carFuelType%>']").attr('selected', 'selected');
			
			if(!document.getElementById("hybrid").checked) {
			    document.getElementById('hybrid').value = "false";
			}else{
				document.getElementById('hybrid').value = "true";
			}
			
			$('#hybrid').click(function(){
				if(!document.getElementById("hybrid").checked) {
				    document.getElementById('hybrid').value = "false";
				}else{
					document.getElementById('hybrid').value = "true";
				}			
			});	
		});	
		
		$('#back').click(function(){
			location.href = './cars?action=pagination&filterYear=<%=filterYear%>&filterMake=<%=filterMake%>&page=<%=pagei%>';
		});

		(function() {
		  'use strict';
		  window.addEventListener('load', function() {
		    var forms = document.getElementsByClassName('needs-validation');
		    var validation = Array.prototype.filter.call(forms, function(form) {
		      form.addEventListener('submit', function(event) {
		        if (form.checkValidity() === false) {
		          event.preventDefault();
		          event.stopPropagation();
		        }
		        form.classList.add('was-validated');
		      }, false);
		    });
		  }, false);
		})();
	</script>
</body>
</html>