package javaexternal.epam.task7.model.repository;

import javaexternal.epam.task7.model.enum_queries.CountrySQLQueries;
import javaexternal.epam.task7.model.entity.Country;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CountryRepository extends AbstractRepository<Country, String>
{
    @Override
    public void createRecord(Country country)
    {
        try(PreparedStatement statement = connection.prepareStatement(CountrySQLQueries.INSERT_RECORD.getQuery());)
        {
            statement.setString(1, country.getCountry());
            statement.setString(2, country.getCitizenName());
            statement.setString(3, country.getLanguage());
            statement.execute();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public Country readRecord(String countryName)
    {
        Country country = null;
        try(PreparedStatement statement = connection.prepareStatement(CountrySQLQueries.GET_RECORD.getQuery()))
        {
            statement.setString(1, countryName);
            ResultSet rs = statement.executeQuery();

            while (rs.next())
            {
                country = new Country();
                country.setCountry(rs.getString("Country"));
                country.setCitizenName(rs.getString("CitizenName"));
                country.setLanguage(rs.getString("Language"));
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return country;
    }

    @Override
    public void updateRecord(String countryName)
    {
        Country country = new Country();

        try(PreparedStatement statement = connection.prepareStatement(CountrySQLQueries.UPDATE_RECORD.getQuery()))
        {
            statement.setString(1, country.getLanguage());
            statement.setString(2, country.getCitizenName());
            statement.setString(3, country.getCountry());
            statement.execute();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRecord(String countryName)
    {
        try(PreparedStatement statement = connection.prepareStatement(CountrySQLQueries.DELETE_RECORD.getQuery()))
        {
            statement.setString(1, countryName);
            statement.execute();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public List<Country> readAllRecords()
    {
        List<Country> countries = new ArrayList<>();
        Country country = null;

        try(Statement statement = connection.createStatement())
        {
            ResultSet rs = statement.executeQuery(CountrySQLQueries.GET_ALL_RECORDS.getQuery());

            while (rs.next())
            {
                country = new Country();
                country.setCountry(rs.getString("Country"));
                country.setCitizenName(rs.getString("CitizenName"));
                country.setLanguage(rs.getString("Language"));
                countries.add(country);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return countries;
    }
}
