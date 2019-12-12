package by.javatr.task5.runner;

import by.javatr.scanner.CustomScanner;
import by.javatr.scanner.exception.CustomScannerException;
import by.javatr.task5.unit.Unit;
import by.javatr.task5.unit.exception.InvalidPerfectNumberException;

/**
 * 5.  Составить программу, печатающую значение true, если указанное высказывание является истинным, и
 * false  —  в противном  случае:  является  ли  целое  число  совершенным  (сумма  делителей  равна  самому
 * числу).
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Input integer: ");
        int number;
        try {
            number = CustomScanner.readInteger(System.in);
        } catch (CustomScannerException e) {
            System.out.println("Input error!");
            return;
        }

        try {
            System.out.println(Unit.isNumberPerfect(number));
        } catch (InvalidPerfectNumberException e) {
            System.out.println("Invalid argument!");
        }
    }
}
