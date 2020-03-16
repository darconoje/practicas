package com.practicas.exercise1;

import org.json.JSONArray;
import org.json.JSONObject;

public class FuncionesEjercicio1 {

 //Funcion 1 - Devuelve marca y modelo de los coches dentro del rango de los limites indicados	
 public JSONArray devolverMarcaModelo(JSONArray array, int liminferior, int limsuperior) {
  if(liminferior<=0||limsuperior>array.length()-1||liminferior>limsuperior) {
	  return null;
  }else {
	  JSONArray arrayReturn = new JSONArray();
	  //se recorre el array de coches desde el limite superior al limite superior
	  for (int i = liminferior - 1; i <= limsuperior - 1; i++) {
		  JSONObject objReturn = new JSONObject();
		  JSONObject jObj = array.getJSONObject(i);
		  //se recoge en un jsonobject la marca y modelo del coche
		  objReturn.put("make",jObj.getJSONObject("Identification").getString("Make"));
		  objReturn.put("model", jObj.getJSONObject("Identification").getString("ID"));
		  //se añade el jsonobject al jsonarray de retorno
		  arrayReturn.put(objReturn);
	  }
	  return arrayReturn;
  }
 }

 //Funcion 2 - Devuelve marca y modelo de los primeros n coches del array de coches que superen la potencia indicada
 public JSONArray primerosPotencia(JSONArray array, int n, int potencia) {
  if(n<=0||potencia<=0||n>array.length()-1) {
	  return null;
  }else {
	  JSONArray arrayReturn = new JSONArray();
	  //se inicia el contador a 1
	  int contador = 1;
	  //se recorre el array de coches
	  for (int i = 0; i < array.length() - 1; i++) {
	   //si el contador es menor o igual al n indicado y la potencia es mayor o igual que la indicada recoge el modelo y marca del coche en un jsonobject
	   if (((JSONObject) array.get(i)).getJSONObject("Engine Information").getJSONObject("Engine Statistics").getInt("Horsepower") >= potencia && contador <= n) {
	    
	    JSONObject objReturn = new JSONObject();
	    JSONObject jObj = array.getJSONObject(i);
		objReturn.put("make",jObj.getJSONObject("Identification").getString("Make"));
		objReturn.put("model", jObj.getJSONObject("Identification").getString("ID"));	    
	    //se añade el jsonobject al jsonarray de retorno
		arrayReturn.put(objReturn);
	    contador++;
	   }
	  }	
	  return arrayReturn;
  }
 }

 //Funcion 3 - Devuelve marca y modelo de los coches que son o no automaticos	
 public JSONArray esAutomatico(JSONArray array, boolean automatico) {
  JSONArray arrayReturn = new JSONArray();	 
  //se recorre el array de coches	 
  if(automatico == true) {
	  for (int i = 0; i <= array.length() - 1; i++) {
		  //si la clasificacion del coche equivale a "Automatic transmission" recoge marca y modelo y lo incluye en un jsonobject
		  if (((JSONObject) array.get(i)).getJSONObject("Identification").getString("Classification").equals("Automatic transmission")) {
		   JSONObject objReturn = new JSONObject();
		   JSONObject jObj = array.getJSONObject(i);
		   objReturn.put("make",jObj.getJSONObject("Identification").getString("Make"));
		   objReturn.put("model", jObj.getJSONObject("Identification").getString("ID"));	    
		   //se añade el jsonobject al jsonarray de retorno
		   arrayReturn.put(objReturn);
		  }	 		   
	  }
   }else {
	   for (int i = 0; i <= array.length() - 1; i++) {
		   //si la clasificacion del coche es distinta a "Automatic transmission" recoge marca y modelo y lo incluye en un jsonobject
		   if (!((JSONObject) array.get(i)).getJSONObject("Identification").getString("Classification").equals("Automatic transmission")) {
		    JSONObject objReturn = new JSONObject();
		    JSONObject jObj = array.getJSONObject(i);
			objReturn.put("make",jObj.getJSONObject("Identification").getString("Make"));
			objReturn.put("model", jObj.getJSONObject("Identification").getString("ID"));	    
		    //se añade el jsonobject al jsonarray de retorno
			arrayReturn.put(objReturn);
		   }			   
	   }	     
  }
  return arrayReturn;
 }

