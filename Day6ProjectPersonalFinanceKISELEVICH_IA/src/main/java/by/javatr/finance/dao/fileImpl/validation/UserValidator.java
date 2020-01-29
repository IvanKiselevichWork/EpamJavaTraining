package by.javatr.finance.dao.fileImpl.validation;

import by.javatr.finance.bean.User;
import by.javatr.finance.dao.exception.user.*;
import by.javatr.finance.dao.fileImpl.FileUserDAO;

public class UserValidator {

    public UserValidator() {

    }

    public void check(User user) throws UserDAOException {
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
