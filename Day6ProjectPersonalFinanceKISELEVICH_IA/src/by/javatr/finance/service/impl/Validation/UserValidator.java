package by.javatr.finance.service.impl.validation;

import by.javatr.finance.service.exception.user.IncorrectLoginServiceException;
import by.javatr.finance.service.exception.user.IncorrectPasswordServiceException;
import by.javatr.finance.service.exception.user.UserServiceExceptionMessages;

public class UserValidator {
    public void check(String login, String password) throws IncorrectLoginServiceException, IncorrectPasswordServiceException {
        if (login == null) {
            throw new IncorrectLoginServiceException(UserServiceExceptionMessages.loginIsNull);
        }
        if (login.isEmpty()) {
            throw new IncorrectLoginServiceException(UserServiceExceptionMessages.loginIsEmpty);
        }
        if (password == null) {
            throw new IncorrectPasswordServiceException(UserServiceExceptionMessages.passwordIsNull);
        }
    }
}
