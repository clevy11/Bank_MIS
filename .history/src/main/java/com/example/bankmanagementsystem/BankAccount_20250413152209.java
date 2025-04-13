package com.example.bankmanagementsystem;

import javafx.scene.control.Alert;

public interface BankAccount {
    // Core banking operations
    void deposit(double amount);
    boolean withdraw(double amount);
    double getBalance();
    
    // Account information
    String getAccountNumber();
    String getAccountType();
    
    // Transaction history
    String getLastNTransactions(int n);
    void addTransaction(String type, double amount);
    
    // Account-specific features
    double calculateInterest();
    boolean isWithdrawalAllowed(double amount);
    double getAvailableBalance();

    // Alert handling
    void showAlert(String title, String content);
} 