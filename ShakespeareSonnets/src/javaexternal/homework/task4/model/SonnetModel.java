package javaexternal.homework.task4.model;

import java.util.*;

public class SonnetModel
{
    private String searchedWord;
    Set<String> wordsFromAllUrls = new HashSet<>();

    // key - word, value - list of urls and word frequency in every url
    Map<String, List<Map<String, Integer>>> bigMap = new HashMap<>();


    public String getSearchedWord()
    {
        return searchedWord;
    }

    public void setSearchedWord(String searchedWord)
    {
        this.searchedWord = searchedWord;
    }

    public Map<String, Map<String, Integer>> getSmallMap(String url)
    {
        // key - word, value - its frequency from one url
        Map<String, Map<String, Integer>> smallMap = new HashMap<>();

        URLReader urlReader = new URLReader();
        String[] words = urlReader.getAllWordsFromHtmlPage(url).toLowerCase().split("[\\s,.?!<>]");
        wordsFromAllUrls.addAll(Arrays.asList(words));

        for(String word: words)
        {
            String key = word;
            Map<String, Integer> value = new HashMap<>();
            Integer wordFreq;

            if(smallMap.containsKey(word))
            {
                wordFreq = smallMap.get(word).get(url);
                ++wordFreq;
            }
            else
                wordFreq = 1;

            value.put(url, wordFreq);
            smallMap.put(key, value);
        }
        return smallMap;
    }

    public void addSmallMapToBigMap(Map<String, Map<String, Integer>> map)
    {
        Set<Map.Entry<String, Map<String, Integer>>> smallSet = map.entrySet();
        Set<Map.Entry<String, List<Map<String, Integer>>>> bigSet = bigMap.entrySet();

        for(Map.Entry<String, Map<String, Integer>> entry: smallSet)
        {
            List<Map<String, Integer>> innerListOfBigMap = new LinkedList<>();

            if(bigMap.containsKey(entry.getKey()))
            {
                innerListOfBigMap = bigMap.get(entry.getKey());
                innerListOfBigMap.add(entry.getValue());
                bigMap.replace(entry.getKey(), innerListOfBigMap);
            }
            else
            {
                innerListOfBigMap.add(entry.getValue());
                bigMap.put(entry.getKey(), innerListOfBigMap);
            }
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
