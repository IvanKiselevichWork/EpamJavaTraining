package by.javatr.finance.controller.command;

import by.javatr.finance.view.View;

public class ExitCommand implements Command {

    private static View view = View.getInstance();

    @Override
    public void execute() {
        view.showExitMessage();
        System.exit(0);
    }
}
