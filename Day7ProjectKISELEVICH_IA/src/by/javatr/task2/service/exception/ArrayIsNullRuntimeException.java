package by.javatr.task2.service.exception;

public class ArrayIsNullRuntimeException extends RuntimeException {
    public ArrayIsNullRuntimeException() {
    }

    public ArrayIsNullRuntimeException(String message) {
        super(message);
    }

    public ArrayIsNullRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArrayIsNullRuntimeException(Throwable cause) {
        super(cause);
    }
}
