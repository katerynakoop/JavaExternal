package javaexternal.epam.task7.runner;

import javaexternal.epam.task7.controller.Controller;
import javaexternal.epam.task7.model.Model;
import javaexternal.epam.task7.view.View;

public class Runner
{
    public static void main(String[] args)
    {
        Model model = new Model();
        View view = new View();
        Controller baseApplication = new Controller(model, view);
        baseApplication.execute();
    }
}
