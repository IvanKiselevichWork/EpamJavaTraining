package by.javatr.task2.service.exception;

public class SortHelperIsNullRuntimeException extends RuntimeException {
    public SortHelperIsNullRuntimeException() {
    }

    public SortHelperIsNullRuntimeException(String message) {
        super(message);
    }

    public SortHelperIsNullRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public SortHelperIsNullRuntimeException(Throwable cause) {
        super(cause);
    }
}
