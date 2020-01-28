package main.java.by.javatr.finance.service.factory;

import main.java.by.javatr.finance.service.RecordService;
import main.java.by.javatr.finance.service.UserService;
import main.java.by.javatr.finance.service.impl.RecordServiceImpl;
import main.java.by.javatr.finance.service.impl.UserServiceImpl;

public final class ServiceFactory {
    private final static ServiceFactory instance = new ServiceFactory();

    private final UserService userService = new UserServiceImpl();
    private final RecordService recordService = new RecordServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public UserService getUserService() {
        return userService;
    }

    public RecordService getRecordService() {
        return recordService;
    }
}
