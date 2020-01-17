package by.javatr.finance.controller;

import by.javatr.finance.controller.command.Command;
import by.javatr.finance.controller.exception.AbstractControllerException;

public class Controller {
    private final CommandProvider commandProvider = new CommandProvider();
    private final char PARAMS_DELIMITER = ';';

    public String execute(String request) throws AbstractControllerException {
        String commandName = null;
        Command command = null;

        commandName = request.substring(0, request.indexOf(PARAMS_DELIMITER));
        command = commandProvider.getCommand(commandName);

        return command.execute(request);
    }
}
