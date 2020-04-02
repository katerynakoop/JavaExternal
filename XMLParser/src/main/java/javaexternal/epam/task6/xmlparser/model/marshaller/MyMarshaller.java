package javaexternal.epam.task6.xmlparser.model.marshaller;

import javaexternal.epam.task6.xmlparser.model.beerbuilder.BeerBuilder;
import javaexternal.epam.task6.xmlparser.model.classes_for_xmlfile.Beers;
import javaexternal.epam.task6.xmlparser.view.XMLParserView;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class MyMarshaller
{
    File xmlFile = new File("src/main/resources/Beer.xml");

    public void marshal()
    {
        BeerBuilder beer1 = new BeerBuilder.Builder()
                .setWater(1, "liters")
                .setGrain(250, "grams")
                .setHops(50, "grams")
                .setYeast(20, "grams")
                .setSugar(2, "kilograms")
                .setIngredients()
                .setStrength(10, "%")
                .setTransparency(50, "%")
                .setFiltering("yes")
                .setNutritionalValue(42, "kilocalories")
                .setCharacteristics()
                .setBeer("Kronenbourg 1664 Blanc", "stout", "alcoholic", "Kronenbourg")
                .build();

        BeerBuilder beer2 = new BeerBuilder.Builder()
                .setWater(1, "liters")
                .setGrain(210, "grams")
                .setHops(60, "grams")
                .setYeast(22, "grams")
                .setSugar(3, "kilograms")
                .setIngredients()
                .setStrength(0, "%")
                .setTransparency(70, "%")
                .setFiltering("yes")
                .setNutritionalValue(50, "kilocalories")
                .setCharacteristics()
                .setBeer("Corona extra porter", "porter", "non-alcoholic", "Corona extra")
                .build();


        Beers beers = new Beers();
        beers.getBeerList();
        beers.addBeerToBeersList(beer1.getBeer());
        beers.addBeerToBeersList(beer2.getBeer());

        try
        {
            JAXBContext jaxbContext = JAXBContext.newInstance(Beers.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(beers, xmlFile);
            marshaller.marshal(beers, System.out);
        }
        catch (JAXBException e)
        {
                // make logs
                e.printStackTrace();
        }
    }

    public void unmarshal()
    {
        try
        {
            JAXBContext jaxbContext = JAXBContext.newInstance(Beers.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Beers beers = (Beers) unmarshaller.unmarshal(xmlFile);
            XMLParserView.displayClassBeerOnConsole(beers);
        }
        catch (JAXBException e)
        {
            // make logs
            e.printStackTrace();
        }
    }
}
