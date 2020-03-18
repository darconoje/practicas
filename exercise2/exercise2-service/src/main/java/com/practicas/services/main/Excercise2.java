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
		int liminferior = 1;
		int limsuperior = 2;
		System.out.println(carservice.devolverRango(liminferior, limsuperior));
		System.out.println("Funcion n coches con potencia mayor a determinada:");
		int n = 10;
		int potencia = 275;
		System.out.println(carservice.primerosPotencia(n, potencia));
		System.out.println("Funcion de coches por tipo de clasificacion:");
		String clasificacion = "Automatic transmission";
		System.out.println(carservice.tipoClasificacion(clasificacion));
		System.out.println("Funcion de coches por tipo de traccion:");
		String traccion = "Rear-wheel drive";
		System.out.println(carservice.tipoTraccion(traccion));
		System.out.println("Funcion de coches por tipo de fuel:");
		String fuel = "Diesel fuel";
		System.out.println(carservice.tipoFuel(fuel));
		System.out.println("Funcion de n coches por año ordenados por potencia:");
		int n2 = 10;
		int anno = 2011;
		boolean ordendescendente = true;
		System.out.println(carservice.cochesPorAnno(n2, anno, ordendescendente));
		System.out.println("Funcion de coches con caracter numerico en modelo en un indice dado:");
		int indice = 10;
		System.out.println(carservice.caracterNumerico(indice));
		System.out.println("Funcion de coches que sean o no hibridos:");
		boolean hibrido = true;
		System.out.println(carservice.esHibrido(hibrido));
		System.out.println("Funcion de coches segun velocidades:");
		int velocidades = 6;
		System.out.println(carservice.cantidadVelocidades(velocidades));
		System.out
				.println("Funcion de coches ordenados por consumo en ciudad mayor o menor a una cantidad determinada");
		int cantidad = 25;
		boolean cantidadmenor = true;
		boolean ordendescendente2 = true;
		System.out.println(carservice.consumoCiudad(cantidad, cantidadmenor, ordendescendente2));
		System.out.println("Funcion de coches con determinada cadena de caracteres en su engine type");
		String caracteres = "Ford";
		System.out.println(carservice.incluyeEnMotor(caracteres));
	}

}
