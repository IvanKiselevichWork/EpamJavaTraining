package by.javatr.finance.service;

import by.javatr.finance.service.exception.AbstractServiceException;

public interface UserService {
    void signIn(String login, String password) throws AbstractServiceException;
    void signOut(String login) throws AbstractServiceException;
    void registration(String login, String password) throws AbstractServiceException;
}
