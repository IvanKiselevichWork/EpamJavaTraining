package by.javatr.finance.view;

import by.javatr.finance.bean.Record;


import java.util.List;
import java.util.Scanner;

public class View {

    private View() {
    }

    private static class ViewHolder {
        private static final View instance = new View();
        private static View getInstance() {
            return instance;
        }
    }

    public static View getInstance() {
        return ViewHolder.getInstance();
    }

    public void showMainMenu() {
        System.out.println("--------------------------");
        System.out.println("Main menu:");
        System.out.println("1 - Sign in");
        System.out.println("2 - Registration");
        System.out.println("0 - Exit");
        System.out.println("--------------------------");
    }

    public void showUserMenu() {
        System.out.println("--------------------------");
        System.out.println("User menu:");
        System.out.println("1 - Show all my records");
        System.out.println("2 - Add record");
        System.out.println("3 - Remove record");
        System.out.println("4 - Sign out");
        System.out.println("0 - Exit");
        System.out.println("--------------------------");
    }

    public String getCommand(String message, String[] validCommands) {
        Scanner scanner = new Scanner(System.in);
        String command;
        MAIN_LOOP:
        while (true) {
            System.out.println(message);
            command = scanner.nextLine();
            for (String validCommand : validCommands) {
                if (validCommand.equals(command)) {
                    break MAIN_LOOP;
                }
            }
            System.out.println("Wrong input!");
        }
        return command;
    }

    public String getString(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }

    public void showErrorMessage(Throwable error) {
        if (error != null) {
            if (error.getCause() != null) {
                System.out.println("Error occurred: " + error.getCause().getMessage());
            } else {
                System.out.println("Error occurred: " + error.getMessage());
            }
        } else {
            System.out.println("Error occurred: " + "unknown error");
        }

    }

    public void showExitMessage() {
        System.out.println("Turning off...");
    }

    public void welcomeUser(String login) {
        System.out.println("Welcome, " + login + "!");
    }

    public void signInDataRequest() {
        System.out.println("Input data for signing in: ");
    }

    public void registrationDataRequest() {
        System.out.println("Input data for registration: ");
    }

    public void showAccountNotFoundMessage() {
        System.out.println("Account not found!");
    }

    public void showLoginInUseMessage() {
        System.out.println("Login in use!");
    }

    public void showRecordList(List<Record> recordList) {
        int index = 1;
        System.out.println("Records:");
        for (Record record : recordList) {
            System.out.println(index++ + ": " + record.toString());
        }
        if (recordList.size() == 0) {
            System.out.println("No records");
        }
    }

    public void showRecordAddedMessage(Record record) {
        System.out.println("Record added: \n" + record);
    }

    public void showRecordRemovedMessage() {
        System.out.println("Record removed");
    }

    public void showCaution(String message) {
        System.out.println(message);
    }

    public void showGoodbye(String login) {
        System.out.println("Goodbye, " + login + "!");
    }
}
