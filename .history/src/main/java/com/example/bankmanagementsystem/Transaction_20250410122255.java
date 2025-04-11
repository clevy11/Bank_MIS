package com.example.bankmanagementsystem;

import java.time.LocalDateTime;

public class Transaction {
    private String type;
    private double amount;
    private LocalDateTime timestamp;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return String.format("%s - %s: $%.2f", timestamp, type, amount);
    }
} 