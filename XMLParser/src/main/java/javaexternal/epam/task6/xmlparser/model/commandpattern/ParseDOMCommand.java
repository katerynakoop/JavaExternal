package javaexternal.epam.task6.xmlparser.model.commandpattern;

public class ParseDOMCommand implements ICommand
{
    Commands commands;

    public ParseDOMCommand(Commands commands)
    {
        this.commands = commands;
    }

    @Override
    public void execute()
    {
        commands.parseDOM();
    }
}
