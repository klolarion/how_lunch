package com.example.how_lunch.service;

import com.example.how_lunch.dto.UserInfoDto;
import com.example.how_lunch.model.Transaction;

import java.util.List;

/**
 * 최초생성 2024.07.22 - 김재근
 *
 * */

public interface AccountService {

    void newAccount(long userId, String accountNumber);

    List<UserInfoDto> getAllAccounts(long id);
    UserInfoDto getAccount(long id, String accountNumber);
    List<Transaction> getAccountTransactions(long userId, String accountNumber);
    List<Transaction> getMyAllTransactions(long userId);
}