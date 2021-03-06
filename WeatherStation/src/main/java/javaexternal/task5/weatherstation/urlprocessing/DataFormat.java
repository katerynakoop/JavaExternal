package javaexternal.task5.weatherstation.urlprocessing;

import javaexternal.task5.weatherstation.parser.JSONParser;
import javaexternal.task5.weatherstation.parser.Parser;
import javaexternal.task5.weatherstation.parser.XMLParser;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DataFormat
{
    final static Logger logger = Logger.getLogger(DataFormat.class);
    private String dataFormat;

    public void setResponseDataFormat()
    {
        System.out.print("Choose data format: enter 1 for XML format, enter 2 for JSON format\nYour choice: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            int choice = Integer.parseInt(reader.readLine());

            if(choice == 1)
                dataFormat = "xml";
            else
                dataFormat = "json";

        }
        catch (NumberFormatException | IOException e)
        {
            logger.error(e);
        }
    }

    public String getDataFormat()
    {
        return dataFormat;
    }

    public Parser getParser()
    {
        if(dataFormat.equals("xml"))
            return new XMLParser();
        else
            return new JSONParser();

    }
}
