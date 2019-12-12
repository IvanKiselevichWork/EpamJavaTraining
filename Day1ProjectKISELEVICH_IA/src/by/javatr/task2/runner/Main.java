package by.javatr.task2.runner;

import by.javatr.scanner.CustomScanner;
import by.javatr.scanner.exception.CustomScannerException;
import by.javatr.task2.unit.Unit;
import by.javatr.task2.unit.exception.InvalidMonthException;
import by.javatr.task2.unit.exception.InvalidYearException;

import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.util.Date;

/**
 * 2.  Составить программу, которая по заданным году и номеру месяца определяет количество дней в этом
 * месяце и корректно определялись все високосные года.
 */
public class Main {
    public static void main(String[] args) {

        int year;
        System.out.println("Input year");
        try {
            year = CustomScanner.readInteger(System.in);
        } catch (CustomScannerException e) {
            System.out.println("Input error!");
            return;
        }

        int month;
        System.out.println("Input month number");
        try {
            month = CustomScanner.readInteger(System.in);
        } catch (CustomScannerException e) {
            System.out.println("Input error!");
            return;
        }

        int daysInMonth;
        boolean isYearLeap;
        try {
            daysInMonth = Unit.getDaysInMonth(year, month);
            isYearLeap = Unit.isYearLeap(year);
        } catch (InvalidYearException e) {
            System.out.println("Invalid year");
            return;
        } catch (InvalidMonthException e) {
            System.out.println("Invalid month");
            return;
        }

        System.out.println("Days count = " + daysInMonth);
        System.out.println("Is year leap = " + isYearLeap);
    }
}
