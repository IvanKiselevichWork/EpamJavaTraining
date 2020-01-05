package by.javatr.finance.runner;

import by.javatr.finance.controller.MainMenuController;
import by.javatr.finance.controller.command.CommandParameters;

public class Main {

    public static void main(String[] args) {
        try {
            MainMenuController.getInstance().execute(MainMenuController.RUN_MAIN_MENU_COMMAND, new CommandParameters());
        } catch (Exception e) {
            System.out.println("If you see this message, something went wrong!");
            e.printStackTrace();
        }
    }
}
