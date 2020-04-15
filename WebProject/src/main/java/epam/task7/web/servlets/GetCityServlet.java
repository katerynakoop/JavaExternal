package epam.task7.web.servlets;

import epam.task7.web.jdbc.connection.DBConnector;
import epam.task7.web.jdbc.repository.CityRepository;
import epam.task7.web.model.City;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "GetCityServlet", urlPatterns = "/get-city")
public class GetCityServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        int id = Integer.parseInt(request.getParameter("cityId"));

        DBConnector connector = new DBConnector();
        Connection connection =  connector.getConnection();
        CityRepository cityRepository = new CityRepository(connection);
        City city = cityRepository.readRecord(id);

        request.setAttribute("searchedCity", city);

        request.getRequestDispatcher("GetCity.jsp").forward(request, response);
    }
}
