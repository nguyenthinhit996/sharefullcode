package com.sharefullcode.blopot.backendsavetoken.components;

import java.io.Serializable;

public class LoginPojo implements Serializable {
    private String username;
    private String password;

    public LoginPojo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public LoginPojo() {
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
