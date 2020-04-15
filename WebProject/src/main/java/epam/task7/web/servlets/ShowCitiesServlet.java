package epam.task7.web.servlets;

import epam.task7.web.jdbc.connection.DBConnector;
import epam.task7.web.model.City;
import epam.task7.web.jdbc.repository.CityRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

public class ShowCitiesServlet extends HttpServlet
{

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String selectedActionCity  =  request.getParameter("city_action");

        request.setAttribute("obj", "city");

        switch (selectedActionCity)
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

        CityRepository cityRepository = new CityRepository(connection);
        List<City> cities = cityRepository.readAllRecords();

        request.setAttribute("cities", cities);
        request.getRequestDispatcher("ShowCities.jsp").forward(request, response);
    }
}
