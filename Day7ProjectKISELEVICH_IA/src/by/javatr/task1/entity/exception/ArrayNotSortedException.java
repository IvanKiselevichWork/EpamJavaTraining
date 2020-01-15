package by.javatr.task1.entity.exception;

public class ArrayNotSortedException extends AbstractArrayException {
    public ArrayNotSortedException() {
    }

    public ArrayNotSortedException(String message) {
        super(message);
    }

    public ArrayNotSortedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArrayNotSortedException(Throwable cause) {
        super(cause);
    }
}
