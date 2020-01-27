package by.javatr.finance.controller.command.usermenu;

import by.javatr.finance.bean.User;
import by.javatr.finance.controller.CommandName;
import by.javatr.finance.controller.CommandParameters;
import by.javatr.finance.controller.command.Command;
import by.javatr.finance.view.View;

public class SignOutCommand implements Command {

    private final View view = View.getInstance();

    @Override
    public CommandParameters execute(CommandParameters commandParameters) {
        String login = ((User)commandParameters.getParameter(CommandParameters.USER)).getLogin();
        view.showGoodbye(login);
        commandParameters.setParameter(CommandParameters.USER, null);
        commandParameters.setParameter(CommandParameters.NEXT_COMMAND, CommandName.SHOW_MAIN_MENU);
        return commandParameters;
    }
}
