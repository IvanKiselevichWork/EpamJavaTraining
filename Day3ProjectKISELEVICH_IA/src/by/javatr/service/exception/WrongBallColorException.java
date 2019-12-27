package by.javatr.service.exception;

public class WrongBallColorException extends Exception {

    public WrongBallColorException() {
    }

    public WrongBallColorException(String message) {
        super(message);
    }

    public WrongBallColorException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongBallColorException(Throwable cause) {
        super(cause);
    }
}
