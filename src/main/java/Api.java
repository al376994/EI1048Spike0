import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Api {

	static private String keyAirVisual = "bf324fc3-3c44-4f50-bd19-836179b019b8";
	static private String keyOpenWeather = "8f2633d2de2dbc92ae0f906749d61e15";

	// http://api.airvisual.com/v2/countries?key={{YOUR_API_KEY}}

	HttpClient client = HttpClient.newHttpClient();

	HttpRequest requestAirirVisual = HttpRequest.newBuilder(
			URI.create("http://api.airvisual.com/v2/countries?key=" + keyAirVisual))
			.header("accept", "application/json")
			.build();
	HttpRequest requestOpenWeather;

	public String getCountries() {
		HttpResponse<String> r = null;
		try {
			r = client.send(requestAirirVisual, BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		if (r == null) return "";

		return r.body();

	}

	// "http://api.airvisual.com/v2/countries?key=" + keyAirVisual

}
