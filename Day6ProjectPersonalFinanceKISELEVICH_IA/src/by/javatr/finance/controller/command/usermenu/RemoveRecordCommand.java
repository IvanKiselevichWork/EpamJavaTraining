package by.javatr.finance.controller.command.usermenu;

import by.javatr.finance.bean.User;
import by.javatr.finance.controller.CommandName;
import by.javatr.finance.controller.CommandParameters;
import by.javatr.finance.controller.command.Command;
import by.javatr.finance.controller.command.UserMessages;
import by.javatr.finance.controller.command.mainmenu.SignInCommand;
import by.javatr.finance.controller.exception.AbstractControllerException;
import by.javatr.finance.controller.exception.ControllerException;
import by.javatr.finance.controller.exception.ControllerExceptionMessages;
import by.javatr.finance.bean.Record;
import by.javatr.finance.logger.Logger;
import by.javatr.finance.service.RecordService;
import by.javatr.finance.service.exception.record.RecordServiceException;
import by.javatr.finance.service.factory.ServiceFactory;
import by.javatr.finance.view.View;

import java.util.List;

public class RemoveRecordCommand implements Command {

    private static final View view = View.getInstance();
    private static final RecordService recordService = ServiceFactory.getInstance().getRecordService();
    private final Logger logger = Logger.getLogger(this);

    @Override
    public CommandParameters execute(CommandParameters commandParameters) throws AbstractControllerException {
        try {
            if (commandParameters == null) {
                throw new ControllerException(ControllerExceptionMessages.internalError);
            }

            String login = ((User)commandParameters.getParameter(CommandParameters.USER)).getLogin();

            List<Record> recordList  = recordService.getAllRecordsByLogin(login);
            view.showRecordList(recordList);

            String[] recordIds = new String[recordList.size()];
            for (int i = 0; i < recordList.size(); i++) {
                recordIds[i] = String.valueOf(recordList.get(i).getId());
            }

            String recordIdStr = view.getCommand(UserMessages.RECORD_INDEX_REQUEST, recordIds);
            int recordIndex = Integer.parseInt(recordIdStr);
            recordService.removeRecord(recordIndex);
            view.showRecordRemovedMessage();
        } catch (RecordServiceException e) {
            logger.error(e.getMessage());
            view.showErrorMessage(UserMessages.UNEXPECTED_ERROR_MESSAGE);
        }
        commandParameters.setParameter(CommandParameters.NEXT_COMMAND, CommandName.SHOW_USER_MENU);
        return commandParameters;
    }
}
