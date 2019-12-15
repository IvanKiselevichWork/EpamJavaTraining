class BirthdayDataException extends Exception {

    public BirthdayDataException() {
    }

    public BirthdayDataException(String message) {
        super(message);
    }

    public BirthdayDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public BirthdayDataException(Throwable cause) {
        super(cause);
    }
}