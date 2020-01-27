package by.javatr.finance.controller.command.mainmenu;

import by.javatr.finance.bean.User;
import by.javatr.finance.controller.CommandName;
import by.javatr.finance.controller.CommandParameters;
import by.javatr.finance.controller.command.Command;
import by.javatr.finance.controller.command.UserMessages;
import by.javatr.finance.logger.Logger;
import by.javatr.finance.service.UserService;
import by.javatr.finance.service.exception.user.UserServiceException;
import by.javatr.finance.service.factory.ServiceFactory;
import by.javatr.finance.view.View;

public class SignInCommand implements Command {

    private final View view = View.getInstance();
    private final UserService userService = ServiceFactory.getInstance().getUserService();
    private final Logger logger = Logger.getLogger(this.getClass());

    @Override
    public CommandParameters execute(CommandParameters commandParameters) {
        view.signInDataRequest();
        String login = view.getString(UserMessages.LOGIN_REQUEST_MESSAGE);
        String password = view.getString(UserMessages.PASSWORD_REQUEST_MESSAGE);

        if (commandParameters == null) {
            commandParameters = new CommandParameters();
        }

        try {
            User user = new User(login, password);
            if(userService.signIn(user)) {
                view.welcomeUser(login);

                commandParameters.setParameter(CommandParameters.USER, user);
                commandParameters.setParameter(CommandParameters.NEXT_COMMAND, CommandName.SHOW_USER_MENU);
            } else {
                view.showAccountNotFoundMessage();
                commandParameters.setParameter(CommandParameters.NEXT_COMMAND, CommandName.SHOW_MAIN_MENU);
            }

        } catch (UserServiceException e) {
            logger.error(e.getMessage());
            view.showErrorMessage(UserMessages.UNEXPECTED_ERROR_MESSAGE);
            commandParameters.setParameter(CommandParameters.NEXT_COMMAND, CommandName.SHOW_MAIN_MENU);
        }
        return commandParameters;
    }
}
