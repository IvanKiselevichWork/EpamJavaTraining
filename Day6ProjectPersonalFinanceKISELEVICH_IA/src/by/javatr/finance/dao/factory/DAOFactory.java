package by.javatr.finance.dao.factory;

import by.javatr.finance.dao.RecordDAO;
import by.javatr.finance.dao.UserDAO;
import by.javatr.finance.dao.fileImpl.FileRecordDAO;
import by.javatr.finance.dao.fileImpl.FileUserDAO;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final UserDAO fileUserDao = new FileUserDAO();
    private final RecordDAO fileRecordDAO = new FileRecordDAO();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public UserDAO getUserDAO() {
        return fileUserDao;
    }

    public RecordDAO getRecordDAO() {
        return fileRecordDAO;
    }
}
