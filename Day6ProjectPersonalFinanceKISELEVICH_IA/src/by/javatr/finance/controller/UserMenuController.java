package by.javatr.finance.controller;

import by.javatr.finance.controller.command.*;
import by.javatr.finance.controller.command.usermenucontroller.AddRecordCommand;
import by.javatr.finance.controller.command.usermenucontroller.RunUserMenuCommand;
import by.javatr.finance.controller.command.usermenucontroller.ShowAllUserRecordsCommand;


public class UserMenuController extends Controller {

    public static final String RUN_USER_MENU_COMMAND = "RUN_USER_MENU";
    public static final String[] USER_MENU_COMMANDS = {"0", "1", "2"};

    static {
        registerCommand(USER_MENU_COMMANDS[0], new ExitCommand());
        registerCommand(USER_MENU_COMMANDS[1], new ShowAllUserRecordsCommand());
        registerCommand(USER_MENU_COMMANDS[2], new AddRecordCommand());

        registerCommand(RUN_USER_MENU_COMMAND, new RunUserMenuCommand());
    }

    private static final UserMenuController instance = new UserMenuController();

    public static UserMenuController getInstance() {
        return instance;
    }

    private UserMenuController() {

    }

}
