package by.javatr.service.exception;

public class BallBucketServiceException extends Exception {
    public BallBucketServiceException() {
        super();
    }

    public BallBucketServiceException(String message) {
        super(message);
    }

    public BallBucketServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public BallBucketServiceException(Throwable cause) {
        super(cause);
    }
    //oracle 90-x code convension`
    // роберт мартин чистый код
}
