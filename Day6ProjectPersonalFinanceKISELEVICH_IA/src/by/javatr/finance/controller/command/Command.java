package by.javatr.finance.controller.command;

import by.javatr.finance.controller.exception.AbstractControllerException;

public interface Command {
    String execute(String request) throws AbstractControllerException;
}
