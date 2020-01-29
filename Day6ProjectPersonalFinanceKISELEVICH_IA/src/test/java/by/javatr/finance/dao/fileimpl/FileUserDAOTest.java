package by.javatr.finance.dao.fileimpl;

import by.javatr.finance.bean.User;
import by.javatr.finance.dao.exception.user.UserDAOException;
import by.javatr.finance.dao.fileImpl.FileUserDAO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static by.javatr.finance.dao.fileImpl.FileUserDAO.USERS_FILENAME;

public class FileUserDAOTest {

    private final FileUserDAO fileUserDAO = new FileUserDAO();

    @Before
    public void init() throws IOException {
        Files.write(Paths.get(USERS_FILENAME), "".getBytes());
    }

    @Test
    public void signInOK() throws UserDAOException, IOException {

        String userStr = "1;49" + System.lineSeparator();
        Files.write(Paths.get(USERS_FILENAME), userStr.getBytes());

        User user = new User("1", "1");
        Assert.assertTrue(fileUserDAO.signIn(user));
    }

    @Test
    public void signInFail() throws UserDAOException, IOException {

        Files.write(Paths.get(USERS_FILENAME), "".getBytes());

        User user = new User("1", "1");
        Assert.assertFalse(fileUserDAO.signIn(user));
    }

    @Test
    public void registrationOK() throws UserDAOException, IOException {

        Files.write(Paths.get(USERS_FILENAME), "".getBytes());

        User user = new User("1", "1");
        Assert.assertTrue(fileUserDAO.registration(user));
        List<String> usersList = Files.readAllLines(Paths.get(USERS_FILENAME));
        Assert.assertEquals("1;49", usersList.get(0));
    }

    @Test
    public void registrationFail() throws UserDAOException, IOException {

        Files.write(Paths.get(USERS_FILENAME), "1;49".getBytes());

        User user = new User("1", "2");
        Assert.assertFalse(fileUserDAO.registration(user));
        List<String> usersList = Files.readAllLines(Paths.get(USERS_FILENAME));
        Assert.assertEquals("1;49", usersList.get(0));
    }
}
