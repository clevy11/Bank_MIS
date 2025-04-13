package com.example.bankmanagementsystem;

public class CurrentAccount extends AbstractAccount {
    private static final double OVERDRAFT_LIMIT = 500.0;

    public CurrentAccount(String accountNumber, double initialBalance) {
        super(accountNumber, initialBalance, "Current");
    }

    @Override
    public boolean withdraw(double amount) {
        if (isWithdrawalAllowed(amount)) {
            balance -= amount;
            addTransaction("Withdrawal", amount);
            return true;
        }
        return false;
    }

    @Override
    public double calculateInterest() {
        return 0; // Current accounts don't earn interest
    }

    @Override
    public boolean isWithdrawalAllowed(double amount) {
        return amount > 0 && (balance - amount) >= -OVERDRAFT_LIMIT;
    }

    @Override
    public double getAvailableBalance() {
        return balance + OVERDRAFT_LIMIT;
    }
} 