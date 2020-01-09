package by.javatr.finance.controller.command.usermenucontroller;

import by.javatr.finance.controller.command.Command;
import by.javatr.finance.controller.command.CommandParameters;
import by.javatr.finance.controller.command.UserMessages;
import by.javatr.finance.controller.exception.AbstractControllerException;
import by.javatr.finance.controller.exception.ControllerException;
import by.javatr.finance.controller.exception.ControllerExceptionMessages;
import by.javatr.finance.entity.Record;
import by.javatr.finance.service.RecordService;
import by.javatr.finance.service.exception.record.RecordServiceException;
import by.javatr.finance.service.factory.ServiceFactory;
import by.javatr.finance.view.View;

import java.util.List;

public class RemoveRecordCommand implements Command {

    private static final View view = View.getInstance();
    private static final RecordService recordService = ServiceFactory.getInstance().getRecordService();

    @Override
    public void execute(CommandParameters commandParameters) throws AbstractControllerException {
        try {
            if (commandParameters == null) {
                throw new ControllerException(ControllerExceptionMessages.internalError);
            }
            List<Record> recordList  = recordService.getAllRecordsByLogin(commandParameters.getParameter(CommandParameters.LOGIN_PARAMETER));
            view.showRecordList(recordList);

            String[] recordIndexes = new String[recordList.size()];
            for (int i = 0; i < recordList.size(); i++) {
                recordIndexes[i] = String.valueOf(i + 1);
            }

            String recordIndexStr = view.getCommand(UserMessages.RECORD_INDEX_REQUEST, recordIndexes);
            int recordIndex = Integer.parseInt(recordIndexStr) - 1;
            recordService.removeRecord(recordList.get(recordIndex));
            view.showRecordRemovedMessage();
        } catch (RecordServiceException e) {
            view.showErrorMessage(e.getMessage());
        }
    }
}
