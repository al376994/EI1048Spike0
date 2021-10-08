import APIs.Airvisual;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

		List<Object> rawProvinces = jObject.getJSONArray("data").toList();
		List<String> provinces = rawProvinces.stream()
				.map(object -> Objects.toString(object, null))
				.collect(Collectors.toList());
		provinces.replaceAll(x -> x.substring(7, x.length()-1));

		System.out.println(provinces);

		Date date = new Date(2021, 10, 8);

	}

}
