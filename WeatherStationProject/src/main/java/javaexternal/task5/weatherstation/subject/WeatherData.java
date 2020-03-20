package javaexternal.task5.weatherstation.subject;

import javaexternal.task5.weatherstation.observer.Observer;
import javaexternal.task5.weatherstation.parser.JSONParser;
import javaexternal.task5.weatherstation.parser.Parser;
import javaexternal.task5.weatherstation.urlprocessing.DataFormat;
import javaexternal.task5.weatherstation.urlprocessing.Location;
import javaexternal.task5.weatherstation.urlprocessing.URLProcessing;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject
{
    private List<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;
    protected float temp_min;
    protected float temp_max;
    protected float wind_speed;


    public WeatherData()
    {
        observers = new ArrayList<>();
    }

    @Override
    public void notifyObservers()
    {
        for(Observer observer: observers)
        {
            observer.update(temperature, humidity, pressure, temp_min, temp_max, wind_speed);
        }
    }

    @Override
    public void registerObserver(Observer o)
    {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o)
    {
        int i = observers.indexOf(o);
        if(i >= 0)
        {
            observers.remove(i);
        }
    }

    public void measurementsChanged()
    {
        notifyObservers();
    }

    public void getMeasurementsFromOpenWeatherMapAPI()
    {
        URLProcessing urlProcessing = new URLProcessing();
        Location location = new Location();
        DataFormat dataFormat = new DataFormat();
        Parser parser;

        dataFormat.setResponseDataFormat();
        parser = dataFormat.getParser();

        location.setLocation();
        String url = urlProcessing.getURL(location.getLocation(), dataFormat.getDataFormat());

        String response = urlProcessing.getResponseBodyFromUrl(url);
        parser.parse(response);

        this.temperature = converseKelvinToCelsius(parser.getTemperature());
        this.humidity = parser.getHumidity();
        this.pressure = parser.getPressure();
        this.temp_min = parser.getTempMin();
        this.temp_max = parser.getTempMax();
        this.wind_speed = parser.getWindSpeed();

        measurementsChanged();
    }

    public float converseKelvinToCelsius(float KelvinTemp)
    {
        float CelsiusTemp = KelvinTemp - 273.15f;
        return CelsiusTemp;
    }

    public float getTemperature()
    {
        return temperature;
    }

    public float getHumidity()
    {
        return humidity;
    }

    public float getPressure()
    {
        return pressure;
    }

    public float getTemp_min()
    {
        return temp_min;
    }

    public float getTemp_max()
    {
        return temp_max;
    }

    public float getWind_speed()
    {
        return wind_speed;
    }
}
