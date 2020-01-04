package by.javatr.finance.controller;

import by.javatr.finance.controller.command.*;


public class UserMenuController extends Controller {

    public static final String[] USER_MENU_COMMANDS = {"0", "1", "2"};

    private static UserMenuController instance = new UserMenuController();

    public static UserMenuController getInstance() {
        return instance;
    }

    private UserMenuController() {
        registerCommand(USER_MENU_COMMANDS[0], new ExitCommand());
        registerCommand(USER_MENU_COMMANDS[1], new ShowAllUserRecordsCommand());
        registerCommand(USER_MENU_COMMANDS[2], new AddRecordCommand());
    }

}
