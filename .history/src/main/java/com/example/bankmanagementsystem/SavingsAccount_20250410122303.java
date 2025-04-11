package com.example.bankmanagementsystem;

public class SavingsAccount extends AbstractAccount {
    private static final double MINIMUM_BALANCE = 100.0;
    private static final double INTEREST_RATE = 0.02; // 2% annual interest

    public SavingsAccount(String accountNumber, double initialBalance) {
        super(accountNumber, initialBalance, "Savings");
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && (balance - amount) >= MINIMUM_BALANCE) {
            balance -= amount;
            transactionHistory.add(new Transaction("Withdrawal", amount));
            return true;
        }
        return false;
    }

    public void calculateInterest() {
        double interest = balance * INTEREST_RATE / 12; // Monthly interest
        balance += interest;
        transactionHistory.add(new Transaction("Interest", interest));
    }
} 