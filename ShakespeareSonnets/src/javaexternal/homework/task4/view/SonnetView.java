package javaexternal.homework.task4.view;

import javaexternal.homework.task4.model.SonnetModel;

import java.util.*;

public class SonnetView
{
    public final String ENTER_SEARCHED_WORD = "Enter the searched word: ";
    public final String WRONG_INPUT = "Wrong input!\n";

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
            System.out.println("There is not this word in these URLs!");
        System.out.println();
    }

    public void displayBigMap(SonnetModel model)
    {
        Map<String, List<Map<String, Integer>>> bigMap = model.getBigMap();

        Set<Map.Entry<String, List<Map<String, Integer>>>> bigMapSet = bigMap.entrySet();

        for(Map.Entry<String, List<Map<String, Integer>>> entry: bigMapSet)
        {
            System.out.println("Word: " + entry.getKey());
            List<Map<String, Integer>> innerList = entry.getValue();

            for(Map<String, Integer> mapOfInnerList: innerList)
            {
                Set<Map.Entry<String, Integer>> setOfMapOfInnerList = mapOfInnerList.entrySet();

                for(Map.Entry<String, Integer> entryOfMapOfInnerList: setOfMapOfInnerList)
                {
                    System.out.print("URL: " + entryOfMapOfInnerList.getKey() + "\t\t");
                    System.out.println("WORD'S FREQUENCY: " + entryOfMapOfInnerList.getValue());
                }
            }
        }
    }

    public void displayUrls(List<String> urls)
    {
        for(String url: urls)
        {
            System.out.println(url);
        }
    }

    public void showMenu()
    {
        System.out.println("Select action: ");
        System.out.println("1: display all words from urls");
        System.out.println("2: search a word");
        System.out.println("3: exit the application");
        System.out.print("\nEnter your choice: ");
    }
}
