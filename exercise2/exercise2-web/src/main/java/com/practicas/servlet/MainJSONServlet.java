package com.practicas.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.practicas.model.Car;
import com.practicas.model.PaginaCompleta;
import com.practicas.services.CarComparator;
import com.practicas.services.CarMakeComparator;
import com.practicas.services.CarPkComparator;
import com.practicas.services.CarPredicate;
import com.practicas.services.CarYearComparator;

@WebServlet(name = "MainJSONServlet", urlPatterns = {
		"/carsJSON" }, initParams = @WebInitParam(name = "location", value = "Hola"), loadOnStartup = 1)
public class MainJSONServlet extends AbstractServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PaginaCompleta pagina = new PaginaCompleta();

		long countTotal = carService.totalCar();
		pagina.setRecordsTotal(countTotal);

		pagina.setRecordsFiltered(carService.totalCar());
		int draw = Integer.parseInt(request.getParameter("draw"));

		pagina.setDraw(draw);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		int start = Integer.parseInt(request.getParameter("start"));
		int length = Integer.parseInt(request.getParameter("length"));
		int end = start + length;

		CarPredicate p = new CarPredicate();
		List<Predicate<Car>> plist = new ArrayList<Predicate<Car>>();

		String make = (String) request.getParameter("columns[2][search][value]");
		String year = (String) request.getParameter("columns[3][search][value]");
		String classification = (String) request.getParameter("columns[4][search][value]");
		String fuelType = (String) request.getParameter("columns[5][search][value]");
		String hybrid = (String) request.getParameter("columns[6][search][value]");
		String search = request.getParameter("search[value]");

		if (make != null && !make.equals("")) {
			make = make.substring(1, make.length() - 1);
			plist.add(p.porMarca(make));
		}

		if (year != null && !year.equals("")) {
			year = year.substring(1, year.length() - 1);
			plist.add(p.porAnno(Integer.parseInt(year)));
		}

		if (classification != null && !classification.equals("")) {
			classification = classification.substring(1, classification.length() - 1);
			plist.add(p.porClasificacion(classification));
		}

		if (fuelType != null && !fuelType.equals("")) {
			fuelType = fuelType.substring(1, fuelType.length() - 1);
			plist.add(p.porTipoFuel(fuelType));
		}

		if (hybrid != null && !hybrid.equals("")) {
			hybrid = hybrid.substring(1, hybrid.length() - 1);
			plist.add(p.porHibrido(Boolean.parseBoolean(hybrid)));
		}

		if (search != null && !search.equals("")) {
			plist.add(p.incluyeEnModeloOMarca(search));
		}

		long count = carService.getCarsCount(plist);
		pagina.setRecordsFiltered(count);

		String orderCol = request.getParameter("order[0][column]");
		String orderDir = request.getParameter("order[0][dir]");

		boolean orderDirBoolean = orderDir.equals("asc") ? true : false;

		CarComparator carComparator = null;

		int r = (int) count % length;

		if (Long.valueOf(request.getParameter("start")) > count - length) {

			end = start + r;

		}

		switch (orderCol == null ? "" : orderCol) {
		case "0":
			carComparator = new CarPkComparator(orderDirBoolean);
			break;
		case "2":
			carComparator = new CarMakeComparator(orderDirBoolean);
			break;
		case "3":
			carComparator = new CarYearComparator(orderDirBoolean);
			break;
		default:
			break;
		}
		pagina.setCars(carService.getCarsCompare(start, end, plist, carComparator));

		System.out.println(orderDir);
		System.out.println(orderCol);

		Map<String, List<?>> filters = new HashMap<String, List<?>>();

		filters.put("makes", carService.getCarsMakes());
		filters.put("years", carService.getCarsYears());
		filters.put("classifications", carService.getCarsClassifications());
		filters.put("fueltypes", carService.getCarsFuelTypes());
		pagina.setFilters(filters);

		Gson gson = new Gson();
		out.print(gson.toJson(pagina));
		out.flush();

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		super.doPost(request, response);

	}
}
