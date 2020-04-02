
package javaexternal.epam.task6.xmlparser.model.classes_for_xmlfile;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory
{

    private final static QName _Beers_QNAME = new QName("", "beers");

    public ObjectFactory()
    {

    }

    public Characteristics createCharacteristicsObject()
    {
        return new Characteristics();
    }

    public Beers createBeersObject()
    {
        return new Beers();
    }

    public Ingredients createIngredientsObject()
    {
        return new Ingredients();
    }

    public NutritionalValue createNutritionalValueObject()
    {
        return new NutritionalValue();
    }

    public Strength createStrengthObject()
    {
        return new Strength();
    }

    public Yeast createYeastObject()
    {
        return new Yeast();
    }

    public Transparency createTransparencyObject()
    {
        return new Transparency();
    }

    public Beer createBeerObject()
    {
        return new Beer();
    }
    public Grain createGrainObject()
    {
        return new Grain();
    }

    public Water createWaterObject()
    {
        return new Water();
    }

    public Hops createHopsObject()
    {
        return new Hops();
    }

    public Sugar createSugarObject()
    {
        return new Sugar();
    }

    public Filtering createFilteringObject()
    {
        return new Filtering();
    }


    @XmlElementDecl(namespace = "", name = "beers")
    public JAXBElement<Beers> createBeersObject(Beers value)
    {
        return new JAXBElement<Beers>(_Beers_QNAME, Beers.class, null, value);
    }

}
