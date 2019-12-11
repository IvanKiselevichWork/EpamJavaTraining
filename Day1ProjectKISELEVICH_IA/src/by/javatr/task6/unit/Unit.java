package by.javatr.task6.unit;

import by.javatr.task6.entity.Timestamp;

public class Unit {
    public static Timestamp getTimestampFromSecond(int second) {
        second--;

        int hours = second / Timestamp.SECONDS_PER_HOUR;
        second -= hours * Timestamp.SECONDS_PER_HOUR;
        int minutes = second / Timestamp.SECONDS_PER_MINUTE;
        second -= minutes * Timestamp.SECONDS_PER_MINUTE;

        return new Timestamp(hours, minutes, second);
    }
}
