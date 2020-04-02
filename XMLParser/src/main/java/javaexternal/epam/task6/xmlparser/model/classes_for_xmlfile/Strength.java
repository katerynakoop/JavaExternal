
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
@XmlType(name = "strengthType", propOrder = {
    "value"
})

public class Strength
{
    @XmlValue
    @Min(value = 0, message = ValidationMessages.MORE_THAN + 0)
    @Max(value = 15, message = ValidationMessages.LESS_THAN + 15)
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
        return "StrengthType{" +
                "value=" + value +
                ", unit='" + unit + '\'' +
                '}';
    }
}
