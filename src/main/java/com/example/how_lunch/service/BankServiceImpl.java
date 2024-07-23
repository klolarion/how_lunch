package com.example.how_lunch.service;

import com.example.how_lunch.dao.TransactionDAO;
import com.example.how_lunch.dao.TransactionDAOImpl;

/**
 * 최초생성 2024.07.22 - 김재근
 *
 * */

public class BankServiceImpl implements BankService{

    private TransactionDAO transactionDAO= new TransactionDAOImpl();

    @Override
    public int deposit(long userId, String accountNumber, double amount) {
        return transactionDAO.deposit(userId, accountNumber, amount);
    }

    @Override
    public int withdraw(long userId, String accountNumber, double amount) {
        return transactionDAO.withdraw(userId, accountNumber, amount);
    }

    @Override
    public int transfer(long userId, double amount, String myAccountNum, String targetAccountNum) {
        return transactionDAO.transfer(userId, amount, myAccountNum, targetAccountNum);
    }


}
