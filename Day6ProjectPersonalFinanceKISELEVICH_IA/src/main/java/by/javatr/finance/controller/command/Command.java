package main.java.by.javatr.finance.controller.command;

import main.java.by.javatr.finance.controller.CommandParameters;
import main.java.by.javatr.finance.controller.exception.AbstractControllerException;

public interface Command {
    CommandParameters execute(CommandParameters commandParameters) throws AbstractControllerException;
}
