package com.example.how_lunch.service;

/**
 * 최초생성 2024.07.22 - 김재근
 *
 * */

public interface UserService {
    void newUser();
    boolean login(String email, String password);
    int changePassword(String email, String cPassword, String nPassword);

}
