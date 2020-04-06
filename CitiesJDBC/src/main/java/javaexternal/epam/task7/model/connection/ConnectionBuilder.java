package javaexternal.epam.task7.model.connection;

import java.sql.Connection;

@FunctionalInterface
public interface ConnectionBuilder
{
    Connection getConnection();
}
