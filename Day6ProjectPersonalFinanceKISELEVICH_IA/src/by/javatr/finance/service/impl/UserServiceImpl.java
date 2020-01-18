package by.javatr.finance.service.impl;

import by.javatr.finance.bean.User;
import by.javatr.finance.dao.UserDAO;
import by.javatr.finance.dao.exception.user.AccountNotFoundDAOException;
import by.javatr.finance.dao.exception.user.UserDAOException;
import by.javatr.finance.dao.exception.user.LoginInUseDAOException;
import by.javatr.finance.dao.factory.DAOFactory;
import by.javatr.finance.service.UserService;
import by.javatr.finance.service.exception.user.AccountNotFoundServiceException;
import by.javatr.finance.service.exception.user.LoginInUseServiceException;
import by.javatr.finance.service.exception.user.UserServiceException;
import by.javatr.finance.service.impl.validation.UserValidator;

public class UserServiceImpl implements UserService {

    private final static UserValidator userValidator = new UserValidator();

    private final static UserDAO userDAO = DAOFactory.getInstance().getUserDAO();

    /**
     * if did'n throw anything - signIn is OK
     * @param user User
     * @throws AccountNotFoundServiceException if account not found
     * @throws UserServiceException if other exception occurs
     */
    @Override
    public void signIn(User user) throws AccountNotFoundServiceException, UserServiceException {
        try {
            userValidator.check(user);
            userDAO.signIn(user);
        } catch (AccountNotFoundDAOException e) {
            throw new AccountNotFoundServiceException(e);
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
     * @throws LoginInUseServiceException if login in use
     * @throws UserServiceException if other exception occurs
     */
    @Override
    public void registration(User user) throws LoginInUseServiceException, UserServiceException {
        try {
            userValidator.check(user);
            userDAO.registration(user);
        } catch (LoginInUseDAOException e) {
            throw new LoginInUseServiceException(e);
        } catch (UserDAOException e) {
            throw new UserServiceException(e);
        }
    }
}
