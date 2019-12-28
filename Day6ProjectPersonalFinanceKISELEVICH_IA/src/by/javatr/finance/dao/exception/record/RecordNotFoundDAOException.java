package by.javatr.finance.dao.exception.record;

import by.javatr.finance.dao.exception.AbstractDAOException;

public class RecordNotFoundDAOException extends AbstractDAOException {
    public RecordNotFoundDAOException() {
    }

    public RecordNotFoundDAOException(String message) {
        super(message);
    }

    public RecordNotFoundDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public RecordNotFoundDAOException(Throwable cause) {
        super(cause);
    }
}
