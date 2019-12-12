package by.javatr.scanner.exception;

public class CustomScannerException extends Exception {
    public CustomScannerException() {
    }

    public CustomScannerException(String message) {
        super(message);
    }

    public CustomScannerException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomScannerException(Throwable cause) {
        super(cause);
    }
}
