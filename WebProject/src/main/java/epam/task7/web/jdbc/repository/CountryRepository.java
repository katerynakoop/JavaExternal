
package epam.task7.web.jdbc.repository;

import epam.task7.web.jdbc.enum_queries.CountrySQLQueries;
import epam.task7.web.model.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryRepository extends Repository implements CRUDRepository<Country, String>
{
    private final Logger logger = LoggerFactory.getLogger(CountryRepository.class);
    String result_str;

    public CountryRepository(Connection connection)
    {
        super(connection);
    }

/*    public static void main(String[] args)
    {
        DBConnector connector = new DBConnector();
        Connection con = connector.getConnection();
        CountryRepository countryRepository = new CountryRepository(con);
        boolean b = countryRepository.isCountryInDB("England");
        System.out.println(b);
    }*/

    public boolean isCountryInDB(String countryName)
    {
        boolean isCountryInDB = false;

        try(PreparedStatement statement = connection.prepareStatement(CountrySQLQueries.CHECK_COUNTRY_EXISTENCE.getQuery()))
        {
            statement.setString(1, countryName);
            ResultSet rs = statement.executeQuery();

            if(rs.next() && (rs.getInt(1) == 1))
            {
                isCountryInDB = true;
            }
        }
        catch (SQLException e)
        {
            logger.error(RepositoryMessages.PRESENCE_WAS_NOT_CHECKED, e);
        }
        return isCountryInDB;
    }

    @Override
    public String createRecord(Country country)
    {
        result_str = null;

        if(!isCountryInDB(country.getName()))
        {
            try (PreparedStatement statement = connection.prepareStatement(CountrySQLQueries.INSERT_RECORD.getQuery())) {
                statement.setString(1, country.getName());
                statement.setString(2, country.getCitizenName());
                statement.setString(3, country.getLanguage());
                statement.execute();
                result_str = RepositoryMessages.RECORD_CREATED_SUCCESSFULLY;
            }
            catch (SQLException e)
            {
                logger.error(RepositoryMessages.RECORD_WAS_NOT_CREATED, e);
                result_str = RepositoryMessages.RECORD_WAS_NOT_CREATED;
            }
        }
        else
        {
            result_str = RepositoryMessages.RECORD_ALREADY_EXIST_IN_DB;
        }

        return result_str;
    }

    @Override
    public Country readRecord(String countryName)
    {
        Country country = null;

        if(isCountryInDB(countryName))
        {
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
                logger.error(RepositoryMessages.RECORD_WAS_NOT_READ, e);
            }
        }

        return country;
    }

    @Override
    public String updateRecord(String countryName, Country updatedCountry)
    {
        String result_str;

        if(isCountryInDB(countryName))
        {
            try(PreparedStatement statement = connection.prepareStatement(CountrySQLQueries.UPDATE_RECORD.getQuery()))
            {
                statement.setString(1, updatedCountry.getLanguage());
                statement.setString(2, updatedCountry.getCitizenName());
                statement.setString(3, updatedCountry.getName());
                statement.execute();
                result_str = RepositoryMessages.RECORD_UPDATED_SUCCESSFULLY;
            }
            catch (SQLException e)
            {
                logger.error(RepositoryMessages.RECORD_WAS_NOT_UPDATED, e);
                result_str = RepositoryMessages.RECORD_WAS_NOT_UPDATED;
            }
        }
        else
        {
            result_str = RepositoryMessages.RECORD_DOES_NOT_EXIST_IN_DB;
        }

        return result_str;
    }

    @Override
    public String deleteRecord(String countryName)
    {
        result_str = null;
        if(isCountryInDB(countryName))
        {
            try(PreparedStatement statement = connection.prepareStatement(CountrySQLQueries.DELETE_RECORD.getQuery()))
            {
                statement.setString(1, countryName);
                statement.execute();
                result_str = RepositoryMessages.RECORD_DELETED_SUCCESSFULLY;
            }
            catch (SQLException e)
            {
                logger.error(RepositoryMessages.RECORD_WAS_NOT_DELETED, e);
                result_str = RepositoryMessages.RECORD_WAS_NOT_DELETED;
            }
        }
        else
        {
            result_str = RepositoryMessages.RECORD_DOES_NOT_EXIST_IN_DB;
        }
        return result_str;
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
                country.setName(rs.getString("Country"));
                country.setCitizenName(rs.getString("CitizenName"));
                country.setLanguage(rs.getString("Language"));
                countries.add(country);
            }
        }
        catch(SQLException e)
        {
            logger.error(RepositoryMessages.ALL_RECORDS_LIST_WAS_NOT_CREATED  , e);
        }
        return countries;
    }
}
