package main.java.by.javatr.finance.service;

import main.java.by.javatr.finance.bean.User;
import main.java.by.javatr.finance.service.exception.user.UserServiceException;

public interface UserService {
    boolean signIn(User user) throws UserServiceException;
    //void signOut(String login) throws AccountNotFoundServiceException, UserServiceException; // todo
    boolean registration(User user) throws UserServiceException;
}
