import APIs.Airvisual;
import APIs.Openweather;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Spike_APIs {

	public static void main (String [ ] args) {
		//printAirVisualAllCountries();
		//printAirVisualAllProvincesFrom("Spain");
		printOpenWeatherCurrentTimeOfCoords(39.986f, -0.0376709f);
	}

	static private void printStart() {
		System.out.println("\n\n--------------------------------------------------------------");
	}

	static private void printFinal() {
		System.out.println("--------------------------------------------------------------\n");
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

	static private void printOpenWeatherCurrentTimeOfCoords(float lat, float lon) {
		printStart();

		String raw = Openweather.currentWeatherOnCoords(lat, lon);
		JSONObject jObject = new JSONObject(raw);

		String weather = jObject.get("weather").toString();
		weather = new JSONObject(weather.substring(1, weather.length()-1)).get("description").toString();

		String sTemp = jObject.getJSONObject("main").get("temp").toString();
		double temp = (Double.parseDouble(sTemp) - 273.15);
		temp = temp - temp%0.01;

		System.out.println(raw);
		System.out.println("Weather: " + weather);
		System.out.println("Temperature: " + temp + "ºC");

		printFinal();
	}

}
