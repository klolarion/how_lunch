package com.example.how_lunch.service;

/**
 * 최초생성 2024.07.22 - 김재근
 *
 * */

public interface BankService {
    int deposit(long userId, String accountNumber, double amount);

    int withdraw(long userid, String accountNumber, double amount);

    int transfer(long userId, double amount, String myAccountNum, String targetAccountNum);
}
