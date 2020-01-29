package by.javatr.finance.dao.fileimpl.validation;


import by.javatr.finance.bean.User;
import by.javatr.finance.dao.exception.user.UserDAOException;
import by.javatr.finance.dao.fileImpl.validation.UserValidator;
import org.junit.Assert;
import org.junit.Test;

public class UserValidatorTest {

    private final UserValidator userValidator = new UserValidator();

    @Test
    public void checkValidUserOK() throws UserDAOException {
        User user = new User(
                "login",
                "pass");
        userValidator.check(user);
        Assert.assertTrue(true);
    }

    @Test(expected = UserDAOException.class)
    public void checkInvalidUserUserDAOException() throws UserDAOException {
        User user = null;
        userValidator.check(user);
        Assert.assertTrue(true);
    }

    @Test(expected = UserDAOException.class)
    public void checkInvalidUserLoginUserDAOException() throws UserDAOException {
        User user = new User(
                null,
                "pass");
        userValidator.check(user);
        Assert.assertTrue(true);
    }

    @Test(expected = UserDAOException.class)
    public void checkInvalidUserPasswordUserDAOException() throws UserDAOException {
        User user = new User(
                "login",
                null);
        userValidator.check(user);
        Assert.assertTrue(true);
    }
}
