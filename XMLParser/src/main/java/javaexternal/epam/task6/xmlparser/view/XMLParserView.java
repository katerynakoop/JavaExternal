package javaexternal.epam.task6.xmlparser.view;

import javaexternal.epam.task6.xmlparser.model.classes_for_xmlfile.Beer;
import javaexternal.epam.task6.xmlparser.model.classes_for_xmlfile.Beers;

public class XMLParserView
{
    public final static String STARTED_SAX_PARSING = "\nSAX PARSING STARTED...";
    public final static String STARTED_STAX_PARSING = "\nStAX PARSING STARTED...";
    public final static String STARTED_DOM_PARSING = "\nDOM PARSING STARTED...";
    public final static String STARTED_MARSHALLING = "\nMARSHALLING STARTED...";
    public final static String STARTED_UNMARSHALLING = "\nUNMARSHALLING STARTED...";

    public final static String BEERS = "BEERS:\n";
    public final static String BEER = "BEER: ";
    public final static String NAME = "Name: ";
    public final static String TYPE = "Type: ";
    public final static String ALCOHOL = "Alcohol: ";
    public final static String MANUFACTURER = "Manufacturer: ";
    public final static String INGREDIENTS = "Ingredients: ";
    public final static String WATER = "Water: ";
    public final static String GRAIN = "Grain: ";
    public final static String HOPS = "Hops: ";
    public final static String YEAST = "Yeast: ";
    public final static String SUGAR = "Sugar: ";
    public final static String CHARACTERISTICS = "Characteristics: ";
    public final static String STRENGTH = "Strength: ";
    public final static String TRANSPARENCY = "Transparency: ";
    public final static String FILTERING = "Filtering: ";
    public final static String NUTRITIONAL_VALUE = "Nutritional value: ";

    public static void displayClassBeerOnConsole(Beers beers)
    {
        System.out.println(BEERS);
        int i = 0;

        for(Beer beer: beers.getBeerList())
        {
            System.out.println(XMLParserView.BEER + (++i) + ": ");
            System.out.println(XMLParserView.NAME + beer.getName());
            System.out.println(XMLParserView.TYPE + beer.getType());
            System.out.println(XMLParserView.ALCOHOL + beer.getAlcohol());
            System.out.println(XMLParserView.MANUFACTURER + beer.getManufacturer() + "\n");

            System.out.println(XMLParserView.INGREDIENTS);
            System.out.println(XMLParserView.WATER + beer.getIngredients().getWater().getValue() + " " +
                    beer.getIngredients().getWater().getUnit());
            System.out.println(XMLParserView.GRAIN + beer.getIngredients().getGrain().getValue() + " " +
                    beer.getIngredients().getGrain().getUnit());
            System.out.println(XMLParserView.HOPS + beer.getIngredients().getHops().getValue() + " " +
                    beer.getIngredients().getHops().getUnit());
            System.out.println(XMLParserView.YEAST + beer.getIngredients().getYeast().getValue() + " " +
                    beer.getIngredients().getYeast().getUnit());
            System.out.println(XMLParserView.SUGAR + beer.getIngredients().getSugar().getValue() + " " +
                    beer.getIngredients().getSugar().getUnit() + "\n");

            System.out.println(XMLParserView.CHARACTERISTICS);
            System.out.println(XMLParserView.STRENGTH + beer.getCharacteristics().getStrength().getValue() + " " +
                    beer.getCharacteristics().getStrength().getUnit());
            System.out.println(XMLParserView.TRANSPARENCY + beer.getCharacteristics().getTransparency().getValue() + " " +
                    beer.getCharacteristics().getTransparency().getUnit());
            System.out.println(XMLParserView.FILTERING + beer.getCharacteristics().getFiltering().getValue());
            System.out.println(XMLParserView.NUTRITIONAL_VALUE + beer.getCharacteristics().getNutritionalValue().getValue() +
                            " " + beer.getCharacteristics().getNutritionalValue().getUnit());
        }
    }
}
