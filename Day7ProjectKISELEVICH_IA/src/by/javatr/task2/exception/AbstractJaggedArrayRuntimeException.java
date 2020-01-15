package by.javatr.task2.exception;

public abstract class AbstractJaggedArrayRuntimeException extends RuntimeException {
    public AbstractJaggedArrayRuntimeException() {
    }

    public AbstractJaggedArrayRuntimeException(String message) {
        super(message);
    }

    public AbstractJaggedArrayRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public AbstractJaggedArrayRuntimeException(Throwable cause) {
        super(cause);
    }
}
