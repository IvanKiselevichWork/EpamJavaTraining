package by.javatr.finance.controller.command;

import by.javatr.finance.controller.Controller;
import by.javatr.finance.controller.UserMenuController;
import by.javatr.finance.controller.exception.ControllerException;
import by.javatr.finance.service.UserService;
import by.javatr.finance.service.exception.user.LoginInUseServiceException;
import by.javatr.finance.service.exception.user.UserServiceException;
import by.javatr.finance.service.factory.ServiceFactory;
import by.javatr.finance.view.View;

import java.util.Scanner;

import static by.javatr.finance.controller.command.MenuCommandsNames.RUN_USER_MENU_COMMAND;

public class RegistrationCommand implements Command {

    private static View view = View.getInstance();
    private UserMenuController controller;

    protected static UserService userService = ServiceFactory.getInstance().getUserService();

    public RegistrationCommand(UserMenuController controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        view.registrationLoginAndPasswordRequest();
        Scanner scanner = new Scanner(System.in);
        String login = scanner.nextLine();
        String password = scanner.nextLine();

        try {
            userService.registration(login, password);
            view.welcomeUser(login);
            //todo
            controller.execute(RUN_USER_MENU_COMMAND);
        } catch (LoginInUseServiceException e) {
            view.showLoginInUseMessage(e);
        } catch (UserServiceException | ControllerException e) {
            view.showErrorMessage(e.getMessage());
        }
    }
}
