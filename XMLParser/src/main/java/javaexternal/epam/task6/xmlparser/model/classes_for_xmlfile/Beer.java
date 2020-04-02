package javaexternal.epam.task6.xmlparser.model.classes_for_xmlfile;

import javaexternal.epam.task6.xmlparser.view.ValidationMessages;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "beerType", propOrder = {
    "name",
    "type",
    "alcohol",
    "manufacturer",
    "ingredients",
    "characteristics"
})
public class Beer
{
    @XmlElement(required = true)
    @NotNull(message = ValidationMessages.NOT_NULL)
    private String name;

    @XmlElement(required = true)
    @Pattern(regexp = "light|ale|wheat|porter|lager|stout|marzen|dunkel",
            message = ValidationMessages.POSSIBLE_VALUES + ValidationMessages.TYPE_VALUES)
    private String type;

    @XmlElement(required = true)
    @Pattern(regexp = "alcoholic|non-alcoholic",
            message = ValidationMessages.POSSIBLE_VALUES + ValidationMessages.ALCOHOL_VALUES)
    private String alcohol;

    @XmlElement(required = true)
    @NotEmpty(message = ValidationMessages.NOT_EMPTY)
    private String manufacturer;

    @XmlElement(required = true)
    private Ingredients ingredients;
    @XmlElement(required = true)
    protected Characteristics characteristics;

    public String getName()
    {
        return name;
    }

    public void setName(String value)
    {
        this.name = value;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String value)
    {
        this.type = value;
    }

    public String getAlcohol()
    {
        return alcohol;
    }

    public void setAlcohol(String value)
    {
        this.alcohol = value;
    }

    public String getManufacturer()
    {
        return manufacturer;
    }

    public void setManufacturer(String value)
    {
        this.manufacturer = value;
    }

    public Ingredients getIngredients()
    {
        return ingredients;
    }

    public void setIngredients(Ingredients value)
    {
        this.ingredients = value;
    }

    public Characteristics getCharacteristics()
    {
        return characteristics;
    }

    public void setCharacteristics(Characteristics value)
    {
        this.characteristics = value;
    }

    @Override
    public String toString()
    {
        return "BeerType{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", alcohol='" + alcohol + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", ingredients=" + ingredients +
                ", characteristics=" + characteristics +
                '}';
    }
}
