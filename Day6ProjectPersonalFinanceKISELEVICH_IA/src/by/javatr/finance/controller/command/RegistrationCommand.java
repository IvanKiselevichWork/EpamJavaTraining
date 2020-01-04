package by.javatr.finance.controller.command;

import by.javatr.finance.service.UserService;
import by.javatr.finance.service.factory.ServiceFactory;
import by.javatr.finance.view.View;

import java.util.Scanner;

public class RegistrationCommand implements Command {

    private static View view = View.getInstance();
    protected static UserService userService = ServiceFactory.getInstance().getUserService();

    @Override
    public void execute() {
        view.registrationLoginAndPasswordRequest();
        Scanner scanner = new Scanner(System.in);
        String login = scanner.nextLine();
        String password = scanner.nextLine();

        try {
            userService.registration(login, password);
            view.welcomeUser(login);
            //todo
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
