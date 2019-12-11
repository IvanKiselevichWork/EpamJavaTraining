package by.javatr.task6.entity;

public class Timestamp {

    public static final int SECONDS_PER_HOUR = 3600;
    public static final int SECONDS_PER_MINUTE = 60;

    private int hours;
    private int minutes;
    private int seconds;

    public Timestamp(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }
}
