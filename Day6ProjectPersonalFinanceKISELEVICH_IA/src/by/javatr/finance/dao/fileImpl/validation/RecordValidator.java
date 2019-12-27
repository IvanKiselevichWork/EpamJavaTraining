package by.javatr.finance.dao.fileImpl.validation;

import by.javatr.finance.dao.exception.user.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static by.javatr.finance.dao.fileImpl.FileUserDAO.*;

public class RecordValidator {

    public RecordValidator() {

    }


    private void check(String login, String password) throws WrongUserPasswordException, WrongUserLoginException {
        if (login == null) {
            throw new WrongUserLoginException(UserExceptionMessages.loginIsNull);
        }
        if (password == null) {
            throw new WrongUserPasswordException(UserExceptionMessages.passwordIsNull);
        }
    }

}
