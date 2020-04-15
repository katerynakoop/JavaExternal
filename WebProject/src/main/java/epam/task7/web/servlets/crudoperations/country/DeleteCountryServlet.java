package epam.task7.web.servlets.crudoperations.country;

import epam.task7.web.jdbc.connection.DBConnector;
import epam.task7.web.jdbc.repository.CountryRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

public class DeleteCountryServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String name = request.getParameter("countryName");

        DBConnector connector = new DBConnector();
        Connection connection = connector.getConnection();
        CountryRepository countryRepository = new CountryRepository(connection);
        String result_str = countryRepository.deleteRecord(name);
        response.getWriter().println(result_str);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.getRequestDispatcher("DeleteRecord.jsp").forward(request, response);
        request.setAttribute("obj", "country");
    }
}
