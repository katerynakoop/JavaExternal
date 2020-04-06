package javaexternal.epam.task7.model.entity;

public class Country implements Entity
{
    private String country;
    private String citizenName;
    private String language;

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
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
}
