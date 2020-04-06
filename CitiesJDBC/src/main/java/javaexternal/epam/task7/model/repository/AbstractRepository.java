package javaexternal.epam.task7.model.repository;

import javaexternal.epam.task7.model.connection.DBConnector;
import javaexternal.epam.task7.model.entity.Entity;

import java.sql.Connection;
import java.util.List;

public abstract class AbstractRepository<E extends Entity, Key>
{
    protected Connection connection;

    abstract void createRecord(final E e);
    abstract void updateRecord(final Key key);
    abstract void deleteRecord(final Key key);
    abstract E readRecord(final Key key);
    abstract List<E> readAllRecords();

    public AbstractRepository()
    {
        DBConnector dbConnector = new DBConnector();
        connection = dbConnector.getConnection();
    }

    public Connection getConnection()
    {
        return connection;
    }
}
