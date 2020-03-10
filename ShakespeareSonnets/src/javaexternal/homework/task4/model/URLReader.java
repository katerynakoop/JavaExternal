package javaexternal.homework.task4.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLReader
{
    public String getAllWordsFromHtmlPage(String url)
    {
        StringBuilder response;
        URLConnection connection;
        BufferedReader bufferedReader;
        String str;

        try
        {
            URL website = new URL(url);
            connection = website.openConnection();
            bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            response = new StringBuilder();

            while ((str = bufferedReader.readLine()) != null)
                response.append(str);

            bufferedReader.close();
        }
        catch (MalformedURLException ex)
        {
            response = null;
            ex.printStackTrace();
        }
        catch (IOException ex)
        {
            response = null;
            ex.printStackTrace();
        }

        return response.toString();
    }
}
