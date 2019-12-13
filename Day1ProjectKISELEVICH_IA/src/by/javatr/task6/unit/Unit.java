package by.javatr.task6.unit;

import by.javatr.task6.entity.Timestamp;
import by.javatr.task6.unit.exception.InvalidSecondException;

public class Unit {
    //todo test
    public static Timestamp getTimestampFromSecond(int second) throws InvalidSecondException {
        if (second < 1) {
            throw new InvalidSecondException("Invalid second argument, must be second >= 1");
        }

        second--;

        int hours = second / Timestamp.SECONDS_PER_HOUR;
        second -= hours * Timestamp.SECONDS_PER_HOUR;
        int minutes = second / Timestamp.SECONDS_PER_MINUTE;
        second -= minutes * Timestamp.SECONDS_PER_MINUTE;

        return new Timestamp(hours, minutes, second);
    }
}
