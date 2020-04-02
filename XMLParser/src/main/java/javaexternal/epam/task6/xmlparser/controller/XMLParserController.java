package javaexternal.epam.task6.xmlparser.controller;

import javaexternal.epam.task6.xmlparser.model.XMLParserModel;
import javaexternal.epam.task6.xmlparser.model.commandpattern.*;
import javaexternal.epam.task6.xmlparser.view.XMLParserView;

public class XMLParserController
{
    XMLParserModel model;
    XMLParserView view;

    public XMLParserController(XMLParserModel model, XMLParserView view)
    {
        this.model = model;
        this.view = view;

        Commands commands = new Commands();
        model.setMarshallCommand(new MarshallCommand(commands));
        model.setUnmarshallCommand(new UnmarshallCommand(commands));
        model.setParseDOMCommand(new ParseDOMCommand(commands));
        model.setParseSAXCommand(new ParseSAXCommand(commands));
        model.setParseStAXCommand(new ParseStAXCommand(commands));
    }

    public void startExecution()
    {
        System.out.println(XMLParserView.STARTED_MARSHALLING);
        model.executeMarshallCommand();

        System.out.println(XMLParserView.STARTED_UNMARSHALLING);
        model.executeUnmarshallCommand();

        System.out.println(XMLParserView.STARTED_DOM_PARSING);
        model.executeParseDOMCommand();

        System.out.println(XMLParserView.STARTED_SAX_PARSING);
        model.executeParseSAXCommand();

        System.out.println(XMLParserView.STARTED_STAX_PARSING);
        model.executeParseStAXCommand();
    }
}
