package javaexternal.epam.task6.xmlparser.model.commandpattern;

import javaexternal.epam.task6.xmlparser.model.marshaller.MyMarshaller;
import javaexternal.epam.task6.xmlparser.model.parser.IParser;
import javaexternal.epam.task6.xmlparser.model.parser.dom.MyDOMParser;
import javaexternal.epam.task6.xmlparser.model.parser.sax.MySAXParser;
import javaexternal.epam.task6.xmlparser.model.parser.stax.MyStAXParser;

public class Commands
{
    MyMarshaller myMarshaller;
    IParser myParser;

    public void marshall()
    {
        myMarshaller = new MyMarshaller();
        myMarshaller.marshal();
    }

    public void unmarshall()
    {
        myMarshaller = new MyMarshaller();
        myMarshaller.unmarshal();
    }

    public void parseDOM()
    {
        myParser = new MyDOMParser();
        myParser.parseXMLFile();

    }

    public void parseSAX()
    {
        myParser = new MySAXParser();
        myParser.parseXMLFile();
    }

    public void parseStAX()
    {
        myParser = new MyStAXParser();
        myParser.parseXMLFile();
    }
}
