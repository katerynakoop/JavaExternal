package epam.task7.web.jdbc.repository;

import epam.task7.web.jdbc.connection.DBConnector;

import java.sql.Connection;

public class Repository
{
    Connection connection;
    public Repository(Connection connection)
    {
        this.connection = connection;
    }

    public Repository()
    {

    }
}
