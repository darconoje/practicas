package com.practicas.exercise1;

import org.json.JSONArray;
import org.json.JSONObject;

public class FuncionesEjercicio1 {

 //Funcion 1 - Devuelve marca y modelo de los coches dentro del rango de los limites indicados	
 public void devolverMarcayModelo(JSONArray array, int liminferior, int limsuperior) {
  //se recorre el array de coches desde el limite superior al limite superior y se imprime marca y modelo de cada coche	 
  for (int i = liminferior - 1; i <= limsuperior - 1; i++) {
   System.out.println("Coche " + (i + 1) + " - Marca: " + ((JSONObject) array.get(i)).getJSONObject("Identification").getString("Make") + " ; Modelo: " + ((JSONObject) array.get(i)).getJSONObject("Identification").getString("ID"));
  }
 }

 //Funcion 2 - Devuelve marca y modelo de los primeros n coches del array de coches que superen la potencia indicada
 public void primerosPotencia(JSONArray array, int n, int potencia) {
  //se inicia el contador a 1
  int contador = 1;
  //se recorre el array de coches
  for (int i = 0; i < array.length() - 1; i++) {
   //si el contador es menor o igual al n indicado y la potencia es mayor o igual que la indicada recoge el modelo y marca del coche y lo imprime
   if (((JSONObject) array.get(i)).getJSONObject("Engine Information").getJSONObject("Engine Statistics").getInt("Horsepower") >= potencia && contador <= n) {
    System.out.println("Coche " + (i + 1) + " - Marca: " + ((JSONObject) array.get(i)).getJSONObject("Identification").getString("Make") + " ; Modelo: " + ((JSONObject) array.get(i)).getJSONObject("Identification").getString("ID"));
    contador++;
   }
  }
 }

 //Funcion 3 - Devuelve marca y modelo de los coches automaticos	
 public void cochesAutomaticos(JSONArray array) {
  //se recorre el array de coches	 
  for (int i = 0; i <= array.length() - 1; i++) {
   //si la clasificacion del coche equivale a "Automatic transmission" imprime marca y modelo del coche
   if (((JSONObject) array.get(i)).getJSONObject("Identification").getString("Classification").equals("Automatic transmission")) {
    System.out.println("Coche " + (i + 1) + " - Marca: " + ((JSONObject) array.get(i)).getJSONObject("Identification").getString("Make") + " ; Modelo: " + ((JSONObject) array.get(i)).getJSONObject("Identification").getString("ID"));
   }
  }
 }

 //Funcion 4 - Devuelve marca y modelo de los coches con traccion trasera	
 public void traccionTrasera(JSONArray array) {
  //se recorre el array de coches	 
  for (int i = 0; i <= array.length() - 1; i++) {
   //si la linea de transmision equivale a "Rear-wheel drive" imprime marca y modelo del coche
   if (((JSONObject) array.get(i)).getJSONObject("Engine Information").getString("Driveline").equals("Rear-wheel drive")) {
    System.out.println("Coche " + (i + 1) + " - Marca: " + ((JSONObject) array.get(i)).getJSONObject("Identification").getString("Make") + " ; Modelo: " + ((JSONObject) array.get(i)).getJSONObject("Identification").getString("ID"));
   }
  }
 }

 //Funcion 5 - Devuelve marca y modelo de los coches que son diesel	
 public void cochesDiesel(JSONArray array) {
  //se recorre el array de coches	 
  for (int i = 0; i <= array.length() - 1; i++) {
   //si el tipo de fuel equivale a "Rear-wheel drive" imprime marca y modelo del coche
   if (((JSONObject) array.get(i)).getJSONObject("Fuel Information").getString("Fuel Type").equals("Diesel fuel")) {
    System.out.println("Coche " + (i + 1) + " - Marca: " + ((JSONObject) array.get(i)).getJSONObject("Identification").getString("Make") + " ; Modelo: " + ((JSONObject) array.get(i)).getJSONObject("Identification").getString("ID"));
   }
  }
 }

}
