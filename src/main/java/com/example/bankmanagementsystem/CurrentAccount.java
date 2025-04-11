package com.example.bankmanagementsystem;

public class CurrentAccount extends AbstractAccount {
    private static final double OVERDRAFT_LIMIT = 500.0;

    public CurrentAccount(String accountNumber, double initialBalance) {
        super(accountNumber, initialBalance, "Current");
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && (balance - amount) >= -OVERDRAFT_LIMIT) {
            balance -= amount;
            transactionHistory.add(new Transaction("Withdrawal", amount));
            return true;
        }
        return false;
    }
} 