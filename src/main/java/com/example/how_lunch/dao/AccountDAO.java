package com.example.how_lunch.dao;

import com.example.how_lunch.dto.UserInfoDto;

import java.util.List;

/**
 * 최초생성 2024.07.22 - 김재근
 *
 * */

public interface AccountDAO {
    List<UserInfoDto> getAllAccounts(long userId);

    UserInfoDto getAccount(long userId, String accountNumber);

    void newAccount(long userId, String accountNumber);
}
