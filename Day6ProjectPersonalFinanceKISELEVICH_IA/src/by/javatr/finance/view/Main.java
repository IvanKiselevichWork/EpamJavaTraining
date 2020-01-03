package by.javatr.finance.view;

import by.javatr.finance.controller.Command;
import by.javatr.finance.controller.Controller;
import by.javatr.finance.controller.MainMenuController;
import by.javatr.finance.dao.exception.AbstractDAOException;
import by.javatr.finance.dao.fileImpl.FileRecordDAO;
import by.javatr.finance.dao.fileImpl.FileUserDAO;
import by.javatr.finance.entity.Record;
import by.javatr.finance.entity.exception.RecordException;
import by.javatr.finance.service.UserService;
import by.javatr.finance.service.impl.UserServiceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*
        //Record r = new Record(1, "asdf", LocalDateTime.parse("2007-12-03T10:15:30"), 45);
        try {


            FileRecordDAO fileRecordDAO = new FileRecordDAO();/*
            fileRecordDAO.addRecord(new Record("admin", "asdf", LocalDateTime.parse("2007-12-03T10:15:35"), 445));
            fileRecordDAO.addRecord(new Record("admin", "asdf", LocalDateTime.parse("2007-12-03T10:15:31"), 435));
            fileRecordDAO.addRecord(new Record("admin", "asdf", LocalDateTime.parse("2007-12-03T10:15:32"), 455));
            fileRecordDAO.addRecord(new Record("admin", "asdf", LocalDateTime.parse("2007-12-03T10:15:33"), 465));


            List<Record> recordList = fileRecordDAO.getAllRecords();
            for (Record record : recordList) {
                System.out.println(record);
            }
            FileUserDAO fileUserDAO = new FileUserDAO();
            //fileUserDAO.registration("admin", "1234");
            fileUserDAO.signIn("admin", "1234");
            System.out.println("admin signed in!");
        } catch (AbstractDAOException e) {//| RecordException e) {
            e.printStackTrace();
        }
        */
        try {
            MainMenuController.getInstance().start();
            //System.out.println("Success!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
