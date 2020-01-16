package by.javatr.task2.service.exception;

public abstract class AbstractJaggedArrayException extends Exception {
    public AbstractJaggedArrayException() {
    }

    public AbstractJaggedArrayException(String message) {
        super(message);
    }

    public AbstractJaggedArrayException(String message, Throwable cause) {
        super(message, cause);
    }

    public AbstractJaggedArrayException(Throwable cause) {
        super(cause);
    }
}
