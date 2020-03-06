package epam.homework.task4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class URLContainer
{
    List<String> urls = new ArrayList<String>();
    final int numOfUrls = 20;
    private static String urlCounter;
    String url;

    private String romeNumbers[] = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII",
                                    "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX"};

    public URLContainer()
    {
        fillUrlsList();
    }

    public void fillUrlsList()
    {
        for(int i = 0; i < numOfUrls; i++)
        {
            urlCounter = romeNumbers[i];
            url = "http://shakespeare.mit.edu/Poetry/sonnet." + urlCounter + ".html";
            urls.add(url);
        }
    }

    public int getNumOfUrls()
    {
        return numOfUrls;
    }
    public List getUrlsList()
    {
        return urls;
    }

    public void displayUrls()
    {
        for(String url: urls)
        {
            System.out.println(url);
        }
    }
}


class URLReader
{
    String [] arrayWordsFromUrl;
    ArrayList<String> listOfWordsFromAllUrls = new ArrayList();

    Map<String, Integer> mapOfWordsAndTheirFreq = new HashMap<>();

    public String getAllWordsFromHtmlPage(String url)
    {
        StringBuilder response;
        URLConnection connection;
        BufferedReader bufferedReader;
        String str;

        try
        {
            URL website = new URL(url);
            connection = website.openConnection();
            bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            response = new StringBuilder();

            while ((str = bufferedReader.readLine()) != null)
                response.append(str);

            bufferedReader.close();
        }
        catch (MalformedURLException ex)
        {
            response = null;
            ex.printStackTrace();
        }
        catch (IOException ex)
        {
            response = null;
            ex.printStackTrace();
        }

        return response.toString();
    }

    public void addWordsToListOfWordsFromAllUrls(String words)
    {
        arrayWordsFromUrl = words.split(" ");

        for(String word: arrayWordsFromUrl)
            listOfWordsFromAllUrls.add(word);
    }

    public void addWordsToMapOfWordsAndFreqs()
    {
        for(String key: listOfWordsFromAllUrls)
        {
            Integer freq = mapOfWordsAndTheirFreq.get(key);
            Integer value;
            if(freq == null)
                value = 1;
            else
                value = ++freq;

            mapOfWordsAndTheirFreq.put(key, value);
        }
    }

    public Map<String, Integer> getMapOfWordsAndFreqs()
    {
        return mapOfWordsAndTheirFreq;
    }

    public void displayMapOfWordsAndFreqs()
    {
        for (Map.Entry<String, Integer> entry : mapOfWordsAndTheirFreq.entrySet())
        {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
    }
}

public class ShakespearesSonnets
{
    public static void main(String[] args)
    {
        URLContainer urlContainer = new URLContainer();
        URLReader urlReader = new URLReader();

        urlContainer.displayUrls();

        List<String> urls = urlContainer.getUrlsList();

        for(String url: urls)
        {
            String words = urlReader.getAllWordsFromHtmlPage(url);
            urlReader.addWordsToListOfWordsFromAllUrls(words);
            urlReader.addWordsToMapOfWordsAndFreqs();
        }

        urlReader.displayMapOfWordsAndFreqs();
    }
}