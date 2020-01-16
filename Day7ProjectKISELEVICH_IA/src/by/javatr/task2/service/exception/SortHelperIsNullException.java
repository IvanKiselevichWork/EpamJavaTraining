package by.javatr.task2.service.exception;

public class SortHelperIsNullException extends AbstractJaggedArrayException {
    public SortHelperIsNullException() {
    }

    public SortHelperIsNullException(String message) {
        super(message);
    }

    public SortHelperIsNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public SortHelperIsNullException(Throwable cause) {
        super(cause);
    }
}
