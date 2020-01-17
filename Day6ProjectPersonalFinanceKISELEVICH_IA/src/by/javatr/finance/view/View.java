package by.javatr.finance.view;

import by.javatr.finance.controller.Controller;
import by.javatr.finance.controller.exception.AbstractControllerException;
import by.javatr.finance.entity.Record;

import java.util.List;
import java.util.Scanner;

public class View {

    private Controller controller;

    private final static String BASE_REQUEST = "SHOW_MAIN_MENU;";

    public View() {
        controller = new Controller();
    }

    public void runView() {
        String request = BASE_REQUEST;
        String response = null;
        while (true) {
            response = sendRequest(request);
            request = handleResponse(response);
        }
    }

    private String sendRequest(String request) {
        String response = null;

        try {
            response = controller.execute(request);
        } catch (AbstractControllerException e) {
            // todo log
            showErrorMessage("Controller broken!");
            System.exit(-1);
        }
        return response;

    }

    private String handleResponse(String response) {
        String request = null;

        return request;
    }

    private void showMainMenu() {
        System.out.println("--------------------------");
        System.out.println("Main menu:");
        System.out.println("1 - Sign in");
        System.out.println("2 - Registration");
        System.out.println("0 - Exit");
        System.out.println("--------------------------");
    }

    private void showUserMenu() {
        System.out.println("--------------------------");
        System.out.println("User menu:");
        System.out.println("1 - Show all my records");
        System.out.println("2 - Add record");
        System.out.println("3 - Remove record");
        System.out.println("0 - Exit");
        System.out.println("--------------------------");
    }

    private String getCommand(String message, String[] validCommands) {
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

    private String getString(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }

    private void showErrorMessage(String message) {
        System.out.println("Error occurred: " + message);
    }

    private void showExitMessage() {
        System.out.println("Turning off...");
    }

    private void welcomeUser(String login) {
        System.out.println("Welcome, " + login + "!");
    }

    private void signInDataRequest() {
        System.out.println("Input data for signing in: ");
    }

    private void registrationDataRequest() {
        System.out.println("Input data for registration: ");
    }

    private void showAccountNotFoundMessage() {
        System.out.println("Account not found!");
    }

    private void showLoginInUseMessage() {
        System.out.println("Login in use!");
    }

    private void showRecordList(List<Record> recordList) {
        int index = 1;
        System.out.println("Records:");
        for (Record record : recordList) {
            System.out.println(index++ + ": " + record.toString());
        }
    }

    private void showRecordAddedMessage(Record record) {
        System.out.println("Record added: \n" + record);
    }

    private void showRecordRemovedMessage() {
        System.out.println("Record removed");
    }
}
