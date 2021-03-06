package com.practicas.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.practicas.model.Car;
import com.practicas.services.CarCityMphComparator;
import com.practicas.services.CarComparator;
import com.practicas.services.CarHorsePowerComparator;
import com.practicas.services.CarPkComparator;
import com.practicas.services.CarPredicate;
import com.practicas.services.CarService;
import com.practicas.services.data.DatabaseJson;

@Service("carService")
public class CarServiceImpl implements CarService {
	
	@PostConstruct
	public void init() {
		DatabaseJson.loadDatabase().getDataParsed();
	}
	
	public List<Car> getCars(int liminferior, int limsuperior) {

		List<Car> array = DatabaseJson.loadDatabase().getDataParsed();

		if (liminferior > limsuperior) {
			return null;
		}

		int begin = liminferior;
		if (begin < 0) {
			begin = 0;
		}
		int end = limsuperior;
		if (end <= 0 || end > array.size()) {
			end = array.size();
		}

		CarPkComparator pkcomparator = new CarPkComparator(true);
		List<Car> arraySorted = array.stream().sorted(pkcomparator).collect(Collectors.toList());
		return arraySorted.subList(begin, end);

	}

	public List<Car> getCars(int start, int end, Predicate<Car> p) {
		
		assert p != null;
		Stream<Car> stream = getCars(-1, -1).stream();
		Stream<Car> stream2 = getCars(-1, -1).stream();
		int count = (int) stream2.count();
		List<Car> cars = new ArrayList<Car>();
		if (count < 10) {
			end = count;
			cars = stream.filter(p).collect(Collectors.toList()).subList(0, (int) end);
		} else {
			cars = stream.filter(p).collect(Collectors.toList()).subList(start, (int) end);
		}

		return cars;

//		assert p != null;
//
//		List<Car> cars = getCars(liminferior, limsuperior).stream().filter(p).collect(Collectors.toList());
//		return cars;
	}

	public List<Car> getCars(int liminferior, int limsuperior, Predicate<Car> p, CarComparator comparator) {

		List<Car> cars = getCars(liminferior, limsuperior, p);
		if (comparator != null) {
			return cars.stream().sorted(comparator).collect(Collectors.toList());
		}

		return cars.stream().sorted().collect(Collectors.toList());
	}

	public List<Car> getCars(int liminferior, int limsuperior, List<Predicate<Car>> ps, CarComparator comparator) {
		
		
		List<Car> cars = getCars(liminferior, limsuperior, ps);
		if (comparator != null) {
			return cars.stream().sorted(comparator).collect(Collectors.toList());
		}

		return cars.stream().sorted().collect(Collectors.toList());
	}

	public List<Car> getCars(int liminferior, int limsuperior, Predicate<Car> p, CarComparator comparator, int limit) {

		assert limit > 0;

		List<Car> cars = getCars(liminferior, limsuperior, p, comparator);
		return cars.stream().limit(limit).collect(Collectors.toList());
	}

	public List<Car> getCars(int liminferior, int limsuperior, Predicate<Car> p, int limit) {
		assert limit > 0;
		List<Car> cars = getCars(liminferior, limsuperior, p);
		return cars.stream().limit(limit).collect(Collectors.toList());
	}

	public List<Car> getCarsCompare(int start, int end, List<Predicate<Car>> ps, CarComparator comparator) {
		long total = getCarsCount(ps);
		List<Car> cars = getCars(0, total, ps);
		if (start < 0) {
			start = 0;
		}
		if (total < end) {
			end = (int) total;
		}
		if (comparator != null) {
			return cars.stream().sorted(comparator).collect(Collectors.toList()).subList(start, end);
		}
		return cars.stream().sorted().collect(Collectors.toList()).subList(start, end);
	}

	public List<Car> primerosPotencia(int n, int potencia, boolean mayor) {

		if (n <= 0 || potencia <= 0) {
			return null;
		}

		CarPredicate p = new CarPredicate();
		if (mayor == true) {
			return getCars(-1, -1, p.porPotenciaMayor(potencia), n);
		} else {
			return getCars(-1, -1, p.porPotenciaMenor(potencia), n);
		}

	}

