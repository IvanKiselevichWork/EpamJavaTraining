package by.javatr.finance.controller.command.usermenu;

import by.javatr.finance.controller.command.Command;
import by.javatr.finance.controller.command.UserMessages;
import by.javatr.finance.controller.exception.AbstractControllerException;
import by.javatr.finance.controller.exception.ControllerException;
import by.javatr.finance.controller.exception.ControllerExceptionMessages;
import by.javatr.finance.entity.Record;
import by.javatr.finance.entity.exception.RecordException;
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
    public void execute(CommandParameters commandParameters) throws AbstractControllerException {

        if (commandParameters == null || commandParameters.getParameter(CommandParameters.LOGIN_PARAMETER) == null) {
            throw new ControllerException(ControllerExceptionMessages.internalError);
        }

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
            record = new Record(commandParameters.getParameter(CommandParameters.LOGIN_PARAMETER),
                    cause,
                    date,
                    amount);
            recordService.addRecord(record);
        } catch (RecordException | RecordServiceException e) {
            throw new ControllerException(e);
        }

        view.showRecordAddedMessage(record);
    }
}
