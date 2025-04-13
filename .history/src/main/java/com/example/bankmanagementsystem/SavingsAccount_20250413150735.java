package com.example.bankmanagementsystem;

public class SavingsAccount extends AbstractAccount {
    private static final double MINIMUM_BALANCE = 100.0;
    private static final double INTEREST_RATE = 0.02; // 2% annual interest

    public SavingsAccount(String accountNumber, double initialBalance) {
        super(accountNumber, initialBalance, "Savings");
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
        return balance * INTEREST_RATE / 12; // Monthly interest
    }

    @Override
    public boolean isWithdrawalAllowed(double amount) {
        return amount > 0 && (balance - amount) >= MINIMUM_BALANCE;
    }

    @Override
    public double getAvailableBalance() {
        return balance - MINIMUM_BALANCE;
    }

    public void applyMonthlyInterest() {
        double interest = calculateInterest();
        balance += interest;
        addTransaction("Interest", interest);
    }
} 