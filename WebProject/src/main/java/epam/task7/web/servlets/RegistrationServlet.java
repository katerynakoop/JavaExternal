package epam.task7.web.servlets;

import epam.task7.web.jdbc.connection.DBConnector;
import epam.task7.web.model.User;
import epam.task7.web.jdbc.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

public class RegistrationServlet extends HttpServlet
{

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phoneNum = request.getParameter("phoneNum");

        User user = new User(username, firstname, lastname, password, email, phoneNum);

        DBConnector connector = new DBConnector();
        Connection connection = connector.getConnection();

        UserRepository userRepository = new UserRepository(connection);
        userRepository.registerUser(user);

        request.setAttribute("user", user);
        request.getRequestDispatcher("Login.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.getRequestDispatcher("Registration.jsp").forward(request, response);
    }
}
