package by.javatr.task1.entity.exception;

public class IndexOutOfBoundsException extends AbstractArrayException {
    public IndexOutOfBoundsException() {
    }

    public IndexOutOfBoundsException(String message) {
        super(message);
    }

    public IndexOutOfBoundsException(String message, Throwable cause) {
        super(message, cause);
    }

    public IndexOutOfBoundsException(Throwable cause) {
        super(cause);
    }
}
