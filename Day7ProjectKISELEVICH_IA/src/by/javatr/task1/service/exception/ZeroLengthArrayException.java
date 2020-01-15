package by.javatr.task1.service.exception;

public class ZeroLengthArrayException extends AbstractArrayServiceException {
    public ZeroLengthArrayException() {
    }

    public ZeroLengthArrayException(String message) {
        super(message);
    }

    public ZeroLengthArrayException(String message, Throwable cause) {
        super(message, cause);
    }

    public ZeroLengthArrayException(Throwable cause) {
        super(cause);
    }
}
