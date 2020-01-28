package main.java.by.javatr.finance.controller.command.mainmenu;

import main.java.by.javatr.finance.bean.User;
import main.java.by.javatr.finance.controller.CommandName;
import main.java.by.javatr.finance.controller.CommandParameters;
import main.java.by.javatr.finance.controller.command.Command;
import main.java.by.javatr.finance.controller.command.UserMessages;
import main.java.by.javatr.finance.logger.Logger;
import main.java.by.javatr.finance.service.UserService;
import main.java.by.javatr.finance.service.exception.user.UserServiceException;
import main.java.by.javatr.finance.service.factory.ServiceFactory;
import main.java.by.javatr.finance.view.View;

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
