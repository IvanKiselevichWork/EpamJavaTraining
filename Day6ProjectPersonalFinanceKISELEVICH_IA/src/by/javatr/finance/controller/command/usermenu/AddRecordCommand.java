package by.javatr.finance.controller.command.usermenu;

import by.javatr.finance.bean.User;
import by.javatr.finance.controller.CommandName;
import by.javatr.finance.controller.CommandParameters;
import by.javatr.finance.controller.command.Command;
import by.javatr.finance.controller.command.UserMessages;
import by.javatr.finance.controller.exception.AbstractControllerException;
import by.javatr.finance.controller.exception.ControllerException;
import by.javatr.finance.controller.exception.ControllerExceptionMessages;
import by.javatr.finance.bean.Record;
import by.javatr.finance.service.RecordService;
import by.javatr.finance.service.exception.record.RecordServiceException;
import by.javatr.finance.service.factory.ServiceFactory;
import by.javatr.finance.view.View;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

public class AddRecordCommand implements Command {

    private static final View view = View.getInstance();
    private static final RecordService recordService = ServiceFactory.getInstance().getRecordService();

    @Override
    public CommandParameters execute(CommandParameters commandParameters) throws AbstractControllerException {

        if (commandParameters == null || commandParameters.getParameter(CommandParameters.USER) == null) {
            throw new ControllerException(ControllerExceptionMessages.internalError);
        }
        String login = ((User)commandParameters.getParameter(CommandParameters.USER)).getLogin();

        String cause = view.getString(UserMessages.CAUSE_REQUEST_MESSAGE);

        LocalDateTime date;
        while (true) {
            try {
                date = LocalDateTime.parse(view.getString(UserMessages.DATE_REQUEST_MESSAGE));
                break;
            } catch (DateTimeParseException e) {
                view.showErrorMessage(UserMessages.INVALID_DATE_MESSAGE);
            }
        }

        double amount = 0;
        while (true) {
            try {
                amount = Double.parseDouble(view.getString(UserMessages.AMOUNT_REQUEST_MESSAGE));
                break;
            } catch (NumberFormatException e) {
                view.showErrorMessage(UserMessages.INVALID_AMOUNT_MESSAGE);
            }
        }
        Record record = null;
        try {
            record = new Record(-1,
                    login,
                    cause,
                    date,
                    amount);
            record = recordService.addRecord(record);
        } catch (RecordServiceException e) {
            throw new ControllerException(e);
        }

        view.showRecordAddedMessage(record);

        commandParameters.setParameter(CommandParameters.NEXT_COMMAND, CommandName.SHOW_USER_MENU);
        return commandParameters;
    }
}
