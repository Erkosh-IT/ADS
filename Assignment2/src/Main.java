import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class BankAccount {
    int accountNumber;
    String username;
    double balance;

    public BankAccount(int accountNumber, String username, double balance) {
        this.accountNumber = accountNumber;
        this.username = username;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber + " | Name: " + username + " | Balance: " + balance;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedList<BankAccount> accounts = new LinkedList<>();
        Stack<String> transactionHistory = new Stack<>();
        Queue<String> billQueue = new LinkedList<>();
        Queue<BankAccount> accountRequests = new LinkedList<>();

        int nextAccountNumber = 1001;

        accounts.add(new BankAccount(1000, "Ali", 150000));
        accounts.add(new BankAccount(1001, "Sara", 220000));

        boolean running = true;

        while (running) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Enter Bank");
            System.out.println("2. Enter ATM");
            System.out.println("3. Admin Area");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            int mainChoice = scanner.nextInt();
            scanner.nextLine();

            switch (mainChoice) {
                case 1:
                    boolean bankMenu = true;
                    while (bankMenu) {
                        System.out.println("\n--- BANK MENU ---");
                        System.out.println("1. Submit account opening request");
                        System.out.println("2. Deposit money");
                        System.out.println("3. Withdraw money");
                        System.out.println("4. Pay a bill");
                        System.out.println("5. Back to Main Menu");
                        System.out.print("Select an option: ");

                        int bChoice = scanner.nextInt();
                        scanner.nextLine();

                        if (bChoice == 1) {
                            System.out.print("Enter your name: ");
                            String name = scanner.nextLine();
                            System.out.print("Enter initial deposit: ");
                            double initialDep = scanner.nextDouble();

                            BankAccount newAcc = new BankAccount(nextAccountNumber++, name, initialDep);
                            accountRequests.add(newAcc);
                            System.out.println("Request sent to Admin!");
                        } else if (bChoice == 2) {
                            System.out.print("Enter username: ");
                            String name = scanner.nextLine();
                            BankAccount acc = findAccount(accounts, name);
                            if (acc != null) {
                                System.out.print("Deposit amount: ");
                                double amount = scanner.nextDouble();
                                acc.deposit(amount);
                                System.out.println("New balance: " + acc.balance);
                                transactionHistory.push("Deposit " + amount + " to " + name);
                            } else {
                                System.out.println("Account not found!");
                            }
                        } else if (bChoice == 3) {
                            System.out.print("Enter username: ");
                            String name = scanner.nextLine();
                            BankAccount acc = findAccount(accounts, name);
                            if (acc != null) {
                                System.out.print("Withdraw amount: ");
                                double amount = scanner.nextDouble();
                                if (acc.withdraw(amount)) {
                                    System.out.println("New balance: " + acc.balance);
                                    transactionHistory.push("Withdraw " + amount + " from " + name);
                                } else {
                                    System.out.println("Insufficient funds!");
                                }
                            } else {
                                System.out.println("Account not found!");
                            }
                        } else if (bChoice == 4) {
                            System.out.print("Enter bill name (e.g., Electricity Bill): ");
                            String billName = scanner.nextLine();
                            billQueue.add(billName);
                            System.out.println("Added: " + billName);
                        } else if (bChoice == 5) {
                            bankMenu = false;
                        }
                    }
                    break;

                case 2:
                    boolean atmMenu = true;
                    while (atmMenu) {
                        System.out.println("\n--- ATM MENU ---");
                        System.out.println("1. Balance enquiry");
                        System.out.println("2. Withdraw");
                        System.out.println("3. Back to Main Menu");
                        System.out.print("Select an option: ");

                        int aChoice = scanner.nextInt();
                        scanner.nextLine();

                        if (aChoice == 1) {
                            System.out.print("Enter username: ");
                            String name = scanner.nextLine();
                            BankAccount acc = findAccount(accounts, name);
                            if (acc != null) {
                                System.out.println("Balance: " + acc.balance);
                            } else {
                                System.out.println("Account not found!");
                            }
                        } else if (aChoice == 2) {
                            System.out.print("Enter username: ");
                            String name = scanner.nextLine();
                            BankAccount acc = findAccount(accounts, name);
                            if (acc != null) {
                                System.out.print("Withdraw amount: ");
                                double amount = scanner.nextDouble();
                                if (acc.withdraw(amount)) {
                                    System.out.println("Transaction successful.");
                                    transactionHistory.push("ATM Withdraw " + amount + " from " + name);
                                } else {
                                    System.out.println("Insufficient funds!");
                                }
                            } else {
                                System.out.println("Account not found!");
                            }
                        } else if (aChoice == 3) {
                            atmMenu = false;
                        }
                    }
                    break;

                case 3:
                    boolean adminMenu = true;
                    while (adminMenu) {
                        System.out.println("\n--- ADMIN AREA ---");
                        System.out.println("1. Process account queue");
                        System.out.println("2. Process bill payment queue");
                        System.out.println("3. Display all accounts");
                        System.out.println("4. Undo last transaction");
                        System.out.println("5. View last transaction");
                        System.out.println("6. Display bill queue");
                        System.out.println("7. Display pending account requests");
                        System.out.println("8. Show Task 6 (Array of 3 accounts)");
                        System.out.println("9. Back to Main Menu");
                        System.out.print("Select an option: ");

                        int adChoice = scanner.nextInt();

                        if (adChoice == 1) {
                            if (accountRequests.isEmpty()) {
                                System.out.println("No pending requests.");
                            } else {
                                BankAccount newClient = accountRequests.poll();
                                accounts.add(newClient);
                                System.out.println("Account added successfully: " + newClient.username);
                            }
                        } else if (adChoice == 2) {
                            if (billQueue.isEmpty()) {
                                System.out.println("No bills to process.");
                            } else {
                                String currentBill = billQueue.poll();
                                System.out.println("Processing: " + currentBill);
                                transactionHistory.push("Processed bill: " + currentBill);
                            }
                        } else if (adChoice == 3) {
                            System.out.println("Accounts List:");
                            for (BankAccount account : accounts) {
                                System.out.println(account.toString());
                            }
                        } else if (adChoice == 4) {
                            if (!transactionHistory.isEmpty()) {
                                String lastAction = transactionHistory.pop();
                                System.out.println("Undo " + lastAction + " removed");
                            } else {
                                System.out.println("Transaction history is empty.");
                            }
                        } else if (adChoice == 5) {
                            if (!transactionHistory.isEmpty()) {
                                System.out.println("Last transaction: " + transactionHistory.peek());
                            } else {
                                System.out.println("Transaction history is empty.");
                            }
                        } else if (adChoice == 6) {
                            System.out.println("Bill Queue: " + billQueue);
                        } else if (adChoice == 7) {
                            System.out.println("Pending Account Requests:");
                            for (BankAccount req : accountRequests) {
                                System.out.println(req.username + " (Initial Deposit: " + req.balance + ")");
                            }
                        } else if (adChoice == 8) {
                            BankAccount[] predefinedAccounts = new BankAccount[3];
                            predefinedAccounts[0] = new BankAccount(9001, "Aruzhan", 50000);
                            predefinedAccounts[1] = new BankAccount(9002, "Nurlan", 120000);
                            predefinedAccounts[2] = new BankAccount(9003, "Diyas", 30000);

                            System.out.println("--- Task 6: Predefined Accounts (Array) ---");
                            for (int i = 0; i < predefinedAccounts.length; i++) {
                                System.out.println((i + 1) + ". " + predefinedAccounts[i].username + " - Balance: " + predefinedAccounts[i].balance);
                            }
                        } else if (adChoice == 9) {
                            adminMenu = false;
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting system. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        scanner.close();
    }

    public static BankAccount findAccount(LinkedList<BankAccount> list, String name) {
        for (BankAccount acc : list) {
            if (acc.username.equalsIgnoreCase(name)) {
                return acc;
            }
        }
        return null;
    }
}