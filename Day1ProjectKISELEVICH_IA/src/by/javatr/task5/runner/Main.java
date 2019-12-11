package by.javatr.task5.runner;

import by.javatr.scanner.CustomScanner;
import by.javatr.task5.unit.Unit;

public class Main {
    public static void main(String[] args) {
        System.out.println("Input integer: ");
        int number = CustomScanner.readInteger(System.in);
        System.out.println(Unit.isNumberPerfect(number));
    }
}
