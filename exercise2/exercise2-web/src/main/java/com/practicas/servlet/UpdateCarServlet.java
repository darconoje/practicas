package com.practicas.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.practicas.model.Car;
import com.practicas.services.CarService;
import com.practicas.services.data.DatabaseJson;

@WebServlet(name = "UpdateCarServlet", urlPatterns = { "/update" })
public class UpdateCarServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doGet(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*String transmission = request.getParameter("transmission");
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
		String fueltype = request.getParameter("fueltype");	*/
		
		
		String pk = request.getParameter("pk");
		String redirect = request.getParameter("redirect");

		CarValidator carvalidator = new CarValidator();
		
		boolean valid = carvalidator.validateCar(request);

		if (valid == true) {
			/*CarService carservice = new CarService();

			Optional<Car> carOp = carservice.getCarByPk(Integer.valueOf(pk));

			if (carOp.isPresent()) {

				Car car = carOp.get();

				car.getEngineinformation().setDriveline(driveline);
				car.getEngineinformation().setEnginetype(enginetype);

				int contador = 0;
				for (Car c : DatabaseJson.loadDatabase().getDataParsed()) {
					if (c.getPk() == Integer.valueOf(pk)) {
						DatabaseJson.loadDatabase().getDataParsed().set(contador, c);
					}
					contador++;
				}
				
			}*/

			if (redirect.equals("")) {
				response.sendRedirect("./cars");
			} else {
				response.sendRedirect("./cars?" + decodeValue(redirect));
			}
		}
	}

	public static String decodeValue(String value) {
		String result = "";
		try {
			result = java.net.URLDecoder.decode(value, StandardCharsets.UTF_8.name());
		} catch (UnsupportedEncodingException e) {
			// not going to happen - value came from JDK's own StandardCharsets
		}
		return result;
	}

}