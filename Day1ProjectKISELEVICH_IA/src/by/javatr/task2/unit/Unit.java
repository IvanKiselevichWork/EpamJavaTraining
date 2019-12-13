package by.javatr.task2.unit;

import by.javatr.task2.unit.exception.InvalidMonthException;
import by.javatr.task2.unit.exception.InvalidYearException;

import java.time.DateTimeException;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;

public class Unit {

    public static int getDaysInMonth(int year, int month) throws InvalidYearException, InvalidMonthException {
        Month month1;
        try {
            month1 = Month.of(month);
        } catch (DateTimeException e) {
            throw new InvalidMonthException(e);
        }
        YearMonth yearMonth;
        try {
            yearMonth = YearMonth.of(year, month1);
        } catch (DateTimeException e) {
            throw new InvalidYearException(e);
        }
        return yearMonth.lengthOfMonth();
    }

    public static boolean isYearLeap(int year) throws InvalidYearException {
        Year year1;
        try {
            year1 = Year.of(year);
            return year1.isLeap();
        } catch (DateTimeException e) {
            throw new InvalidYearException(e);
        }
    }
}
