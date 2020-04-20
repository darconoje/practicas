package com.practicas.servlet;

import javax.servlet.http.HttpServletRequest;

public class CarValidator {

	boolean validateCar(HttpServletRequest request) {
		boolean valid = false;
		
		String transmission = request.getParameter("transmission");
		String enginetype = request.getParameter("enginetype");
		String horsepower = request.getParameter("horsepower");
		String torque = request.getParameter("torque");
		String hybrid = request.getParameter("hybrid");
		if(hybrid==null) {
			hybrid = "false";
		}
		String forwardgears = request.getParameter("numberofforwardgears");
		String driveline = request.getParameter("driveline");
		String make = request.getParameter("make");
		String modelyear = request.getParameter("modelyear");
		String model = request.getParameter("model");
		String classification = request.getParameter("classification");
		String year = request.getParameter("year");
		String width = request.getParameter("width");
		String length = request.getParameter("length");
		String height = request.getParameter("height");
		String highwaympg = request.getParameter("highwaympg");
		String citymph = request.getParameter("citymph");
		String fueltype = request.getParameter("fueltype");						
		
		if (!transmission.equals("") && transmission != null && !enginetype.equals("") && enginetype != null
				&& Integer.valueOf(horsepower) > 0 && horsepower != null && Integer.valueOf(torque) > 0
				&& torque != null && hybrid != null && !forwardgears.equals("") && forwardgears != null
				&& !driveline.equals("") && driveline != null && !make.equals("") && make != null
				&& !modelyear.equals("") && modelyear != null && !model.equals("") && model != null
				&& !classification.equals("") && classification != null && !year.equals("") && year != null
				&& Integer.valueOf(width) > 0 && width != null && Integer.valueOf(length) > 0 && length != null
				&& Integer.valueOf(height) > 0 && height != null && Integer.valueOf(highwaympg) > 0
				&& highwaympg != null && Integer.valueOf(citymph) > 0 && citymph != null && !fueltype.equals("")
				&& fueltype != null) {

			valid = true;

		}
		
		return valid;
	}
	
}