	public List<Car> tipoClasificacion(String clasificacion) {

		if (clasificacion == null || clasificacion.equals("")) {
			return null;
		}

		CarPredicate p = new CarPredicate();
		return getCars(-1, -1, p.tipoClasificacion(clasificacion));

	}

	public List<Car> tipoTraccion(String traccion) {

		if (traccion == null || traccion.equals("")) {
			return null;
		}

		CarPredicate p = new CarPredicate();
		return getCars(-1, -1, p.tipoTraccion(traccion));

	}

	public List<Car> tipoFuel(String fuel) {

		if (fuel == null || fuel.equals("")) {
			return null;
		}

		CarPredicate p = new CarPredicate();
		return getCars(-1, -1, p.tipoFuel(fuel));

	}

	public List<Car> cochesPorAnno(int n, int anno, boolean ordendescendente) {

		if (n <= 0 || anno < 2000) {
			return null;
		}

		CarHorsePowerComparator horsepowercomparator = new CarHorsePowerComparator(ordendescendente);
		CarPredicate p = new CarPredicate();
		return getCars(-1, -1, p.cochesPorAnno(anno), horsepowercomparator, n);

	}

	public List<Car> caracterNumericoEnId(int indice) {

		if (indice < 0) {
			return null;
		}

		CarPredicate p = new CarPredicate();
		return getCars(-1, -1, p.caracterNumericoEnId(indice));

	}

	public List<Car> esHibrido(boolean hibrido) {

		CarPredicate p = new CarPredicate();
		return getCars(-1, -1, p.esHibrido(hibrido));

	}

	public List<Car> cantidadVelocidades(int velocidades) {

		if (velocidades <= 0) {
			return null;
		}

		CarPredicate p = new CarPredicate();
		return getCars(-1, -1, p.velocidades(velocidades));

	}

	public List<Car> consumoCiudad(int cantidad, boolean cantidadmenor, boolean ordendescendente) {

		if (cantidad <= 0) {
			return null;
		}

		CarCityMphComparator citymphcomparator = new CarCityMphComparator(ordendescendente);
		CarPredicate p = new CarPredicate();
		if (cantidadmenor == true) {
			return getCars(-1, -1, p.consumoCiudadMenorA(cantidad), citymphcomparator);
		} else {
			return getCars(-1, -1, p.consumoCiudadMayorA(cantidad), citymphcomparator);
		}

	}

	public List<Car> incluyeEnMotor(String caracteres) {

		if (caracteres.length() == 0) {
			return null;
		}

		CarPredicate p = new CarPredicate();
		return getCars(-1, -1, p.incluyeEnMotor(caracteres));

	}

	/**
	 * Obtiene las marcas distintas de los coches
	 * 
	 * @return
	 */
	public List<String> getCarsMakes() {
		List<Car> cars = getCars(-1, -1);
		List<String> carsMakes = new ArrayList<>();
		for (int i = 0; i < cars.size(); i++) {
			carsMakes.add(cars.get(i).getIdentification().getMake());
		}
		return carsMakes.stream().distinct().sorted().collect(Collectors.toList());
	}

	/**
	 * Obtiene los a�os distintos de los veh�culos
	 * 
	 * @return
	 */
	public List<Integer> getCarsYears() {
		List<Car> cars = getCars(-1, -1);
		List<Integer> carsYears = new ArrayList<>();
		for (int i = 0; i < cars.size(); i++) {
			carsYears.add(cars.get(i).getIdentification().getYear());
		}
		return carsYears.stream().distinct().sorted().collect(Collectors.toList());
	}

	public List<String> getCarsTransmissions() {
		List<Car> cars = getCars(-1, -1);
		List<String> carsTransmissions = new ArrayList<>();
		for (int i = 0; i < cars.size(); i++) {
			carsTransmissions.add(cars.get(i).getEngineinformation().getTransmission());
		}
		return carsTransmissions.stream().distinct().sorted().collect(Collectors.toList());
	}

	public List<Integer> getCarsNumberOfForwardGears() {
		List<Car> cars = getCars(-1, -1);
		List<Integer> carsNumberOfForwardGears = new ArrayList<>();
		for (int i = 0; i < cars.size(); i++) {
			carsNumberOfForwardGears.add(cars.get(i).getEngineinformation().getNumberofforwardgears());
		}
		return carsNumberOfForwardGears.stream().distinct().sorted().collect(Collectors.toList());
	}

