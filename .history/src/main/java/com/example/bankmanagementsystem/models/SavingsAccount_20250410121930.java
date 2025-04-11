package com.example.bankmanagementsystem.models;

import com.example.bankmanagementsystem.interfaces.BankAccountOperations;
import com.example.bankmanagementsystem.interfaces.BankAccountOperations.InsufficientFundsException;

public class SavingsAccount extends Account {
    private static final double MINIMUM_BALANCE = 100.0;
    private static final double INTEREST_RATE = 0.02; // 2% annual interest

    public SavingsAccount(String accountHolderName, double initialBalance) {
        super(accountHolderName, initialBalance);
        if (initialBalance < MINIMUM_BALANCE) {
            throw new IllegalArgumentException("Initial balance must be at least $" + MINIMUM_BALANCE);
        }
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (balance - amount < MINIMUM_BALANCE) {
            throw new InsufficientFundsException("Withdrawal would violate minimum balance requirement");
        }
        balance -= amount;
        addTransaction(new Transaction(accountNumber, amount, TransactionType.WITHDRAWAL, "Withdrawal"));
    }

    public void calculateInterest() {
        double interest = balance * INTEREST_RATE / 12; // Monthly interest
        balance += interest;
        addTransaction(new Transaction(accountNumber, interest, TransactionType.INTEREST, "Monthly Interest"));
    }
} 