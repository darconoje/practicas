<%@page import="java.io.UnsupportedEncodingException"%>
<%@page import="java.nio.charset.StandardCharsets"%>
<%@page import="com.practicas.model.Identification"%>
<%@page import="com.practicas.model.Car"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
List<String> makes = (List<String>)request.getAttribute("makes");
List<Integer> years = (List<Integer>)request.getAttribute("years");
List<Car> cars = (List<Car>) request.getAttribute("cars");
%>
{
	'filters':{
		'makes':[
			<%
			int totalmakes = makes.size();
			int contadormakes = 0;
			String sepmakes = ",";
			for (String make: makes){ 
				contadormakes ++;
				if(contadormakes == totalmakes){
					sepmakes="";
					
				}
			%>
				{
					'id': '<%=make %>',
					'value': '<%=make %>'
				}<%=sepmakes %>
			<%} %>
		],
		'years':[
			<%
			int totalyears = years.size();
			int contadoryears = 0;
			String sepyears = ",";
			for(Integer year: years){
				contadoryears ++;
				if(contadoryears == totalyears){
					sepyears="";
					
				}				
				
			%>
				{
					'id': '<%=year %>',
					'value': '<%=year %>'
				}<%=sepyears%>
			<%} %>
		]
	},
	'cars':[
	
	]
}