package by.javatr.finance.controller;

import by.javatr.finance.controller.command.Command;
import by.javatr.finance.controller.exception.AbstractControllerException;

public class Controller {
    private final CommandProvider commandProvider = new CommandProvider();

    public CommandParameters execute(CommandParameters commandParameters) throws AbstractControllerException {
        String commandName = commandParameters.getParameter(CommandParameters.NEXT_COMMAND).toString();
        Command command = commandProvider.getCommand(commandName);
        return command.execute(commandParameters);
    }
}
