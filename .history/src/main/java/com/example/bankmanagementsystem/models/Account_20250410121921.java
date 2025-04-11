package com.example.bankmanagementsystem.models;

import com.example.bankmanagementsystem.interfaces.BankAccountOperations;
import java.util.LinkedList;

public abstract class Account implements BankAccountOperations {
    protected String accountNumber;
    protected double balance;
    protected String accountHolderName;
    protected LinkedList<Transaction> transactionHistory;
    protected static int accountCounter = 1000;

    public Account(String accountHolderName, double initialBalance) {
        this.accountNumber = generateAccountNumber();
        this.balance = initialBalance;
        this.accountHolderName = accountHolderName;
        this.transactionHistory = new LinkedList<>();
    }

    private String generateAccountNumber() {
        return "ACC" + (++accountCounter);
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
        addTransaction(new Transaction(accountNumber, amount, TransactionType.DEPOSIT, "Deposit"));
    }

    @Override
    public abstract void withdraw(double amount) throws InsufficientFundsException;

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void addTransaction(Transaction transaction) {
        transactionHistory.addFirst(transaction);
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public LinkedList<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public LinkedList<Transaction> getLastNTransactions(int n) {
        LinkedList<Transaction> lastN = new LinkedList<>();
        int count = 0;
        for (Transaction transaction : transactionHistory) {
            if (count >= n) break;
            lastN.add(transaction);
            count++;
        }
        return lastN;
    }
} 