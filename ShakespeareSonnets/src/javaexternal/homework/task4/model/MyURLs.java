package javaexternal.homework.task4.model;

import java.util.ArrayList;
import java.util.List;

public class MyURLs
{
    private List<String> urls = new ArrayList<String>();
    private final int numOfUrls = 20;
    private static String sonnetCounter;
    private String url;

    private String romeNumbers[] = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
            "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX"};

    public MyURLs()
    {
        fillUrlsList();
    }

    public void fillUrlsList()
    {
        for(int i = 0; i < numOfUrls; i++)
        {
            sonnetCounter = romeNumbers[i];
            url = "http://shakespeare.mit.edu/Poetry/sonnet." + sonnetCounter + ".html";
            urls.add(url);
        }

        /*for(int i = 0; i < 2; i++)
        {
            sonnetCounter = romeNumbers[i];
            url = "http://shakespeare.mit.edu/Poetry/sonnet." + sonnetCounter + ".html";
            urls.add(url);
        }*/
    }

    public int getNumOfUrls()
    {
        return numOfUrls;
    }
    public List getUrlsList()
    {
        return urls;
    }
}