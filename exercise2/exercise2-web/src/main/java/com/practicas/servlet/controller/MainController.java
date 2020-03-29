package com.practicas.servlet.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.practicas.model.Car;
import com.practicas.services.CarPredicate;
import com.practicas.services.CarService;

public class MainController {
	
	public void mainAction(HttpServletRequest request, HttpServletResponse response) {
		CarService carservice = new CarService();
		List<Car> cars = carservice.getCars(0, 10);
		long count = carservice.totalCar;
		
		request.setAttribute("total", count);
		request.setAttribute("cars", cars);
		
	}
	
	public void pagination(HttpServletRequest request, HttpServletResponse response) {
		String page = request.getParameter("page");
		int begin = 0;
		int end = 10;
		if(page != null) {
			begin = (Integer.valueOf(page)+ 1*10-10 )*10;
			end = begin + 10;
		}
		CarService carservice = new CarService();
		
		long count = carservice.totalCar;
		long lastpage = count/10;
		int r = (int)count%10;
		if(Long.valueOf(request.getParameter("page"))==lastpage) {
			end = begin + r;
		}
		
		List<Car> cars = carservice.getCars(begin, end);

		request.setAttribute("total", count);
		request.setAttribute("cars", cars);
		request.setAttribute("page", page);
		request.setAttribute("lastpage", lastpage);
	}

	public void filters(HttpServletRequest request, HttpServletResponse response) {
		String year = request.getParameter("filterYear");
		String make = request.getParameter("filterMake");
		CarService carservice = new CarService();
		CarPredicate p = new CarPredicate();
		List<Predicate<Car>> plist = new ArrayList<Predicate<Car>>();
		if(!year.equals("null")) {
			plist.add(p.porAnno(Integer.parseInt(year)));
		}
		if(!make.equals("null")) {
			plist.add(p.porMarca(make));
		}	
		String page = request.getParameter("page");
		int begin = 0;
		int end = 10;
		if(page != null) {
			begin = (Integer.valueOf(page)+ 1*10-10 )*10;
			end = begin + 10;
		}	
		
		long count = carservice.getCarsCount(plist);
		long lastpage = count/10;
		int r = (int) count%10;
		if(Long.valueOf(request.getParameter("page"))==lastpage) {
			end = begin + r;
		}
		
		List<Car> cars = carservice.getCars(begin, end, plist);
		request.setAttribute("cars", cars);
		request.setAttribute("make", make);
		request.setAttribute("year", year);
		request.setAttribute("total", count);
		request.setAttribute("page", page);
		request.setAttribute("lastpage", lastpage);
	}
	
	public void carView(HttpServletRequest request, HttpServletResponse response) {
		String page = request.getParameter("page");
		String filterMake = request.getParameter("filterMake");
		String filterYear = request.getParameter("filterYear");
		String carId = request.getParameter("id");
		if(page != null) {
			request.setAttribute("page",page);			
		}
		if(filterMake != null || filterYear != null) {
			request.setAttribute("filterMake",filterMake);
			request.setAttribute("filterYear",filterYear);			
		}
		CarService carservice = new CarService();
		List<Car> cars = carservice.getCars(-1, -1);
		Car car = cars.get(Integer.valueOf(carId));
		request.setAttribute("car", car);
		request.setAttribute("id", carId);
		request.setAttribute("transmissions", carservice.getCarsTransmissions());
		request.setAttribute("forwardgears", carservice.getCarsNumberOfForwardGears());
		request.setAttribute("drivelines", carservice.getCarsDrivelines());
		request.setAttribute("classifications", carservice.getCarsClassifications());
		request.setAttribute("fueltypes", carservice.getCarsFuelTypes());
	}
}
