package javaexternal.epam.task6.xmlparser.model.parser.sax;

import javaexternal.epam.task6.xmlparser.model.parser.IParser;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class MySAXParser implements IParser
{
    @Override
    public void parseXMLFile()
    {
        final File xmlFile = new File("src/main/resources/Beer.xml");
        SAXParserFactory factory;
        SAXParser saxParser;
        DefaultHandler handler;

        try
        {
            factory = SAXParserFactory.newInstance();
            saxParser = factory.newSAXParser();
            handler = new Handler();
            saxParser.parse(xmlFile, handler);

        }
        catch (ParserConfigurationException | SAXException | IOException e)
        {
            e.printStackTrace();
        }
    }
}
