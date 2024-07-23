package com.example.how_lunch.model;

import java.sql.Date;
import java.time.LocalDateTime;

/**
 * 최초생성 2024.07.22 - 김재근
 *
 * */

public class Transaction {
    private long transactionId;
    private long userId;
    private String type;
    private double amount;
    private String mainAccount;
    private String targetAccount;
    private LocalDateTime regDate;

    public Transaction(long userId, String type, double amount, String mainAccount, String targetAccount) {
        this.userId = userId;
        this.type = type;
        this.amount = amount;
        this.mainAccount = mainAccount;
        this.targetAccount = targetAccount;
    }

    public Transaction(long transactionId, long userId, String type, double amount, String mainAccount, String targetAccount, LocalDateTime regDate) {
        this.transactionId = transactionId;
        this.userId = userId;
        this.type = type;
        this.amount = amount;
        this.mainAccount = mainAccount;
        this.targetAccount = targetAccount;
        this.regDate = regDate;
    }

    public Transaction() {}

    public long getTransactionId() {
        return transactionId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getMainAccount() {
        return mainAccount;
    }

    public void setMainAccount(String mainAccount) {
        this.mainAccount = mainAccount;
    }

    public String getTargetAccount() {
        return targetAccount;
    }

    public void setTargetAccount(String targetAccount) {
        this.targetAccount = targetAccount;
    }

    public LocalDateTime getTime() {
        return regDate;
    }
}
