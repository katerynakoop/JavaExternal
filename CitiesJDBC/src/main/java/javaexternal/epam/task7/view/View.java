package javaexternal.epam.task7.view;

import javaexternal.epam.task7.model.entity.City;
import javaexternal.epam.task7.model.entity.Country;

import java.util.List;

public class View
{
    public static void displayCity(City city)
    {
        System.out.println("INFO ABOUT CITY: ");
        System.out.println("ID: " + city.getId());
        System.out.println("Name: " + city.getName());
        System.out.println("Country: " + city.getCountry());
        System.out.println("Foundation year: " + city.getFoundationYear());
        System.out.println("Square: " + city.getSquare());
        System.out.println("Population: " + city.getPopulation());
    }

    public static void displayCountry(Country country)
    {
        System.out.println("INFO ABOUT CITY: ");
        System.out.println("Country: " + country.getCountry());
        System.out.println("Citizen name: " + country.getCitizenName());
        System.out.println("Language: " + country.getLanguage());
    }

    public static void displayAllCities(List<City> cities)
    {
        for(City city: cities)
        {
            displayCity(city);
        }
    }

    public static void displayAllCountries(List<Country> countries)
    {
        for(Country country: countries)
        {
            displayCountry(country);
        }
    }

}
