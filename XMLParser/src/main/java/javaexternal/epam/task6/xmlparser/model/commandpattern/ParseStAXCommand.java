package javaexternal.epam.task6.xmlparser.model.commandpattern;

public class ParseStAXCommand implements ICommand
{
    Commands commands;

    public ParseStAXCommand(Commands commands)
    {
        this.commands = commands;
    }

    @Override
    public void execute()
    {
        commands.parseStAX();
    }
}
