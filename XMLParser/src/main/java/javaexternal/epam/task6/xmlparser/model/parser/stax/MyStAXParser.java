package javaexternal.epam.task6.xmlparser.model.parser.stax;

import javaexternal.epam.task6.xmlparser.model.parser.IParser;
import javaexternal.epam.task6.xmlparser.view.XMLParserView;

import javax.xml.stream.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;


public class MyStAXParser implements IParser
{
    @Override
    public void parseXMLFile()
    {
        try
        {
            final FileInputStream xmlFile = new FileInputStream("src/main/resources/Beer.xml");
            XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
            XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(xmlFile);
            String attributeValue = "";

            while(xmlStreamReader.hasNext())
            {
                int eventType = xmlStreamReader.getEventType();

                switch(eventType)
                {
                    case XMLStreamReader.START_ELEMENT:
                        String tagName = xmlStreamReader.getLocalName() .toUpperCase();
                        Field field = XMLParserView.class.getDeclaredField(tagName);

                        if(field.getName().equals(tagName))
                        {
                            System.out.print(field.get(null).toString() + " ");
                        }
                        if(xmlStreamReader.getAttributeCount() > 0)
                        {
                            attributeValue = xmlStreamReader.getAttributeValue(0);
                        }
                        break;

                    case XMLStreamReader.CHARACTERS:
                        if(!xmlStreamReader.getText().isEmpty())
                        {
                            System.out.print(xmlStreamReader.getText() + " " + attributeValue);
                            attributeValue = "";
                        }
                        break;
                    }
                    xmlStreamReader.next();
            }
            xmlStreamReader.close();
        }
        catch (XMLStreamException | FileNotFoundException | NoSuchFieldException | IllegalAccessException e)
        {
            e.printStackTrace();
        }
    }
}
