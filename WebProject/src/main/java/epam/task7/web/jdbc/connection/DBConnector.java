package epam.task7.web.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector
{
    private Connection connection;

    private final String URL = "jdbc:mysql://localhost:3306/cities_db";
    private final String USERNAME = "root";
    private final String PASSWORD = "root";

    /*public static void main(String[] args)
    {
        DBConnector dbConnector = new DBConnector();
        dbConnector.getConnection();
        dbConnector.closeConnection();
    }*/

    public DBConnector()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public Connection getConnection()
    {
        try
        {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return connection;
    }

    public void closeConnection()
    {
        try
        {
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
