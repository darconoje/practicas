package com.practicas.exercise1;

import org.json.JSONArray;

import com.practicas.exercise1.utils.DatabaseJson;

public class Exercise1 {

    public static void main(String[] args){
    	
    	JSONArray array = DatabaseJson.loadDatabase().getData();
    	
    	funcionesEjercicio1 funciones = new funcionesEjercicio1();
    	
    	funciones.devolverMarcayModelo(array);
    }
    
}


