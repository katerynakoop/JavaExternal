package javaexternal.task5.weatherstation.parser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class XMLParser extends Parser
{
    @Override
    public void parse(String responseBody)
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try
        {
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document document = documentBuilder.parse(responseBody);

            Element temperatureElement = (Element)document.getElementsByTagName("temperature");
            temperature = Integer.parseInt(temperatureElement.getAttribute("value"));
            temp_min = Integer.parseInt(temperatureElement.getAttribute("min"));
            temp_max = Integer.parseInt(temperatureElement.getAttribute("max"));

            Element humidityElement = (Element)document.getElementsByTagName("humidity");
            humidity = Integer.parseInt(humidityElement.getAttribute("value")); //unit  %

            Element pressureElement = (Element)document.getElementsByTagName("pressure");
            pressure = Integer.parseInt(pressureElement.getAttribute("value")); //unit hPa

            NodeList windNodeList = document.getElementsByTagName("wind");
            wind_speed =  windNodeList.item(0).getNodeType();
        }
        catch (ParserConfigurationException | SAXException | IOException e)
        {
            // make logs
            e.printStackTrace();
        }

    }
}
