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

    public int getUserChoice()
    {
        int userChoice;
        int defaultChoice = -1;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            userChoice = Integer.parseInt(reader.readLine());
        }
        catch (IOException | NumberFormatException e)
        {
            userChoice = defaultChoice;
        }

        return userChoice;
    }

    public void searchWord()
    {
        System.out.println(view.ENTER_SEARCHED_WORD);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            model.setSearchedWord(reader.readLine());
        }
        catch (IOException e)
        {
            System.out.println(view.WRONG_INPUT);
        }


        List<Map<String, Integer>> listOfUrlsAndFreqOfSearchedWord =
                model.searchWordAndGetItsUrlsAndFreq(model.getSearchedWord());

        view.displayUrlsAndFreqOfSearchedWord(model, listOfUrlsAndFreqOfSearchedWord);
    }

    public void execute()
    {
        boolean continueUsingThisSoftware = true;

        MyURLs myURLs = new MyURLs();
        List<String> urls = myURLs.getUrlsList();

        for (String url: urls)
        {
            model.addSmallMapToBigMap(model.getSmallMap(url));
        }

        do
        {
           view.showMenu();
           switch(getUserChoice())
           {
               case 1:
                   view.displayBigMap(model);
                   System.out.println();
                   break;
               case 2:
                   searchWord();
                   break;
               case 3:
                   continueUsingThisSoftware = false;
                   break;
               default:
                   System.out.println(view.WRONG_INPUT);
                   break;

           }

        } while(continueUsingThisSoftware);
    }
}
