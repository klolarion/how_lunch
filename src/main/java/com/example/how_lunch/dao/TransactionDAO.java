package com.example.how_lunch.dao;

import com.example.how_lunch.model.Transaction;

import java.util.List;

/**
 * 최초생성 2024.07.22 - 김재근
 *
 * */

public interface TransactionDAO {
    int transfer(long userId, double amount, String myAccountNum, String targetAccountNum);

    int withdraw(long userId, String accountNumber, double amount);

    int deposit(long userId, String accountNumber, double amount);

    List<Transaction> getAccountTransactions(long usrId, String accountNumber);
    List<Transaction> getMyAllTransactions(long userId);


}
