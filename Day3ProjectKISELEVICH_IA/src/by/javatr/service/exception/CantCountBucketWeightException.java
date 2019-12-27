package by.javatr.service.exception;

public class CantCountBucketWeightException extends Exception {

    public CantCountBucketWeightException() {
    }

    public CantCountBucketWeightException(String message) {
        super(message);
    }

    public CantCountBucketWeightException(String message, Throwable cause) {
        super(message, cause);
    }

    public CantCountBucketWeightException(Throwable cause) {
        super(cause);
    }
}
