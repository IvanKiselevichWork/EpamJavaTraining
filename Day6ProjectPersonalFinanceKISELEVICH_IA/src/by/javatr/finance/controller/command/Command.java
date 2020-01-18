package by.javatr.finance.controller.command;

import by.javatr.finance.controller.CommandParameters;
import by.javatr.finance.controller.exception.AbstractControllerException;

public interface Command {
    CommandParameters execute(CommandParameters commandParameters) throws AbstractControllerException;
}
