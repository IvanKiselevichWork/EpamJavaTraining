package by.javatr.finance.controller.command;

import java.util.HashMap;

public class CommandParameters {
    private final HashMap<String, String> paramsMap = new HashMap<>();

    public static final String LOGIN_PARAMETER = "login";

    public void setParameter(String key, String value) {
        paramsMap.put(key, value);
    }

    public String getParameter(String key) {
        return paramsMap.get(key);
    }
}
