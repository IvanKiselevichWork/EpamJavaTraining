package by.javatr.finance.view;

import java.util.Scanner;

public class View {

    private static View instance = new View();

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
        //System.out.println("2 - Registration");
        System.out.println("0 - Exit");
        System.out.println("--------------------------");
    }

    public String getCommand(String message, String[] validCommands) {
        Scanner scanner = new Scanner(System.in);
        String command = null;
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

    public void showErrorMessage(String message) {
        System.out.println("Error occurred: " + message);
    }

    public void showExitMessage() {
        System.out.println("Turning off...");
    }

    public void welcomeUser(String login) {
        System.out.println("Welcome, " + login + "!"); // todo
    }

    public void signInLoginAndPasswordRequest() {
        System.out.println("Input login and password for signing in: ");
    }

    public void registrationLoginAndPasswordRequest() {
        System.out.println("Input login and password for registration: ");
    }

    public void showAccountNotFoundMessage(Exception e) {
        System.out.println("Account not found!");
        showErrorMessage(e.getMessage());
    }

}
