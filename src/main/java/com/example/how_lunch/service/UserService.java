package com.example.how_lunch.service;

import com.example.how_lunch.model.Users;

import java.util.Map;

/**
 * 최초생성 2024.07.22 - 김재근
 *
 * */

public interface UserService {
    void newUser(Users user);
    Map<String, String> login(String email, String password);
    int changePassword(String email, String cPassword, String nPassword);

}
