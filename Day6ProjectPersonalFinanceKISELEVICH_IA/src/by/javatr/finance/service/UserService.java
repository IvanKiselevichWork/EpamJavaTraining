package by.javatr.finance.service;

import by.javatr.finance.service.exception.user.AccountNotFoundServiceException;
import by.javatr.finance.service.exception.user.LoginInUseServiceException;
import by.javatr.finance.service.exception.user.UserServiceException;

public interface UserService {
    void signIn(String login, String password) throws AccountNotFoundServiceException, UserServiceException;
    void signOut(String login) throws AccountNotFoundServiceException, UserServiceException;
    void registration(String login, String password) throws LoginInUseServiceException, UserServiceException;
}
