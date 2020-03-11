package javaexternal.homework.task4.controller;


import javaexternal.homework.task4.model.MyURLs;
import javaexternal.homework.task4.model.SonnetModel;
import javaexternal.homework.task4.view.SonnetView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

public class SonnetController
{
    SonnetModel model;
    SonnetView view;

    public SonnetController(SonnetModel model, SonnetView view)
    {
        this.model = model;
        this.view = view;
    }

    public void execute()
    {
        MyURLs myURLs = new MyURLs();
        List<String> urls = myURLs.getUrlsList();

        for (String url: urls)
        {
            model.addSmallMapToBigMap(model.getSmallMap(url));
        }

        System.out.println(view.ENTER_SEARCHED_WORD);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            model.setSearchedWord(reader.readLine());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        List<Map<String, Integer>> listOfUrlsAndFreqOfSearchedWord =
                model.searchWordAndGetItsUrlsAndFreq(model.getSearchedWord());

        view.displayUrlsAndFreqOfSearchedWord(model, listOfUrlsAndFreqOfSearchedWord);
        view.displayBigMap(model);
    }
}
