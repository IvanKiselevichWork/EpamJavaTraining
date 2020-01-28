package main.java.by.javatr.finance.dao;

import main.java.by.javatr.finance.bean.User;
import main.java.by.javatr.finance.dao.exception.user.UserDAOException;

public interface UserDAO {
    boolean signIn(User user) throws UserDAOException;
    boolean registration(User user) throws UserDAOException;
}
