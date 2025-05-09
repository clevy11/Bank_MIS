# Bank Management System

A JavaFX-based banking application that demonstrates Object-Oriented Programming principles and provides a user-friendly interface for managing different types of bank accounts.

## Features

- **Multiple Account Types**
  - Savings Account (with minimum balance and interest)
  - Current Account (with overdraft facility)
  - Fixed Deposit Account (with maturity date and higher interest)

- **Core Banking Operations**
  - Account Creation
  - Deposits
  - Withdrawals
  - Balance Inquiry
  - Transaction History

- **User Interface**
  - Welcome Screen
  - Account Management Dashboard
  - Transaction History Display
  - Error Handling and Validation

## Technical Implementation

- **Object-Oriented Programming**
  - Inheritance
  - Polymorphism
  - Abstract Classes
  - Interfaces
  - Constructor Chaining

- **Data Structures**
  - Linked List for Transaction History
  - Efficient Data Management

- **JavaFX Features**
  - Modern UI Design
  - Scene Navigation
  - Event Handling
  - Input Validation

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── example/
│   │           └── bankmanagementsystem/
│   │               ├── HelloApplication.java
│   │               ├── HelloController.java
│   │               ├── AccountController.java
│   │               ├── BankAccount.java
│   │               ├── AbstractAccount.java
│   │               ├── SavingsAccount.java
│   │               ├── CurrentAccount.java
│   │               ├── FixedDepositAccount.java
│   │               └── Transaction.java
│   └── resources/
│       └── com/
│           └── example/
│               └── bankmanagementsystem/
│                   ├── hello-view.fxml
│                   └── account-view.fxml
```

## How to Run

1. Clone the repository
2. Open the project in your preferred Java IDE
3. Run `HelloApplication.java`
4. Click the "Welcome" button to access the account management system

## Usage

1. **Creating an Account**
   - Select account type from dropdown
   - Enter initial balance
   - Click "Create Account"

2. **Making Transactions**
   - Enter amount in the amount field
   - Click "Deposit" or "Withdraw"
   - View transaction history below

3. **Viewing Information**
   - Account details are displayed in the Account Information section
   - Transaction history shows the last 10 transactions

## Requirements

- Java 17 or higher
- JavaFX 17 or higher
- Maven (for dependency management)

## Dependencies

- JavaFX
- Java SE Development Kit

## Contributing

Feel free to fork the repository and submit pull requests for any improvements or bug fixes.

## License

This project is open-source and available under the MIT License.
