package by.javatr.finance.entity;

import by.javatr.finance.entity.exception.InvalidCauseException;
import by.javatr.finance.entity.exception.InvalidDateException;
import by.javatr.finance.entity.exception.RecordExceptionMessages;

import java.time.LocalDateTime;

public class Record {
    private long userId;
    private String cause;
    private LocalDateTime date;
    private double amount;

    public Record(long userId, String cause, LocalDateTime date, double amount) throws InvalidDateException, InvalidCauseException {
        if (cause == null) {
            throw new InvalidCauseException(RecordExceptionMessages.causeIsNull);
        }
        if (date == null) {
            throw new InvalidDateException(RecordExceptionMessages.dateIsNull);
        }
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

    public void setCause(String cause) throws InvalidCauseException {
        if (cause == null) {
            throw new InvalidCauseException(RecordExceptionMessages.causeIsNull);
        }
        this.cause = cause;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) throws InvalidDateException {
        if (date == null) {
            throw new InvalidDateException(RecordExceptionMessages.dateIsNull);
        }
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        Record r = (Record)o;
        return userId == r.userId
                && cause.equals(r.cause)
                && date.equals(r.date)
                && Double.compare(amount, r.amount) == 0;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = prime + (int)(userId^(userId>>>32));
        hash = prime * hash + (cause == null ? 0 : cause.hashCode());
        hash = prime * hash + (date == null ? 0 : date.hashCode());
        long amountLong = Double.doubleToLongBits(amount);
        hash = prime * hash + (int)(amountLong^(amountLong>>>32));
        return hash;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": "
                + "user id = " + userId
                + ", cause = " + cause
                + ", date = " + date
                + ", amount = " + amount;
    }
}
