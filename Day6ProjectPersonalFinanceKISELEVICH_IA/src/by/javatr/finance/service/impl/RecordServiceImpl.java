package by.javatr.finance.service.impl;

import by.javatr.finance.dao.RecordDAO;
import by.javatr.finance.dao.exception.AbstractDAOException;
import by.javatr.finance.dao.factory.DAOFactory;
import by.javatr.finance.entity.Record;
import by.javatr.finance.service.RecordService;
import by.javatr.finance.service.exception.AbstractServiceException;
import by.javatr.finance.service.exception.record.AddRecordServiceException;
import by.javatr.finance.service.exception.record.GetAllRecordsServiceException;
import by.javatr.finance.service.exception.record.RemoveRecordServiceException;
import by.javatr.finance.service.impl.Validation.RecordValidator;

import java.util.List;

public class RecordServiceImpl implements RecordService {

    private final static RecordValidator recordValidator = new RecordValidator();

    private RecordDAO recordDAO = DAOFactory.getInstance().getRecordDAO();

    @Override
    public void addRecord(Record record) throws AbstractServiceException {
        try {
            recordDAO.addRecord(record);
        } catch (AbstractDAOException e) {
            throw new AddRecordServiceException(e);
        }
    }

    @Override
    public void removeRecord(Record record) throws AbstractServiceException {
        try {
            recordDAO.removeRecord(record);
        } catch (AbstractDAOException e) {
            throw new RemoveRecordServiceException(e);
        }
    }

    @Override
    public List<Record> getAllRecords() throws AbstractServiceException {
        try {
            return recordDAO.getAllRecords();
        } catch (AbstractDAOException e) {
            throw new GetAllRecordsServiceException(e);
        }
    }
}
