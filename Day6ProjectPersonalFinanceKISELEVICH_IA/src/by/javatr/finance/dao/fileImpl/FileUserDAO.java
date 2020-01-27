package by.javatr.finance.dao.fileImpl;

import by.javatr.finance.bean.User;
import by.javatr.finance.dao.UserDAO;
import by.javatr.finance.dao.exception.user.*;
import by.javatr.finance.dao.fileImpl.validation.UserValidator;
import by.javatr.finance.logger.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileUserDAO implements UserDAO {

    public final static String USERS_FILENAME = "users.txt";
    public final static String DELIMITER = ";";
    public final static int LOGIN_INDEX = 0;
    public final static int PASSWORD_INDEX = 1;

    private final UserValidator userValidator = new UserValidator();
    private final Logger logger = Logger.getLogger(this);

    public FileUserDAO() {
    }

    /**
     * if did'n throw anything - signIn is OK
     * @param user User bean
     * @return boolean true - if signIn successful, false - if not (incorrect credentials)
     * @throws UserDAOException if other exception occurs
     */
    @Override
    public boolean signIn(User user) throws UserDAOException {
        try {

            userValidator.checkUserForSignIn(user);

            File usersFile = new File(USERS_FILENAME);
            if (!usersFile.exists()) {
                logger.warning("No users file");
                return false;
            }

            String login = user.getLogin();
            String password = user.getPassword();
            password = String.valueOf(password.hashCode());

            List<String> users = Files.readAllLines(Paths.get(USERS_FILENAME));
            for (String userStr: users) {
                String[] loginPasswordArray = userStr.split(DELIMITER);
                if (loginPasswordArray.length < 2) {
                    throw new UserDAOException(UserDAOExceptionMessages.dataCorrupted);
                }
                String login1 = loginPasswordArray[LOGIN_INDEX];
                String password1 = loginPasswordArray[PASSWORD_INDEX];

                if(login1 == null || password1 == null) {
                    throw new UserDAOException(UserDAOExceptionMessages.dataCorrupted);
                }

                if (login1.equals(login) && password1.equals(password)) {
                    return true;
                }
            }
            return false;
        } catch (IOException e) {
            throw new UserDAOException(UserDAOExceptionMessages.cantReadUser, e);
        }
    }

    /**
     * if did'n throw anything - registration is OK
     * @param user User bean
     * @return boolean true - if registration successful, false - if not (login in use, e.t.)
     * @throws UserDAOException if other exception occurs
     */
    @Override
    public boolean registration(User user) throws UserDAOException {
        try {
            userValidator.checkUserForRegistration(user);
            if (isLoginInUse(user.getLogin())) {
                return false;
            }
            String login = user.getLogin();
            String password = user.getPassword();
            password = String.valueOf(password.hashCode());
            Files.write(Paths.get(USERS_FILENAME), (login + DELIMITER + password + System.lineSeparator()).getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            return true;
        } catch (IOException e) {
            throw new UserDAOException(UserDAOExceptionMessages.cantWriteUser, e);
        }
    }

    private boolean isLoginInUse(String checkLogin) throws UserDAOException {
        try {
            File source = new File(FileUserDAO.USERS_FILENAME);
            if (!source.exists()) {
                return false;
            }
            List<String> users = Files.readAllLines(Paths.get(FileUserDAO.USERS_FILENAME));
            for (String user: users) {
                String login = user.split(FileUserDAO.DELIMITER)[FileUserDAO.LOGIN_INDEX];
                if (login.equals(checkLogin)) {
                    return true;
                }
            }
            return false;
        } catch (IOException e) {
            throw new UserDAOException(UserDAOExceptionMessages.cantReadUser, e);
        }
    }


}
