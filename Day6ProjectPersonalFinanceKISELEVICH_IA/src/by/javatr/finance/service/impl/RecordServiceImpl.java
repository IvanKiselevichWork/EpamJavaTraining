package by.javatr.finance.service.impl;

import by.javatr.finance.dao.RecordDAO;
import by.javatr.finance.dao.exception.AbstractDAOException;
import by.javatr.finance.dao.factory.DAOFactory;
import by.javatr.finance.entity.Record;
import by.javatr.finance.service.RecordService;
import by.javatr.finance.service.exception.record.RecordServiceException;
import by.javatr.finance.service.impl.validation.RecordValidator;

import java.util.ArrayList;
import java.util.List;

public class RecordServiceImpl implements RecordService {

    private final static RecordValidator recordValidator = new RecordValidator();

    private final static RecordDAO recordDAO = DAOFactory.getInstance().getRecordDAO();

    @Override
    public void addRecord(Record record) throws RecordServiceException {
        try {
            recordValidator.checkRecord(record);
            recordDAO.addRecord(record);
        } catch (AbstractDAOException e) {
            throw new RecordServiceException(e);
        }
    }

    @Override
    public void removeRecord(Record record) throws RecordServiceException {
        try {
            recordValidator.checkRecord(record);
            recordDAO.removeRecord(record);
        } catch (AbstractDAOException e) {
            throw new RecordServiceException(e);
        }
    }

    @Override
    public List<Record> getAllRecordsByLogin(String login) throws RecordServiceException {
        try {
            List<Record> allRecords = recordDAO.getAllRecords();
            List<Record> result = new ArrayList<>();
            for (Record record : allRecords) {
                if (record.getUserLogin().equals(login)) {
                    result.add(record);
                }
            }
            return result;
        } catch (AbstractDAOException e) {
            throw new RecordServiceException(e);
        }
    }
}