	public List<String> getCarsDrivelines() {
		List<Car> cars = getCars(-1, -1);
		List<String> carsDrivelines = new ArrayList<>();
		for (int i = 0; i < cars.size(); i++) {
			carsDrivelines.add(cars.get(i).getEngineinformation().getDriveline());
		}
		return carsDrivelines.stream().distinct().sorted().collect(Collectors.toList());
	}

	public List<String> getCarsClassifications() {
		List<Car> cars = getCars(-1, -1);
		List<String> carsClassifications = new ArrayList<>();
		for (int i = 0; i < cars.size(); i++) {
			carsClassifications.add(cars.get(i).getIdentification().getClassification());
		}
		return carsClassifications.stream().distinct().sorted().collect(Collectors.toList());
	}

	public List<String> getCarsFuelTypes() {
		List<Car> cars = getCars(-1, -1);
		List<String> carsFuelTypes = new ArrayList<>();
		for (int i = 0; i < cars.size(); i++) {
			carsFuelTypes.add(cars.get(i).getFuelinformation().getFueltype());
		}
		return carsFuelTypes.stream().distinct().sorted().collect(Collectors.toList());
	}

	/**
	 * Obtiene el n�mero de coches que cumplen el predicado
	 * 
	 * @param p
	 * @return
	 */
	public long getCarsCount(Predicate<Car> p) {
		assert p != null;
		return (long) getCars(-1, -1).stream().filter(p).count();
	}

	public Optional<Car> getCarByPk(int pk) {
		assert pk >= 0;
		List<Car> cars = getCars(-1, -1);
		return cars.stream().filter(c -> c.getPk() == pk).findFirst();
	}

	/**
	 * Obtiene los coches que cumplen un predicado
	 * 
	 * @param start inicio
	 * @param end   fin
	 * @param p     Predicado
	 * @return
	 */
	public List<Car> getCars(int start, int end, List<Predicate<Car>> ps) {

		assert ps != null;
		Stream<Car> stream = getCars(-1, -1).stream();
		Stream<Car> stream2 = getCars(-1, -1).stream();
		for (Predicate<Car> p : ps) {
			stream = stream.filter(p);
			stream2 = stream2.filter(p);
		}
		int count = (int) stream2.count();
		List<Car> cars = new ArrayList<Car>();
		if (count < 10) {
			end = count;
			cars = stream.collect(Collectors.toList()).subList(0, end);
		} else {
			cars = stream.collect(Collectors.toList()).subList(start, end);
		}

		return cars;
	}

	public List<Car> getCars(int start, long end, List<Predicate<Car>> ps) {

		assert ps != null;
		Stream<Car> stream = getCars(-1, -1).stream();
		Stream<Car> stream2 = getCars(-1, -1).stream();
		for (Predicate<Car> p : ps) {
			stream = stream.filter(p);
			stream2 = stream2.filter(p);
		}
		int count = (int) stream2.count();
		List<Car> cars = new ArrayList<Car>();
		if (count < 10) {
			end = count;
			cars = stream.collect(Collectors.toList()).subList(0, (int) end);
		} else {
			cars = stream.collect(Collectors.toList()).subList(start, (int) end);
		}

		return cars;
	}
	
	public List<Car> getCars(int start, int end, CarComparator comparator){
		assert comparator != null;
		
		Stream<Car> stream = getCars(-1, -1).stream();
		Stream<Car> stream2 = getCars(-1, -1).stream();
		int count = (int) stream2.count();
		List<Car> cars = new ArrayList<Car>();
		if (count < 10) {
			end = count;
			cars = stream.sorted(comparator).collect(Collectors.toList()).subList(0, (int) end);
		} else {
			cars = stream.sorted(comparator).collect(Collectors.toList()).subList(start, (int) end);
		}	
		
		return cars;
	}

	/**
	 * Obtiene el n�mero de coches que cumplen el predicado
	 * 
	 * @param p
	 * @return
	 */
	public long getCarsCount(List<Predicate<Car>> ps) {

		assert ps != null;
		Stream<Car> stream = getCars(-1, -1).stream();
		for (Predicate<Car> p : ps) {
			stream = stream.filter(p);
		}
		return stream.count();
	}

	public long totalCar() {
		return getCars(-1, -1).parallelStream().count();
	}

}
