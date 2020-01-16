package by.javatr.task1.service.exception;

public class InvalidArrayException extends AbstractArrayServiceException {
    public InvalidArrayException() {
    }

    public InvalidArrayException(String message) {
        super(message);
    }

    public InvalidArrayException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidArrayException(Throwable cause) {
        super(cause);
    }
}
