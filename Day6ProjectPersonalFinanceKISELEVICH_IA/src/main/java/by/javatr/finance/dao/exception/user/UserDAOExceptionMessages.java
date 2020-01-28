package main.java.by.javatr.finance.dao.exception.user;

public interface UserDAOExceptionMessages {
    String cantWriteUser = "Can't write user";
    String cantReadUser = "Can't read user";
    String userIsNull = "User is null";
    String loginIsNull = "Login is null";
    String loginInUse = "Login in use";
    String loginIsInvalid = "Login contains invalid symbols";
    String passwordIsNull = "Password is null";
    String accountNotFound = "Account not found";
    String dataCorrupted = "User data corrupted";
}
