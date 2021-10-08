package APIs;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

abstract class Api {

	static final String keyAirVisual = "bf324fc3-3c44-4f50-bd19-836179b019b8";
	static final String keyOpenWeather = "8f2633d2de2dbc92ae0f906749d61e15";
	private static final HttpClient client = HttpClient.newHttpClient();

	static String GetBody(String givenURI) {
		HttpRequest request = makeRequest(givenURI);
		if (request == null) return null;
		HttpResponse<String> response = getResponse(request);
		return response.body();
	}

	static private HttpRequest makeRequest(String givenURI) {
		return HttpRequest.newBuilder(URI.create(givenURI))
				.header("accept", "application/json")
				.build();
	}

	static private HttpResponse<String> getResponse(HttpRequest request) {
		HttpResponse<String> response = null;
		try {
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		return response;
	}

	private HttpRequest requestOpenWeather;


}
