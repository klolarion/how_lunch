package com.example.how_lunch.dao;

/**
 * 최초생성 2024.07.22 - 김재근
 *
 * */

public interface UserDAO {
    void newUser(String username, String email, String password);
    void login(String email, String password);
    int changePassword(String username, String cPassword, String nPassword);


}
