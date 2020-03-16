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
  int liminferior = 24;
  int limsuperior = 32;
  System.out.println("Funcion 1:");
  System.out.println(funciones.devolverMarcaModelo(array, liminferior, limsuperior));
  System.out.println("Funcion 2:");
  //Funcion 2 - Devuelve marca y modelo de los primeros n coches del array de coches que superen la potencia indicada
  int n = 10;
  int potencia = 150;
  System.out.println(funciones.primerosPotencia(array, n, potencia));
  System.out.println("Funcion 3:");
  //Funcion 3 - Devuelve marca y modelo de los coches que son o no automaticos
  boolean automatico = true;
  System.out.println(funciones.esAutomatico(array,automatico));
  System.out.println("Funcion 4:");
  //Funcion 4 - Devuelve marca y modelo de los coches que tienen o no traccion trasera
  boolean tracciontrasera = true;
  System.out.println(funciones.esTraccionTrasera(array,tracciontrasera));
  System.out.println("Funcion 5:");
  //Funcion 5 - Devuelve marca y modelo de los coches que son o no diesel
  boolean diesel = true;
  System.out.println(funciones.esDiesel(array,diesel));
 }

}


