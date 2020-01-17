package by.javatr.finance.controller.command.mainmenu;

import by.javatr.finance.controller.command.Command;
import by.javatr.finance.controller.exception.AbstractControllerException;

public class ShowMainMenuCommand implements Command {

    @Override
    public String execute(String request) throws AbstractControllerException {
        return "SHOW_MAIN_MENU";
        /*
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MENU;");
        stringBuffer.append("\n--------------------------");
        stringBuffer.append("\nMain menu:");
        stringBuffer.append("\n1 - Sign in");
        stringBuffer.append("\n2 - Registration");
        stringBuffer.append("\n0 - Exit");
        stringBuffer.append("\n--------------------------");
        stringBuffer.append(";0,1,2;EXIT,SIGN_IN,REGISTRATION;");
        return stringBuffer.toString();
         */
    }
}
