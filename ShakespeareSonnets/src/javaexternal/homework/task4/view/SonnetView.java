package javaexternal.homework.task4.view;

import javaexternal.homework.task4.model.SonnetModel;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class SonnetView
{
    public final String ENTER_SEARCHED_WORD = "Enter the searched word: ";

    public void displayMapOfWordsAndTheirFreq(SonnetModel model)
    {
        Set<Map.Entry<String, List<Map<String, Integer>>>> bigSet = model.getBigMap().entrySet();

        for (Map.Entry<String, List<Map<String, Integer>>> entry : bigSet)
        {
            System.out.println("Word: " + entry.getKey());

            for(Map<String, Integer> innerMap: entry.getValue())
            {
                Set<Map.Entry<String, Integer>> smallSet = innerMap.entrySet();
                for(Map.Entry<String, Integer> map: smallSet)
                {
                    System.out.println("url: " + map.getKey() + "frequency: " + map.getValue() + "\n");
                }
            }
        }
    }

    public void displayUrlsAndFreqOfSearchedWord(SonnetModel model, List<Map<String, Integer>> listOfUrlsAndFreq)
    {
        if(listOfUrlsAndFreq != null)
        {
            System.out.println("URLs where \"" + model.getSearchedWord() + "\" is found and frequency of it in every URL:");
            for(Map<String, Integer> mapOfUrlAndFreq: listOfUrlsAndFreq)
            {
                Set<Map.Entry<String, Integer>> setOfUrlsAndFreq = mapOfUrlAndFreq.entrySet();
                for(Map.Entry<String, Integer> innerMap: setOfUrlsAndFreq)
                {
                    System.out.println("URL: " + innerMap.getKey() + "\tWORD\'S FREQUENCY: " + innerMap.getValue());
                }
            }
        }
        else
            System.out.println("There is not this word in sonnets 1-20");
        System.out.println();
    }

    public void displayUrls(List<String> urls)
    {
        for(String url: urls)
        {
            System.out.println(url);
        }
    }
}
