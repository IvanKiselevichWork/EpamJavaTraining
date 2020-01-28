package by.javatr.finance.controller.exception;

public abstract class AbstractControllerException extends Exception {
    public AbstractControllerException() {
    }

    public AbstractControllerException(String message) {
        super(message);
    }

    public AbstractControllerException(String message, Throwable cause) {
        super(message, cause);
    }

    public AbstractControllerException(Throwable cause) {
        super(cause);
    }
}
