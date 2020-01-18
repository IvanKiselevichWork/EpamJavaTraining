package by.javatr.finance.dao;

import by.javatr.finance.bean.User;
import by.javatr.finance.dao.exception.user.AccountNotFoundDAOException;
import by.javatr.finance.dao.exception.user.UserDAOException;
import by.javatr.finance.dao.exception.user.LoginInUseDAOException;

public interface UserDAO {
    void signIn(User user) throws AccountNotFoundDAOException, UserDAOException;
    void registration(User user) throws LoginInUseDAOException, UserDAOException;
}
