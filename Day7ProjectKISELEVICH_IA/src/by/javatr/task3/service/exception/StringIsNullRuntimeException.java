package by.javatr.task3.service.exception;

public class StringIsNullRuntimeException extends AbstractTextServiceRuntimeException {
    public StringIsNullRuntimeException() {
    }

    public StringIsNullRuntimeException(String message) {
        super(message);
    }

    public StringIsNullRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public StringIsNullRuntimeException(Throwable cause) {
        super(cause);
    }
}
