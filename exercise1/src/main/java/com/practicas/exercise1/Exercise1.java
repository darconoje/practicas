package com.practicas.exercise1;

import org.json.JSONArray;

import com.practicas.exercise1.utils.DatabaseJson;

public class Exercise1 {

 public static void main(String[] args) {

  //se crea array de coches a partir del archivo json	 
  JSONArray array = DatabaseJson.loadDatabase().getData();

  //se crea objeto funciones usado para llamar a los metodos
  FuncionesEjercicio1 funciones = new FuncionesEjercicio1();

  //Funcion 1 - Devuelve marca y modelo de los coches dentro del rango de los limites indicados
  System.out.println("Funcion 1:");
  int liminferior = 24;
  int limsuperior = 32;
  System.out.println(funciones.devolverMarcaModelo(array, liminferior, limsuperior));

  //Funcion 2 - Devuelve marca y modelo de los primeros n coches del array de coches que superen la potencia indicada
  System.out.println("Funcion 2:");
  int n = 10;
  int potencia = 150;
  System.out.println(funciones.primerosPotencia(array, n, potencia));

  //Funcion 3 - Devuelve marca y modelo de los coches que son o no automaticos
  System.out.println("Funcion 3:");
  boolean automatico = true;
  System.out.println(funciones.esAutomatico(array, automatico));

  //Funcion 4 - Devuelve marca y modelo de los coches que tienen o no traccion trasera
  System.out.println("Funcion 4:");
  boolean tracciontrasera = true;
  System.out.println(funciones.esTraccionTrasera(array, tracciontrasera));

  //Funcion 5 - Devuelve marca y modelo de los coches que son o no diesel
  System.out.println("Funcion 5:");
  boolean diesel = true;
  System.out.println(funciones.esDiesel(array, diesel));
 }

}