package by.javatr.finance.runner;

import by.javatr.finance.controller.MainController;
import by.javatr.finance.controller.MainMenuController;

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
            MainController.getInstance().execute(MainController.RUN_MAIN_MENU);
            //System.out.println("Success!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
