package by.javatr.finance.service.impl;

import by.javatr.finance.dao.RecordDAO;
import by.javatr.finance.dao.exception.AbstractDAOException;
import by.javatr.finance.dao.factory.DAOFactory;
import by.javatr.finance.entity.Record;
import by.javatr.finance.service.RecordService;
import by.javatr.finance.service.exception.record.*;
import by.javatr.finance.service.impl.Validation.RecordValidator;

import java.util.List;

public class RecordServiceImpl implements RecordService {

    private final static RecordValidator recordValidator = new RecordValidator();

    private RecordDAO recordDAO = DAOFactory.getInstance().getRecordDAO();

    @Override
    public void addRecord(Record record) throws AddRecordServiceException, IncorrectRecordServiceException, IncorrectDateServiceException, IncorrectCauseServiceException {
        try {
            recordValidator.checkRecord(record);
            recordDAO.addRecord(record);
        } catch (AbstractDAOException e) {
            throw new AddRecordServiceException(e);
        }
    }

    @Override
    public void removeRecord(Record record) throws RemoveRecordServiceException, IncorrectRecordServiceException, IncorrectDateServiceException, IncorrectCauseServiceException {
        try {
            recordValidator.checkRecord(record);
            recordDAO.removeRecord(record);
        } catch (AbstractDAOException e) {
            throw new RemoveRecordServiceException(e);
        }
    }

    @Override
    public List<Record> getAllRecords() throws GetAllRecordsServiceException {
        try {
            return recordDAO.getAllRecords();
        } catch (AbstractDAOException e) {
            throw new GetAllRecordsServiceException(e);
        }
    }
}
