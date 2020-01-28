package main.java.by.javatr.finance.bean;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String login;
    private String password;

    public User() {

    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        User u = (User)o;
        return  login.equals(u.login)
                && password.equals(u.password);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;
        hash = prime * hash + (login == null ? 0 : login.hashCode());
        hash = prime * hash + (password == null ? 0 : password.hashCode());
        return hash;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": "
                + "login = " + login
                + ", password = " + password;
    }
}
