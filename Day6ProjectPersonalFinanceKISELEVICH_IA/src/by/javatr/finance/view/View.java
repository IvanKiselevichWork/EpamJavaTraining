package by.javatr.finance.view;

import by.javatr.finance.entity.Record;

import java.util.List;
import java.util.Scanner;

public class View {

    private static final View instance = new View();

    public static View getInstance() {
        return instance;
    }

    private View(){

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
            System.out.println("Wrong command!");
        }
        return command;
    }

    public String getString(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }

    public void showErrorMessage(String message) {
        System.out.println("Error occurred: " + message);
    }

    public void showExitMessage() {
        System.out.println("Turning off...");
    }

    public void welcomeUser(String login) {
        System.out.println("Welcome, " + login + "!"); // todo
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
    }
}
