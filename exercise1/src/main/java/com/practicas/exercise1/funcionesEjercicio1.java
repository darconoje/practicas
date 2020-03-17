package com.practicas.exercise1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class FuncionesEjercicio1 {

	// Funcion 1 - Devuelve marca y modelo de los coches dentro del rango de los
	// limites indicados
	public JSONArray devolverMarcaModelo(JSONArray array, int liminferior, int limsuperior) {
		if (liminferior <= 0 || limsuperior > array.length() - 1 || liminferior > limsuperior) {
			return null;
		}
		JSONArray arrayReturn = new JSONArray();
		// se recorre el array de coches desde el limite superior al limite superior
		for (int i = liminferior - 1; i < limsuperior; i++) {
			JSONObject objReturn = new JSONObject();
			JSONObject jObj = array.getJSONObject(i);
			// se recoge en un jsonobject la marca y modelo del coche
			objReturn.put("make", jObj.getJSONObject("Identification").getString("Make"));
			objReturn.put("model", jObj.getJSONObject("Identification").getString("ID"));
			// se añade el jsonobject al jsonarray de retorno
			arrayReturn.put(objReturn);
		}
		return arrayReturn;

	}

	// Funcion 2 - Devuelve marca y modelo de los primeros n coches del array de
	// coches que superen la potencia indicada
	public JSONArray primerosPotencia(JSONArray array, int n, int potencia) {
		if (n <= 0 || potencia <= 0 || n > array.length() - 1) {
			return null;
		}
		JSONArray arrayReturn = new JSONArray();
		// se inicia el contador a 1
		int contador = 1;
		// se recorre el array de coches
		for (int i = 0; i < array.length(); i++) {
			// si el contador es menor o igual al n indicado y la potencia es mayor o igual
			// que la indicada recoge el modelo y marca del coche en un jsonobject
			int objeto = ((JSONObject) array.get(i)).getJSONObject("Engine Information")
					.getJSONObject("Engine Statistics").getInt("Horsepower");
			if (objeto >= potencia && contador <= n) {

				JSONObject objReturn = new JSONObject();
				JSONObject jObj = array.getJSONObject(i);
				objReturn.put("make", jObj.getJSONObject("Identification").getString("Make"));
				objReturn.put("model", jObj.getJSONObject("Identification").getString("ID"));
				// se añade el jsonobject al jsonarray de retorno
				arrayReturn.put(objReturn);
				contador++;
			}
		}
		return arrayReturn;

	}

	// Funcion 3 - Devuelve marca y modelo de los coches segun su tipo de
	// clasificacion
	public JSONArray tipoClasificacion(JSONArray array, String clasificacion) {
		if (clasificacion == null || clasificacion.equals("")) {
			return null;
		}
		JSONArray arrayReturn = new JSONArray();
		// se recorre el array de coches
		for (int i = 0; i < array.length(); i++) {
			// recoge marca y modelo de coche en un jsonobject de los que coincidan con la
			// clasificacion especificada
			String objeto = ((JSONObject) array.get(i)).getJSONObject("Identification").getString("Classification");
			if (objeto.equals(clasificacion)) {
				JSONObject objReturn = new JSONObject();
				JSONObject jObj = array.getJSONObject(i);
				objReturn.put("make", jObj.getJSONObject("Identification").getString("Make"));
				objReturn.put("model", jObj.getJSONObject("Identification").getString("ID"));
				// se añade el jsonobject al jsonarray de retorno
				arrayReturn.put(objReturn);
			}
		}
		return arrayReturn;
	}

	// Funcion 4 - Devuelve marca y modelo de los coches segun su tipo de traccion
	// trasera
	public JSONArray tipoTraccion(JSONArray array, String traccion) {
		if (traccion == null || traccion.equals("")) {
			return null;
		}
		JSONArray arrayReturn = new JSONArray();
		// se recorre el array de coches
		for (int i = 0; i < array.length(); i++) {
			// recoge marca y modelo de coche en un jsonobject de los que coincidan con el
			// tipo de traccion especificada
			String object = ((JSONObject) array.get(i)).getJSONObject("Engine Information").getString("Driveline");
			if (object.equals(traccion)) {
				JSONObject objReturn = new JSONObject();
				JSONObject jObj = array.getJSONObject(i);
				objReturn.put("make", jObj.getJSONObject("Identification").getString("Make"));
				objReturn.put("model", jObj.getJSONObject("Identification").getString("ID"));
				// se añade el jsonobject al jsonarray de retorno
				arrayReturn.put(objReturn);
			}
		}
		return arrayReturn;
	}

	// Funcion 5 - Devuelve marca y modelo de los coches segun su tipo de fuel
	public JSONArray tipoFuel(JSONArray array, String fuel) {
		if (fuel == null || fuel.equals("")) {
			return null;
		}
		JSONArray arrayReturn = new JSONArray();
		// se recorre el array de coches
		for (int i = 0; i < array.length(); i++) {
			// recoge marca y modelo de coche en un jsonobject de los que coincidan con el
			// tipo de fuel especificado
			String object = ((JSONObject) array.get(i)).getJSONObject("Fuel Information").getString("Fuel Type");
			if (object.equals(fuel)) {
				JSONObject objReturn = new JSONObject();
				JSONObject jObj = array.getJSONObject(i);
				objReturn.put("make", jObj.getJSONObject("Identification").getString("Make"));
				objReturn.put("model", jObj.getJSONObject("Identification").getString("ID"));
				// se añade el jsonobject al jsonarray de retorno
				arrayReturn.put(objReturn);
			}
		}
		return arrayReturn;
	}

	// Funcion 6 - Devuelve las n primeras marcas y modelos de coches de un año
	// determinado, ordenados por potencia
	public JSONArray cochesPorAnno(JSONArray array, int n, int anno, boolean ordendescendente) {
		JSONArray arrayReturn = new JSONArray();
		if (n <= 0 || anno < 2000 || n > array.length() - 1) {
			return null;
		}
		int contador = 1;
		for (int i = 0; contador <= n; i++) {
			// recoge marca, modelo y potencia de coche en un jsonobject de los que
			// coincidan con el
			// año del modelo
			int object = ((JSONObject) array.get(i)).getJSONObject("Identification").getInt("Year");
			if (object == anno) {
				JSONObject objReturn = new JSONObject();
				JSONObject jObj = array.getJSONObject(i);
				objReturn.put("make", jObj.getJSONObject("Identification").getString("Make"));
				objReturn.put("model", jObj.getJSONObject("Identification").getString("ID"));
				objReturn.put("horsepower", jObj.getJSONObject("Engine Information").getJSONObject("Engine Statistics")
						.getInt("Horsepower"));
				// se añade el jsonobject al jsonarray de retorno
				arrayReturn.put(objReturn);
				contador++;
			}

		}
		// se pasa el jsonarray a tipo arraylist para poder usar comparadores
		List<JSONObject> jsonValues = new ArrayList<JSONObject>();
		for (int i = 0; i < arrayReturn.length(); i++) {
			jsonValues.add(arrayReturn.getJSONObject(i));
		}

		Collections.sort(jsonValues, new Comparator<JSONObject>() {

			private static final String HORSEPOWER = "horsepower";

			@Override
			public int compare(JSONObject a, JSONObject b) {
				Integer valA = 0;
				Integer valB = 0;

				valA = (int) a.get(HORSEPOWER);
				valB = (int) b.get(HORSEPOWER);

				int mult = -1;
				if (!ordendescendente) {
					mult = 1;
				}

				if (valA < valB) {
					return mult * -1;
				} else if (valA > valB) {
					return mult * 1;
				} else {
					return mult * (a.getString("model").compareTo(b.getString("model")));
				}
			}
		});
		// se crea variable jsonarray y se llena con el resultante arraylist, se retorna
		// esta variable
		JSONArray arraySorted = new JSONArray();
		for (int i = 0; i < jsonValues.size(); i++) {
			arraySorted.put(jsonValues.get(i));
		}
		return arraySorted;
	}

	// Funcion 7 - Devuelve modelos cuyo caracter en un indice dado sea un numero
	public JSONArray caracterNumerico(JSONArray array, int indice) {
		JSONArray arrayReturn = new JSONArray();
		if (indice < 0) {
			return null;
		}
		// se recorre el array de coches
		for (int i = 0; i < array.length(); i++) {
			char c = ((JSONObject) array.get(i)).getJSONObject("Identification").getString("ID").charAt(indice);
			int ascii = (int) c;
			if (ascii >= 48 && ascii <= 57) {
				JSONObject objReturn = new JSONObject();
				JSONObject jObj = array.getJSONObject(i);
				// se recoge en un jsonobject el modelo del coche
				objReturn.put("model", jObj.getJSONObject("Identification").getString("ID"));
				// se añade el jsonobject al jsonarray de retorno
				arrayReturn.put(objReturn);
			}

		}
		return arrayReturn;
	}

	// Funcion 8 - Devuelve marca y modelo de los coches que son o no hibridos
	public JSONArray esHibrido(JSONArray array, boolean hibrido) {
		JSONArray arrayReturn = new JSONArray();
		// se recorre el array de coches
		if (hibrido == true) {
			for (int i = 0; i < array.length(); i++) {
				// si en la informacion del motor devuelve 'true' en "Hybrid" recoge marca y
				// modelo y lo incluye en un jsonobject
				boolean object = ((JSONObject) array.get(i)).getJSONObject("Engine Information").getBoolean("Hybrid");
				if (object == true) {
					JSONObject objReturn = new JSONObject();
					JSONObject jObj = array.getJSONObject(i);
					objReturn.put("make", jObj.getJSONObject("Identification").getString("Make"));
					objReturn.put("model", jObj.getJSONObject("Identification").getString("ID"));
					// se añade el jsonobject al jsonarray de retorno
					arrayReturn.put(objReturn);
				}
			}
		} else {
			for (int i = 0; i < array.length(); i++) {
				// si en la informacion del motor devuelve 'false' en "Hybrid" recoge marca y
				// modelo y lo incluye en un jsonobject
				boolean object = ((JSONObject) array.get(i)).getJSONObject("Engine Information").getBoolean("Hybrid");
				if (!object == false) {
					JSONObject objReturn = new JSONObject();
					JSONObject jObj = array.getJSONObject(i);
					objReturn.put("make", jObj.getJSONObject("Identification").getString("Make"));
					objReturn.put("model", jObj.getJSONObject("Identification").getString("ID"));
					// se añade el jsonobject al jsonarray de retorno
					arrayReturn.put(objReturn);
				}
			}
		}
		return arrayReturn;
	}

	// Funcion 10 - Devuelve modelos y marcas de los coches segun la cantidad de
	// velocidades
	public JSONArray cantidadVelocidades(JSONArray array, int velocidades) {
		if (velocidades <= 0 || velocidades > 8) {
			return null;
		}
		JSONArray arrayReturn = new JSONArray();
		// se recorre el array de coches
		for (int i = 0; i < array.length(); i++) {
			// recoge marca y modelo de coche en un jsonobject de los que coincidan con el
			// numero de velocidades especificado
			int object = ((JSONObject) array.get(i)).getJSONObject("Engine Information")
					.getInt("Number of Forward Gears");
			if (object == velocidades) {
				JSONObject objReturn = new JSONObject();
				JSONObject jObj = array.getJSONObject(i);
				objReturn.put("make", jObj.getJSONObject("Identification").getString("Make"));
				objReturn.put("model", jObj.getJSONObject("Identification").getString("ID"));
				// se añade el jsonobject al jsonarray de retorno
				arrayReturn.put(objReturn);
			}
		}
		return arrayReturn;
	}

	// Funcion 11 - Devuelve modelos y marcas de los coches que tengan un consumo en
	// ciudad menor o mayr a una cantidad indicada, ordenandolos segun se haya
	// indicado
	public JSONArray consumoCiudad(JSONArray array, int cantidad, boolean cantidadmenor, boolean ordendescendente) {
		if (cantidad <= 0) {
			return null;
		}
		JSONArray arrayReturn = new JSONArray();
		// se recorre el array de coches
		for (int i = 0; i < array.length(); i++) {
			// recoge marca y modelo de coche en un jsonobject de los que tengan una
			// cantidad de consumo menor a lo indicado
			int object = ((JSONObject) array.get(i)).getJSONObject("Fuel Information").getInt("City mph");
			if (cantidadmenor == true) {
				if (object < cantidad) {
					JSONObject objReturn = new JSONObject();
					JSONObject jObj = array.getJSONObject(i);
					objReturn.put("make", jObj.getJSONObject("Identification").getString("Make"));
					objReturn.put("model", jObj.getJSONObject("Identification").getString("ID"));
					objReturn.put("mph", jObj.getJSONObject("Fuel Information").getInt("City mph"));
					// se añade el jsonobject al jsonarray de retorno
					arrayReturn.put(objReturn);
				}
			} else {
				if (object > cantidad) {
					JSONObject objReturn = new JSONObject();
					JSONObject jObj = array.getJSONObject(i);
					objReturn.put("make", jObj.getJSONObject("Identification").getString("Make"));
					objReturn.put("model", jObj.getJSONObject("Identification").getString("ID"));
					objReturn.put("mph", jObj.getJSONObject("Fuel Information").getInt("City mph"));
					// se añade el jsonobject al jsonarray de retorno
					arrayReturn.put(objReturn);
				}
			}

		}
		// se pasa el jsonarray a tipo arraylist para poder usar comparadores
		List<JSONObject> jsonValues = new ArrayList<JSONObject>();
		for (int i = 0; i < arrayReturn.length(); i++) {
			jsonValues.add(arrayReturn.getJSONObject(i));
		}

		Collections.sort(jsonValues, new Comparator<JSONObject>() {

			private static final String MPH = "mph";

			@Override
			public int compare(JSONObject a, JSONObject b) {
				Integer valA = 0;
				Integer valB = 0;

				valA = (int) a.get(MPH);
				valB = (int) b.get(MPH);

				int mult = -1;
				if (!ordendescendente) {
					mult = 1;
				}

				if (valA < valB) {
					return mult * -1;
				} else if (valA > valB) {
					return mult * 1;
				} else {
					return mult * (a.getString("model").compareTo(b.getString("model")));
				}

			}
		});
		// se crea variable jsonarray y se llena con el resultante arraylist, se retorna
		// esta variable
		JSONArray arraySorted = new JSONArray();
		for (int i = 0; i < jsonValues.size(); i++) {
			arraySorted.put(jsonValues.get(i));
		}
		return arraySorted;
	}

	// Funcion 12 - Devuelve modelos y marcas de los coches que contengan una
	// determinada cadena de caracteres dentro de su engine type
	public JSONArray incluyeEnMotor(JSONArray array, String caracteres) {
		if (caracteres.length() == 0) {
			return null;
		}

		JSONArray arrayReturn = new JSONArray();
		// se crea un arraylist donde incluir la lista de coches para posteriormente
		// poder usar el metodo contains
		List<JSONObject> jsonValues = new ArrayList<JSONObject>();
		for (int i = 0; i < array.length(); i++) {
			jsonValues.add(array.getJSONObject(i));
		}
		// se recorre el array de coches
		for (int i = 0; i < array.length(); i++) {
			String object = jsonValues.get(i).getJSONObject("Engine Information").getString("Engine Type");
			if(object.contains(caracteres)) {
				JSONObject objReturn = new JSONObject();
				JSONObject jObj = array.getJSONObject(i);
				objReturn.put("make", jObj.getJSONObject("Identification").getString("Make"));
				objReturn.put("model", jObj.getJSONObject("Identification").getString("ID"));
				// se añade el jsonobject al jsonarray de retorno
				arrayReturn.put(objReturn);				
			}
		}
		return arrayReturn;
	}

}