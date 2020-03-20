package javaexternal.task5.weatherstation.urlprocessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Location
{
    private String city;
    BufferedReader reader;

    public void setLocation()
    {
        reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the name of the city you want the current weather for: ");

        try
        {
            this.city = reader.readLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            // make logs
        }
    }

    public String getLocation()
    {
        return city;
    }
}
