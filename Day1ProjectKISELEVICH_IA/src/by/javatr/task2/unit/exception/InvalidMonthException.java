package by.javatr.task2.unit.exception;

public class InvalidMonthException extends Exception {
    public InvalidMonthException() {
    }

    public InvalidMonthException(String message) {
        super(message);
    }

    public InvalidMonthException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidMonthException(Throwable cause) {
        super(cause);
    }
}
