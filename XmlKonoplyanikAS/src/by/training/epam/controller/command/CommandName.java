package by.training.epam.controller.command;

public enum CommandName {
	
	SAX,
	STAX,
	DOM,
	ERROR,
	HOME;
	
	public static CommandName parse(String name) {
		CommandName commandName;
		try {
			commandName = CommandName.valueOf(name.toUpperCase());
		} catch (IllegalArgumentException | NullPointerException e) {
			commandName = CommandName.ERROR;
		}
		return commandName;
	}

}
