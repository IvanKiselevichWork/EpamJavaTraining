package by.javatr.finance.controller.command;

import by.javatr.finance.service.UserService;
import by.javatr.finance.service.factory.ServiceFactory;
import by.javatr.finance.service.impl.UserServiceImpl;
import by.javatr.finance.view.View;

import java.util.Scanner;

public class SignInCommand implements Command {

    private static View view = View.getInstance();
    protected static UserService userService = ServiceFactory.getInstance().getUserService();

    @Override
    public void execute() {
        System.out.println("Start execute"); // todo

        Scanner scanner = new Scanner(System.in);
        String login = scanner.nextLine();
        String password = scanner.nextLine();

        try {
            userService.signIn(login, password);
            System.out.println("Welcome, " + login + "!"); // todo
            //todo
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
