package main.java.by.javatr.finance.dao.fileImpl.validation;

import main.java.by.javatr.finance.bean.User;
import main.java.by.javatr.finance.dao.exception.user.*;
import main.java.by.javatr.finance.dao.fileImpl.FileUserDAO;

public class UserValidator {

    public UserValidator() {

    }

    public void checkUserForRegistration(User user) throws UserDAOException {
        check(user);
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
}
