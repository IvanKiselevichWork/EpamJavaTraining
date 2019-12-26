package by.javatr.task7.entity;

public class BirthdayData {
    private final String dayOfWeek;
    private final int fullYears;
    private final boolean isBirthdayToday;


    public BirthdayData(String dayOfWeek, int fullYears, boolean isBirthdayToday) {
        this.dayOfWeek = dayOfWeek;
        this.fullYears = fullYears;
        this.isBirthdayToday = isBirthdayToday;
    }


    public String getDayOfWeek() {
        return this.dayOfWeek;
    }

    public int getFullYears() {
        return this.fullYears;
    }

    public boolean isBirthdayToday() {
        return this.isBirthdayToday;
    }

}