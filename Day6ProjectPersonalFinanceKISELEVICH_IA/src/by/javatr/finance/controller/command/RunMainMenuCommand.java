package by.javatr.finance.controller.command;

import by.javatr.finance.controller.Controller;
import by.javatr.finance.controller.exception.ControllerException;
import by.javatr.finance.view.View;

import static by.javatr.finance.controller.MainMenuController.MAIN_MENU_COMMANDS;

public class RunMainMenuCommand implements Command {

    private Controller controller;

    public RunMainMenuCommand(Controller controller) {
        if (controller != null) {
            this.controller = controller;
        }
    }

    private static View view = View.getInstance();

    @Override
    public void execute() {
        view.showMainMenu();
        String command = view.getCommand("Input command:", MAIN_MENU_COMMANDS);
        try {
            controller.execute(command);
        } catch (ControllerException e) {
            view.showErrorMessage("Unexpected error!");
            //log.ERROR(e);
        }
    }
}
