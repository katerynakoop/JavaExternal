package javaexternal.epam.task6.xmlparser.model.parser.dom;

import javaexternal.epam.task6.xmlparser.model.parser.IParser;
import javaexternal.epam.task6.xmlparser.view.XMLParserView;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class MyDOMParser implements IParser
{
    @Override
    public void parseXMLFile()
    {
        final File xmlFile = new File("src/main/resources/Beer.xml");

        try
        {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(xmlFile);
            Element root = doc.getDocumentElement();
            NodeList nodeListBeer = doc.getElementsByTagName("beer");

            for (int i = 0; i < nodeListBeer.getLength(); i++)
            {
                Node node = nodeListBeer.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element element = (Element)node;

                    System.out.println(XMLParserView.BEER + (++i) + ": ");
                    System.out.println(XMLParserView.NAME + element.getElementsByTagName("name").item(0).getTextContent());
                    System.out.println(XMLParserView.TYPE + element.getElementsByTagName("type").item(0).getTextContent());
                    System.out.println(XMLParserView.ALCOHOL + element.getElementsByTagName("alcohol").item(0).getTextContent() );
                    System.out.println(XMLParserView.MANUFACTURER + element.getElementsByTagName("manufacturer").
                                        item(0).getTextContent() + "\n");

                    System.out.println(XMLParserView.INGREDIENTS);
                    System.out.println(XMLParserView.WATER + element.getElementsByTagName("water").item(0)
                            .getChildNodes().item(0).getTextContent() + " " + element.getElementsByTagName("water")
                            .item(0).getAttributes().getNamedItem("unit").getNodeValue());

                    System.out.println(XMLParserView.GRAIN + element.getElementsByTagName("grain").item(0)
                            .getChildNodes().item(0).getTextContent() + " " + element.getElementsByTagName("grain")
                            .item(0).getAttributes().getNamedItem("unit").getNodeValue());

                    System.out.println(XMLParserView.HOPS + element.getElementsByTagName("hops").item(0)
                            .getChildNodes().item(0).getTextContent() + " " + element.getElementsByTagName("hops")
                            .item(0).getAttributes().getNamedItem("unit").getNodeValue());

                    System.out.println(XMLParserView.YEAST + element.getElementsByTagName("yeast").item(0)
                            .getChildNodes().item(0).getTextContent() + " " + element.getElementsByTagName("yeast")
                            .item(0).getAttributes().getNamedItem("unit").getNodeValue());

                    System.out.println(XMLParserView.SUGAR + element.getElementsByTagName("sugar").item(0)
                            .getChildNodes().item(0).getTextContent() + " " + element.getElementsByTagName("sugar")
                            .item(0).getAttributes().getNamedItem("unit").getNodeValue() + "\n");

                    System.out.println(XMLParserView.CHARACTERISTICS);
                    System.out.println(XMLParserView.STRENGTH + element.getElementsByTagName("strength").item(0)
                            .getChildNodes().item(0).getTextContent() + " " + element.getElementsByTagName("strength")
                            .item(0).getAttributes().getNamedItem("unit").getNodeValue());

                    System.out.println(XMLParserView.TRANSPARENCY + element.getElementsByTagName("transparency").item(0)
                            .getChildNodes().item(0).getTextContent() + " " + element.getElementsByTagName("transparency")
                            .item(0).getAttributes().getNamedItem("unit").getNodeValue());

                    System.out.println(XMLParserView.FILTERING + element.getElementsByTagName("filtering").item(0)
                            .getChildNodes().item(0).getTextContent());

                    System.out.println(XMLParserView.NUTRITIONAL_VALUE + element.getElementsByTagName("nutritional_value").item(0)
                            .getChildNodes().item(0).getTextContent() + " " + element.getElementsByTagName("nutritional_value")
                            .item(0).getAttributes().getNamedItem("unit").getNodeValue());
                }
            }
        }
        catch (SAXException | ParserConfigurationException | IOException e)
        {
            e.printStackTrace();
        }
    }
}
