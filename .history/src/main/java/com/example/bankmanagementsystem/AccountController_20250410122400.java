package com.example.bankmanagementsystem;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import java.util.Random;

public class AccountController {
    @FXML private ComboBox<String> accountTypeCombo;
    @FXML private TextField initialBalanceField;
    @FXML private TextField amountField;
    @FXML private TextArea accountInfoArea;
    @FXML private TextArea transactionArea;

    private BankAccount currentAccount;
    private Random random = new Random();

    @FXML
    public void initialize() {
        accountTypeCombo.setItems(FXCollections.observableArrayList("Savings", "Current", "Fixed Deposit"));
    }

    @FXML
    private void createAccount() {
        try {
            String accountType = accountTypeCombo.getValue();
            double initialBalance = Double.parseDouble(initialBalanceField.getText());
            String accountNumber = generateAccountNumber();

            switch (accountType) {
                case "Savings":
                    currentAccount = new SavingsAccount(accountNumber, initialBalance);
                    break;
                case "Current":
                    currentAccount = new CurrentAccount(accountNumber, initialBalance);
                    break;
                case "Fixed Deposit":
                    currentAccount = new FixedDepositAccount(accountNumber, initialBalance, 12); // 12 months term
                    break;
            }

            updateAccountInfo();
        } catch (NumberFormatException e) {
            showAlert("Invalid Input", "Please enter a valid number for the initial balance.");
        }
    }

    @FXML
    private void deposit() {
        if (currentAccount == null) {
            showAlert("No Account", "Please create an account first.");
            return;
        }

        try {
            double amount = Double.parseDouble(amountField.getText());
            currentAccount.deposit(amount);
            updateAccountInfo();
            amountField.clear();
        } catch (NumberFormatException e) {
            showAlert("Invalid Input", "Please enter a valid amount.");
        }
    }

    @FXML
    private void withdraw() {
        if (currentAccount == null) {
            showAlert("No Account", "Please create an account first.");
            return;
        }

        try {
            double amount = Double.parseDouble(amountField.getText());
            if (currentAccount.withdraw(amount)) {
                updateAccountInfo();
                amountField.clear();
            } else {
                showAlert("Withdrawal Failed", "Insufficient funds or withdrawal not allowed.");
            }
        } catch (NumberFormatException e) {
            showAlert("Invalid Input", "Please enter a valid amount.");
        }
    }

    private void updateAccountInfo() {
        if (currentAccount != null) {
            accountInfoArea.setText(String.format(
                "Account Number: %s\n" +
                "Account Type: %s\n" +
                "Balance: $%.2f",
                currentAccount.getAccountNumber(),
                currentAccount.getAccountType(),
                currentAccount.getBalance()
            ));

            transactionArea.setText(currentAccount.getLastNTransactions(10));
        }
    }

    private String generateAccountNumber() {
        return String.format("%08d", random.nextInt(100000000));
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
} 