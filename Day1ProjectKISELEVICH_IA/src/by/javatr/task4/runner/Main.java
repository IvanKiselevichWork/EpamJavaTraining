package by.javatr.task4.runner;

import by.javatr.scanner.CustomScanner;
import by.javatr.task4.unit.Unit;

public class Main {
    private static final int NUMBERS_COUNT = 4;
    public static void main(String[] args) {
        int[] numbers = new int[NUMBERS_COUNT];
        for (int i = 0; i < NUMBERS_COUNT; i++) {
            System.out.println("Input integer #" + (i + 1));
            numbers[i] = CustomScanner.readInteger(System.in);
        }

        System.out.println(Unit.isArrayHasTwoEvenNumbers(numbers));
    }
}
