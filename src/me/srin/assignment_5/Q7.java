package me.srin.assignment_5;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.*;

import static java.lang.System.*;

public class Q7 {
    private static final BankDB BANK = new Bank();
    public static final Pattern createAccountPattern = Pattern.compile("^create\\s+([a-zA-Z ]+)$");
    public static final Pattern depositPattern = Pattern.compile("^deposit\\s+(\\d+\\.?\\d*)\\s+to\\s+([a-zA-Z ]+)$");
    public static final Pattern withdrawPattern = Pattern.compile("^withdraw\\s+(\\d+\\.?\\d*)\\s+from\\s+([a-zA-Z ]+)$");
    public static final Pattern balancePattern = Pattern.compile("^balance\\s+([a-zA-Z ]+)$");
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(in);
        out.println("Welcome to the Bank of Srinjoy!\n");
        String sb =
                "+--------------------------------------------------------------------------------------------+\n" +
                "|  available commands to use the bank interface:                                             |\n" +
                "+--------------------------------------------------------------------------------------------+\n" +
                "|  create [account name] - creates a new account with the given name                         |\n" +
                "|  deposit [amount] to [account name] - deposits the given amount to the account             |\n" +
                "|  withdraw [amount] from [account name] - withdraws the given amount from the account       |\n" +
                "|  balance [account name] - prints the balance of the account                                |\n" +
                "|  help - prints the list of commands                                                        |\n" +
                "|  exit - exits the bank                                                                     |\n" +
                "+--------------------------------------------------------------------------------------------+\n";
        out.println(sb);
        while (true) try {
            out.print("--> ");
            String command = sc.nextLine();
            if (command.equals("exit")) {
                out.println("Thank you for using the Bank of Srinjoy!");
                break;
            } else if (command.equals("help")) {
                out.println(sb);
            } else if (command.matches(createAccountPattern.pattern())) {
                Matcher matcher = createAccountPattern.matcher(command);
                if (matcher.find()) {
                    String accountName = matcher.group(1);
                    BANK.createAccount(accountName);
                }
            } else if (command.matches(depositPattern.pattern())) {
                Matcher matcher = depositPattern.matcher(command);
                if (matcher.find()) {
                    float amount = Float.parseFloat(matcher.group(1));
                    String accountName = matcher.group(2);
                    BANK.deposit(accountName, amount);
                }
            } else if (command.matches(withdrawPattern.pattern())) {
                Matcher matcher = withdrawPattern.matcher(command);
                if (matcher.find()) {
                    float amount = Float.parseFloat(matcher.group(1));
                    String accountName = matcher.group(2);
                    BANK.withdraw(accountName, amount);
                }
            } else if (command.matches(balancePattern.pattern())) {
                Matcher matcher = balancePattern.matcher(command);
                if (matcher.find()) {
                    String accountName = matcher.group(1);
                    float balance = BANK.balance(accountName);
                    System.out.printf("Amount preset in %s's bank account is %.2f\n", accountName, balance);
                }
            } else throw new IllegalArgumentException("Invalid command: " + command);
        } catch (IllegalArgumentException e) {
            out.println(e.getMessage());
            Thread.sleep(50);
        }
    }
    static class Bank implements BankDB {
        private final HashMap<String, AtomicReference<Float>> accounts = new HashMap<>();
        @Override
        public void createAccount(String name) {
            accounts.putIfAbsent(name, new AtomicReference<>(0f));
            out.println("Account " + name + " created successfully!");
        }

        @Override
        public void deposit(String account, float amount) throws IllegalArgumentException {
            AtomicReference<Float> balance = retrieveAccount(account);
            balance.getAndUpdate(oldAmount -> oldAmount + amount);
            out.println("Deposited " + amount + " to " + account);
        }

        @Override
        public void withdraw(String account, float amount) throws IllegalArgumentException {
            AtomicReference<Float> balance = retrieveAccount(account);
            float oldAmount = balance.get();
            if (oldAmount < amount) throw new IllegalArgumentException("Insufficient balance");
            balance.getAndUpdate(oldAmt -> oldAmt - amount);
            out.println("Withdrew " + amount + " from " + account);
        }

        @Override
        public float balance(String account) throws IllegalArgumentException {
            return retrieveAccount(account).get();
        }
        private AtomicReference<Float> retrieveAccount(String account) throws IllegalArgumentException {
            AtomicReference<Float> balance = accounts.get(account);
            if (balance == null) {
                throw new IllegalArgumentException("Account not found: " + account);
            }
            return balance;
        }
    }
    interface BankDB {
        void createAccount(String name);
        void deposit(String account, float amount) throws IllegalArgumentException;
        void withdraw(String account, float amount) throws IllegalArgumentException;
        float balance(String account) throws IllegalArgumentException;
    }
}
