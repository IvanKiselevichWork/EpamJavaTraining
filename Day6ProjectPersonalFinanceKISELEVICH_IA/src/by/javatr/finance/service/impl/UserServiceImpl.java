package by.javatr.finance.service.impl;

import by.javatr.finance.service.UserService;
import by.javatr.finance.service.exception.user.AccountNotFoundServiceException;
import by.javatr.finance.service.exception.user.LoginInUseServiceException;
import by.javatr.finance.service.exception.user.UserServiceException;
import by.javatr.finance.service.impl.validation.UserValidator;

public class UserServiceImpl implements UserService {

    private static final UserValidator userValidator = new UserValidator();

    @Override
    public void signIn(String login, String password) throws AccountNotFoundServiceException, UserServiceException {
        //todo
    }

    @Override
    public void signOut(String login) throws AccountNotFoundServiceException, UserServiceException {
        //todo
    }

    @Override
    public void registration(String login, String password) throws LoginInUseServiceException, UserServiceException {
        //todo
    }
}
