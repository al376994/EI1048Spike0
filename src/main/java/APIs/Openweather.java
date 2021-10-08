package APIs;

public class Openweather extends Api {

	static private String key = keyOpenWeather;

	static public String currentWeatherOnCoords(float lat, float lon) {
		String uri = "http://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=" + key;
		return GetBody(uri);
	}

}
