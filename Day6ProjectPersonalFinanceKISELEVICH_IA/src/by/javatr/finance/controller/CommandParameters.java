package by.javatr.finance.controller;

import java.util.HashMap;

public class CommandParameters {

    public static final String USER = "user";
    public static final String NEXT_COMMAND = "nextCommand";

    private final HashMap<String, Object> parametersMap = new HashMap<>();

    public Object getParameter(String parameter) {
        return parametersMap.get(parameter);
    }

    public void setParameter(String parameter, Object value) {
        parametersMap.put(parameter, value);
    }
}
