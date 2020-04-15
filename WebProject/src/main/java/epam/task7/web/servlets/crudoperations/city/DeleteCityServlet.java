package epam.task7.web.servlets.crudoperations.city;

import epam.task7.web.jdbc.connection.DBConnector;
import epam.task7.web.jdbc.repository.CityRepository;
import epam.task7.web.jdbc.repository.CountryRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

public class DeleteCityServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        int id = Integer.parseInt(request.getParameter("cityId"));

        DBConnector connector = new DBConnector();
        Connection connection = connector.getConnection();
        CityRepository cityRepository = new CityRepository(connection);
        String result_str = cityRepository.deleteRecord(id);
        response.getWriter().println(result_str);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.getRequestDispatcher("DeleteRecord.jsp").forward(request, response);
        request.setAttribute("obj", "city");
    }
}
