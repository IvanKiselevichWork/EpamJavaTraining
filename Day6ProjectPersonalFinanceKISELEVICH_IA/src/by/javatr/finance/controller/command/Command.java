package by.javatr.finance.controller.command;

import by.javatr.finance.controller.exception.AbstractControllerException;

public interface Command {
    void execute(CommandParameters commandParameters) throws AbstractControllerException;
}
