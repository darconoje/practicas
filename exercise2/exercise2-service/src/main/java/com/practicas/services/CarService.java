package com.practicas.services;

import com.practicas.model.Car;

import java.util.List;
import java.util.stream.Collectors;

public class CarService {

	public List<Car> devolverRango(List<Car> array, int liminferior, int limsuperior) {
		if (liminferior <= 0 || limsuperior > array.size() - 1 || liminferior > limsuperior) {
			return null;
		}

		return array.subList(liminferior, limsuperior);

	}

	public List<Car> primerosPotencia(List<Car> array, int n, int potencia) {
		if (n <= 0 || potencia <= 0 || n > array.size() - 1) {
			return null;
		}

		List<Car> listReturn = array.stream()
				.filter(car -> car.getEngineinformation().getEnginestatistics().getHorsepower() > potencia).limit(n)
				.collect(Collectors.toList());

		return listReturn;
	}

	public List<Car> tipoClasificacion(List<Car> array, String clasificacion) {
		if (clasificacion == null || clasificacion.equals("")) {
			return null;
		}
		List<Car> listReturn = array.stream()
				.filter(car -> car.getIdentification().getClassification().equals(clasificacion)).collect(Collectors.toList());

		return listReturn;
	}
}
