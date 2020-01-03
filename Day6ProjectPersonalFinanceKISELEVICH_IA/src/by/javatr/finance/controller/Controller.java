package by.javatr.finance.controller;

import by.javatr.finance.controller.exception.ControllerException;
import by.javatr.finance.controller.exception.ControllerExceptionMessages;

import java.util.HashMap;

public abstract class Controller {
    protected final HashMap<String, Command> commandMap = new HashMap<>();

    protected void registerCommand(String commandName, Command command) {
        commandMap.put(commandName, command);
    }

    protected void execute(String commandName) throws ControllerException {
        Command command = commandMap.get(commandName);
        if (command == null) {
            throw new ControllerException(ControllerExceptionMessages.noCommand + commandName);
        }
        command.execute();
    }
}
