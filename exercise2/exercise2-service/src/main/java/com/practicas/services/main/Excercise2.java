package com.practicas.services.main;

import java.util.List;

import com.practicas.model.Car;
import com.practicas.services.CarService;
import com.practicas.services.data.DatabaseJson;

public class Excercise2 {

	public static void main(String[] args) {

		CarService carservice = new CarService();
		
		List<Car> listCar = DatabaseJson.loadDatabase().getDataParsed();
		
		System.out.println(listCar.get(0));
		
		System.out.println("Funcion rango:");
		System.out.println(carservice.devolverRango(listCar, 1, 2));
		System.out.println("Funcion n coches con potencia mayor a determinada:");
		System.out.println(carservice.primerosPotencia(listCar, 10, 275));
		System.out.println("Funcion tipo de clasificacion:");
		System.out.println(carservice.tipoClasificacion(listCar,"Automatic transmission"));

	}

}
