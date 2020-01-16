package by.javatr.task1.service.exception;

public class ArrayIsNullException extends AbstractArrayServiceException {
    public ArrayIsNullException() {
    }

    public ArrayIsNullException(String message) {
        super(message);
    }

    public ArrayIsNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArrayIsNullException(Throwable cause) {
        super(cause);
    }
}
