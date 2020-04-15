package epam.task7.web.jdbc.repository;

import epam.task7.web.exceptions.WrongPasswordException;
import epam.task7.web.exceptions.WrongUsernameException;
import epam.task7.web.model.User;
import epam.task7.web.jdbc.enum_queries.UserSQLQueries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository extends Repository
{
    public UserRepository(Connection connection)
    {
        super(connection);
    }

/*    public static void main(String[] args)
    {
        DBConnector connector = new DBConnector();
        Connection connection = connector.getConnection();

        UserRepository repository = new UserRepository(connection);
        repository.loginUser("kkoop", "1234");
    }*/

    private final Logger logger = LoggerFactory.getLogger(UserRepository.class);

    public void registerUser(User user)
    {
        try(PreparedStatement statement = connection.prepareStatement(UserSQLQueries.INSERT_RECORD.getQuery());)
        {
            statement.setString(1, user.getFirstname());
            statement.setString(2, user.getLastname());
            statement.setString(3, user.getUsername());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getEmail());
            statement.setString(6, user.getPhoneNum());
            statement.execute();
        }
        catch (SQLException e)
        {
            logger.error("The user was not added to database. SQL exception was thrown!", e);
        }
    }

    public boolean isPasswordCorrect(String username, String password) throws SQLException
    {
        String correctPassword;

        try(PreparedStatement statementCheckPsw = connection.prepareStatement(UserSQLQueries.CHECK_PASSWORD.getQuery());
            PreparedStatement statementGetPsw = connection.prepareStatement(UserSQLQueries.GET_PASSWORD.getQuery()))
        {
            statementGetPsw.setString(1, username);
            ResultSet rsGetPsw = statementGetPsw.executeQuery();
            rsGetPsw.next();
            correctPassword = rsGetPsw.getString(1);

            statementCheckPsw.setString(1, password);
            statementCheckPsw.setString(2, correctPassword);
            ResultSet rsCheckPsw = statementCheckPsw.executeQuery();
            rsCheckPsw.next();

            if(rsCheckPsw.getInt(1) == 0)
                return true;
            else
                throw new WrongPasswordException();
        }
        catch(WrongPasswordException e)
        {
            logger.info("The user entered wrong password!");
            return false;
        }
    }

    public boolean isUserPresentInDB(String username) throws SQLException
    {
        try(PreparedStatement statement = connection.prepareStatement(UserSQLQueries.CHECK_USERNAME.getQuery()))
        {
            statement.setString(1,username);
            ResultSet rs = statement.executeQuery();

            rs.next();
            if (rs.getInt(1) == 1)
                return true;
            else
                throw new WrongUsernameException();
        }
        catch (WrongUsernameException e)
        {
            logger.info("The user entered wrong username!");
            return false;
        }
    }


    public boolean loginUser(String username, String password)
    {
        boolean isDataCorrect = false;
        boolean isUsernamePresent;
        boolean isPasswordCorrect;

        try
        {
            isUsernamePresent = isUserPresentInDB(username);
            isPasswordCorrect = isPasswordCorrect(username, password);

            if(isUsernamePresent && isPasswordCorrect)
            {
                isDataCorrect = true;
            }
        }
        catch(SQLException e)
        {
            logger.error("The user did not login. Something went wrong! SQL exception was thrown!" ,e);
        }

        return  isDataCorrect;
    }
}
