package com.example.how_lunch.service;

/**
 * 최초생성 2024.07.22 - 김재근
 *
 * */

public class UserServiceImpl implements UserService{

    @Override
    public void newUser() {}

    @Override
    public boolean login(String email, String password) {
        return false;
    }

    @Override
    public int changePassword(String email, String cPassword, String nPassword) {
        return 0;
    }
}
