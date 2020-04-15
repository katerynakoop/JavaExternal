package epam.task7.web.servlets.crudoperations.country;

import epam.task7.web.jdbc.connection.DBConnector;
import epam.task7.web.jdbc.repository.CityRepository;
import epam.task7.web.jdbc.repository.CountryRepository;
import epam.task7.web.model.City;
import epam.task7.web.model.Country;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

public class ReadCountryServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String name = request.getParameter("countryName");
        request.getRequestDispatcher("/get-country").forward(request, response);
        DBConnector connector = new DBConnector();
        Connection connection =  connector.getConnection();
        CountryRepository countryRepository = new CountryRepository(connection);

        Country country = countryRepository.readRecord(name);

        request.setAttribute("searchedCountry", country);
        request.getRequestDispatcher("GetCountry.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.getRequestDispatcher("ReadRecord.jsp").forward(request, response);
        request.setAttribute("obj", "country");
    }
}
