package me.srin.assignment_1;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        out.print("Enter an amount present in the user's wallet: ");
        float amount = sc.nextFloat();
        User user = new User(amount);
        out.println("Choose the following options to perform the respective operations: ");
        out.println("\t1. Enter an amount to deposit");
        out.println("\t2. Enter an amount to withdraw");
        out.println("\t3. Add amount to wallet");
        out.println("\t4. Check balance");
        out.println("\t5. exit");
        int ch = 0;
        while (ch != 5) {
            out.print("--> ");
            ch = sc.nextInt();
            switch (ch) {
                case 1 -> {
                    amount = sc.nextFloat();
                    user.deposit(amount);
                }
                case 2 -> {
                    amount = sc.nextFloat();
                    user.withdraw(amount);
                }
                case 3 -> {
                    out.print("Enter the amount to be added: ");
                    amount = sc.nextFloat();
                    user.addAmountToWallet(amount);
                }
                case 4 -> user.check_balance();
                case 5 -> out.println("bye");
                default -> out.println("wrong choice try again :(");
            }
        }
    }

    static class User {
        private float wallet;
        private final BankAccount bank = new BankAccount();

        User(float wallet) {
            this.wallet = wallet;
        }

        void addAmountToWallet(float amount) { this.wallet += amount; }

        void check_balance() {
            out.printf("Wallet: %.2f\n", wallet);
            bank.check_balance();
        }

        void deposit(float amount) {
            if (amount <= wallet) {
                wallet -= amount;
                bank.deposit(amount);
            } else {
                out.println("wallet was either empty or insufficient amount present :')");
            }
        }

        void withdraw(float amount) {
            if (bank.withdraw(amount)) {
                wallet += amount;
            }
        }
    }
    static class BankAccount {
        private float bank_balance = 0f;

        void check_balance() {
            out.printf("bank balance: %.2f\n", bank_balance);
        }

        void deposit(float amount) {
            bank_balance += amount;
        }

        boolean withdraw(float amount) {
            float new_balance = bank_balance - amount;
            if (new_balance <= 0) {
                out.printf("empty or insufficient balance: %.2f\n", bank_balance);
                return false;
            }
            bank_balance = new_balance;
            return true;
        }
    }
}
