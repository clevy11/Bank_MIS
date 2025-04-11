package com.example.bankmanagementsystem.interfaces;

import com.example.bankmanagementsystem.exceptions.InsufficientFundsException;
import com.example.bankmanagementsystem.models.Transaction;

public interface BankAccountOperations {
    void deposit(double amount);
    void withdraw(double amount) throws InsufficientFundsException;
    double getBalance();
    void addTransaction(Transaction transaction);
    String getAccountNumber();
}

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
} 