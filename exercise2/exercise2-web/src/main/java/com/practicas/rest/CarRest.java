package com.practicas.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.practicas.model.Car;
import com.practicas.model.CarRestRequest;
import com.practicas.services.CarComparator;
import com.practicas.services.CarMakeComparator;
import com.practicas.services.CarPkComparator;
import com.practicas.services.CarPredicate;
import com.practicas.services.CarService;
import com.practicas.services.CarYearComparator;

@RestController
@RequestMapping("cars")
public class CarRest {

	@Autowired
	private CarService carService;

	@GetMapping(value = "/id/{id}", produces = "application/json")
	public @ResponseBody Car getCar(@PathVariable int id) {
		return carService.getCarByPk(id).get();
	}

	@GetMapping(value = "/page/{page}", produces = "application/json")
	public @ResponseBody List<Car> page(@PathVariable int page) {
		int start = (page + 1 * 10 - 10) * 10;
		int end = start + 10;

		return carService.getCars(start, end);
	}

	@PostMapping(value = "/filter", consumes = "application/json")
	List<Car> filter(@RequestBody CarRestRequest req) {
		
		String make = req.getMakeFilter();
		int year = req.getYearFilter();
		String classification = req.getClassificationFilter();
		String fuelType = req.getFuelTypeFilter();
		boolean hybrid = req.isHybridFilter();
		String search = req.getSearch();
		int page = req.getPage();
		int recordsPerPage = req.getRecordsPerPage();
		String sortPk = req.getSortPk();
		String sortYear = req.getSortYear();
		String sortMake = req.getSortMake();
		
		int start = (page + 1 * 10 - 10) * 10;
		int end = start + 10;
		
		CarPredicate p = new CarPredicate();
		List<Predicate<Car>> plist = new ArrayList<Predicate<Car>>();		
		
		if (make != null && !make.equals("")) {
			plist.add(p.porMarca(make));
		}

		if (Integer.toString(year) != null && !Integer.toString(year).equals("")) {
			plist.add(p.porAnno(year));
		}

		if (classification != null && !classification.equals("")) {
			plist.add(p.porClasificacion(classification));
		}

		if (fuelType != null && !fuelType.equals("")) {
			plist.add(p.porTipoFuel(fuelType));
		}

		if (Boolean.toString(hybrid) != null && !Boolean.toString(hybrid).equals("")) {
			plist.add(p.porHibrido(hybrid));
		}

		if (search != null && !search.equals("")) {
			plist.add(p.incluyeEnModeloOMarca(search));
		}
		
		CarComparator carComparator = null;
		
		if (sortPk != null && !sortPk.equals("null")) {
			boolean orderDir = sortPk.equals("asc") ? true : false;
			carComparator = new CarPkComparator(orderDir);
		}
		
		if (sortYear != null && !sortYear.equals("null")) {
			boolean orderDir = sortYear.equals("asc") ? true : false;
			carComparator = new CarYearComparator(orderDir);
		}
		
		if (sortMake != null && !sortMake.equals("null")) {
			boolean orderDir = sortMake.equals("asc") ? true : false;
			carComparator = new CarMakeComparator(orderDir);
		}

		return carService.getCars(start, end, plist, carComparator);
	}

	@GetMapping(value = "/filterByClassification/{classificationFilter}/{page}", produces = "application/json")
	public @ResponseBody List<Car> filterByClassification(@PathVariable int page,
			@PathVariable String classificationFilter) {
		int start = (page + 1 * 10 - 10) * 10;
		int end = start + 10;

		if (!StringUtils.isEmpty(classificationFilter)) {

			CarPredicate p = new CarPredicate();

			return carService.getCars(start, end, p.porClasificacion(classificationFilter));

		}

		return carService.getCars(start, end);
	}

	@GetMapping(value = "/filterByMake/{makeFilter}/{page}", produces = "application/json")
	public @ResponseBody List<Car> filterByMake(@PathVariable int page, @PathVariable String makeFilter) {
		int start = (page + 1 * 10 - 10) * 10;
		int end = start + 10;

		if (!StringUtils.isEmpty(makeFilter)) {

			CarPredicate p = new CarPredicate();

			return carService.getCars(start, end, p.porMarca(makeFilter));

		}

		return carService.getCars(start, end);
	}

