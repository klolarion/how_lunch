package com.example.how_lunch.model;

import java.util.List;

/**
 * 최초생성 2024.07.22 - 김재근
 *
 * */

public class Users {
    private long userId;
    private String email;
    private String password;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private List<Account> myAccounts;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Account> getMyAccounts() {
        return myAccounts;
    }

    public void setMyAccounts(List<Account> myAccounts) {
        this.myAccounts = myAccounts;
    }
}
