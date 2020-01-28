package main.java.by.javatr.finance.controller.command.general;

import main.java.by.javatr.finance.controller.CommandParameters;
import main.java.by.javatr.finance.controller.command.Command;
import main.java.by.javatr.finance.view.View;

public class ExitCommand implements Command {

    private final View view = View.getInstance();

    @Override
    public CommandParameters execute(CommandParameters commandParameters) {
        view.showExitMessage();
        System.exit(0);
        return null;
    }
}
