package by.javatr.task2.service.exception;

public class ArrayIsNullException extends AbstractJaggedArrayException {
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
