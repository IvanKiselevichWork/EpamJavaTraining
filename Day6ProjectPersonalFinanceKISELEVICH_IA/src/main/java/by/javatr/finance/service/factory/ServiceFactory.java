package by.javatr.finance.service.factory;

import by.javatr.finance.service.RecordService;
import by.javatr.finance.service.UserService;
import by.javatr.finance.service.impl.RecordServiceImpl;
import by.javatr.finance.service.impl.UserServiceImpl;

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
