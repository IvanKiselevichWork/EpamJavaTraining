package by.javatr.finance.dao.fileImpl;

import by.javatr.finance.bean.User;
import by.javatr.finance.dao.UserDAO;
import by.javatr.finance.dao.exception.user.*;
import by.javatr.finance.dao.fileImpl.validation.UserValidator;

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

    public FileUserDAO() {
    }

    /**
     * if did'n throw anything - signIn is OK
     * @param user User bean
     * @throws AccountNotFoundDAOException if account not found
     * @throws UserDAOException if other exception occurs
     */
    @Override
    public void signIn(User user) throws AccountNotFoundDAOException, UserDAOException {
        try {

            userValidator.checkUserForSignIn(user);

            File usersFile = new File(USERS_FILENAME);
            if (!usersFile.exists()) {
                throw new AccountNotFoundDAOException(UserDAOExceptionMessages.accountNotFound);
            }

            String login = user.getLogin();
            String password = user.getPassword();
            password = String.valueOf(password.hashCode());

            boolean isAccountFound = false;
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
                    isAccountFound = true;
                    break;
                }
            }
            if (!isAccountFound) {
                throw new AccountNotFoundDAOException(UserDAOExceptionMessages.accountNotFound);
            }
        } catch (IOException e) {
            throw new UserDAOException(UserDAOExceptionMessages.cantReadUser, e);
        }
    }

    /**
     * if did'n throw anything - registration is OK
     * @param user User bean
     * @throws LoginInUseDAOException if login in use
     * @throws UserDAOException if other exception occurs
     */
    @Override
    public void registration(User user) throws UserDAOException, LoginInUseDAOException {
        try {
            userValidator.checkUserForRegistration(user);
            String login = user.getLogin();
            String password = user.getPassword();
            password = String.valueOf(password.hashCode());
            Files.write(Paths.get(USERS_FILENAME), (login + DELIMITER + password + System.lineSeparator()).getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new UserDAOException(UserDAOExceptionMessages.cantWriteUser, e);
        }
    }


}
