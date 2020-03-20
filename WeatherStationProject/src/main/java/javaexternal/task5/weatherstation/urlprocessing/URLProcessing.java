package javaexternal.task5.weatherstation.urlprocessing;

import javaexternal.task5.weatherstation.parser.JSONParser;
import javaexternal.task5.weatherstation.parser.Parser;
import javaexternal.task5.weatherstation.parser.XMLParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

public class URLProcessing
{
    private String url;
    final String apiKey = "915eb950e65e6f7b5fe92163c41e3e34";
    private static HttpURLConnection connection;
    BufferedReader reader;

    public String getURL(String location, String dataFormat)
    {
        url = "https://api.openweathermap.org/data/2.5/weather?q=" + location + "&appid=" + apiKey + "&mode=" + dataFormat;
        return url;
    }

    public String getResponseBodyFromUrl(String CurrentWeatherUrl)
    {
        StringBuilder responseContent = new StringBuilder();
        String line;
        try
        {
            URL url = new URL(CurrentWeatherUrl);

            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int responseStatus = connection.getResponseCode();

            if (responseStatus > 299)
            {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine()) != null)
                {
                    responseContent.append(line);
                }
                reader.close();
            }
            else
            {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null)
                {
                    responseContent.append(line);
                }
            }
        }

        // write Exceptions to logs
        catch (MalformedURLException ex)
        {
            System.out.println("Caught MalformedURLException");
        }
        catch (UnknownHostException e)
        {
            System.out.println("Caught UnknownHostException. Check your Internet connection!");
        }
        catch (IOException e)
        {
            System.out.println("Caught IOException");
        }
        finally
        {
            connection.disconnect();
        }

        return responseContent.toString();
    }
}
