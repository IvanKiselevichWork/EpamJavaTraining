package by.javatr.task2.service.exception;

import by.javatr.task1.entity.exception.AbstractArrayRuntimeException;

public class ArrayIsNullRuntimeException extends AbstractArrayRuntimeException {
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
