package epam.task7.web.jdbc.repository;

import epam.task7.web.jdbc.connection.DBConnector;
import epam.task7.web.model.City;
import epam.task7.web.jdbc.enum_queries.CitySQLQueries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityRepository extends Repository implements CRUDRepository<City, Integer>
{
    private final Logger logger = LoggerFactory.getLogger(CityRepository.class);
    String result_str;


/*    public static void main(String[] args)
    {
        DBConnector connector = new DBConnector();
        Connection connection = connector.getConnection();
        CityRepository cityRepository = new CityRepository(connection);

        City city = new City();
        city.setName("New York");
        city.setCountry("The USA");
        city.setFoundationYear("1624 A.D");
        city.setSquare(1213);
        city.setPopulation(8175133);

        String resultStr = cityRepository.createRecord(city);
        System.out.println(resultStr);
    }*/

    public CityRepository(Connection connection)
    {
        super(connection);
    }

    public boolean isCityInDB(int id)
    {
        boolean isCityInDB = false;

        try(PreparedStatement statement = connection.prepareStatement(CitySQLQueries.CHECK_ID_EXISTENCE.getQuery()))
        {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if(rs.next() && (rs.getInt(1) == 1))
            {
                isCityInDB = true;
            }
        }
        catch (SQLException e)
        {
            logger.error(RepositoryMessages.PRESENCE_WAS_NOT_CHECKED, e);
        }
        return isCityInDB;
    }

    @Override
    public String createRecord(final City city)
    {
        result_str = null;

        try(PreparedStatement statement = connection.prepareStatement(CitySQLQueries.INSERT_RECORD.getQuery()))
        {
            statement.setString(1, city.getName());
            statement.setString(2, city.getFoundationYear());
            statement.setInt(3, city.getSquare());
            statement.setInt(4, city.getPopulation());
            statement.setString(5, city.getCountry());
            statement.execute();
            result_str = RepositoryMessages.RECORD_CREATED_SUCCESSFULLY;
        }
        catch (SQLException e)
        {
            result_str = RepositoryMessages.RECORD_WAS_NOT_CREATED;
            logger.error(RepositoryMessages.RECORD_WAS_NOT_CREATED, e);
        }

        return result_str;
    }


    @Override
    public City readRecord(Integer id)
    {
        City city = null;

        if(isCityInDB(id))
        {
            try(PreparedStatement statement = connection.prepareStatement(CitySQLQueries.GET_RECORD.getQuery()))
            {
                statement.setInt(1, id);
                ResultSet rs = statement.executeQuery();

                while (rs.next())
                {
                    city = new City();
                    city.setId(rs.getInt("ID"));
                    city.setName(rs.getString("Name"));
                    city.setFoundationYear(rs.getString("FoundationYear"));
                    city.setSquare(rs.getInt("Square"));
                    city.setPopulation(rs.getInt("Population"));
                    city.setCountry(rs.getString("Country"));
                }
            }
            catch(SQLException e)
            {
                logger.error(RepositoryMessages.RECORD_WAS_NOT_READ);
            }
        }

        return city;
    }

    @Override
    public String updateRecord(Integer id, City updatedCity)
    {
        result_str = null;

        if(isCityInDB(id))
        {
            try(PreparedStatement statement = connection.prepareStatement(CitySQLQueries.UPDATE_RECORD.getQuery()))
            {
                statement.setString(1, updatedCity.getName());
                statement.setString(2, updatedCity.getFoundationYear());
                statement.setInt(3, updatedCity.getSquare());
                statement.setInt(4, updatedCity.getPopulation());
                statement.setString(5, updatedCity.getCountry());
                statement.setInt(6, id);
                statement.execute();
                result_str = RepositoryMessages.RECORD_UPDATED_SUCCESSFULLY;
            }
            catch (SQLException e)
            {
                result_str = RepositoryMessages.RECORD_WAS_NOT_UPDATED;
                logger.error(RepositoryMessages.RECORD_WAS_NOT_UPDATED, e);
            }
        }
        else
        {
            result_str = RepositoryMessages.RECORD_DOES_NOT_EXIST_IN_DB;
        }

        return result_str;
    }

    @Override
    public String deleteRecord(Integer id)
    {
        result_str = null;

        if(isCityInDB(id))
        {
            try(PreparedStatement statement = connection.prepareStatement(CitySQLQueries.DELETE_RECORD.getQuery()))
            {
                statement.setInt(1, id);
                statement.execute();
                result_str = RepositoryMessages.RECORD_DELETED_SUCCESSFULLY;
            }
            catch (SQLException e)
            {
                result_str = RepositoryMessages.RECORD_WAS_NOT_DELETED;
                logger.error(RepositoryMessages.RECORD_WAS_NOT_DELETED, e);
            }
        }
        else
        {
            result_str = RepositoryMessages.RECORD_DOES_NOT_EXIST_IN_DB;
        }

        return result_str;
    }

    @Override
    public List<City> readAllRecords()
    {
        List<City> cities = new ArrayList<>();
        City city = null;

        try(Statement statement = connection.createStatement())
        {
            ResultSet rs = statement.executeQuery(CitySQLQueries.GET_ALL_RECORDS.getQuery());

            while (rs.next())
            {
                city = new City();
                city.setId(rs.getInt("ID"));
                city.setName(rs.getString("Name"));
                city.setFoundationYear(rs.getString("FoundationYear"));
                city.setSquare(rs.getInt("Square"));
                city.setPopulation(rs.getInt("Population"));
                city.setCountry(rs.getString("Country"));
                cities.add(city);
            }
        }
        catch(SQLException e)
        {
            logger.error(RepositoryMessages.ALL_RECORDS_LIST_WAS_NOT_CREATED, e);
        }
        return cities;
    }
}
