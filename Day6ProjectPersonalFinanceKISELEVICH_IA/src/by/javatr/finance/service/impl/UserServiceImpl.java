package by.javatr.finance.service.impl;

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
     * @param login user login
     * @param password user password
     * @throws AccountNotFoundServiceException if account not found
     * @throws UserServiceException if other exception occurs
     */
    @Override
    public void signIn(String login, String password) throws AccountNotFoundServiceException, UserServiceException {
        try {
            userValidator.check(login, password);
            userDAO.signIn(login, password);
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
     * @param login user login
     * @param password user password
     * @throws LoginInUseServiceException if login in use
     * @throws UserServiceException if other exception occurs
     */
    @Override
    public void registration(String login, String password) throws LoginInUseServiceException, UserServiceException {
        try {
            userValidator.check(login, password);
            userDAO.registration(login, password);
        } catch (LoginInUseDAOException e) {
            throw new LoginInUseServiceException(e);
        } catch (UserDAOException e) {
            throw new UserServiceException(e);
        }
    }
}
