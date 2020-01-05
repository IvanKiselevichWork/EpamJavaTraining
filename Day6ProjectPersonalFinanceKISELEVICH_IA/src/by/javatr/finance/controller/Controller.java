package by.javatr.finance.controller;

import by.javatr.finance.controller.command.Command;
import by.javatr.finance.controller.command.CommandParameters;
import by.javatr.finance.controller.exception.AbstractControllerException;
import by.javatr.finance.controller.exception.ControllerException;
import by.javatr.finance.controller.exception.ControllerExceptionMessages;

import java.util.HashMap;

public abstract class Controller {
    protected final static HashMap<String, Command> commandMap = new HashMap<>();

    public static void registerCommand(String commandName, Command command) {
        commandMap.put(commandName, command);
    }

    public void execute(String commandName, CommandParameters commandParameters) throws AbstractControllerException {
        Command command = commandMap.get(commandName);
        if (command == null) {
            throw new ControllerException(ControllerExceptionMessages.noCommand + commandName);
        }
        command.execute(commandParameters);
    }
}
