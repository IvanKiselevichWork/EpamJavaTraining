package by.javatr.finance.entity;

import by.javatr.finance.entity.exception.RecordException;
import by.javatr.finance.entity.exception.RecordExceptionMessages;

import java.time.LocalDateTime;

public class Record {
    private String userLogin;
    private String cause;
    private LocalDateTime date;
    private double amount;

    public Record(String userLogin, String cause, LocalDateTime date, double amount) throws RecordException {
        if (cause == null) {
            throw new RecordException(RecordExceptionMessages.causeIsNull);
        }
        if (date == null) {
            throw new RecordException(RecordExceptionMessages.dateIsNull);
        }
        this.userLogin = userLogin;
        this.cause = cause;
        this.date = date;
        this.amount = amount;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) throws RecordException {
        if (cause == null) {
            throw new RecordException(RecordExceptionMessages.causeIsNull);
        }
        this.cause = cause;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) throws RecordException {
        if (date == null) {
            throw new RecordException(RecordExceptionMessages.dateIsNull);
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
        return userLogin.equals(r.userLogin)
                && cause.equals(r.cause)
                && date.equals(r.date)
                && Double.compare(amount, r.amount) == 0;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = prime + (userLogin == null ? 0 : userLogin.hashCode());
        hash = prime * hash + (cause == null ? 0 : cause.hashCode());
        hash = prime * hash + (date == null ? 0 : date.hashCode());
        long amountLong = Double.doubleToLongBits(amount);
        hash = prime * hash + (int)(amountLong^(amountLong>>>32));
        return hash;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": "
                + "user id = " + userLogin
                + ", cause = " + cause
                + ", date = " + date
                + ", amount = " + amount;
    }
}
