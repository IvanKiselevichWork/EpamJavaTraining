package by.javatr.service.exception;

public class CantCountBallsByColorException extends Exception {

    public CantCountBallsByColorException() {
    }

    public CantCountBallsByColorException(String message) {
        super(message);
    }

    public CantCountBallsByColorException(String message, Throwable cause) {
        super(message, cause);
    }

    public CantCountBallsByColorException(Throwable cause) {
        super(cause);
    }
}
