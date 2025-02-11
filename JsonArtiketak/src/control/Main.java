package control;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

import modelo.Stock;
import vista.TablaStocks;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		@SuppressWarnings("deprecation")
		JsonParser parser = new JsonParser();
		final String url = "src\\fichero\\stocks.json";
		
		FileReader fr = new FileReader(url);
		JsonElement datos = parser.parse(fr);
		
		JsonArray array = datos.getAsJsonArray();
		Iterator<JsonElement> iter = array.iterator();
		System.out.println("Array. Numero de elementos: " + array.size());
		
		ArrayList<Stock> stockList = new ArrayList<Stock>();
		
		while(iter.hasNext()) {
			Stock stock = new Stock();
			
			
			JsonElement entrada = iter.next();
			JsonObject objeto = entrada.getAsJsonObject();
			Iterator<Map.Entry<String, JsonElement>> iter2 = objeto.entrySet().iterator();
			
			JsonPrimitive valor = iter2.next().getValue().getAsJsonPrimitive();
			stock.setCompany(valor.getAsString());
			
			valor = iter2.next().getValue().getAsJsonPrimitive();
			stock.setDescription(valor.getAsString());
			
			valor = iter2.next().getValue().getAsJsonPrimitive();
			stock.setInitialPrice(valor.getAsDouble());
			
			valor = iter2.next().getValue().getAsJsonPrimitive();
			stock.setPrice2002(valor.getAsDouble());
			
			valor = iter2.next().getValue().getAsJsonPrimitive();
			stock.setPrice2007(valor.getAsDouble());
			
			valor = iter2.next().getValue().getAsJsonPrimitive();
			stock.setSymbol(valor.getAsString());
			
			stockList.add(stock);
		}
		
		System.out.println("Ir a lista de stocks?");
		String respuesta = sc.nextLine();
		
		if (respuesta.equals("s")) {
			TablaStocks tabla = new TablaStocks(stockList);
			tabla.setVisible(true);
		}
		
	}

}
