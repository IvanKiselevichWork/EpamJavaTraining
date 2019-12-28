package by.javatr.finance.service.impl;

import by.javatr.finance.service.UserService;
import by.javatr.finance.service.exception.AbstractServiceException;
import by.javatr.finance.service.impl.Validation.UserValidator;

public class UserServiceImpl implements UserService {

    private static final UserValidator userValidator = new UserValidator();

    @Override
    public void signIn(String login, String password) throws AbstractServiceException {
        //todo
    }

    @Override
    public void signOut(String login) throws AbstractServiceException {
        //todo
    }

    @Override
    public void registration(String login, String password) throws AbstractServiceException {
        //todo
    }
}
