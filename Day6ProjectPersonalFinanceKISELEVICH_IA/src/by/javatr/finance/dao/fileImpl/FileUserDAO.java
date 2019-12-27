package by.javatr.finance.dao.fileImpl;

import by.javatr.finance.dao.UserDAO;
import by.javatr.finance.dao.exception.user.*;
import by.javatr.finance.dao.fileImpl.validation.UserValidator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileUserDAO implements UserDAO {

    public final static String USERS_FILENAME = "users.txt";
    public final static String DELIMITER = ";";
    public final static int LOGIN_INDEX = 0;
    public final static int PASSWORD_INDEX = 1;

    private final static String EMPTY_STRING = "";

    private UserValidator userValidator;

    public FileUserDAO() throws WriteUserDAOException {
        try {
            Files.write(Paths.get(USERS_FILENAME), EMPTY_STRING.getBytes());
            userValidator = new UserValidator();
        } catch (IOException e) {
            throw new WriteUserDAOException(UserExceptionMessages.cantWriteUser, e);
        }
    }

    /**
     * if did'n throw anything - signIn is OK
     * @param login user login
     * @param password user password
     * @throws AccountNotFoundException if account not found
     * @throws ReadUserDAOException if cant read user
     * @throws WrongUserLoginException if user login incorrect (etc null)
     * @throws WrongUserPasswordException if user password incorrect (etc null)
     */
    @Override
    public void signIn(String login, String password) throws AccountNotFoundException, ReadUserDAOException, WrongUserPasswordException, WrongUserLoginException  {
        try {
            userValidator.checkUserForSignIn(login, password);

            boolean isAccountFound = false;
            List<String> users = Files.readAllLines(Paths.get(USERS_FILENAME));
            for (String user: users) {
                String[] loginPasswordArray = user.split(DELIMITER);
                String login1 = loginPasswordArray[LOGIN_INDEX];
                String password1 = loginPasswordArray[PASSWORD_INDEX];
                if (login1.equals(login) && password1.equals(password)) {
                    isAccountFound = true;
                    break;
                }
            }
            if (!isAccountFound) {
                throw new AccountNotFoundException(UserExceptionMessages.accountNotFound);
            }
        } catch (IOException e) {
            throw new ReadUserDAOException(UserExceptionMessages.cantWriteUser, e);
        }
    }

    /**
     * if did'n throw anything - registration is OK
     * @param login user login
     * @param password user password
     * @throws ReadUserDAOException if cant read user
     * @throws UserLoginInUseException if cant read user
     * @throws WriteUserDAOException if user password incorrect (etc null)
     * @throws WrongUserLoginException if user login incorrect (etc null)
     * @throws WrongUserPasswordException if user password incorrect (etc null)
     */
    @Override
    public void registration(String login, String password) throws ReadUserDAOException, UserLoginInUseException, WriteUserDAOException, WrongUserLoginException, WrongUserPasswordException {
        try {
            userValidator.checkUserForRegistration(login, password);

            Files.write(Paths.get(USERS_FILENAME), (login + DELIMITER + password).getBytes() );
        } catch (IOException e) {
            throw new WriteUserDAOException(UserExceptionMessages.cantWriteUser, e);
        }
    }


}
