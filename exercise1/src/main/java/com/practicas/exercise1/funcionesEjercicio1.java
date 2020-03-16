package com.practicas.exercise1;

import org.json.JSONArray;
import org.json.JSONObject;

public class funcionesEjercicio1 {

    public void devolverMarcayModelo(JSONArray array) {	 
    	
    	for( int i = 23 ; i<=31 ; i++ ) {
    		System.out.println("Coche " + (i+1) + " - Marca: " + ((JSONObject)array.get(i)).getJSONObject("Identification").getString("Make") +" Modelo: " + ((JSONObject)array.get(i)).getJSONObject("Identification").getString("Model Year") );
    	}
    	
    }
	
}
