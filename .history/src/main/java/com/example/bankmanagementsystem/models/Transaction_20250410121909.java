package com.example.bankmanagementsystem.models;

import java.time.LocalDateTime;

public class Transaction {
    private final String transactionId;
    private final String accountNumber;
    private final double amount;
    private final TransactionType type;
    private final LocalDateTime timestamp;
    private final String description;

    public Transaction(String accountNumber, double amount, TransactionType type, String description) {
        this.transactionId = generateTransactionId();
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.type = type;
        this.timestamp = LocalDateTime.now();
        this.description = description;
    }

    private String generateTransactionId() {
        return "TXN" + System.currentTimeMillis();
    }

    // Getters
    public String getTransactionId() { return transactionId; }
    public String getAccountNumber() { return accountNumber; }
    public double getAmount() { return amount; }
    public TransactionType getType() { return type; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public String getDescription() { return description; }

    @Override
    public String toString() {
        return String.format("[%s] %s - %s: $%.2f - %s", 
            timestamp, transactionId, type, amount, description);
    }
}

enum TransactionType {
    DEPOSIT,
    WITHDRAWAL,
    INTEREST
} 