 //Funcion 4 - Devuelve marca y modelo de los coches que tienen o no traccion trasera	
 public JSONArray esTraccionTrasera(JSONArray array, boolean tracciontrasera) {
  JSONArray arrayReturn = new JSONArray();	 
  //se recorre el array de coches	 
   if(tracciontrasera == true) {
	   for (int i = 0; i <= array.length() - 1; i++) {
		   //si la linea de transmision equivale a "Rear-wheel drive" recoge marca y modelo y lo incluye en un jsonobject
		   if (((JSONObject) array.get(i)).getJSONObject("Engine Information").getString("Driveline").equals("Rear-wheel drive")) {
			   JSONObject objReturn = new JSONObject();
			   JSONObject jObj = array.getJSONObject(i);
			   objReturn.put("make",jObj.getJSONObject("Identification").getString("Make"));
			   objReturn.put("model", jObj.getJSONObject("Identification").getString("ID"));	    
			   //se añade el jsonobject al jsonarray de retorno
			   arrayReturn.put(objReturn);
		   }		   
	   }   
	   
   }else {
	   for (int i = 0; i <= array.length() - 1; i++) {
		   //si la linea de transmision es distinta a "Rear-wheel drive" recoge marca y modelo y lo incluye en un jsonobject
		   if (!((JSONObject) array.get(i)).getJSONObject("Engine Information").getString("Driveline").equals("Rear-wheel drive")) {
			   JSONObject objReturn = new JSONObject();
			   JSONObject jObj = array.getJSONObject(i);
			   objReturn.put("make",jObj.getJSONObject("Identification").getString("Make"));
			   objReturn.put("model", jObj.getJSONObject("Identification").getString("ID"));	    
			   //se añade el jsonobject al jsonarray de retorno
			   arrayReturn.put(objReturn);
		   }		   
	   }
   }
  return arrayReturn;
 }


 //Funcion 5 - Devuelve marca y modelo de los coches que son o no diesel	
 public JSONArray esDiesel(JSONArray array, boolean diesel) {
  JSONArray arrayReturn = new JSONArray();	 
  //se recorre el array de coches	 
   if(diesel == true) {
	   for (int i = 0; i <= array.length() - 1; i++) {
		   //si el tipo de fuel equivale a "Diesel fuel" recoge marca y modelo y lo incluye en un jsonobject
		   if (((JSONObject) array.get(i)).getJSONObject("Fuel Information").getString("Fuel Type").equals("Diesel fuel")) {
			   JSONObject objReturn = new JSONObject();
			   JSONObject jObj = array.getJSONObject(i);
			   objReturn.put("make",jObj.getJSONObject("Identification").getString("Make"));
			   objReturn.put("model", jObj.getJSONObject("Identification").getString("ID"));	    
			   //se añade el jsonobject al jsonarray de retorno
			   arrayReturn.put(objReturn);
		   }		   
	   }   
   }else {
	   for (int i = 0; i <= array.length() - 1; i++) {
		   //si el tipo de fuel es distinto a "Diesel fuel" recoge marca y modelo y lo incluye en un jsonobject
		   if (!((JSONObject) array.get(i)).getJSONObject("Fuel Information").getString("Fuel Type").equals("Diesel fuel")) {
			   JSONObject objReturn = new JSONObject();
			   JSONObject jObj = array.getJSONObject(i);
			   objReturn.put("make",jObj.getJSONObject("Identification").getString("Make"));
			   objReturn.put("model", jObj.getJSONObject("Identification").getString("ID"));	    
			   //se añade el jsonobject al jsonarray de retorno
			   arrayReturn.put(objReturn);
		   }		   
	   }   
   }
  return arrayReturn;
 }

}
