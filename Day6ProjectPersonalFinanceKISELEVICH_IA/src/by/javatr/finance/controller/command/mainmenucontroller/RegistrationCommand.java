package by.javatr.finance.controller.command.mainmenucontroller;

import by.javatr.finance.controller.UserMenuController;
import by.javatr.finance.controller.command.Command;
import by.javatr.finance.controller.command.CommandParameters;
import by.javatr.finance.controller.command.UserMessages;
import by.javatr.finance.controller.exception.AbstractControllerException;
import by.javatr.finance.controller.exception.ControllerException;
import by.javatr.finance.service.UserService;
import by.javatr.finance.service.exception.user.LoginInUseServiceException;
import by.javatr.finance.service.exception.user.UserServiceException;
import by.javatr.finance.service.factory.ServiceFactory;
import by.javatr.finance.view.View;

public class RegistrationCommand implements Command {

    private static final View view = View.getInstance();

    private static final UserService userService = ServiceFactory.getInstance().getUserService();

    @Override
    public void execute(CommandParameters commandParameters) throws AbstractControllerException {
        view.registrationDataRequest();
        String login = view.getString(UserMessages.LOGIN_REQUEST_MESSAGE);
        String password = view.getString(UserMessages.PASSWORD_REQUEST_MESSAGE);

        try {
            userService.registration(login, password);

            view.welcomeUser(login);

            if (commandParameters == null) {
                commandParameters = new CommandParameters();
            }
            commandParameters.setParameter(CommandParameters.LOGIN_PARAMETER, login);

            UserMenuController.getInstance().execute(UserMenuController.RUN_USER_MENU_COMMAND, commandParameters);
        } catch (LoginInUseServiceException e) {
            view.showLoginInUseMessage();
        } catch (UserServiceException | ControllerException e) {
            view.showErrorMessage(e.getMessage());
        }
    }
}
