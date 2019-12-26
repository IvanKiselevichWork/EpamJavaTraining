package by.javatr.task1.runner;

import by.javatr.scanner.CustomScanner;
import by.javatr.scanner.exception.DataNotFoundException;
import by.javatr.scanner.exception.DataSourceException;
import by.javatr.task1.unit.Unit;

/**
 * 1.  Написать  программу,  позволяющую  по  последней  цифре  числа  определить  последнюю  цифру  его
 * квадрата.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Input integer");
        int number;
        try {
            number = CustomScanner.readInteger(System.in);
        } catch (DataNotFoundException | DataSourceException e) {
            System.out.println("Input error!");
            return;
        }

        int lastDigit = Unit.getLastDigit(number);

        int lastDigitOfSqr = Unit.getLastDigitOfSqr(lastDigit);
        System.out.println("Last digit of sqr = " + lastDigitOfSqr);
    }
}
