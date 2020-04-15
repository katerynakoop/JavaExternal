package epam.task7.web.servlets.crudoperations.city;

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

public class CreateCityServlet extends HttpServlet
{
    City city = new City();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String name = request.getParameter("cityName");
        String country = request.getParameter("country");
        String foundationYear = request.getParameter("foundationYear");
        int square = Integer.parseInt(request.getParameter("square"));
        int population = Integer.parseInt(request.getParameter("population"));

        city.setName(name);
        city.setCountry(country);
        city.setFoundationYear(foundationYear);
        city.setSquare(square);
        city.setPopulation(population);

        DBConnector connector = new DBConnector();
        Connection connection = connector.getConnection();
        CityRepository cityRepository = new CityRepository(connection);
        String resutStr = cityRepository.createRecord(city);

        response.getWriter().println(resutStr);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.getRequestDispatcher("CreateRecord.jsp").forward(request, response);
        request.setAttribute("obj", "city");
    }
}
