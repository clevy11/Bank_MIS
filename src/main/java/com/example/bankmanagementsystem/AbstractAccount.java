package com.example.bankmanagementsystem;

import java.util.LinkedList;

public abstract class AbstractAccount implements BankAccount {
    protected String accountNumber;
    protected double balance;
    protected LinkedList<Transaction> transactionHistory;
    protected String accountType;

    public AbstractAccount(String accountNumber, double initialBalance, String accountType) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.accountType = accountType;
        this.transactionHistory = new LinkedList<>();
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add(new Transaction("Deposit", amount));
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String getAccountType() {
        return accountType;
    }

    public LinkedList<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public String getLastNTransactions(int n) {
        StringBuilder result = new StringBuilder();
        int count = Math.min(n, transactionHistory.size());
        for (int i = transactionHistory.size() - 1; i >= transactionHistory.size() - count; i--) {
            result.append(transactionHistory.get(i)).append("\n");
        }
        return result.toString();
    }
} 