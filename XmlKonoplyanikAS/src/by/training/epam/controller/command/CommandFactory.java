package by.training.epam.controller.command;

import java.util.HashMap;
import java.util.Map;

import by.training.epam.controller.command.impl.doDom;
import by.training.epam.controller.command.impl.doSax;
import by.training.epam.controller.command.impl.doStax;
import by.training.epam.controller.command.impl.Error;
import by.training.epam.controller.command.impl.Home;

public class CommandFactory {
	
private static final Map<CommandName, Command> commands = new HashMap<>();
	
	public CommandFactory() {
		commands.put(CommandName.SAX, new doSax());
        commands.put(CommandName.STAX, new doStax());
        commands.put(CommandName.DOM, new doDom());
        commands.put(CommandName.ERROR, new Error());
        commands.put(CommandName.HOME, new Home());
	}

    public Command getCommand(String cName){
        CommandName commandName = CommandName.parse(cName);
        Command command = commands.get(commandName);
        return command;
    }

}
