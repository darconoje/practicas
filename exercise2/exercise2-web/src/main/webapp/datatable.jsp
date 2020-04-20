<%@page import="java.io.UnsupportedEncodingException"%>
<%@page import="java.nio.charset.StandardCharsets"%>
<%@page import="java.net.URLEncoder"%>
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
<link
	href="//cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css"
	rel="stylesheet">
<script
	src="//cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>	
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
				<h2 class="mt-4 ml-4 font-weight-bold">Car List</h2>
				<div class="col-12 mt-3 mb-2 table-responsive">
<table id="example" class="table table-hover table-striped table-bordered" style="width:100%">
<thead class="bg-warning">

</thead>
<tbody>
</tbody>
<tfoot class="bg-warning">
<tr>
						<th scope="col"></th>
						<th scope="col"></th>
						<th scope="col"></th>
						<th scope="col"></th>
						<th scope="col"></th>
						<th scope="col"></th>
						<th scope="col"></th>
						<th scope="col"></th>
</tr>
</tfoot>
</table>
<a href="./cars">Standard Version</a>
</div>
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
    $(document).ready(function() {
			
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
		    
 
    	
        $('#example').DataTable( {
            initComplete: function (settings,json) {
            	var makes = json.filters.makes;
            	var years = json.filters.years;
            	var classifications = json.filters.classifications;
            	var fueltypes = json.filters.fueltypes;
                this.api().columns(2).every( function () {
                    var column = this;
                    var select = $('<select><option value=""></option></select>')
                        .appendTo( $(column.footer()))
                        .on( 'change', function () {
                            var val = $.fn.dataTable.util.escapeRegex(
                                $(this).val()
                            );
     
                            column
                                .search( val ? '^'+val+'$' : '', true, false )
                                .draw();
                        } );
                    
                    for(i=0; i<makes.length;i++){
                    	select.append( '<option value="'+makes[i]+'">'+makes[i]+'</option>' );
                    }
                    
                } );
                this.api().columns(3).every( function () {
                    var column = this;
                    var select = $('<select><option value=""></option></select>')
                        .appendTo( $(column.footer()))
                        .on( 'change', function () {
                            var val = $.fn.dataTable.util.escapeRegex(
                                $(this).val()
                            );
     
                            column
                                .search( val ? '^'+val+'$' : '', true, false )
                                .draw();
                        } );
                    
                    for(i=0; i<years.length;i++){
                    	select.append( '<option value="'+years[i]+'">'+years[i]+'</option>' );
                    }
                    
                } );  
                this.api().columns(4).every( function () {
                    var column = this;
                    var select = $('<select><option value=""></option></select>')
                        .appendTo( $(column.footer()))
                        .on( 'change', function () {
                            var val = $.fn.dataTable.util.escapeRegex(
                                $(this).val()
                            );
     
                            column
                                .search( val ? '^'+val+'$' : '', true, false )
                                .draw();
                        } );
                    
                    for(i=0; i<classifications.length;i++){
                    	select.append( '<option value="'+classifications[i]+'">'+classifications[i]+'</option>' );
                    }
                    
                } ); 
                this.api().columns(5).every( function () {
                    var column = this;
                    var select = $('<select><option value=""></option></select>')
                        .appendTo( $(column.footer()))
                        .on( 'change', function () {
                            var val = $.fn.dataTable.util.escapeRegex(
                                $(this).val()
                            );
     
                            column
                                .search( val ? '^'+val+'$' : '', true, false )
                                .draw();
                        } );
                    
                    for(i=0; i<fueltypes.length;i++){
                    	select.append( '<option value="'+fueltypes[i]+'">'+fueltypes[i]+'</option>' );
                    }
                    
                } );
                this.api().columns(6).every( function () {
                    var column = this;
                    var select = $('<select><option value=""></option></select>')
                        .appendTo( $(column.footer()))
                        .on( 'change', function () {
                            var val = $.fn.dataTable.util.escapeRegex(
                                $(this).val()
                            );
     
                            column
                                .search( val ? '^'+val+'$' : '', true, false )
                                .draw();
                        } );
                    
                    	select.append( '<option value="true">True</option>' );
                    	select.append( '<option value="false">False</option>' );
                    
                } );                 
            },
            "processing": true,
            "serverSide": true,
            "ajax": {
            	url: './carsJSON',
                dataSrc: 'cars'           	
            },
	        "columns": [
	            { data: "pk"},
	            { data: "identification.id"	},
	            { data: "identification.make"},
	            { data: "identification.year"},
	            { data: "identification.classification"},
	            { data: "fuelinformation.fueltype"},
	            { data: "engineinformation.hybrid"}
	        ],
	        "columnDefs": [
	        	{ "className": "dt-center", "targets": [1,2,3,4,5,6,7]},
	            { "title": "ID", 'className': 'font-weight-bold dt-center', "targets": 0, "searchable": false},
	            { "title": "Model", "targets": 1, "orderable": false},
	            { "title": "Make", "targets": 2},
	            { "title": "Year", "targets": 3, "searchable": false},
	            { "title": "Classification", "targets": 4, "orderable": false, "searchable": false},
	            { "title": "Fuel type", "targets": 5, "orderable": false, "searchable": false},
	            { "title": "Hybrid", "targets": 6, "orderable": false, "searchable": false},
	            {
	            	"title": "Actions",
	                "targets": 7,
	                "data": 'pk',
	                "orderable": false,
	                "searchable": false,
	                "render": function (data, type, row, meta) {
	                    return '<a role="button" class="btn btn-warning botonVer" id='+data+' href="./cars?id='+data+'&redirect=<%=encodeValue(request.getQueryString())%>"><span class=\"glyphicon glyphicon-eye-open\"></span></a> <button class="btn btn-warning botonBorrar" id='+data+'><span class=\"glyphicon glyphicon-trash\"></span></button>'
	                }
	            }	            
	          ],
/* 	          "fnServerData": function ( sSource, aoData, fnCallback ) {
	              aoData.push( { "name": "more_data", "value": "my_value" } );
	              $.getJSON( sSource, aoData, function (json) { 
	                  fnCallback(json)
	              } );
	              console.log(aoData);
	          } */

        } );
        

        
    } );
    </script>	
</body>
</html>