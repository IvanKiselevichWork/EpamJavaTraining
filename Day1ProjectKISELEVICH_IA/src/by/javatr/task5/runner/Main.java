package by.javatr.task5.runner;

import by.javatr.scanner.CustomScanner;
import by.javatr.scanner.exception.DataNotFoundException;
import by.javatr.scanner.exception.DataSourceException;
import by.javatr.task5.unit.Unit;

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
        } catch (DataNotFoundException | DataSourceException e) {
            System.out.println("Input error!");
            return;
        }

        System.out.println(Unit.isNumberPerfect(number));
    }
}
