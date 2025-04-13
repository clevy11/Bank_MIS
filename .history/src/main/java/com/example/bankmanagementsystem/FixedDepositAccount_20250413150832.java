package com.example.bankmanagementsystem;

import java.time.LocalDate;

public class FixedDepositAccount extends AbstractAccount {
    private static final double INTEREST_RATE = 0.05; // 5% annual interest
    private LocalDate maturityDate;
    private boolean isMatured;
    private final int termMonths;

    public FixedDepositAccount(String accountNumber, double initialBalance, int months) {
        super(accountNumber, initialBalance, "Fixed Deposit");
        this.termMonths = months;
        this.maturityDate = LocalDate.now().plusMonths(months);
        this.isMatured = false;
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
        return balance * INTEREST_RATE * termMonths / 12;
    }

    @Override
    public boolean isWithdrawalAllowed(double amount) {
        return isMatured && amount > 0 && amount <= balance;
    }

    @Override
    public double getAvailableBalance() {
        return isMatured ? balance : 0;
    }

    public void checkMaturity() {
        if (!isMatured && LocalDate.now().isAfter(maturityDate)) {
            isMatured = true;
            double interest = calculateInterest();
            balance += interest;
            addTransaction("Maturity Interest", interest);
        }
    }

    public LocalDate getMaturityDate() {
        return maturityDate;
    }

    public boolean isMatured() {
        return isMatured;
    }

    public int getTermMonths() {
        return termMonths;
    }
} 