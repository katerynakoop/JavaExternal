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

public class UpdateCountryServlet extends HttpServlet
{
    Country country;
    Country updatedCountry = new Country();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String name = request.getParameter("name");
        DBConnector connector = new DBConnector();
        Connection connection = connector.getConnection();
        CountryRepository countryRepository = new CountryRepository(connection);
        country = countryRepository.readRecord(name);

        if(request.getParameter("name") == null || request.getParameter("name").equals(""))
            updatedCountry.setName(country.getName());
        else
            updatedCountry.setName(request.getParameter("name"));


        if(request.getParameter("citizenName") == null || request.getParameter("citizenName").equals(""))
            updatedCountry.setCitizenName(country.getCitizenName());
        else
            updatedCountry.setCitizenName(request.getParameter("citizenName"));


        if(request.getParameter("language") == null || request.getParameter("language").equals(""))
            updatedCountry.setLanguage(country.getLanguage());
        else
            updatedCountry.setLanguage(request.getParameter("language"));

        String resutStr = countryRepository.updateRecord(name, updatedCountry);

        response.getWriter().println(resutStr);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.getRequestDispatcher("UpdateRecord.jsp").forward(request, response);
        request.setAttribute("obj", "country");
    }
}
