package main.java.by.javatr.finance.bean;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Record implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String userLogin;
    private String cause;
    private LocalDateTime date;
    private double amount;

    public Record() {

    }

    public Record(int id, String userLogin, String cause, LocalDateTime date, double amount) {
        this.id = id;
        this.userLogin = userLogin;
        this.cause = cause;
        this.date = date;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserLogin() {
        return userLogin;
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

    public double getAmount() {
        return amount;
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
        return  id == r.id
                && userLogin.equals(r.userLogin)
                && cause.equals(r.cause)
                && date.equals(r.date)
                && Double.compare(amount, r.amount) == 0;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;
        hash = prime * hash + id;
        hash = prime * hash + (userLogin == null ? 0 : userLogin.hashCode());
        hash = prime * hash + (cause == null ? 0 : cause.hashCode());
        hash = prime * hash + (date == null ? 0 : date.hashCode());
        long amountLong = Double.doubleToLongBits(amount);
        hash = prime * hash + (int)(amountLong^(amountLong>>>32));
        return hash;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": "
                + "id = " + id
                + ", cause = " + cause
                + ", date = " + date
                + ", amount = " + amount;
    }
}
