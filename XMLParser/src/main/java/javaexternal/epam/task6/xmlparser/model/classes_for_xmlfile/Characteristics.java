
package javaexternal.epam.task6.xmlparser.model.classes_for_xmlfile;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "characteristicsType", propOrder = {
    "strength",
    "transparency",
    "filtering",
    "nutritionalValue"
})
public class Characteristics
{
    @XmlElement(required = true)
    protected Strength strength;
    @XmlElement(required = true)
    protected Transparency transparency;
    @XmlElement(required = true)
    protected Filtering filtering;
    @XmlElement(name = "nutritional_value", required = true)
    protected NutritionalValue nutritionalValue;

    public Strength getStrength()
    {
        return strength;
    }

    public void setStrength(Strength value)
    {
        this.strength = value;
    }

    public Transparency getTransparency()
    {
        return transparency;
    }

    public void setTransparency(Transparency value)
    {
        this.transparency = value;
    }

    public Filtering getFiltering()
    {
        return filtering;
    }

    public void setFiltering(Filtering value)
    {
        this.filtering = value;
    }

    public NutritionalValue getNutritionalValue()
    {
        return nutritionalValue;
    }

    public void setNutritionalValue(NutritionalValue value)
    {
        this.nutritionalValue = value;
    }

    @Override
    public String toString() {
        return "CharacteristicsType{" +
                "strength=" + strength +
                ", transparency=" + transparency +
                ", filtering='" + filtering + '\'' +
                ", nutritionalValue=" + nutritionalValue +
                '}';
    }
}

