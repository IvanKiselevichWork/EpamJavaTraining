package by.javatr.task7.entity;

public class BirthdayData {
    private String dayOfWeek;
    private int fullYears;
    private boolean isBirthdayToday;


    public BirthdayData(String dayOfWeek, int fullYears, boolean isBirthdayToday) {
        this.dayOfWeek = dayOfWeek;
        this.fullYears = fullYears;
        this.isBirthdayToday = isBirthdayToday;
    }


    public String getDayOfWeek() {
        return this.dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public int getFullYears() {
        return this.fullYears;
    }

    public void setFullYears(int fullYears) {
        this.fullYears = fullYears;
    }

    public boolean isIsBirthdayToday() {
        return this.isBirthdayToday;
    }

    public boolean getIsBirthdayToday() {
        return this.isBirthdayToday;
    }

    public void setIsBirthdayToday(boolean isBirthdayToday) {
        this.isBirthdayToday = isBirthdayToday;
    }

}