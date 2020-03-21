package javaexternal.task5.weatherstation.parser;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;

public class XMLParser extends Parser
{
    final static Logger logger = Logger.getLogger(XMLParser.class);
    @Override
    public void parse(String responseBody)
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try
        {
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document document = documentBuilder.parse(new InputSource(new StringReader(responseBody)));

            Element rootElement = (Element) document.getElementsByTagName("current").item(0);

            temperature = Float.parseFloat(rootElement.getElementsByTagName("temperature").item(0).
                    getAttributes().getNamedItem("value").getNodeValue());
            temp_min = Float.parseFloat(rootElement.getElementsByTagName("temperature").item(0).
                    getAttributes().getNamedItem("min").getNodeValue());
            temp_max = Float.parseFloat(rootElement.getElementsByTagName("temperature").item(0).
                    getAttributes().getNamedItem("max").getNodeValue());
            humidity = Float.parseFloat(rootElement.getElementsByTagName("humidity").item(0).
                    getAttributes().getNamedItem("value").getNodeValue());
            pressure = Float.parseFloat(rootElement.getElementsByTagName("pressure").item(0).
                    getAttributes().getNamedItem("value").getNodeValue());
            wind_speed = Float.parseFloat(rootElement.getElementsByTagName("wind").item(0).getFirstChild().
                    getAttributes().getNamedItem("value").getNodeValue());

        }
        catch (ParserConfigurationException | SAXException | IOException e)
        {
            logger.error(e);
        }

    }
}
