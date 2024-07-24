package com.example.how_lunch.service;

import com.example.how_lunch.dao.UserDAO;
import com.example.how_lunch.dao.UserDAOImpl;
import com.example.how_lunch.model.Users;

import java.util.Map;

/**
 * 최초생성 2024.07.22 - 김재근
 *
 * */

public class UserServiceImpl implements UserService{
    private UserDAO userDAO = new UserDAOImpl();

    @Override
    public void newUser(Users user) {
        userDAO.newUser(user);
    }

    @Override
    public Map<String, String> login(String email, String password) {
        return userDAO.login(email, password);
    }

    @Override
    public int changePassword(String email, String cPassword, String nPassword) {
        return 0;
    }
}
