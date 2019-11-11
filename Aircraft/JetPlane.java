package Aircraft;

import Fly.Flyable;
import Fly.WeatherTower;
import files.writing;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }

    public void updateCondition()
    {
        String weather = this.weatherTower.getWeather(this.coordinates);
        if (weather.equals("RAIN"))
        {
            this.coordinates.setLatitude(this.coordinates.getLatitude() + 5);
            writing.WriteToFile("JetPlane#" + this.name + "(" + this.id + ") : let us be thankful for the rain");
        }
        else if (weather.equals("SNOW"))
        {
            this.coordinates.setHeight(this.coordinates.getHeight() - 7);
            writing.WriteToFile("JetPlane#" + this.name  + "(" + this.id + ") : Let us make a snow man!?");
        }
        else if (weather.equals("SUN"))
        {
            this.coordinates.setLatitude(this.coordinates.getLongitude() + 10);
            this.coordinates.setHeight(this.coordinates.getHeight() + 2);
            writing.WriteToFile("JetPlane#" + this.name  + "(" + this.id + ") : Everything is so colourful, beautiful weather");
        }
        else if (weather.equals("FOG"))
        {
            this.coordinates.setLatitude(this.coordinates.getLatitude() + 1);
            writing.WriteToFile("JetPlane#" + this.name + "(" + this.id + ") : lets just cancel all our plans");
        }
        if (this.coordinates.getHeight() > 100)
            this.coordinates.setHeight(100);
        else if (this.coordinates.getHeight() <= 0)
        {
            this.weatherTower.unregister(this);
            writing.WriteToFile("JetPlane#" + this.name + "(" + this.id + ")  landing");
            writing.WriteToFile("Tower says: " + "JetPlane#" + this.name + "("+this.id+")" + " unregistered from weather tower");
        }
        //writing.WriteToFile("JetPlane"+this.name +"("+this.id+")"+ "The aircraft is landing\n");

    }
    public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        writing.WriteToFile("Tower says: " + "JetPlane#"+ this.name + "(" + this.id + ")" + " registered to weather tower");
    }
}
