package javaexternal.homework.task4;


import javaexternal.homework.task4.controller.SonnetController;
import javaexternal.homework.task4.model.SonnetModel;
import javaexternal.homework.task4.view.SonnetView;

public class Runner
{
    public static void main(String[] args)
    {
        SonnetModel model = new SonnetModel();
        SonnetView view = new SonnetView();

        SonnetController baseApp = new SonnetController(model, view);
        baseApp.execute();
    }
}
