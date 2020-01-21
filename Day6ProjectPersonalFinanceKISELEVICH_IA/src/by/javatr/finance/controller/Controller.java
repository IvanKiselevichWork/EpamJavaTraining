package by.javatr.finance.controller;

import by.javatr.finance.controller.command.Command;
import by.javatr.finance.controller.command.UserMessages;
import by.javatr.finance.logger.Logger;
import by.javatr.finance.view.View;

public class Controller {

    private final CommandProvider commandProvider = new CommandProvider();
    private static final Logger logger = Logger.getLogger(Controller.class);

    public CommandParameters execute(CommandParameters commandParameters) {
        String commandName = commandParameters.getParameter(CommandParameters.NEXT_COMMAND).toString();
        Command command = commandProvider.getCommand(commandName);

        try {
            commandParameters = command.execute(commandParameters);
        } catch (Exception e) {
            logger.error(e.getMessage());
            View.getInstance().showCaution(UserMessages.UNEXPECTED_ERROR_MESSAGE);
            commandParameters = new CommandParameters();
            commandParameters.setParameter(CommandParameters.NEXT_COMMAND, CommandName.SHOW_MAIN_MENU);
        }

        return commandParameters;
    }
}
