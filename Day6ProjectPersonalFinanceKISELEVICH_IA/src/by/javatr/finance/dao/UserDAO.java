package by.javatr.finance.dao;

import by.javatr.finance.dao.exception.AbstractDAOException;

public interface UserDAO {
    void signIn(String login, String password) throws AbstractDAOException;
    void registration(String login, String password) throws AbstractDAOException;
}
