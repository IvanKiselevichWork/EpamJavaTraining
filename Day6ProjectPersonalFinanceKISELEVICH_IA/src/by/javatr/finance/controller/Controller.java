package by.javatr.finance.controller;

import by.javatr.finance.controller.command.Command;
import by.javatr.finance.controller.command.UserMessages;
import by.javatr.finance.logger.Logger;
import by.javatr.finance.view.View;

public class Controller {

    private final CommandProvider commandProvider = new CommandProvider();
    private final Logger logger = Logger.getLogger(this.getClass());
    private final View view = View.getInstance();

    public CommandParameters execute(CommandParameters commandParameters) {
        String commandName = commandParameters.getParameter(CommandParameters.NEXT_COMMAND).toString();
        Command command = commandProvider.getCommand(commandName);

        try {
            commandParameters = command.execute(commandParameters);
        } catch (Exception e) {
            logger.error(e.getMessage());
            view.showCaution(UserMessages.UNEXPECTED_ERROR_MESSAGE);
            commandParameters = new CommandParameters();
            commandParameters.setParameter(CommandParameters.NEXT_COMMAND, CommandName.SHOW_MAIN_MENU);
        }

        return commandParameters;
    }
}
