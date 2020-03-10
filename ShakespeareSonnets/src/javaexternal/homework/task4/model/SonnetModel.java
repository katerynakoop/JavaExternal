package javaexternal.homework.task4.model;

import java.util.*;

public class SonnetModel
{
    private String searchedWord;
    Set<String> wordsFromAllUrls = new HashSet<>();
    List<Map<String, Integer>> listOfSmallMaps = new ArrayList<>();

    // key - word, value - list of urls and their frequency
    Map<String, List<Map<String, Integer>>> bigMap = new HashMap<>();

    public String getSearchedWord()
    {
        return searchedWord;
    }

    public void setSearchedWord(String searchedWord)
    {
        this.searchedWord = searchedWord;
    }

    public Map<String, Integer> getSmallMap(String url)
    {
        // key - word, value - its frequency from one url
        Map<String, Integer> smallMap = new HashMap<>();

        URLReader urlReader = new URLReader();
        String[] words = urlReader.getAllWordsFromHtmlPage(url).split(" ");
        wordsFromAllUrls.addAll(Arrays.asList(words));

        for(String word: words)
        {
            String key = word;
            Integer value;

            Integer frequency = smallMap.get(word);
            if(frequency == null)
                value = 1;
            else
                value = ++frequency;

            smallMap.put(key, value);
        }

        return smallMap;
    }

    public void addSmallMapToListOfSmallMaps(Map<String, Integer> smallMap)
    {
        listOfSmallMaps.add(smallMap);
    }

    public void addDataToBigMap()
    {
        MyURLs myURLs = new MyURLs();
        List<String> urls = myURLs.getUrlsList();

        for(String word: wordsFromAllUrls)
        {
            List<Map<String, Integer>> listOfInnerMaps = new LinkedList<>();
            for(String url: urls)
            {
                Map<String, Integer> map = getSmallMap(url);
                Map<String, Integer> innerMap = new HashMap<>();

                if(map.containsKey(word))
                {
                    Integer wordFrequency = map.get(word);
                    innerMap.put(url, wordFrequency);
                    listOfInnerMaps.add(innerMap);
                }
            }
            bigMap.put(word, listOfInnerMaps);
        }
    }

    public Map<String, List<Map<String, Integer>>> getBigMap()
    {
        return bigMap;
    }

    public List<Map<String, Integer>> searchWordAndGetItsUrlsAndFreq(String word)
    {
        searchedWord = word;
        return bigMap.getOrDefault(word, null);
    }
}
