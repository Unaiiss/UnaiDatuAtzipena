package control;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("deprecation")
		JsonParser parser = new JsonParser();
		final String url = "C:\\Users\\in2dm3-d\\eclipse-workspaceUnai\\JsonArtiketak\\src\\fichero\\stocks.json";
		
		FileReader fr = new FileReader(url);
		JsonElement datos = parser.parse(fr);
		
		JsonArray array = datos.getAsJsonArray();
		Iterator<JsonElement> iter = array.iterator();
		System.out.println("Array. Numero de elementos: " + array.size());
		
		while(iter.hasNext()) {
			JsonElement entrada = iter.next();
			JsonObject objeto = entrada.getAsJsonObject();
			Iterator<Map.Entry<String, JsonElement>> iter2 = objeto.entrySet().iterator();
			
			JsonPrimitive valor = iter2.next().getValue().getAsJsonPrimitive();
			System.out.println("Company: " + valor.getAsString());
			
			valor = iter2.next().getValue().getAsJsonPrimitive();
			System.out.println("Description: " + valor.getAsString());
			
			valor = iter2.next().getValue().getAsJsonPrimitive();
			System.out.println("Initial price: " + valor.getAsDouble());
			
			valor = iter2.next().getValue().getAsJsonPrimitive();
			System.out.println("Price 2002: " + valor.getAsDouble());
			
			valor = iter2.next().getValue().getAsJsonPrimitive();
			System.out.println("Price 2007: " + valor.getAsDouble());
			
			valor = iter2.next().getValue().getAsJsonPrimitive();
			System.out.println("Symbol: " + valor.getAsString());
			
			System.out.println("");
			
		}
	}

}
