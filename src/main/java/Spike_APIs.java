import org.json.JSONObject;

public class Spike_APIs {

	public static void main (String [ ] args) {
		Api api = new Api();
		String countriesRaw = api.getCountries();

		System.out.println("\n\n---------------------------------------------------------");
		System.out.println("AirVisual all countries raw:\n" + countriesRaw + "\n");

		JSONObject jObject = new JSONObject(countriesRaw);
		String firstListedCountry = jObject.getJSONArray("data").getJSONObject(0).get("country").toString();
		System.out.println("AirVisual first listed country: " + firstListedCountry);
		System.out.println("---------------------------------------------------------\n");

	}

}
