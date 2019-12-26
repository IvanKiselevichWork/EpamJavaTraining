package by.javatr.task4.runner;

import by.javatr.task4.unit.Unit;
import by.javatr.view.View;

/**
 * 4.  Составить программу, печатающую значение true, если указанное высказывание является истинным, и
 * false — в противном случае: среди заданных целых чисел А, В, С, D есть хотя бы два четных.
 */
public class Main {

    public static void main(String[] args) {

        // changes:
            // reworked task
            // removed unnecessary exception
            // removed repetition (readInteger )
        /*
        int[] numbers = new int[NUMBERS_COUNT];

        System.out.println("Input " + NUMBERS_COUNT + " integers");
        for (int i = 0; i < NUMBERS_COUNT; i++) {
            System.out.println("Input integer #" + (i + 1));
            try {
                numbers[i] = CustomScanner.readInteger(System.in);
            } catch (DataNotFoundException | DataSourceException e) {
                System.out.println("Input error!");
                return;
            }
        }

        try {
            System.out.println(Unit.isArrayHasTwoEvenNumbers(numbers));
        } catch (InvalidArrayException e) {
            System.out.println("Invalid arguments!");
        }
        */

        int a, b, c, d;
        a = View.readInteger("Input a: ");
        b = View.readInteger("Input b: ");
        c = View.readInteger("Input c: ");
        d = View.readInteger("Input d: ");

        System.out.println(Unit.isFourNumbersHaveAtLeastTwoEvenNumbers(a, b, c, d));

    }
}
