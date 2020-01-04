package by.javatr.finance.controller.command;

import by.javatr.finance.service.UserService;
import by.javatr.finance.service.factory.ServiceFactory;
import by.javatr.finance.view.View;

public class AddRecordCommand implements Command {

    private static View view = View.getInstance();
    protected static UserService userService = ServiceFactory.getInstance().getUserService();

    @Override
    public void execute() {
        //todo
    }
}
