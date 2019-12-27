package by.javatr.service.exception;

public class WrongBallBucketException extends Exception {

    public WrongBallBucketException() {
    }

    public WrongBallBucketException(String message) {
        super(message);
    }

    public WrongBallBucketException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongBallBucketException(Throwable cause) {
        super(cause);
    }
}
