package by.javatr.task2.unit.exception;

public class InvalidYearException extends Exception{
    public InvalidYearException() {
    }

    public InvalidYearException(String message) {
        super(message);
    }

    public InvalidYearException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidYearException(Throwable cause) {
        super(cause);
    }
}
