package by.javatr.task1.entity.exception;

public class IndexBelowZeroRuntimeException extends AbstractArrayRuntimeException {
    public IndexBelowZeroRuntimeException() {
    }

    public IndexBelowZeroRuntimeException(String message) {
        super(message);
    }

    public IndexBelowZeroRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public IndexBelowZeroRuntimeException(Throwable cause) {
        super(cause);
    }
}
