package by.javatr.finance.controller.command.usermenucontroller;

import by.javatr.finance.controller.command.Command;
import by.javatr.finance.controller.command.CommandParameters;
import by.javatr.finance.controller.exception.AbstractControllerException;
import by.javatr.finance.service.RecordService;
import by.javatr.finance.service.factory.ServiceFactory;
import by.javatr.finance.view.View;

public class AddRecordCommand implements Command {

    private static final View view = View.getInstance();
    protected static RecordService recordService = ServiceFactory.getInstance().getRecordService();

    @Override
    public void execute(CommandParameters commandParameters) throws AbstractControllerException {
        view.showErrorMessage("todo show input record dialog"); //todo show input record
        System.exit(-1);
    }
}
