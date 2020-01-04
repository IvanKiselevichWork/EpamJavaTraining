package by.javatr.finance.controller;

import by.javatr.finance.controller.command.ExitCommand;
import by.javatr.finance.controller.command.RunMainMenuCommand;
import by.javatr.finance.controller.command.SignInCommand;

import static by.javatr.finance.controller.command.MenuCommandsNames.RUN_MAIN_MENU;


public class MainController extends Controller {



    private static MainController instance = new MainController();

    public static MainController getInstance() {
        return instance;
    }

    private MainController() {
        registerCommand(RUN_MAIN_MENU, new RunMainMenuCommand(MainMenuController.getInstance()));
    }

}
