package com.example.how_lunch.service;

import com.example.how_lunch.dto.UserInfoDto;
import com.example.how_lunch.model.Transaction;
import com.example.how_lunch.model.Users;

import java.util.List;

/**
 * 최초생성 2024.07.22 - 김재근
 * 페이징 추가 2024.07.23 - 김재근
 * */

public interface AccountService {

    void newAccount(long userId, String accountNumber);
    List<UserInfoDto> getAllAccounts(long id);
    String getUserInfo(long id);
    UserInfoDto getAccount(long id, String accountNumber);
    List<Transaction> getAccountTransactions(long userId, String accountNumber, int page, int pageSize, String order);
    List<Transaction> getMyAllTransactions(long userId, int page, int pageSize, String order);
    int getMyTransactionCount(long userId);
    int getAccountTransactionCount(long userId, String accountNumber);
}
