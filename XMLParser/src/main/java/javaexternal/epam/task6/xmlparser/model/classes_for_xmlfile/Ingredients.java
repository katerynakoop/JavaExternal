
package javaexternal.epam.task6.xmlparser.model.classes_for_xmlfile;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ingredientsType", propOrder = {
    "water",
    "grain",
    "hops",
    "yeast",
    "sugar"
})
public class Ingredients
{
    @XmlElement(required = true)
    private Water water;
    @XmlElement(required = true)
    private Grain grain;
    @XmlElement(required = true)
    private Hops hops;
    @XmlElement(required = true)
    private Yeast yeast;
    @XmlElement(required = true)
    private Sugar sugar;

    public Water getWater()
    {
        return water;
    }

    public void setWater(Water value)
    {
        this.water = value;
    }

    public Grain getGrain()
    {
        return grain;
    }

    public void setGrain(Grain value)
    {
        this.grain = value;
    }

    public Hops getHops()
    {
        return hops;
    }

    public void setHops(Hops value)
    {
        this.hops = value;
    }

    public Yeast getYeast()
    {
        return yeast;
    }

    public void setYeast(Yeast value)
    {
        this.yeast = value;
    }

    public Sugar getSugar()
    {
        return sugar;
    }

    public void setSugar(Sugar value)
    {
        this.sugar = value;
    }
}
