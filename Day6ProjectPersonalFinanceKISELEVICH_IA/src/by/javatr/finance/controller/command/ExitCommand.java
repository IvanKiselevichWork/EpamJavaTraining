package by.javatr.finance.controller.command;

import by.javatr.finance.view.View;

public class ExitCommand implements Command {

    private static final View view = View.getInstance();

    @Override
    public void execute(CommandParameters commandParameters) {
        view.showExitMessage();
        System.exit(0);
    }
}
