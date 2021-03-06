package javaexternal.epam.task7.model.enum_queries;

public enum CountrySQLQueries
{
    GET_RECORD("SELECT * FROM countries WHERE Country = (?)"),
    GET_ALL_RECORDS("SELECT * FROM countries"),
    INSERT_RECORD("INSERT INTO countries (Country, CitizenName, Language) VALUES ((?), (?), (?))"),
    DELETE_RECORD("DELETE FROM countries WHERE Country = (?)"),
    UPDATE_RECORD("UPDATE countries SET Language = (?), CitizenName = (?) WHERE Country = (?)");

    private String query;

    CountrySQLQueries(String query)
    {
        this.query = query;
    }

    public String getQuery()
    {
        return query;
    }
}
