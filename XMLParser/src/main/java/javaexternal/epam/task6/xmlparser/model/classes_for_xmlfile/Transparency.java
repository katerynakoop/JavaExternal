
package javaexternal.epam.task6.xmlparser.model.classes_for_xmlfile;

import javaexternal.epam.task6.xmlparser.view.ValidationMessages;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "transparencyType", propOrder = {
    "value"
})

public class Transparency
{
    @XmlValue
    @Min(value = 0, message = ValidationMessages.MORE_THAN + 0)
    @Max(value = 100, message = ValidationMessages.LESS_THAN + 100)
    private int value;
    @XmlAttribute(name = "unit")
    private String unit;

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
            return "%";
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
        return "TransparencyType{" +
                "value=" + value +
                ", unit='" + unit + '\'' +
                '}';
    }
}
