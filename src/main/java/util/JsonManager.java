package util;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


/*

 * Se encarga de gestionar el archivo JSON
 * */

public class JsonManager {

	private JSONParser parser;

	private static JsonManager myInstance;

	private JsonManager() {
		parser = new JSONParser();
	}
	
	
	


	/**
	 * Implementa el patrón singleton para obtener una unica instancia de esta clase,
	 * para realizar un uso optimo de los recursos
	 * */
	public static JsonManager getInstance() {

		if (myInstance == null) {
			myInstance = new JsonManager();
		}
		return myInstance;
	}

	public boolean jsonSave(String ruta, JSONObject obj) throws IOException {

		FileWriter file = new FileWriter(ruta);
		file.write(obj.toJSONString());
		System.out.println("Successfully Copied JSON Object to File...");
		System.out.println("\nJSON Object: " + obj);
		return true;

	}

	
	
	public JSONObject getJsonReader(String ruta) throws java.lang.Exception {

		Object obj = null;
		try {

			obj = parser.parse(new FileReader(ruta));
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			throw new Exception("Error al leer archivo json : "+e.getMessage());
		}

		return (JSONObject) obj;

	}
	
	
	public JSONObject getJsonReader() throws java.lang.Exception {

		Object obj = null;
		try {

			obj = parser.parse(new FileReader("data-test.json"));
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			throw new Exception(e);
		}

		return (JSONObject) obj;
	}
	
	/*Determina cuales son las plantillas que se van a editar*/
	public JSONArray cargarEntidades() throws Exception {

		try {

			JSONObject json = (JSONObject) JsonManager.getInstance().getJsonReader();


			return (JSONArray)json.get("entidades");
		} catch (Exception e) {
			throw new Exception("Error al cargar la configuración " + e.getMessage());
		}

	}
	
	
	
}