package com.practicas.servlet.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.practicas.model.Car;
import com.practicas.services.CarMakeComparator;
import com.practicas.services.CarPredicate;
import com.practicas.services.CarService;
import com.practicas.services.CarYearComparator;

@Controller("mainController")
public class MainController {
	
	@Autowired
	private CarService carService;

	public void mainAction(HttpServletRequest request, HttpServletResponse response) {
		List<Car> cars = carService.getCars(0, 10);
		long count = carService.totalCar();

		request.setAttribute("total", count);
		request.setAttribute("cars", cars);

	}

	public void pagination(HttpServletRequest request, HttpServletResponse response) {
		String page = request.getParameter("page");
		int begin = 0;
		int end = 10;
		if (page != null) {
			begin = (Integer.valueOf(page) + 1 * 10 - 10) * 10;
			end = begin + 10;
		}

		long count = carService.totalCar();
		long lastpage = count / 10;
		int r = (int) count % 10;
		if (Long.valueOf(request.getParameter("page")) == lastpage) {
			end = begin + r;
		}

		List<Car> cars = carService.getCars(begin, end);

		request.setAttribute("total", count);
		request.setAttribute("cars", cars);
		request.setAttribute("page", page);
		request.setAttribute("lastpage", lastpage);
	}

	public void filters(HttpServletRequest request, HttpServletResponse response) {
		String year = request.getParameter("filterYear");
		String make = request.getParameter("filterMake");
		String ishybrid = request.getParameter("filterHybrid");
		String classification = request.getParameter("filterClassification");
		CarPredicate p = new CarPredicate();
		List<Predicate<Car>> plist = new ArrayList<Predicate<Car>>();
		if (!year.equals("null")) {
			plist.add(p.porAnno(Integer.parseInt(year)));
		}
		if (!make.equals("null")) {
			plist.add(p.porMarca(make));
		}
		if (!ishybrid.equals("null")) {
			plist.add(p.porHibrido(Boolean.parseBoolean(ishybrid)));
		}
		if (!classification.equals("null")) {
			plist.add(p.porClasificacion(classification));
		}
		String page = request.getParameter("page");
		int begin = 0;
		int end = 10;
		if (page != null) {
			begin = (Integer.valueOf(page) + 1 * 10 - 10) * 10;
			end = begin + 10;
		}

		long count = carService.getCarsCount(plist);
		long lastpage = count / 10;
		int r = (int) count % 10;
		
		if (Long.valueOf(request.getParameter("page")) == lastpage) {
			
			end = begin + r;
			
		}

		String sortyear = request.getParameter("sortYear");
		String sortmake = request.getParameter("sortMake");

		List<Car> cars = new ArrayList<Car>();

		if (!sortyear.equals("null") || !sortmake.equals("null")) {
			if (sortyear.equals("asc")) {
				CarYearComparator yearcomparator = new CarYearComparator(true);
				cars = carService.getCarsCompare(begin, end, plist, yearcomparator);
			} else if (sortyear.equals("desc")) {
				CarYearComparator yearcomparator = new CarYearComparator(false);
				cars = carService.getCarsCompare(begin, end, plist, yearcomparator);
			} else if (sortmake.equals("asc")) {
				CarMakeComparator makecomparator = new CarMakeComparator(true);
				cars = carService.getCarsCompare(begin, end, plist, makecomparator);
			} else if (sortmake.equals("desc")) {
				CarMakeComparator makecomparator = new CarMakeComparator(false);
				cars = carService.getCarsCompare(begin, end, plist, makecomparator);
			}
		} else {
			cars = carService.getCars(begin, end, plist);
		}

		request.setAttribute("cars", cars);
		request.setAttribute("make", make);
		request.setAttribute("year", year);
		request.setAttribute("ishybrid", ishybrid);
		request.setAttribute("classification", classification);
		request.setAttribute("total", count);
		request.setAttribute("page", page);
		request.setAttribute("lastpage", lastpage);
		request.setAttribute("sortyear", sortyear);
		request.setAttribute("sortmake", sortmake);
	}

	public void carView(HttpServletRequest request, HttpServletResponse response) {
		String page = request.getParameter("page");
		String filterMake = request.getParameter("filterMake");
		String filterYear = request.getParameter("filterYear");
		String filterHybrid = request.getParameter("filterHybrid");
		String filterClassification = request.getParameter("filterClassification");
		String sortyear = request.getParameter("sortYear");
		String sortmake = request.getParameter("sortMake");
		String carId = request.getParameter("id");
		if (page != null) {
			request.setAttribute("page", page);
		}
		if (filterMake != null || filterYear != null || filterHybrid != null || filterClassification != null
				|| sortyear != null || sortmake != null) {
			request.setAttribute("filterMake", filterMake);
			request.setAttribute("filterYear", filterYear);
			request.setAttribute("filterHybrid", filterHybrid);
			request.setAttribute("filterClassification", filterClassification);
			request.setAttribute("sortYear", sortyear);
			request.setAttribute("sortMake",sortmake);
		}
		List<Car> cars = carService.getCars(-1, -1);
		Car car = cars.get(Integer.valueOf(carId));
		String redirect = request.getParameter("redirect");
		request.setAttribute("redirect", redirect);
		request.setAttribute("car", car);
		request.setAttribute("id", carId);
		request.setAttribute("transmissions", carService.getCarsTransmissions());
		request.setAttribute("forwardgears", carService.getCarsNumberOfForwardGears());
		request.setAttribute("drivelines", carService.getCarsDrivelines());
		request.setAttribute("classifications", carService.getCarsClassifications());
		request.setAttribute("fueltypes", carService.getCarsFuelTypes());
	}
}
