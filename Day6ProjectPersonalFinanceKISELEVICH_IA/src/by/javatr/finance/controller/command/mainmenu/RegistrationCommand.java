package by.javatr.finance.controller.command.mainmenu;

import by.javatr.finance.bean.User;
import by.javatr.finance.controller.CommandName;
import by.javatr.finance.controller.CommandParameters;
import by.javatr.finance.controller.command.Command;
import by.javatr.finance.controller.command.UserMessages;
import by.javatr.finance.logger.Logger;
import by.javatr.finance.service.UserService;
import by.javatr.finance.service.exception.user.LoginInUseServiceException;
import by.javatr.finance.service.exception.user.UserServiceException;
import by.javatr.finance.service.factory.ServiceFactory;
import by.javatr.finance.view.View;

public class RegistrationCommand implements Command {

    private static final View view = View.getInstance();
    private static final UserService userService = ServiceFactory.getInstance().getUserService();
    private static final Logger logger = Logger.getLogger(RegistrationCommand.class);

    @Override
    public CommandParameters execute(CommandParameters commandParameters) {
        view.registrationDataRequest();
        String login = view.getString(UserMessages.LOGIN_REQUEST_MESSAGE);
        String password = view.getString(UserMessages.PASSWORD_REQUEST_MESSAGE);

        try {
            User user = new User(login, password);
            userService.registration(user);

            view.welcomeUser(login);

            if (commandParameters == null) {
                commandParameters = new CommandParameters();
            }
            commandParameters.setParameter(CommandParameters.USER, user);
            commandParameters.setParameter(CommandParameters.NEXT_COMMAND, CommandName.SHOW_USER_MENU);

        } catch (LoginInUseServiceException e) {
            view.showLoginInUseMessage();
            commandParameters.setParameter(CommandParameters.NEXT_COMMAND, CommandName.SHOW_MAIN_MENU);
        } catch (UserServiceException e) {
            logger.error(e.getMessage());
            view.showErrorMessage(UserMessages.UNEXPECTED_ERROR_MESSAGE);
            commandParameters.setParameter(CommandParameters.NEXT_COMMAND, CommandName.SHOW_MAIN_MENU);
        }
        return commandParameters;
    }
}
