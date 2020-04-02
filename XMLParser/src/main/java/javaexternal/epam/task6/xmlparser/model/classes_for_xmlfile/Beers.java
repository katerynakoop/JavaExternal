
package javaexternal.epam.task6.xmlparser.model.classes_for_xmlfile;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "beersType", propOrder = {
    "beer"
})
@XmlRootElement
public class Beers
{
    @XmlElement(required = true)
    protected List<Beer> beer;

    public List<Beer> getBeerList()
    {
        if (beer == null)
        {
            beer = new ArrayList<Beer>();
        }
        return this.beer;
    }

    public void addBeerToBeersList(Beer newBeer)
    {
        beer.add(newBeer);
    }

    @Override
    public String toString()
    {
        return "BeersType{" +
                "beer=" + beer +
                '}';
    }
}
