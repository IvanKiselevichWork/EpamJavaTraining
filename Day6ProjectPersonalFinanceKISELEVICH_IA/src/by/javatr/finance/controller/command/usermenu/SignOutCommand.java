package by.javatr.finance.controller.command.usermenu;

import by.javatr.finance.bean.Record;
import by.javatr.finance.bean.User;
import by.javatr.finance.controller.CommandName;
import by.javatr.finance.controller.CommandParameters;
import by.javatr.finance.controller.command.Command;
import by.javatr.finance.controller.command.UserMessages;
import by.javatr.finance.controller.exception.AbstractControllerException;
import by.javatr.finance.controller.exception.ControllerException;
import by.javatr.finance.controller.exception.ControllerExceptionMessages;
import by.javatr.finance.service.RecordService;
import by.javatr.finance.service.exception.record.RecordServiceException;
import by.javatr.finance.service.factory.ServiceFactory;
import by.javatr.finance.view.View;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

public class SignOutCommand implements Command {

    private static final View view = View.getInstance();

    @Override
    public CommandParameters execute(CommandParameters commandParameters) throws AbstractControllerException {
        String login = ((User)commandParameters.getParameter(CommandParameters.USER)).getLogin();
        view.showGoodbye(login);
        commandParameters.setParameter(CommandParameters.USER, null);
        commandParameters.setParameter(CommandParameters.NEXT_COMMAND, CommandName.SHOW_MAIN_MENU);
        return commandParameters;
    }
}
