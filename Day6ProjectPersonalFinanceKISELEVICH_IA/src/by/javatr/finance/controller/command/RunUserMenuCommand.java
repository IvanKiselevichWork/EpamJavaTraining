package by.javatr.finance.controller.command;

import by.javatr.finance.controller.Controller;
import by.javatr.finance.controller.exception.ControllerException;
import by.javatr.finance.view.View;

import static by.javatr.finance.controller.MainMenuController.MAIN_MENU_COMMANDS;
import static by.javatr.finance.controller.UserMenuController.USER_MENU_COMMANDS;

public class RunUserMenuCommand implements Command {

    private Controller controller;

    public RunUserMenuCommand(Controller controller) {
        if (controller != null) {
            this.controller = controller;
        }
    }

    private static View view = View.getInstance();

    @Override
    public void execute() {
        view.showUserMenu();
        String command = view.getCommand("Input command:", USER_MENU_COMMANDS);
        try {
            controller.execute(command);
        } catch (ControllerException e) {
            view.showErrorMessage("Unexpected error!");
            //log.ERROR(e);
        }
    }
}
