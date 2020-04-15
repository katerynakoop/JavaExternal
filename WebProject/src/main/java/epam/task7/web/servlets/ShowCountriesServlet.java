package epam.task7.web.servlets;

import epam.task7.web.jdbc.connection.DBConnector;
import epam.task7.web.model.Country;
import epam.task7.web.jdbc.repository.CountryRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

public class ShowCountriesServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String selectedActionCountry  =  request.getParameter("country_action");

        request.setAttribute("obj", "country");

        switch (selectedActionCountry)
        {
            case "create":
                request.getRequestDispatcher("CreateRecord.jsp").forward(request, response);
                break;
            case "read":
                request.getRequestDispatcher("ReadRecord.jsp").forward(request, response);
                break;
            case "update":
                request.getRequestDispatcher("UpdateRecord.jsp").forward(request, response);
                break;
            case "delete":
                request.getRequestDispatcher("DeleteRecord.jsp").forward(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        DBConnector connector = new DBConnector();
        Connection connection = connector.getConnection();

        CountryRepository countryRepository = new CountryRepository(connection);
        List<Country> countries = countryRepository.readAllRecords();
        request.setAttribute("countries", countries);
        request.getRequestDispatcher("ShowCountries.jsp").forward(request, response);
    }
}
