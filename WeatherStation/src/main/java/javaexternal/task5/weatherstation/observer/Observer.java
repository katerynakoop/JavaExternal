package javaexternal.task5.weatherstation.observer;

public interface Observer
{
    void update(float temperature, float humidity, float pressure,float temp_min, float temp_max, float wind_speed);
}
