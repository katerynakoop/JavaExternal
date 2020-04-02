package javaexternal.epam.task6.xmlparser.model.commandpattern;

public class MarshallCommand implements ICommand
{
    Commands commands;

    public MarshallCommand(Commands commands)
    {
        this.commands = commands;
    }

    @Override
    public void execute()
    {
        commands.marshall();
    }
}
