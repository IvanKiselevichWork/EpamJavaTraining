package main.java.by.javatr.finance.runner;

import main.java.by.javatr.finance.controller.CommandName;
import main.java.by.javatr.finance.controller.CommandParameters;
import main.java.by.javatr.finance.controller.Controller;

public class Main {

    public static void main(String[] args) {
        CommandParameters commandParameters = new CommandParameters();
        commandParameters.setParameter(CommandParameters.NEXT_COMMAND, CommandName.SHOW_MAIN_MENU);
        Controller controller = new Controller();

        while (true) {
            commandParameters = controller.execute(commandParameters);
        }
    }
}
