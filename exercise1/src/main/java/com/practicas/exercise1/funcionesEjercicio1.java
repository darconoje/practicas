package com.practicas.exercise1;

import org.json.JSONArray;
import org.json.JSONObject;

public class FuncionesEjercicio1 {

 //Funcion 1 - Devuelve marca y modelo de los coches dentro del rango de los limites indicados	
 public void devolverMarcayModelo(JSONArray array, int liminferior, int limsuperior) {

  for (int i = liminferior - 1; i <= limsuperior - 1; i++) {
   System.out.println("Coche " + (i + 1) + " - Marca: " + ((JSONObject) array.get(i)).getJSONObject("Identification").getString("Make") + " ; Modelo: " + ((JSONObject) array.get(i)).getJSONObject("Identification").getString("ID"));
  }

 }

 //Funcion 2 - Devuelve los primeros n coches del array de coches que superen la potencia indicada
 public void primerosPotencia(JSONArray array, int n, int potencia) {
  //se inicia el contador a 1
  int contador = 1;
  //se recorre el array de coches
  for (int i = 0; i < array.length(); i++) {
   //si el contador es menor o igual al n indicado y la potencia es mayor o igual que la indicada recoge el modelo y marca del coche y lo imprime
   if (((JSONObject) array.get(i)).getJSONObject("Engine Information").getJSONObject("Engine Statistics").getInt("Horsepower") >= potencia && contador <= n) {
    System.out.println("Coche " + (i + 1) + " - Marca: " + ((JSONObject) array.get(i)).getJSONObject("Identification").getString("Make") + " ; Modelo: " + ((JSONObject) array.get(i)).getJSONObject("Identification").getString("ID"));
    contador++;
   }
  }
 }

}
