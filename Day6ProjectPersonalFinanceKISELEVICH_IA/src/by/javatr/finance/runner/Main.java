package by.javatr.finance.runner;

import by.javatr.finance.controller.MainController;

public class Main {

    public static void main(String[] args) {
        try {
            MainController.getInstance().execute(MainController.RUN_MAIN_MENU);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
