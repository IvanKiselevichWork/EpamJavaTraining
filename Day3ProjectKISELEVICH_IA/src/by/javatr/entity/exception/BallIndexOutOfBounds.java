package by.javatr.entity.exception;

public class BallIndexOutOfBounds extends RuntimeException {
    public BallIndexOutOfBounds() {
    }

    public BallIndexOutOfBounds(String message) {
        super(message);
    }

    public BallIndexOutOfBounds(String message, Throwable cause) {
        super(message, cause);
    }

    public BallIndexOutOfBounds(Throwable cause) {
        super(cause);
    }
}
