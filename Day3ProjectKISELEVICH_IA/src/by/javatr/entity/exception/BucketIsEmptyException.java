package by.javatr.entity.exception;

public class BucketIsEmptyException extends Exception {
    public BucketIsEmptyException() {
    }

    public BucketIsEmptyException(String message) {
        super(message);
    }

    public BucketIsEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public BucketIsEmptyException(Throwable cause) {
        super(cause);
    }
}
