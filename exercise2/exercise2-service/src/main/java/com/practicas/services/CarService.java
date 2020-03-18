package com.practicas.services;

import com.practicas.model.Car;
import com.practicas.services.data.DatabaseJson;

import java.util.List;
import java.util.stream.Collectors;

public class CarService {

	public List<Car> devolverRango(int liminferior, int limsuperior) {

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

	public List<Car> primerosPotencia(int n, int potencia) {

		List<Car> array = devolverRango(-1, -1);

		if (n <= 0 || potencia <= 0 || n > array.size() - 1) {
			return null;
		}

		List<Car> listReturn = array.stream()
				.filter(car -> car.getEngineinformation().getEnginestatistics().getHorsepower() > potencia).limit(n)
				.collect(Collectors.toList());

		return listReturn;
	}

	public List<Car> tipoClasificacion(String clasificacion) {

		if (clasificacion == null || clasificacion.equals("")) {
			return null;
		}

		List<Car> array = devolverRango(-1, -1);

		List<Car> listReturn = array.stream()
				.filter(car -> car.getIdentification().getClassification().equals(clasificacion))
				.collect(Collectors.toList());

		return listReturn;
	}

	public List<Car> tipoTraccion(String traccion) {

		if (traccion == null || traccion.equals("")) {
			return null;
		}

		List<Car> array = devolverRango(-1, -1);

		List<Car> listReturn = array.stream().filter(car -> car.getEngineinformation().getDriveline().equals(traccion))
				.collect(Collectors.toList());

		return listReturn;
	}

	public List<Car> tipoFuel(String fuel) {

		if (fuel == null || fuel.equals("")) {
			return null;
		}

		List<Car> array = devolverRango(-1, -1);

		List<Car> listReturn = array.stream().filter(car -> car.getFuelinformation().getFueltype().equals(fuel))
				.collect(Collectors.toList());

		return listReturn;
	}

	public List<Car> cochesPorAnno(int n, int anno, boolean ordendescendente) {

		List<Car> array = devolverRango(-1, -1);

		if (n <= 0 || anno < 2000 || n > array.size() - 1) {
			return null;
		}
		CarHorsePowerComparator horsepowercomparator = new CarHorsePowerComparator(ordendescendente);
		List<Car> listReturn = array.stream().filter(car -> car.getIdentification().getYear() == anno).limit(n)
				.sorted(horsepowercomparator).collect(Collectors.toList());

		return listReturn;
	}

	public List<Car> caracterNumerico(int indice) {

		if (indice < 0) {
			return null;
		}

		List<Car> array = devolverRango(-1, -1);

		List<Car> listReturn = array.stream()
				.filter(car -> (int) car.getIdentification().getId().charAt(indice + 1) >= 48
						&& (int) car.getIdentification().getId().charAt(indice) <= 57)
				.collect(Collectors.toList());
		return listReturn;
	}

	public List<Car> esHibrido(boolean hibrido) {

		List<Car> array = devolverRango(-1, -1);

		List<Car> listReturn = array.stream().filter(car -> car.getEngineinformation().isHybrid() == hibrido)
				.collect(Collectors.toList());
		return listReturn;
	}

	public List<Car> cantidadVelocidades(int velocidades) {

		List<Car> array = devolverRango(-1, -1);

		List<Car> listReturn = array.stream()
				.filter(car -> car.getEngineinformation().getNumberofforwardgears() == velocidades)
				.collect(Collectors.toList());
		return listReturn;
	}

	public List<Car> consumoCiudad(int cantidad, boolean cantidadmenor, boolean ordendescendente) {

		if (cantidad <= 0) {
			return null;
		}

		List<Car> array = devolverRango(-1, -1);

		CarCityMphComparator citymphcomparator = new CarCityMphComparator(ordendescendente);
		if (cantidadmenor == true) {
			List<Car> listReturn = array.stream().filter(car -> car.getFuelinformation().getCitymph() < cantidad)
					.sorted(citymphcomparator).collect(Collectors.toList());
			return listReturn;
		} else {
			List<Car> listReturn = array.stream().filter(car -> car.getFuelinformation().getCitymph() > cantidad)
					.sorted(citymphcomparator).collect(Collectors.toList());
			return listReturn;
		}
	}

	public List<Car> incluyeEnMotor(String caracteres) {

		if (caracteres.length() == 0) {
			return null;
		}

		List<Car> array = devolverRango(-1, -1);

		List<Car> listReturn = array.stream()
				.filter(car -> car.getEngineinformation().getEnginetype().contains(caracteres))
				.collect(Collectors.toList());
		return listReturn;
	}
}
