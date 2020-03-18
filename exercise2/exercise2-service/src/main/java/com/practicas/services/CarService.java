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
		if(begin < 0) {
			begin = 0;
		}
		int end = limsuperior;
		if(end <= 0 || end > array.size()) {
			end = array.size();
		}

		return array.subList(begin,end);

	}

	public List<Car> primerosPotencia(int n, int potencia) {
		
		List<Car> array = devolverRango(-1,-1);
		
		if (n <= 0 || potencia <= 0 || n > array.size() - 1) {
			return null;
		}

		List<Car> listReturn = array.stream()
				.filter(car -> car.getEngineinformation().getEnginestatistics().getHorsepower() > potencia).limit(n)
				.collect(Collectors.toList());

		return listReturn;
	}

	public List<Car> tipoClasificacion(String clasificacion) {
		
		List<Car> array = devolverRango(-1,-1);
		
		if (clasificacion == null || clasificacion.equals("")) {
			return null;
		}
		List<Car> listReturn = array.stream()
				.filter(car -> car.getIdentification().getClassification().equals(clasificacion)).collect(Collectors.toList());

		return listReturn;
	}
}
