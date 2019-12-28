package by.javatr.finance.view;

import by.javatr.finance.dao.exception.AbstractDAOException;
import by.javatr.finance.dao.fileImpl.FileRecordDAO;
import by.javatr.finance.dao.fileImpl.FileUserDAO;
import by.javatr.finance.entity.Record;

import java.time.LocalDateTime;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //Record r = new Record(1, "asdf", LocalDateTime.parse("2007-12-03T10:15:30"), 45);
        try {

            FileRecordDAO fileRecordDAO = new FileRecordDAO();/*
            fileRecordDAO.addRecord(new Record(1, "asdf", LocalDateTime.parse("2007-12-03T10:15:35"), 45));
            fileRecordDAO.addRecord(new Record(2, "asdf", LocalDateTime.parse("2007-12-03T10:15:31"), 45));
            fileRecordDAO.addRecord(new Record(3, "asdf", LocalDateTime.parse("2007-12-03T10:15:32"), 45));
            fileRecordDAO.addRecord(new Record(4, "asdf", LocalDateTime.parse("2007-12-03T10:15:33"), 45));

             */
            List<Record> recordList = fileRecordDAO.getAllRecords();
            for (Record record : recordList) {
                System.out.println(record);
            }
            //FileUserDAO fileUserDAO = new FileUserDAO();
            //fileUserDAO.registration("admin", "1234");
            //fileUserDAO.signIn("admin", "1234");
            //System.out.println("admin signed in!");
        } catch (AbstractDAOException e) {
            e.printStackTrace();
        }
    }
}
