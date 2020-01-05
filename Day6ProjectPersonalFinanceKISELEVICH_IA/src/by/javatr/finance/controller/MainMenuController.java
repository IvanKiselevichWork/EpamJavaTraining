package by.javatr.finance.controller;

import by.javatr.finance.controller.command.ExitCommand;
import by.javatr.finance.controller.command.mainmenucontroller.RegistrationCommand;
import by.javatr.finance.controller.command.mainmenucontroller.RunMainMenuCommand;
import by.javatr.finance.controller.command.mainmenucontroller.SignInCommand;


public class MainMenuController extends Controller {

    public static final String RUN_MAIN_MENU_COMMAND = "MAIN";
    public static final String[] MAIN_MENU_COMMANDS = {"0", "1", "2"};

    static {
        registerCommand(MAIN_MENU_COMMANDS[0], new ExitCommand());
        registerCommand(MAIN_MENU_COMMANDS[1], new SignInCommand());
        registerCommand(MAIN_MENU_COMMANDS[2], new RegistrationCommand());

        registerCommand(RUN_MAIN_MENU_COMMAND, new RunMainMenuCommand());
    }

    private static final MainMenuController instance = new MainMenuController();

    public static MainMenuController getInstance() {
        return instance;
    }

    private MainMenuController() {

    }
}
