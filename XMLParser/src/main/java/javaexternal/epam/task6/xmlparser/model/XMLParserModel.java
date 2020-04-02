package javaexternal.epam.task6.xmlparser.model;

import javaexternal.epam.task6.xmlparser.model.commandpattern.ICommand;

public class XMLParserModel
{
    ICommand marshall;
    ICommand unmarshall;
    ICommand parseDOM;
    ICommand parseSAX;
    ICommand parseStAX;


    public void setMarshallCommand(ICommand marshall)
    {
        this.marshall = marshall;
    }

    public void setUnmarshallCommand(ICommand unmarshall)
    {
        this.unmarshall = unmarshall;
    }

    public void setParseDOMCommand(ICommand parseDOM)
    {
        this.parseDOM = parseDOM;
    }

    public void setParseSAXCommand(ICommand parseSAX)
    {
        this.parseSAX = parseSAX;
    }

    public void setParseStAXCommand(ICommand parseStAX)
    {
        this.parseStAX = parseStAX;
    }

    public void executeMarshallCommand()
    {
        marshall.execute();
    }

    public void executeUnmarshallCommand()
    {
        unmarshall.execute();
    }

    public void executeParseDOMCommand()
    {
        parseDOM.execute();
    }

    public void executeParseSAXCommand()
    {
        parseSAX.execute();
    }

    public void executeParseStAXCommand()
    {
        parseStAX.execute();
    }
}
