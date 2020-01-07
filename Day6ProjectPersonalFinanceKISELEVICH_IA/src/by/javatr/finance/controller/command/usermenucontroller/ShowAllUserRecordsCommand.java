package by.javatr.finance.controller.command.usermenucontroller;

import by.javatr.finance.controller.UserMenuController;
import by.javatr.finance.controller.command.Command;
import by.javatr.finance.controller.command.CommandParameters;
import by.javatr.finance.controller.exception.AbstractControllerException;
import by.javatr.finance.controller.exception.ControllerException;
import by.javatr.finance.controller.exception.ControllerExceptionMessages;
import by.javatr.finance.service.RecordService;
import by.javatr.finance.service.exception.record.RecordServiceException;
import by.javatr.finance.service.factory.ServiceFactory;
import by.javatr.finance.view.View;

public class ShowAllUserRecordsCommand implements Command {

    private static final View view = View.getInstance();
    protected static final RecordService recordService = ServiceFactory.getInstance().getRecordService();

    @Override
    public void execute(CommandParameters commandParameters) throws AbstractControllerException {
        try {
            if (commandParameters == null) {
                throw new ControllerException(ControllerExceptionMessages.internalError);
            }

            view.showRecordList(recordService.getAllRecordsByLogin(commandParameters.getParameter(CommandParameters.LOGIN_PARAMETER)));

            UserMenuController.getInstance().execute(UserMenuController.RUN_USER_MENU_COMMAND, commandParameters);
        } catch (RecordServiceException e) {
            view.showErrorMessage(e.getMessage());
        }
    }
}
