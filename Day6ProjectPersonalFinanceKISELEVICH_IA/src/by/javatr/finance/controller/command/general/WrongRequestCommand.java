package by.javatr.finance.controller.command.general;

import by.javatr.finance.controller.CommandName;
import by.javatr.finance.controller.CommandParameters;
import by.javatr.finance.controller.command.Command;
import by.javatr.finance.controller.command.UserMessages;
import by.javatr.finance.view.View;

public class WrongRequestCommand implements Command {

    private final View view = View.getInstance();

    @Override
    public CommandParameters execute(CommandParameters commandParameters) {
        view.showCaution(UserMessages.WRONG_REQUEST);
        commandParameters.setParameter(CommandParameters.NEXT_COMMAND, CommandName.SHOW_MAIN_MENU);
        return commandParameters;
    }
}
