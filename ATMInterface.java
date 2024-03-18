package atm_interface;

import java.util.Scanner;

class Account {
    private double balance;

    public Account(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds.");
        }
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        Account account = new Account(1000.0); // Initial balance

        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        while (!exit) {
            System.out.println("ATM Interface:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Current Balance: " + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println("Deposit successful. New balance: " + account.getBalance());
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    account.withdraw(withdrawalAmount);
                    System.out.println("Withdrawal successful. Remaining balance: " + account.getBalance());
                    break;
                case 4:
                    System.out.println("Thank you for using our ATM. Visit Again!");
                    System.out.println("Thank You ):");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
            System.out.println();
        }

        scanner.close();
    }
}
