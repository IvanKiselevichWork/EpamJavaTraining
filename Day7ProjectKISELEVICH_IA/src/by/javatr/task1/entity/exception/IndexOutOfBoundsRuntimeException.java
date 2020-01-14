package by.javatr.task1.entity.exception;

public class IndexOutOfBoundsRuntimeException extends AbstractArrayRuntimeException {
    public IndexOutOfBoundsRuntimeException() {
    }

    public IndexOutOfBoundsRuntimeException(String message) {
        super(message);
    }

    public IndexOutOfBoundsRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public IndexOutOfBoundsRuntimeException(Throwable cause) {
        super(cause);
    }
}
