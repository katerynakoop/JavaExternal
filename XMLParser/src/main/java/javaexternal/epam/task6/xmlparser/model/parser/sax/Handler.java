package javaexternal.epam.task6.xmlparser.model.parser.sax;

import javaexternal.epam.task6.xmlparser.model.classes_for_xmlfile.*;
import javaexternal.epam.task6.xmlparser.view.XMLParserView;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class Handler extends DefaultHandler
{
    Beers beers = new Beers();
    Beer beer;
    Ingredients ingredients;
    Characteristics characteristics;
    Water water;
    Grain grain;
    Hops hops;
    Yeast yeast;
    Sugar sugar;
    Strength strength;
    Filtering filtering;
    Transparency transparency;
    NutritionalValue nutritionalValue;



    private boolean bBeer, bName, bType, bAlcohol, bManufacturer, bIngredients, bWater, bGrain,
            bHops, bYeast, bSugar, bCharacteristics, bStrength, bTransparency, bFiltering, bNutritionalValue;

    @Override
    public void startDocument()
    {

    }

    @Override
    public void endDocument()
    {
        XMLParserView.displayClassBeerOnConsole(beers);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
    {
        switch (qName)
        {
            case "beer":
                bBeer = true;
                break;
            case "name":
                bName = true;
                break;
            case "type":
                bType = true;
                break;
            case "alcohol":
                bAlcohol = true;
                break;
            case "manufacturer":
                bManufacturer = true;
                break;
            case "ingredients":
                bIngredients = true;
                break;
            case "water":
                bWater = true;
                break;
            case "grain":
                bGrain = true;
                break;
            case "hops":
                bHops = true;
                break;
            case "yeast":
                bYeast = true;
                break;
            case "sugar":
                bSugar = true;
                break;
            case "characteristics":
                bCharacteristics = true;
                break;
            case "strength":
                bStrength = true;
                break;
            case "transparency":
                bTransparency = true;
                break;
            case "filtering":
                bFiltering = true;
                break;
            case "nutritional_value":
                bNutritionalValue = true;
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
    {

    }


    @Override
    public void characters(char ch[], int start, int length)
    {
        String str = new String(ch, start, length).trim();

        if(bBeer)
        {
            beer = new Beer();
            beer.setIngredients(ingredients);
            beer.setCharacteristics(characteristics);
            beers.getBeerList();
            beers.addBeerToBeersList(beer);
            bBeer = false;
        }

        if(bName)
        {
            beer.setName(str);
            bName = false;
        }

        if(bType)
        {
            beer.setType(str);
            bType = false;
        }

        if(bAlcohol)
        {
            beer.setAlcohol(str);
            bAlcohol = false;
        }

        if(bManufacturer)
        {
            beer.setManufacturer(str);
            bManufacturer = false;
        }

        if(bIngredients)
        {
            ingredients = new Ingredients();
            beer.setIngredients(ingredients);
            bIngredients = false;
        }

        if(bWater)
        {
            water = new Water();
            beer.getIngredients().setWater(water);
            beer.getIngredients().getWater().setValue(Integer.parseInt(str));
            bWater = false;
        }

        if(bGrain)
        {
            grain = new Grain();
            beer.getIngredients().setGrain(grain);
            beer.getIngredients().getWater().setValue(Integer.parseInt(str));
            bGrain = false;
        }

        if(bHops)
        {
            hops = new Hops();
            beer.getIngredients().setHops(hops);
            beer.getIngredients().getHops().setValue(Integer.parseInt(str));
            bHops = false;
        }

        if(bYeast)
        {
            yeast = new Yeast();
            beer.getIngredients().setYeast(yeast);
            beer.getIngredients().getYeast().setValue(Integer.parseInt(str));
            bYeast = false;
        }

        if(bSugar)
        {
            sugar = new Sugar();
            beer.getIngredients().setSugar(sugar);
            beer.getIngredients().getSugar().setValue(Integer.parseInt(str));
            bSugar = false;
        }

        if(bCharacteristics)
        {
            characteristics = new Characteristics();
            beer.setCharacteristics(characteristics);
            bCharacteristics = false;
        }

        if(bStrength)
        {
            strength = new Strength();
            beer.getCharacteristics().setStrength(strength);
            beer.getCharacteristics().getStrength().setValue(Integer.parseInt(str));
            bStrength = false;
        }

        if(bTransparency)
        {
            transparency = new Transparency();
            beer.getCharacteristics().setTransparency(transparency);
            beer.getCharacteristics().getTransparency().setValue(Integer.parseInt(str));
            bTransparency = false;
        }

        if(bFiltering)
        {
            filtering = new Filtering();
            beer.getCharacteristics().setFiltering(filtering);
            beer.getCharacteristics().getFiltering().setValue(str);
            bFiltering = false;
        }

        if(bNutritionalValue)
        {
            nutritionalValue = new NutritionalValue();
            beer.getCharacteristics().setNutritionalValue(nutritionalValue);
            beer.getCharacteristics().getNutritionalValue().setValue(Integer.parseInt(str));
            bNutritionalValue = false;
        }
    }
}
