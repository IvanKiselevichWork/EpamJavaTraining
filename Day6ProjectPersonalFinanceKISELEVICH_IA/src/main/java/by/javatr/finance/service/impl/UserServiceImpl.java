package main.java.by.javatr.finance.service.impl;

import main.java.by.javatr.finance.bean.User;
import main.java.by.javatr.finance.dao.UserDAO;
import main.java.by.javatr.finance.dao.exception.user.UserDAOException;
import main.java.by.javatr.finance.dao.factory.DAOFactory;
import main.java.by.javatr.finance.service.UserService;
import main.java.by.javatr.finance.service.exception.user.UserServiceException;
import main.java.by.javatr.finance.service.impl.validation.UserValidator;

public class UserServiceImpl implements UserService {

    private final UserValidator userValidator = new UserValidator();

    private final UserDAO userDAO = DAOFactory.getInstance().getUserDAO();

    /**
     * if did'n throw anything - signIn is OK
     * @param user User
     * @return boolean true - if signIn successful, false - if not (incorrect credentials)
     * @throws UserServiceException if other exception occurs
     */
    @Override
    public boolean signIn(User user) throws UserServiceException {
        try {
            userValidator.check(user);
            return userDAO.signIn(user);
        } catch (UserDAOException e) {
            throw new UserServiceException(e);
        }
    }

    /*
    @Override
    public void signOut(String login) throws AccountNotFoundServiceException, UserServiceException {
        //todo
    }
     */

    /**
     * if did'n throw anything - registration is OK
     * @param user User
     * @return boolean true - if registration successful, false - if not (login in use, e.t.)
     * @throws UserServiceException if other exception occurs
     */
    @Override
    public boolean registration(User user) throws UserServiceException {
        try {
            userValidator.check(user);
            return userDAO.registration(user);
        } catch (UserDAOException e) {
            throw new UserServiceException(e);
        }
    }
}
