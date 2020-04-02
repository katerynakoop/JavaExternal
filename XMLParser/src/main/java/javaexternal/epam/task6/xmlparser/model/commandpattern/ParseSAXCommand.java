package javaexternal.epam.task6.xmlparser.model.commandpattern;

public class ParseSAXCommand implements ICommand
{
    Commands commands;

    public ParseSAXCommand(Commands commands)
    {
        this.commands = commands;
    }

    @Override
    public void execute()
    {
        commands.parseSAX();
    }
}
