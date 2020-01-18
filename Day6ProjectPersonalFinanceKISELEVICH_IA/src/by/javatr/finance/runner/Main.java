package by.javatr.finance.runner;

import by.javatr.finance.controller.CommandParameters;
import by.javatr.finance.controller.Controller;
import by.javatr.finance.controller.exception.AbstractControllerException;

public class Main {

    public static void main(String[] args) {
        CommandParameters commandParameters = new CommandParameters();
        Controller controller = new Controller();
        try {
            while (true) {
                commandParameters = controller.execute(commandParameters);
            }
        } catch (AbstractControllerException e) {
            System.out.println("Something goes wrong...");
            e.printStackTrace();
        }
    }
}
