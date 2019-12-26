package by.javatr.task2.unit;

import by.javatr.task2.unit.exception.InvalidMonthException;
import by.javatr.task2.unit.exception.InvalidYearException;

import java.time.DateTimeException;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;

public class Unit {

    // fix variable naming (year1, month1)
    public static int getDaysInMonth(int year, int monthNumber) throws InvalidYearException, InvalidMonthException {
        Month month;
        try {
            month = Month.of(monthNumber);
        } catch (DateTimeException e) {
            throw new InvalidMonthException(e);
        }
        YearMonth yearMonth;
        try {
            yearMonth = YearMonth.of(year, month);
        } catch (DateTimeException e) {
            throw new InvalidYearException(e);
        }
        return yearMonth.lengthOfMonth();
    }

    public static boolean isYearLeap(int yearNumber) throws InvalidYearException {
        Year year;
        try {
            year = Year.of(yearNumber);
            return year.isLeap();
        } catch (DateTimeException e) {
            throw new InvalidYearException(e);
        }
    }
}
