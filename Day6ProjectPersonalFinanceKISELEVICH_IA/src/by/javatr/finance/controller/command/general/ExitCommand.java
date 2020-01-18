package by.javatr.finance.controller.command.general;

import by.javatr.finance.controller.CommandName;
import by.javatr.finance.controller.CommandParameters;
import by.javatr.finance.controller.command.Command;
import by.javatr.finance.view.View;

public class ExitCommand implements Command {

    @Override
    public CommandParameters execute(CommandParameters commandParameters) {
        System.exit(0);
        return null;
    }
}
