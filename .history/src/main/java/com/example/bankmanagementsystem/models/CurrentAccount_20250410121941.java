package com.example.bankmanagementsystem.models;

import com.example.bankmanagementsystem.interfaces.BankAccountOperations;
import com.example.bankmanagementsystem.interfaces.BankAccountOperations.InsufficientFundsException;

public class CurrentAccount extends Account {
    private static final double OVERDRAFT_LIMIT = 1000.0;

    public CurrentAccount(String accountHolderName, double initialBalance) {
        super(accountHolderName, initialBalance);
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (balance - amount < -OVERDRAFT_LIMIT) {
            throw new InsufficientFundsException("Withdrawal would exceed overdraft limit");
        }
        balance -= amount;
        addTransaction(new Transaction(accountNumber, amount, TransactionType.WITHDRAWAL, "Withdrawal"));
    }
} 