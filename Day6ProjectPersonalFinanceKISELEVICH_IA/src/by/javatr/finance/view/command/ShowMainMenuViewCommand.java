package by.javatr.finance.view.command;

import by.javatr.finance.view.View;

public class ShowMainMenuViewCommand implements ViewCommand {
    @Override
    public String execute(String request) {
        System.out.println("--------------------------");
        System.out.println("Main menu:");
        System.out.println("1 - Sign in");
        System.out.println("2 - Registration");
        System.out.println("0 - Exit");
        System.out.println("--------------------------");
        String commandStr = View.getCommand("Input command: ", new String[] {"0", "1", "2"});
        int command = Integer.parseInt(commandStr);
        String response = null;
        switch (command) {
            case 0:
                response = "EXIT;";
                break;
            case 1:
                response = "SIGN_IN;";
                break;
            case 2:
                response = "REGISTRATION;";
                break;
        }
        return response;
    }
}
