package by.javatr.finance.dao.impl;

import by.javatr.finance.dao.UserDAO;
import by.javatr.finance.dao.exception.DAOException;
import by.javatr.finance.dao.exception.user.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileUserDAO implements UserDAO {

    private final static String USERS_FILENAME = "users.txt";
    private final static String DELIMITER = ";";
    private final static String EMPTY_STRING = "";

    public FileUserDAO() throws DAOException {
        try {
            Files.write(Paths.get(USERS_FILENAME), EMPTY_STRING.getBytes());
        } catch (IOException e) {
            throw new WriteUserDAOException(UserExceptionMessages.cantWriteUser, e);
        }
    }

    @Override
    public void signIn(String login, String password) throws DAOException {
        return false;
    }

    @Override
    public void registration(String login, String password) throws DAOException {
        if (login == null) {
            throw new WrongUserLoginException(UserExceptionMessages.loginIsNull);
        }
        if (password == null) {
            throw new WrongUserPasswordException(UserExceptionMessages.passwordIsNull);
        }
        if (isLoginInUse(login)) {
            throw new UserLoginInUseException(UserExceptionMessages.loginInUse);
        }
        try {
            Files.write(Paths.get(USERS_FILENAME), (login + DELIMITER + password).getBytes() );
        } catch (IOException e) {
            throw new WriteUserDAOException(UserExceptionMessages.cantWriteUser, e);
        }
    }

    private boolean isLoginInUse(String checkLogin) throws DAOException {
        try {
            List<String> users = Files.readAllLines(Paths.get(USERS_FILENAME));
            for (String user: users) {
                String login = user.split(DELIMITER)[0];
                if (login.equals(checkLogin)) {
                    return true;
                }
            }
            return false;
        } catch (IOException e) {
            throw new ReadUserDAOException(UserExceptionMessages.cantReadUser, e);
        }
    }
}
