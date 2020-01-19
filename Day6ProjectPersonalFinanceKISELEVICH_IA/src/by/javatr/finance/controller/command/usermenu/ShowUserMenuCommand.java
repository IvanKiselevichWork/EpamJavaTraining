package by.javatr.finance.controller.command.usermenu;

import by.javatr.finance.controller.CommandName;
import by.javatr.finance.controller.CommandParameters;
import by.javatr.finance.controller.command.Command;
import by.javatr.finance.view.View;

public class ShowUserMenuCommand implements Command {

    private final View view = View.getInstance();

    @Override
    public CommandParameters execute(CommandParameters commandParameters) {
        view.showUserMenu();
        int commandIndex = Integer.parseInt(view.getCommand("Input command:", new String[]{"0", "1", "2", "3", "4"}));
        CommandName[] commandNames = {CommandName.EXIT, CommandName.SHOW_ALL_RECORDS, CommandName.ADD_RECORD, CommandName.REMOVE_RECORD, CommandName.SIGN_OUT};

        commandParameters.setParameter(CommandParameters.NEXT_COMMAND, commandNames[commandIndex]);

        return commandParameters;
    }
}
