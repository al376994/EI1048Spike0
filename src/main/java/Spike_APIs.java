import APIs.Airvisual;
import org.json.JSONObject;

import java.util.Date;

public class Spike_APIs {

	public static void main (String [ ] args) {
		//printAirVisualAllCountries();
		printAirVisualAllProvincesFrom("Spain");
	}

	static private void printStart() {
		System.out.println("\n\n---------------------------------------------------------");
	}

	static private void printFinal() {
		System.out.println("---------------------------------------------------------\n");
	}

	static private void printAirVisualAllCountries() {
		printStart();

		String countriesRaw = Airvisual.getCountries();
		System.out.println("AirVisual all countries raw:\n" + countriesRaw + "\n");

		JSONObject jObject = new JSONObject(countriesRaw);
		String firstListedCountry = jObject.getJSONArray("data").getJSONObject(0).get("country").toString();
		System.out.println("AirVisual first listed country: " + firstListedCountry);

		printFinal();
	}

	static private void printAirVisualAllProvincesFrom(String country) {
		printStart();

		String raw = Airvisual.getProvinceFrom(country);
		JSONObject jObject = new JSONObject(raw);

	}

}
