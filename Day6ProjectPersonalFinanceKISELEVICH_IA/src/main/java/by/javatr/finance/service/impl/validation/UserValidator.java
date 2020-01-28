package by.javatr.finance.service.impl.validation;


import by.javatr.finance.bean.User;
import by.javatr.finance.service.exception.user.UserServiceException;
import by.javatr.finance.service.exception.user.UserServiceExceptionMessages;

public class UserValidator {
    public void check(User user) throws UserServiceException {
        if (user == null) {
            throw new UserServiceException(UserServiceExceptionMessages.userIsNull);
        }
        String login = user.getLogin();
        String password = user.getPassword();
        if (login == null) {
            throw new UserServiceException(UserServiceExceptionMessages.loginIsNull);
        }
        if (login.isEmpty()) {
            throw new UserServiceException(UserServiceExceptionMessages.loginIsEmpty);
        }
        if (password == null) {
            throw new UserServiceException(UserServiceExceptionMessages.passwordIsNull);
        }
    }
}
