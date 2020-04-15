package epam.task7.web.model;

import java.io.Serializable;

public class Country implements Model, Serializable
{
    private String name;
    private String citizenName;
    private String language;

    public Country(String name, String citizenName, String language)
    {
        this.name = name;
        this.citizenName = citizenName;
        this.language = language;
    }

    public Country()
    {

    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getCitizenName()
    {
        return citizenName;
    }

    public void setCitizenName(String citizenName)
    {
        this.citizenName = citizenName;
    }

    public String getLanguage()
    {
        return language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }

    @Override
    public String toString()
    {
        return "INFO ABOUT COUNTRY: " +
                "Name: " + name + "\n" +
                "Citizen name: " + citizenName + "\n" +
                "Language: " + language + "\n";
    }
}
