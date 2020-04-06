package javaexternal.epam.task7.model.enum_queries;

public enum CitySQLQueries
{
    GET_RECORD("SELECT * FROM cities WHERE ID = (?)"),
    GET_ALL_RECORDS("SELECT * FROM cities"),
    INSERT_RECORD("INSERT INTO cities (Name, FoundationYear, Square, Population, Country) VALUES ((?), (?), (?), (?), (?))"),
    DELETE_RECORD("DELETE FROM cities WHERE ID = (?)"),
    UPDATE_RECORD("UPDATE cities SET Name = (?), FoundationYear = (?), Square = (?), Population = (?), Country = (?) WHERE ID = (?)");
    //CHECK_EXISTENCE("SELECT 1 FROM cities WHERE Name = (?), FoundationYear = (?), Square = (?), Population = (?), Country = (?)");

    private String query;

    CitySQLQueries(String query)
    {
        this.query = query;
    }

    public String getQuery()
    {
        return query;
    }
}
