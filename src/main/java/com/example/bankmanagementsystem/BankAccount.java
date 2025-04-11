package com.example.bankmanagementsystem;

public interface BankAccount {
    void deposit(double amount);
    boolean withdraw(double amount);
    double getBalance();
    String getAccountNumber();
    String getAccountType();
    String getLastNTransactions(int n);
} 