package javaexternal.task5.weatherstation.parser;

public abstract class Parser
{
    protected float temperature;
    protected float humidity;
    protected float pressure;
    protected float temp_min;
    protected float temp_max;
    protected float wind_speed;

    public abstract void parse(String data);

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

    public float getTempMin()
    {
        return temp_min;
    }

    public float getTempMax()
    {
        return temp_max;
    }

    public float getWindSpeed()
    {
        return wind_speed;
    }
}
