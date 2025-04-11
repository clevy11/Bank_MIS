package com.example.bankmanagementsystem.models;

import com.example.bankmanagementsystem.interfaces.BankAccountOperations;
import com.example.bankmanagementsystem.interfaces.BankAccountOperations.InsufficientFundsException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class FixedDepositAccount extends Account {
    private static final double INTEREST_RATE = 0.05; // 5% annual interest
    private final LocalDate maturityDate;
    private final LocalDate startDate;
    private final int termMonths;

    public FixedDepositAccount(String accountHolderName, double initialBalance, int termMonths) {
        super(accountHolderName, initialBalance);
        this.termMonths = termMonths;
        this.startDate = LocalDate.now();
        this.maturityDate = startDate.plusMonths(termMonths);
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (LocalDate.now().isBefore(maturityDate)) {
            throw new InsufficientFundsException("Cannot withdraw before maturity date");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds");
        }
        balance -= amount;
        addTransaction(new Transaction(accountNumber, amount, TransactionType.WITHDRAWAL, "Withdrawal after maturity"));
    }

    public void calculateInterest() {
        long monthsPassed = ChronoUnit.MONTHS.between(startDate, LocalDate.now());
        if (monthsPassed > 0) {
            double interest = balance * INTEREST_RATE * monthsPassed / 12;
            balance += interest;
            addTransaction(new Transaction(accountNumber, interest, TransactionType.INTEREST, "Fixed Deposit Interest"));
        }
    }

    public LocalDate getMaturityDate() {
        return maturityDate;
    }

    public int getTermMonths() {
        return termMonths;
    }
} 