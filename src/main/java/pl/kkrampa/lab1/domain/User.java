package pl.kkrampa.lab1.domain;

import java.io.Serializable;

public class User implements Serializable {

    private String login;

    private String password;

    private transient String rpassword;

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

    public String getRpassword() {
        return rpassword;
    }

    public void setRpassword(String rpassword) {
        this.rpassword = rpassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", rpassword='" + rpassword + '\'' +
                '}';
    }
}
