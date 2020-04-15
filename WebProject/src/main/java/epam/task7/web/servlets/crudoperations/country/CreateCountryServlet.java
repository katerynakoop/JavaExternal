package epam.task7.web.servlets.crudoperations.country;

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

public class CreateCountryServlet extends HttpServlet
{
    Country country = new Country();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String name = request.getParameter("name");
        String citizenName = request.getParameter("citizenName");
        String language = request.getParameter("language");

        country.setName(name);
        country.setCitizenName(citizenName);
        country.setLanguage(language);

        DBConnector connector = new DBConnector();
        Connection connection = connector.getConnection();
        CountryRepository countryRepository = new CountryRepository(connection);
        String resutStr = countryRepository.createRecord(country);

        response.getWriter().println(resutStr);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.getRequestDispatcher("CreateRecord.jsp").forward(request, response);
        request.setAttribute("obj", "country");
    }
}
