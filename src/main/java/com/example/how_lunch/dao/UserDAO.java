package com.example.how_lunch.dao;

import com.example.how_lunch.model.Users;

/**
 * 최초생성 2024.07.22 - 김재근
 *
 * */

public interface UserDAO {
    void newUser(Users user);
    boolean login(String email, String password);
    int changePassword(String username, String cPassword, String nPassword);
}
