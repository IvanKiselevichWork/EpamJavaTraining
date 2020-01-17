package by.javatr.finance.controller.command.general;

import by.javatr.finance.controller.command.Command;
import by.javatr.finance.controller.command.UserMessages;
import by.javatr.finance.view.View;

public class WrongRequestCommand implements Command {

    private static final View view = View.getInstance();

    @Override
    public String execute(String request) {
        return UserMessages.WRONG_REQUEST;
    }
}
