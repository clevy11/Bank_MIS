package com.example.bankmanagementsystem;

import java.time.LocalDate;

public class FixedDepositAccount extends AbstractAccount {
    private static final double INTEREST_RATE = 0.05; // 5% annual interest
    private LocalDate maturityDate;
    private boolean isMatured;

    public FixedDepositAccount(String accountNumber, double initialBalance, int months) {
        super(accountNumber, initialBalance, "Fixed Deposit");
        this.maturityDate = LocalDate.now().plusMonths(months);
        this.isMatured = false;
    }

    @Override
    public boolean withdraw(double amount) {
        if (isMatured && amount <= balance) {
            balance -= amount;
            transactionHistory.add(new Transaction("Withdrawal", amount));
            return true;
        }
        return false;
    }

    public void checkMaturity() {
        if (LocalDate.now().isAfter(maturityDate)) {
            isMatured = true;
            double interest = balance * INTEREST_RATE;
            balance += interest;
            transactionHistory.add(new Transaction("Maturity Interest", interest));
        }
    }

    public LocalDate getMaturityDate() {
        return maturityDate;
    }

    public boolean isMatured() {
        return isMatured;
    }
} 