package by.javatr.finance.controller.command.mainmenucontroller;

import by.javatr.finance.controller.MainMenuController;
import by.javatr.finance.controller.command.Command;
import by.javatr.finance.controller.command.CommandParameters;
import by.javatr.finance.controller.command.UserMessages;
import by.javatr.finance.controller.exception.AbstractControllerException;
import by.javatr.finance.view.View;

public class RunMainMenuCommand implements Command {

    private static final View view = View.getInstance();

    @Override
    public void execute(CommandParameters commandParameters) throws AbstractControllerException {
        view.showMainMenu();
        String command = view.getCommand(UserMessages.COMMAND_REQUEST_MESSAGE, MainMenuController.MAIN_MENU_COMMANDS);
        MainMenuController.getInstance().execute(command, commandParameters);
    }
}
