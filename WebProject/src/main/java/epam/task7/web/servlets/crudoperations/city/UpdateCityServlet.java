package epam.task7.web.servlets.crudoperations.city;

import epam.task7.web.jdbc.connection.DBConnector;
import epam.task7.web.jdbc.repository.CityRepository;
import epam.task7.web.model.City;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class UpdateCityServlet extends HttpServlet
{
    City city;
    City updatedCity = new City();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        int id = Integer.parseInt(request.getParameter("id"));
        DBConnector connector = new DBConnector();
        Connection connection = connector.getConnection();
        CityRepository cityRepository = new CityRepository(connection);
        city = cityRepository.readRecord(id);

        if(request.getParameter("cityName") == null || request.getParameter("cityName").equals(""))
            updatedCity.setName(city.getName());
        else
            updatedCity.setName(request.getParameter("cityName"));


        if(request.getParameter("foundationYear") == null || request.getParameter("foundationYear").equals(""))
            updatedCity.setFoundationYear(city.getFoundationYear());
        else
            updatedCity.setFoundationYear(request.getParameter("foundationYear"));


        if(request.getParameter("square") == null || request.getParameter("square").equals(""))
            updatedCity.setSquare(city.getSquare());
        else
            updatedCity.setSquare(Integer.parseInt(request.getParameter("square")));


        if(request.getParameter("population") == null || request.getParameter("population").equals(""))
            updatedCity.setPopulation(city.getPopulation());
        else
            updatedCity.setPopulation(Integer.parseInt(request.getParameter("population")));


        if(request.getParameter("country") == null || request.getParameter("country").equals(""))
            updatedCity.setCountry(city.getCountry());
        else
            updatedCity.setCountry(request.getParameter("country"));

        String resutStr = cityRepository.updateRecord(id, updatedCity);

        response.getWriter().println(resutStr);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.getRequestDispatcher("UpdateRecord.jsp").forward(request, response);
        request.setAttribute("obj", "city");
    }
}
