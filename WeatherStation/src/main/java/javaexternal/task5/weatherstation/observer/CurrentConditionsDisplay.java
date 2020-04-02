package javaexternal.task5.weatherstation.observer;

import javaexternal.task5.weatherstation.subject.Subject;

public class CurrentConditionsDisplay implements Observer, DisplayElement
{
    private float temperature;
    private float humidity;
    private float pressure;
    protected float temp_min;
    protected float temp_max;
    protected float wind_speed;
    private Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData)
    {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display()
    {
        System.out.println("The current weather: ");
        System.out.println("Temperature: " + temperature);
        System.out.println("Humidity: " + humidity);
        System.out.println("Pressure: " + pressure);
        System.out.println("Min temperature for the day: " + temp_min);
        System.out.println("Max temperature for the day: " + temp_max);
        System.out.println("Speed of the wind: " + wind_speed);
    }

    @Override
    public void update(float temperature, float humidity, float pressure,float temp_min, float temp_max, float wind_speed)
    {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.temp_min = temp_min;
        this.temp_max = temp_max;
        this.wind_speed = wind_speed;
    }
}