	@GetMapping(value = "/filterByFuelType/{fuelTypeFilter}/{page}", produces = "application/json")
	public @ResponseBody List<Car> filterByFuelType(@PathVariable int page, @PathVariable String fuelTypeFilter) {
		int start = (page + 1 * 10 - 10) * 10;
		int end = start + 10;

		if (!StringUtils.isEmpty(fuelTypeFilter)) {

			CarPredicate p = new CarPredicate();

			return carService.getCars(start, end, p.porTipoFuel(fuelTypeFilter));

		}

		return carService.getCars(start, end);
	}

	@GetMapping(value = "/filterByYear/{yearFilter}/{page}", produces = "application/json")
	public @ResponseBody List<Car> filterByYear(@PathVariable int page, @PathVariable int yearFilter) {
		int start = (page + 1 * 10 - 10) * 10;
		int end = start + 10;

		if (!StringUtils.isEmpty(Integer.toString(yearFilter))) {

			CarPredicate p = new CarPredicate();

			return carService.getCars(start, end, p.porAnno(yearFilter));

		}

		return carService.getCars(start, end);
	}

	@GetMapping(value = "/filterByHybrid/{hybridFilter}/{page}", produces = "application/json")
	public @ResponseBody List<Car> filterByHybrid(@PathVariable int page, @PathVariable boolean hybridFilter) {
		int start = (page + 1 * 10 - 10) * 10;
		int end = start + 10;

		if (!StringUtils.isEmpty(Boolean.toString(hybridFilter))) {

			CarPredicate p = new CarPredicate();

			return carService.getCars(start, end, p.porHibrido(hybridFilter));

		}

		return carService.getCars(start, end);
	}

	@GetMapping(value = "/sortByPk/{order}/{page}", produces = "application/json")
	public @ResponseBody List<Car> sortByPk(@PathVariable int page, @PathVariable String order) {
		int start = (page + 1 * 10 - 10) * 10;
		int end = start + 10;

		if (!StringUtils.isEmpty(order)) {

			boolean dir = order.equals("asc") ? true : false;

			CarComparator carComparator = new CarPkComparator(dir);

			return carService.getCars(start, end, carComparator);

		}

		return carService.getCars(start, end);
	}

	@GetMapping(value = "/sortByMake/{order}/{page}", produces = "application/json")
	public @ResponseBody List<Car> sortByMake(@PathVariable int page, @PathVariable String order) {
		int start = (page + 1 * 10 - 10) * 10;
		int end = start + 10;

		if (!StringUtils.isEmpty(order)) {

			boolean dir = order.equals("asc") ? true : false;

			CarComparator carComparator = new CarMakeComparator(dir);

			return carService.getCars(start, end, carComparator);

		}

		return carService.getCars(start, end);
	}

	@GetMapping(value = "/sortByYear/{order}/{page}", produces = "application/json")
	public @ResponseBody List<Car> sortByYear(@PathVariable int page, @PathVariable String order) {
		int start = (page + 1 * 10 - 10) * 10;
		int end = start + 10;

		if (!StringUtils.isEmpty(order)) {

			boolean dir = order.equals("asc") ? true : false;

			CarComparator carComparator = new CarYearComparator(dir);

			return carService.getCars(start, end, carComparator);

		}

		return carService.getCars(start, end);
	}

	@GetMapping(value = "/search/{search}/{page}", produces = "application/json")
	public @ResponseBody List<Car> search(@PathVariable int page, @PathVariable String search) {
		int start = (page + 1 * 10 - 10) * 10;
		int end = start + 10;

		if (!StringUtils.isEmpty(search)) {

			CarPredicate p = new CarPredicate();

			return carService.getCars(start, end, p.incluyeEnModeloOMarca(search));

		}

		return carService.getCars(start, end);
	}

}
