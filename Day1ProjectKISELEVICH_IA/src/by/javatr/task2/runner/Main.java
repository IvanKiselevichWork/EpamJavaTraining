package by.javatr.task2.runner;

import by.javatr.scanner.CustomScanner;
import by.javatr.task2.unit.Unit;

import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        int year = 0;
        do {
            System.out.println("Input year");
            year = CustomScanner.readInteger(System.in);
        }
        while(year < Year.MIN_VALUE || year > Year.MAX_VALUE);


        int month = 0;
        do {
            System.out.println("Input month");
            month = CustomScanner.readInteger(System.in);
        }
        while(month < 1 || month > 12);

        int daysInMonth = Unit.getDaysInMonth(year, month);

        System.out.println("Days count = " + daysInMonth);
    }
}
