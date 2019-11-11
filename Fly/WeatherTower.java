package Fly;

import Aircraft.Coordinates;
import WeatherGeneration.WeatherProvider;

public class WeatherTower extends Tower
{
    public String getWeather(Coordinates coordinates)
    {
       return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

     void changeWeather()
    {
        this.conditionChanged();
    }
}
