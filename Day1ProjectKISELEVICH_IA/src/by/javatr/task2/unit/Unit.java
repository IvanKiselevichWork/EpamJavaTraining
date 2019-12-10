package by.javatr.task2.unit;

import java.time.YearMonth;

public class Unit {
    public static int getDaysInMonth(int year, int month) {
        YearMonth yearMonth = YearMonth.of(year,month);
        return yearMonth.lengthOfMonth();
    }
}
