package by.javatr.finance.controller;

import by.javatr.finance.controller.exception.ControllerException;
import by.javatr.finance.service.UserService;
import by.javatr.finance.service.factory.ServiceFactory;
import by.javatr.finance.service.impl.UserServiceImpl;
import by.javatr.finance.view.View;

import java.util.Scanner;

public class MainMenuController extends Controller {

    private static final String[] COMMANDS = {"0", "1", "2"};

    private static MainMenuController instance = new MainMenuController();
    private static View view = View.getInstance();

    protected static UserService userService = ServiceFactory.getInstance().getUserService();

    public static MainMenuController getInstance() {
        return instance;
    }

    public void start() {
        view.showMainMenu();
        String command = view.getCommand("Input command:", COMMANDS);
        try {
            execute(command);
        } catch (ControllerException e) {
            view.showErrorMessage("Unexpected error!");
            //log.ERROR(e);
        }
    }

    private MainMenuController() {
        init();
    }

    protected void init() {
        registerCommand(COMMANDS[0], new Command() {
            @Override
            public void execute() {
                System.out.println("Turning off..."); // todo
                System.exit(0);
            }
        });
        registerCommand(COMMANDS[1], new Command() {
            @Override
            public void execute() {
                System.out.println("Start execute"); // todo
                UserService userService = new UserServiceImpl();
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
        });
    }
}
