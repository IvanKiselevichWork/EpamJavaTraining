package by.javatr.finance.controller.command.usermenu;

import by.javatr.finance.controller.UserMenuController;
import by.javatr.finance.controller.command.Command;
import by.javatr.finance.controller.command.UserMessages;
import by.javatr.finance.controller.exception.AbstractControllerException;
import by.javatr.finance.view.View;

public class ShowUserMenuCommand implements Command {

    private static final View view = View.getInstance();

    @Override
    public void execute(CommandParameters commandParameters) throws AbstractControllerException {
        view.showUserMenu();
        String command = view.getCommand(UserMessages.COMMAND_REQUEST_MESSAGE, UserMenuController.USER_MENU_COMMANDS);
        UserMenuController.getInstance().execute(command, commandParameters); // execute command

        UserMenuController.getInstance().execute(UserMenuController.RUN_USER_MENU_COMMAND, commandParameters);
    }
}
