package by.javatr.finance.dao.fileImpl.validation;

import by.javatr.finance.bean.User;
import by.javatr.finance.dao.exception.user.*;
import by.javatr.finance.dao.fileImpl.FileUserDAO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class UserValidator {

    public UserValidator() {

    }

    public void checkUserForRegistration(User user) throws UserDAOException, LoginInUseDAOException {
        check(user);
        if (isLoginInUse(user.getLogin())) {
            throw new LoginInUseDAOException(UserDAOExceptionMessages.loginInUse);
        }
    }

    public void checkUserForSignIn(User user) throws UserDAOException {
        check(user);
    }

    private void check(User user) throws UserDAOException {
        if (user == null) {
            throw new UserDAOException(UserDAOExceptionMessages.userIsNull);
        }
        String login = user.getLogin();
        String password = user.getPassword();
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
            File source = new File(FileUserDAO.USERS_FILENAME);
            if (!source.exists()) {
                return false;
            }
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
