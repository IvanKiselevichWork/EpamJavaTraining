package by.javatr.finance.controller.command.mainmenu;

import by.javatr.finance.controller.UserMenuController;
import by.javatr.finance.controller.command.Command;
import by.javatr.finance.controller.command.UserMessages;
import by.javatr.finance.controller.exception.AbstractControllerException;
import by.javatr.finance.service.UserService;
import by.javatr.finance.service.exception.user.AccountNotFoundServiceException;
import by.javatr.finance.service.exception.user.UserServiceException;
import by.javatr.finance.service.factory.ServiceFactory;
import by.javatr.finance.view.View;

public class SignInCommand implements Command {

    private static final View view = View.getInstance();

    private static final UserService userService = ServiceFactory.getInstance().getUserService();

    @Override
    public void execute(CommandParameters commandParameters) throws AbstractControllerException {
        view.signInDataRequest();
        String login = view.getString(UserMessages.LOGIN_REQUEST_MESSAGE);
        String password = view.getString(UserMessages.PASSWORD_REQUEST_MESSAGE);

        try {
            userService.signIn(login, password);

            view.welcomeUser(login);

            if (commandParameters == null) {
                commandParameters = new CommandParameters();
            }
            commandParameters.setParameter(CommandParameters.LOGIN_PARAMETER, login);

            UserMenuController.getInstance().execute(UserMenuController.RUN_USER_MENU_COMMAND, commandParameters);
        } catch (AccountNotFoundServiceException e) {
            view.showAccountNotFoundMessage();
        } catch (UserServiceException e) {
            view.showErrorMessage(e.getMessage());
        }
    }
}
