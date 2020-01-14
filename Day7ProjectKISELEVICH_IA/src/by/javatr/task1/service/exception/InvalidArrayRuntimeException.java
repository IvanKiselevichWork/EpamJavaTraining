package by.javatr.task1.service.exception;

public class InvalidArrayRuntimeException extends AbstractArrayServiceRuntimeException {
    public InvalidArrayRuntimeException() {
    }

    public InvalidArrayRuntimeException(String message) {
        super(message);
    }

    public InvalidArrayRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidArrayRuntimeException(Throwable cause) {
        super(cause);
    }
}
