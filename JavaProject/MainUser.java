
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
    }
}

class BankAccountManager {
    private Map<String, BankAccount> accounts = new HashMap<>();

    public void addAccount(String accountNumber, String accountHolder) {
        if (!accounts.containsKey(accountNumber)) {
            BankAccount newAccount = new BankAccount(accountNumber, accountHolder);
            accounts.put(accountNumber, newAccount);
            System.out.println("Account created successfully.");
        } else {
            System.out.println("Account number already exists.");
        }
    }

    public BankAccount getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public void removeAccount(String accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            accounts.remove(accountNumber);
            System.out.println("Account removed successfully.");
        } else {
            System.out.println("Account not found.");
        }
    }

    public void deposit(String accountNumber, double amount) {
        BankAccount account = getAccount(accountNumber);
        if (account != null) {
            account.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void withdraw(String accountNumber, double amount) {
        BankAccount account = getAccount(accountNumber);
        if (account != null) {
            account.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void displayAccountDetails(String accountNumber) {
        BankAccount account = getAccount(accountNumber);
        if (account != null) {
            account.displayDetails();
        } else {
            System.out.println("Account not found.");
        }
    }
}

public class MainUser {
    public static void main(String[] args) {
        BankAccountManager manager = new BankAccountManager();
        Scanner scanner = new Scanner(System.in);
        String accountNumber, accountHolder;
        double amount;
        int choice;

        while (true) {
            System.out.println("\nBank Account Management System:");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Remove Account");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();// consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    System.out.print("Enter account holder name: ");
                    accountHolder = scanner.nextLine();
                    manager.addAccount(accountNumber, accountHolder);
                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    System.out.print("Enter amount to deposit: ");
                    amount = scanner.nextDouble();
                    manager.deposit(accountNumber, amount);
                    break;
                case 3:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    System.out.print("Enter amount to withdraw: ");
                    amount = scanner.nextDouble();
                    manager.withdraw(accountNumber, amount);
                    break;
                case 4:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    manager.displayAccountDetails(accountNumber);
                    break;
                case 5:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    manager.removeAccount(accountNumber);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

