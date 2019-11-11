package WeatherGeneration;

import Aircraft.Coordinates;

import java.util.Random;

public class WeatherProvider
{
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private  String weather[] = {"RAIN", "FOG", "SNOW", "SUN"};

    WeatherProvider()
    {
    }

    public static WeatherProvider getProvider()
    {
        return WeatherProvider.weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates)
    {
        Random rand = new Random();
        int weath = 0;
        weath = rand.nextInt(4);
        return weather[weath];
    }
}
