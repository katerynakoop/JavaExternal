package javaexternal.task5.weatherstation.runner;

import javaexternal.task5.weatherstation.observer.CurrentConditionsDisplay;
import javaexternal.task5.weatherstation.subject.WeatherData;

public class WeatherStation
{
    public static void main(String[] args)
    {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
        weatherData.getMeasurementsFromOpenWeatherMapAPI();
        currentDisplay.display();
    }
}
