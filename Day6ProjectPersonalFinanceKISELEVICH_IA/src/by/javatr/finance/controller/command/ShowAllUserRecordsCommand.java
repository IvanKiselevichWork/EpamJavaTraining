package by.javatr.finance.controller.command;

import by.javatr.finance.service.UserService;
import by.javatr.finance.service.exception.user.AccountNotFoundServiceException;
import by.javatr.finance.service.exception.user.UserServiceException;
import by.javatr.finance.service.factory.ServiceFactory;
import by.javatr.finance.view.View;

import java.util.Scanner;

public class ShowAllUserRecordsCommand implements Command {

    private static View view = View.getInstance();
    protected static UserService userService = ServiceFactory.getInstance().getUserService();

    @Override
    public void execute() {
        //todo
    }
}
