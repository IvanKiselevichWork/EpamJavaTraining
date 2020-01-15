package by.javatr.task1.entity.exception;

public abstract class AbstractArrayException extends Exception {
    public AbstractArrayException() {
    }

    public AbstractArrayException(String message) {
        super(message);
    }

    public AbstractArrayException(String message, Throwable cause) {
        super(message, cause);
    }

    public AbstractArrayException(Throwable cause) {
        super(cause);
    }
}
