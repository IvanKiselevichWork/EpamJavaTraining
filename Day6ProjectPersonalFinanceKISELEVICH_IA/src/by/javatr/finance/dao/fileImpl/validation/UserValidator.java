package by.javatr.finance.dao.fileImpl.validation;

import by.javatr.finance.dao.exception.user.*;
import by.javatr.finance.dao.fileImpl.FileUserDAO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class UserValidator {

    public UserValidator() {

    }

    public void checkUserForRegistration(String login, String password) throws UserDAOException, LoginInUseDAOException {
        check(login, password);
        if (isLoginInUse(login)) {
            throw new LoginInUseDAOException(UserDAOExceptionMessages.loginInUse);
        }
    }

    public void checkUserForSignIn(String login, String password) throws UserDAOException {
        check(login, password);
    }

    private void check(String login, String password) throws UserDAOException {
        if (login == null) {
            throw new UserDAOException(UserDAOExceptionMessages.loginIsNull);
        }
        if (login.contains(FileUserDAO.DELIMITER)) {
            throw new UserDAOException(UserDAOExceptionMessages.loginIsInvalid);
        }
        if (password == null) {
            throw new UserDAOException(UserDAOExceptionMessages.passwordIsNull);
        }
    }

    private boolean isLoginInUse(String checkLogin) throws UserDAOException {
        try {
            List<String> users = Files.readAllLines(Paths.get(FileUserDAO.USERS_FILENAME));
            for (String user: users) {
                String login = user.split(FileUserDAO.DELIMITER)[FileUserDAO.LOGIN_INDEX];
                if (login.equals(checkLogin)) {
                    return true;
                }
            }
            return false;
        } catch (IOException e) {
            throw new UserDAOException(UserDAOExceptionMessages.cantReadUser, e);
        }
    }
}
