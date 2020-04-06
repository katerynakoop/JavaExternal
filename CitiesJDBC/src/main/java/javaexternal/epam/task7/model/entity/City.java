package javaexternal.epam.task7.model.entity;

public class City implements Entity
{
    private int id;
    private String name;
    private String foundationYear;
    private int square;
    private int population;
    private String country;

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
}
