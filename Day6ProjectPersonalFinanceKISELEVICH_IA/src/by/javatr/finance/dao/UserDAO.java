package by.javatr.finance.dao;

import by.javatr.finance.dao.exception.user.AccountNotFoundDAOException;
import by.javatr.finance.dao.exception.user.UserDAOException;
import by.javatr.finance.dao.exception.user.LoginInUseDAOException;

public interface UserDAO {
    void signIn(String login, String password) throws AccountNotFoundDAOException, UserDAOException;
    void registration(String login, String password) throws LoginInUseDAOException, UserDAOException;
}
