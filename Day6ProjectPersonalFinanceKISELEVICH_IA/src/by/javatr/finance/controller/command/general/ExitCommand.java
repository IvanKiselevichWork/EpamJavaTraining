package by.javatr.finance.controller.command.general;

import by.javatr.finance.controller.CommandParameters;
import by.javatr.finance.controller.command.Command;
import by.javatr.finance.view.View;

public class ExitCommand implements Command {

    private static final View view = View.getInstance();

    @Override
    public CommandParameters execute(CommandParameters commandParameters) {
        view.showExitMessage();
        System.exit(0);
        return null;
    }
}
