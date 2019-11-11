package Aircraft;

import Fly.Flyable;
import Fly.WeatherTower;
import files.writing;

public class Helicopter extends Aircraft implements Flyable
{
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates Coordinates)
    {
        super(name, Coordinates);
    }

    public void updateCondition()
    {
        String weather = this.weatherTower.getWeather(this.coordinates);
        if (weather.equals("RAIN"))
        {
            this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
            writing.WriteToFile("Helicopter#" + this.name + "(" + this.id + ") : Rain is a blessing");
        }
        else if (weather.equals("SNOW"))
        {
            this.coordinates.setHeight(this.coordinates.getHeight() - 12);
            writing.WriteToFile("Helicopter#" + this.name + "(" + this.id + ") : Its so cold");
        }
        else if(weather.equals("SUN"))
        {
            this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
            this.coordinates.setHeight(this.coordinates.getHeight() + 2);
            writing.WriteToFile("Helicopter#"+ this.name + "(" + this.id + ") : Lets enjoy this beautiful weather");
        }
        else if (weather.equals("FOG"))
        {
            this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
            writing.WriteToFile("Helicopter#" + this.name  + "(" + this.id + ") : This weather makes you feel so alone");
        }
        if (this.coordinates.getHeight() > 100)
            this.coordinates.setHeight(100);
        else if (this.coordinates.getHeight() <= 0)
        {
            this.weatherTower.unregister(this);
            writing.WriteToFile("Helicopter#" + this.name + "(" + this.id + ")  landing");
            writing.WriteToFile("Tower says: " + "Helicopter#" + this.name  +"("+this.id+")" + " unregistered from weather tower");
        }
    }

    public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        writing.WriteToFile("Tower says: " + "Helicopter"+ this.name +"#" + "("+ this.id +")" + " registered to weather tower");
    }

}
