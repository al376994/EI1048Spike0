package APIs;

public class Airvisual extends Api {

	static private String key = keyAirVisual;

	static public String getCountries() {
		String uri = "http://api.airvisual.com/v2/countries?key=" + key;
		return GetBody(uri);
	}

	static public String getProvinceFrom(String country) {
		String uri = "http://api.airvisual.com/v2/states?country=" + country + "&key=" + key;
		return GetBody(uri);
	}
}
