package by.javatr.finance.entity;

import java.time.LocalDateTime;

public class Record {
    private long userId;
    private String cause;
    private LocalDateTime date;
    private double amount;

    public Record(long userId, String cause, LocalDateTime date, double amount) {
        this.userId = userId;
        this.cause = cause;
        this.date = date;
        this.amount = amount;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
