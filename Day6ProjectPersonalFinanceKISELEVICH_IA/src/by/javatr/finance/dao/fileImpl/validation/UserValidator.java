package by.javatr.finance.dao.fileImpl.validation;

import by.javatr.finance.dao.exception.user.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static by.javatr.finance.dao.fileImpl.FileUserDAO.*;

public class UserValidator {

    public UserValidator() {

    }

    public void checkUserForRegistration(String login, String password) throws ReadUserDAOException, UserLoginInUseException, WrongUserLoginException, WrongUserPasswordException {
        check(login, password);
        if (isLoginInUse(login)) {
            throw new UserLoginInUseException(UserExceptionMessages.loginInUse);
        }
    }

    public void checkUserForSignIn(String login, String password) throws WrongUserPasswordException, WrongUserLoginException {
        check(login, password);
    }

    private void check(String login, String password) throws WrongUserPasswordException, WrongUserLoginException {
        if (login == null) {
            throw new WrongUserLoginException(UserExceptionMessages.loginIsNull);
        }
        if (password == null) {
            throw new WrongUserPasswordException(UserExceptionMessages.passwordIsNull);
        }
    }

    private boolean isLoginInUse(String checkLogin) throws ReadUserDAOException {
        try {
            List<String> users = Files.readAllLines(Paths.get(USERS_FILENAME));
            for (String user: users) {
                String login = user.split(DELIMITER)[LOGIN_INDEX];
                if (login.equals(checkLogin)) {
                    return true;
                }
            }
            return false;
        } catch (IOException e) {
            throw new ReadUserDAOException(UserExceptionMessages.cantReadUser, e);
        }
    }
}
