package javaexternal.epam.task6.xmlparser.model.classes_for_xmlfile;

import javaexternal.epam.task6.xmlparser.view.ValidationMessages;

import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "filtering", propOrder = {
        "value"
})
public class Filtering
{
    @XmlValue
    @Pattern(regexp = "yes|not", message = ValidationMessages.POSSIBLE_VALUES + ValidationMessages.FILTERING_VALUES)
    private String value;

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }
}
