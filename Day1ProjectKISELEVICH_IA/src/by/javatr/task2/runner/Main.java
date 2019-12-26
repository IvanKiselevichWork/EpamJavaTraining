package by.javatr.task2.runner;

import by.javatr.task2.unit.Unit;
import by.javatr.task2.unit.exception.InvalidMonthException;
import by.javatr.task2.unit.exception.InvalidYearException;
import by.javatr.view.View;

/**
 * 2.  Составить программу, которая по заданным году и номеру месяца определяет количество дней в этом
 * месяце и корректно определялись все високосные года.
 */
public class Main {
    public static void main(String[] args) {

        // changes:
        //  removed repetition

        int year = View.readInteger("Input year");
        int month = View.readInteger("Input month number");

        /*
        try {
            System.out.println("Input year");
            year = CustomScanner.readInteger(System.in);

            System.out.println("Input month number");
            month = CustomScanner.readInteger(System.in);
        } catch (DataNotFoundException | DataSourceException e) {
            System.out.println("Input error!");
            return;
        }
         */

        try {
            int daysInMonth = Unit.getDaysInMonth(year, month);
            boolean isYearLeap = Unit.isYearLeap(year);
            System.out.println("Days count = " + daysInMonth);
            System.out.println("Is year leap = " + isYearLeap);
        } catch (InvalidYearException e) {
            System.out.println("Invalid year");
        } catch (InvalidMonthException e) {
            System.out.println("Invalid month");
        }

    }
}
