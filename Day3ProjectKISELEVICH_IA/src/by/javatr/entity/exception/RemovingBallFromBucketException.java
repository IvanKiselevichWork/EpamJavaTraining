package by.javatr.entity.exception;

public class RemovingBallFromBucketException extends Exception {

    public RemovingBallFromBucketException() {
    }

    public RemovingBallFromBucketException(String message) {
        super(message);
    }

    public RemovingBallFromBucketException(String message, Throwable cause) {
        super(message, cause);
    }

    public RemovingBallFromBucketException(Throwable cause) {
        super(cause);
    }
}
