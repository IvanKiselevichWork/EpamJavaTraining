package by.javatr.finance.service;

import by.javatr.finance.bean.User;
import by.javatr.finance.service.exception.user.AccountNotFoundServiceException;
import by.javatr.finance.service.exception.user.LoginInUseServiceException;
import by.javatr.finance.service.exception.user.UserServiceException;

public interface UserService {
    void signIn(User user) throws AccountNotFoundServiceException, UserServiceException;
    //void signOut(String login) throws AccountNotFoundServiceException, UserServiceException; // todo
    void registration(User user) throws LoginInUseServiceException, UserServiceException;
}
