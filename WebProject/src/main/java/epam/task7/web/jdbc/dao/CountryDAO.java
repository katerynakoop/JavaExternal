package epam.task7.web.jdbc.dao;

import epam.task7.web.model.Country;
import epam.task7.web.jdbc.enum_queries.CountrySQLQueries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryDAO implements DAO<Country, String>
{
    private  final Connection connection;

    public CountryDAO(Connection connection)
    {
        this.connection = connection;
    }

    @Override
    public void createRecord(Country country)
    {
        try(PreparedStatement statement = connection.prepareStatement(CountrySQLQueries.INSERT_RECORD.getQuery());)
        {
            statement.setString(1, country.getName());
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
                country.setName(rs.getString("Country"));
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
            statement.setString(3, country.getName());
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
}
