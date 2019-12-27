package by.javatr.finance.dao.exception;

public abstract class AbstractDAOException extends Exception {
    public AbstractDAOException() {
    }

    public AbstractDAOException(String message) {
        super(message);
    }

    public AbstractDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public AbstractDAOException(Throwable cause) {
        super(cause);
    }
}
