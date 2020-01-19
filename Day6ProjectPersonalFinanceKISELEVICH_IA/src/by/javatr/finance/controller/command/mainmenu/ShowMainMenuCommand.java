package by.javatr.finance.controller.command.mainmenu;

import by.javatr.finance.controller.CommandName;
import by.javatr.finance.controller.CommandParameters;
import by.javatr.finance.controller.command.Command;
import by.javatr.finance.view.View;

public class ShowMainMenuCommand implements Command {

    private final View view = View.getInstance();

    @Override
    public CommandParameters execute(CommandParameters commandParameters) {
        view.showMainMenu();
        int commandIndex = Integer.parseInt(view.getCommand("Input command:", new String[]{"0", "1", "2"}));
        CommandName[] commandNames = {CommandName.EXIT, CommandName.SIGN_IN, CommandName.REGISTRATION};

        commandParameters.setParameter(CommandParameters.NEXT_COMMAND, commandNames[commandIndex]);

        return commandParameters;
    }
}
