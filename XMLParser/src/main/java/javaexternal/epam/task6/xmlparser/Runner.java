package javaexternal.epam.task6.xmlparser;

import javaexternal.epam.task6.xmlparser.controller.XMLParserController;
import javaexternal.epam.task6.xmlparser.model.XMLParserModel;
import javaexternal.epam.task6.xmlparser.view.XMLParserView;

public class Runner
{
    public static void main(String[] args)
    {
        XMLParserModel model = new XMLParserModel();
        XMLParserView view = new XMLParserView();
        XMLParserController baseApp = new XMLParserController(model, view);

        baseApp.startExecution();
    }
}
