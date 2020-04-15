package epam.task7.web.model;

import java.io.Serializable;

public class City implements Model, Serializable
{
    private int id;
    private String name;
    private String foundationYear;
    private int square;
    private int population;
    private String country;

    public City(String name, String foundationYear, int square, int population, String country)
    {
        this.name = name;
        this.foundationYear = foundationYear;
        this.square = square;
        this.population = population;
        this.country = country;
    }

    public City()
    {

    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getFoundationYear()
    {
        return foundationYear;
    }

    public void setFoundationYear(String foundationYear)
    {
        this.foundationYear = foundationYear;
    }

    public int getSquare()
    {
        return square;
    }

    public void setSquare(int square)
    {
        this.square = square;
    }

    public int getPopulation()
    {
        return population;
    }

    public void setPopulation(int population)
    {
        this.population = population;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    @Override
    public String toString() {
        return "INFO ABOUT CITY: " +
                "ID: " + id + "\n" +
                "Name: " + name + "\n" +
                "Country: " + country + "\n" +
                "Foundation year: " + foundationYear + "\n" +
                "Population: " + population + "\n" +
                "Square: " + square + "\n";
    }

}
