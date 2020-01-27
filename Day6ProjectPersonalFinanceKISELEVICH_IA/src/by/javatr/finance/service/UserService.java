package by.javatr.finance.service;

import by.javatr.finance.bean.User;
import by.javatr.finance.service.exception.user.UserServiceException;

public interface UserService {
    boolean signIn(User user) throws UserServiceException;
    //void signOut(String login) throws AccountNotFoundServiceException, UserServiceException; // todo
    boolean registration(User user) throws UserServiceException;
}
