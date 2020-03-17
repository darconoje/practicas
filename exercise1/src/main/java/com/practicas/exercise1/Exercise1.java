package com.practicas.exercise1;

import org.json.JSONArray;

import com.practicas.exercise1.utils.DatabaseJson;

public class Exercise1 {

	public static void main(String[] args) {

		// se crea array de coches a partir del archivo json
		JSONArray array = DatabaseJson.loadDatabase().getData();

		// se crea objeto funciones usado para llamar a los metodos
		FuncionesEjercicio1 funciones = new FuncionesEjercicio1();

		// Funcion 1 - Devuelve marca y modelo de los coches dentro del rango de los
		// limites indicados
		System.out.println("Funcion 1:");
		int liminferior = 24;
		int limsuperior = 32;
		System.out.println(funciones.devolverMarcaModelo(array, liminferior, limsuperior));

		// Funcion 2 - Devuelve marca y modelo de los primeros n coches del array de
		// coches que superen la potencia indicada
		System.out.println("Funcion 2:");
		int n = 10;
		int potencia = 150;
		System.out.println(funciones.primerosPotencia(array, n, potencia));

		// Funcion 3 - Devuelve marca y modelo de los coches segun su tipo de
		// clasificacion
		System.out.println("Funcion 3:");
		String clasificacion = "Automatic transmission";
		System.out.println(funciones.tipoClasificacion(array, clasificacion));

		// Funcion 4 - Devuelve marca y modelo de los coches segun su tipo de traccion
		System.out.println("Funcion 4:");
		String traccion = "Rear-wheel drive";
		System.out.println(funciones.tipoTraccion(array, traccion));

		// Funcion 5 - Devuelve marca y modelo de los coches segun su tipo de fuel
		System.out.println("Funcion 5:");
		String fuel = "Diesel fuel";
		System.out.println(funciones.tipoFuel(array, fuel));

		// Funcion 6 - Devuelve las n primeras marcas y modelos de coches de un año
		// determinado, ordenados por potencia (mayor a menor)
		System.out.println("Funcion 6:");
		int n2 = 30;
		int anno = 2011;
		boolean ordendescendente = true;
		System.out.println(funciones.cochesPorAnno(array, n2, anno, ordendescendente));

		// Funcion 7 - Devuelve modelos cuyo caracter en un indice dado sea un numero
		System.out.println("Funcion 7:");
		int indice = 9;
		System.out.println(funciones.caracterNumerico(array, indice));

		// Funcion 8 - Devuelve modelos y marcas de los coches que sean o no hibridos
		System.out.println("Funcion 8:");
		boolean hibrido = true;
		System.out.println(funciones.esHibrido(array, hibrido));

		// Funcion 10 - Devuelve modelos y marcas de los coches segun la cantidad de
		// velocidades
		System.out.println("Funcion 10:");
		int velocidades = 6;
		System.out.println(funciones.cantidadVelocidades(array, velocidades));

		// Funcion 11 - Devuelve modelos y marcas de los coches que tengan un consumo en
		// ciudad menor o mayr a una cantidad indicada, ordenandolos segun se haya indicado
		System.out.println("Funcion 11:");
		int cantidad = 25;
		boolean cantidadmenor = true;
		boolean ordendescendente2 = true;
		System.out.println(funciones.consumoCiudad(array, cantidad, cantidadmenor, ordendescendente2));

		// Funcion 12 - Devuelve modelos y marcas de los coches que contengan una
		// determinada cadena de caracteres dentro de su engine type
		System.out.println("Funcion 12:");
		String caracteres = "Ford";
		System.out.println(funciones.incluyeEnMotor(array,caracteres));
	}

}