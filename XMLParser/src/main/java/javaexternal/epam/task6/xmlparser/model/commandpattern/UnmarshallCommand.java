package javaexternal.epam.task6.xmlparser.model.commandpattern;

public class UnmarshallCommand implements ICommand
{

    Commands commands;

    public UnmarshallCommand(Commands commands)
    {
        this.commands = commands;
    }

    @Override
    public void execute()
    {
        commands.unmarshall();
    }
}
