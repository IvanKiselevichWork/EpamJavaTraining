package by.javatr.finance.controller.command;

import by.javatr.finance.service.UserService;
import by.javatr.finance.service.exception.user.AccountNotFoundServiceException;
import by.javatr.finance.service.exception.user.UserServiceException;
import by.javatr.finance.service.factory.ServiceFactory;
import by.javatr.finance.service.impl.UserServiceImpl;
import by.javatr.finance.view.View;

import java.util.Scanner;

public class SignInCommand implements Command {

    private static View view = View.getInstance();
    protected static UserService userService = ServiceFactory.getInstance().getUserService();

    @Override
    public void execute() {
        view.signInLoginAndPasswordRequest();
        Scanner scanner = new Scanner(System.in);
        String login = scanner.nextLine();
        String password = scanner.nextLine();

        try {
            userService.signIn(login, password);
            view.welcomeUser(login);
            //todo
        } catch (AccountNotFoundServiceException e) {
            view.showAccountNotFoundMessage(e);
            //log.ERROR(e)
        } catch (UserServiceException e) {
            view.showErrorMessage(e.getMessage());
            //log.ERROR(e)
        }
    }
}
