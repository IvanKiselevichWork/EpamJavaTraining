package by.javatr.task6.unit;

import java.util.Calendar;

public class Unit {
    public static Calendar getResultDate(int duration) {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.DATE, duration);
        return now;
    }
}