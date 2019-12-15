package by.javatr.task4.main;

/**
4.  Создать  приложение  для  ввода  пароля  из  командной  строки  и  сравнения  его  со  строкой-
образцом. 
 */
public class Main {
    public static void main(String[] args) {

        String secretPassword = "qwerty1234";
        String input;
        if (args.length < 1) {
            System.out.println("No args");
            return;
        }
        input = args[0];
        if (secretPassword.equals(input)) {
            System.out.println("Correct password!");
        } else {
            System.out.println("Wrong password!");
        }
    }
}