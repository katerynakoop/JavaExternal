package epam.task7.web.jdbc.enum_queries;

public enum UserSQLQueries
{
    INSERT_RECORD("INSERT INTO users (Firstname, Lastname, Username, Password, Email, PhoneNumber) " +
            "VALUES ((?), (?), (?), (?), (?), (?))"),
    CHECK_USERNAME("SELECT 1 FROM users WHERE Username=(?)"),
    GET_PASSWORD("SELECT Password FROM users WHERE Username=(?)"),
    CHECK_PASSWORD("SELECT STRCMP (?,?)");

    private String query;

    UserSQLQueries(String query)
    {
        this.query = query;
    }

    public String getQuery()
    {
        return query;
    }
}
