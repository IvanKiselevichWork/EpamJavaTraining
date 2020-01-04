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

    private static final UserValidator userValidator = new UserValidator();

    private final UserDAO userDAO = DAOFactory.getInstance().getUserDAO();

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
