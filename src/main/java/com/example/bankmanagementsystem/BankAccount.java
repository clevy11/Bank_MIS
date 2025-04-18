package com.example.bankmanagementsystem;

import javafx.scene.control.Alert;

public interface BankAccount {

    void deposit(double amount);
    boolean withdraw(double amount);
    double getBalance();
    String getAccountNumber();
    String getAccountType();
    String getLastNTransactions(int n);
    void addTransaction(String type, double amount);
    double calculateInterest();
    boolean isWithdrawalAllowed(double amount);
    double getAvailableBalance();
    void showAlert(String title, String content);
} 