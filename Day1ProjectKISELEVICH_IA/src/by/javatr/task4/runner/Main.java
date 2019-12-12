package by.javatr.task4.runner;

import by.javatr.scanner.CustomScanner;
import by.javatr.scanner.exception.CustomScannerException;
import by.javatr.task4.unit.Unit;
import by.javatr.task4.unit.exception.InvalidArrayException;

/**
 * 4.  Составить программу, печатающую значение true, если указанное высказывание является истинным, и
 * false — в противном случае: среди заданных целых чисел А, В, С, D есть хотя бы два четных.
 */
public class Main {

    private static final int NUMBERS_COUNT = 4;

    public static void main(String[] args) {

        int[] numbers = new int[NUMBERS_COUNT];

        System.out.println("Input " + NUMBERS_COUNT + " integers");
        for (int i = 0; i < NUMBERS_COUNT; i++) {
            System.out.println("Input integer #" + (i + 1));
            try {
                numbers[i] = CustomScanner.readInteger(System.in);
            } catch (CustomScannerException e) {
                System.out.println("Input error!");
                return;
            }
        }

        try {
            System.out.println(Unit.isArrayHasTwoEvenNumbers(numbers));
        } catch (InvalidArrayException e) {
            System.out.println("Invalid arguments!");
        }


    }
}
