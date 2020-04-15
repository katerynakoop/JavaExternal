package epam.task7.web.servlets;

import epam.task7.web.jdbc.connection.DBConnector;
import epam.task7.web.jdbc.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.getRequestDispatcher("Login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        boolean userLoginedSuccessfully;

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        DBConnector connector = new DBConnector();
        Connection connection = connector.getConnection();

        UserRepository userRepository = new UserRepository(connection);
        userLoginedSuccessfully = userRepository.loginUser(username, password);

        response.getWriter().println(Boolean.valueOf(userLoginedSuccessfully));

        if(userLoginedSuccessfully)
        {
            request.getRequestDispatcher("DatabaseInfo.jsp").forward(request, response);
        }
        else
        {
            response.getWriter().println("Username or password you entered are wrong! Try again");
        }
    }
}
