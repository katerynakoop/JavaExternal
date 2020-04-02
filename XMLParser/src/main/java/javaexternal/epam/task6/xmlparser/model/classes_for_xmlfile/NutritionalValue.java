
package javaexternal.epam.task6.xmlparser.model.classes_for_xmlfile;

import javaexternal.epam.task6.xmlparser.view.ValidationMessages;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "nutritional_valueType", propOrder = {
    "value"
})
public class NutritionalValue
{
    @XmlValue
    @Min(30)
    @Max(60)
    @Positive(message = ValidationMessages.POSITIVE_NUM)
    protected int value;
    @XmlAttribute(name = "unit")
    protected String unit;

    public int getValue()
    {
        return value;
    }

    public void setValue(int value)
    {
        this.value = value;
    }

    public String getUnit()
    {
        if (unit == null) {
            return "kilocalories";
        } else {
            return unit;
        }
    }

    public void setUnit(String value)
    {
        this.unit = value;
    }

    @Override
    public String toString()
    {
        return "NutritionalValueType{" +
                "value=" + value +
                ", unit='" + unit + '\'' +
                '}';
    }
}
