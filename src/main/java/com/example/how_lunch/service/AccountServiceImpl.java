package com.example.how_lunch.service;

import com.example.how_lunch.dao.AccountDAO;
import com.example.how_lunch.dao.AccountDAOImpl;
import com.example.how_lunch.dao.TransactionDAO;
import com.example.how_lunch.dao.TransactionDAOImpl;
import com.example.how_lunch.dto.UserInfoDto;
import com.example.how_lunch.model.Transaction;

import java.util.List;

/**
 * 최초생성 2024.07.22 - 김재근
 * 페이징 추가 2024.07.23 - 김재근
 * */

public class AccountServiceImpl implements AccountService{
    private AccountDAO accountDAO = new AccountDAOImpl();
    private TransactionDAO transactionDAO = new TransactionDAOImpl();

    @Override
    public void newAccount(long userId, String accountNumber) {
        accountDAO.newAccount(userId, accountNumber);
    }

    @Override
    public List<UserInfoDto> getAllAccounts(long userId) {
        return accountDAO.getAllAccounts(userId);
    }

    @Override
    public UserInfoDto getAccount(long id, String accountNumber) {
        return accountDAO.getAccount(id, accountNumber);
    }

    @Override
    public List<Transaction> getAccountTransactions(long userId, String accountNumber, int page, int pageSize, String order) {
        return transactionDAO.getAccountTransactions(userId, accountNumber, page, pageSize, order);
    }
    @Override
    public List<Transaction> getMyAllTransactions(long userId, int page, int pageSize, String order) {
        return transactionDAO.getMyAllTransactions(userId, page, pageSize, order);
    }

    @Override
    public int getMyTransactionCount(long userId) {
        return transactionDAO.getMyTransactionCount(userId);
    }

    @Override
    public int getAccountTransactionCount(long userId, String accountNumber) {
        return transactionDAO.getAccountTransactionCount(userId, accountNumber);
    }


}
