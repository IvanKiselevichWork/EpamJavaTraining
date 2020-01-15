package by.javatr.task2.exception;

import by.javatr.task1.entity.exception.AbstractArrayRuntimeException;

public class SortHelperIsNullRuntimeException extends AbstractArrayRuntimeException {
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
