package by.javatr.task10.unit.exception;

public class InvalidStepException extends Exception {
    public InvalidStepException() {
    }

    public InvalidStepException(String message) {
        super(message);
    }

    public InvalidStepException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidStepException(Throwable cause) {
        super(cause);
    }
}
