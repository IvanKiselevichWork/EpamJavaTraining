package by.javatr.finance.dao;

import by.javatr.finance.dao.exception.DAOException;

public interface UserDAO {
    void signIn(String login, String password) throws DAOException;
    void registration(String login, String password) throws DAOException;
}
