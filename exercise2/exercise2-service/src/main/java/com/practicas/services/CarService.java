package com.practicas.services;

import com.practicas.model.Car;
import com.practicas.services.data.DatabaseJson;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CarService {

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

		return array.subList(begin, end);

	}

	public List<Car> getCars(int liminferior, int limsuperior, Predicate<Car> p) {

		assert p != null;

		List<Car> cars = getCars(liminferior, limsuperior).stream().filter(p).collect(Collectors.toList());
		return cars;
	}

	public List<Car> getCars(int liminferior, int limsuperior, Predicate<Car> p, CarComparator comparator) {

		List<Car> cars = getCars(liminferior, limsuperior, p);
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
		for(int i = 0; i< cars.size();i++) {
			carsMakes.add(cars.get(i).getIdentification().getMake());
		}
		return carsMakes;
	}

	/**
	 * Obtiene los años distintos de los vehículos
	 * 
	 * @return
	 */
	public List<Integer> getCarsYears() {
		List<Car> cars = getCars(-1, -1);
		List<Integer> carsYears= new ArrayList<>();
		for(int i = 0; i<cars.size(); i++) {
			carsYears.add(cars.get(i).getIdentification().getYear());
		}
		return carsYears;
	}

	/**
	 * Obtiene el número de coches que cumplen el predicado
	 * 
	 * @param p
	 * @return
	 */
	public long getCarsCount(Predicate<Car> p) {
		return (long) getCars(-1, -1).stream().filter(p).count();
	}
}
