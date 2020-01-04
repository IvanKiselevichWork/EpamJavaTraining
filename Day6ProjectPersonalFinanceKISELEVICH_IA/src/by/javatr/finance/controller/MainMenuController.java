package by.javatr.finance.controller;

import by.javatr.finance.controller.command.ExitCommand;
import by.javatr.finance.controller.command.SignInCommand;


public class MainMenuController extends Controller {

    public static final String[] MAIN_MENU_COMMANDS = {"0", "1", "2"};

    private static MainMenuController instance = new MainMenuController();

    public static MainMenuController getInstance() {
        return instance;
    }

    private MainMenuController() {
        registerCommand(MAIN_MENU_COMMANDS[0], new ExitCommand());
        registerCommand(MAIN_MENU_COMMANDS[1], new SignInCommand());
        //registerCommand(MAIN_MENU_COMMANDS[2], new RegistrationCommand());
    }

}
