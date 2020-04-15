package epam.task7.web.servlets;

import epam.task7.web.jdbc.connection.DBConnector;
import epam.task7.web.jdbc.repository.CountryRepository;
import epam.task7.web.model.Country;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;


@WebServlet(name = "GetCountryServlet", urlPatterns = "/get-country")
public class GetCountryServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String name = request.getParameter("countryName");

        DBConnector connector = new DBConnector();
        Connection connection =  connector.getConnection();
        CountryRepository countryRepository = new CountryRepository(connection);
        Country country = countryRepository.readRecord(name);

        request.setAttribute("searchedCountry", country);

        request.getRequestDispatcher("GetCountry.jsp").forward(request, response);
    }
}
