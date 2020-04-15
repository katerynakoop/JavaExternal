package epam.task7.web.servlets.crudoperations.city;

import epam.task7.web.jdbc.connection.DBConnector;
import epam.task7.web.jdbc.repository.CityRepository;
import epam.task7.web.model.City;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

public class ReadCityServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.getRequestDispatcher("ReadRecord.jsp").forward(request, response);
        request.setAttribute("obj", "city");
    }
}
