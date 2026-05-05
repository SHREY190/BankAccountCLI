import java.util.ArrayList;
import java.util.Scanner;

public class BankCLI {
    private static final Scanner sc = new Scanner(System.in);
    private static final Bank bank = new Bank();

    public void start() {
        System.out.println("\n============================================");
        System.out.println("      💳 BANK ACCOUNT CLI");
        System.out.println("============================================\n");

        boolean isRunning = true;

        while (isRunning) {
            printMenu();
            String choice = sc.nextLine().trim();


            switch (choice) {
                case "1" -> handleCreateAccount();
                case "2" -> handleGetAccountDetails();
                case "3" -> handleDeposit();
                case "4" -> handleWithdraw();
                case "5" -> handleTransfer();
                case "6" -> handleTransactionHistory();
                case "7" -> {
                    System.out.println("Exit application");
                    isRunning = false;
                }
                default -> System.out.println("Invalid Option try again!");
            }
        }
    }

    private void printMenu() {
        System.out.println("Choose from the following operations: ");
        System.out.println("1. Create new Account.");
        System.out.println("2. Get account details.");
        System.out.println("3. Deposit money");
        System.out.println("4. Withdraw money");
        System.out.println("5. Transfer money");
        System.out.println("6. Check Transaction History");
        System.out.println("7. Exit Application");

    }

    private void handleCreateAccount() {
        System.out.print("Enter the account holder's name: ");
        String accountHolderName = sc.nextLine();
        System.out.print("Please provide the initial balance to add in the account: ");
        int initialBalance = Integer.parseInt(sc.nextLine());

        try {
            System.out.println(bank.createAccount(accountHolderName, initialBalance).getAccountNo());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void handleGetAccountDetails() {
        System.out.print("Enter the account ID to fetch its details: ");
        int fetchAccountId = Integer.parseInt(sc.nextLine());
        try {
            System.out.println(bank.getAccount(fetchAccountId));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void handleDeposit() {
        System.out.print("Enter the account ID in which you want to deposit the money: ");
        int depositAccountId = Integer.parseInt(sc.nextLine());
        System.out.print("Enter the amount you want to deposit: ");
        int depositAmount = Integer.parseInt(sc.nextLine());

        try {
            bank.deposit(depositAccountId, depositAmount);
            System.out.println(depositAmount + "rs has been deposited to account " + depositAccountId);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void handleWithdraw() {
        System.out.print("Enter the account ID from which you want to withdraw the money: ");
        int withdrawAccountId = Integer.parseInt(sc.nextLine());
        System.out.print("Enter the amount you want to withdraw: ");
        int withdrawAmount = Integer.parseInt(sc.nextLine());

        try {
            bank.withdraw(withdrawAccountId, withdrawAmount);
            System.out.println(withdrawAmount + "rs has been withdraw from account " + withdrawAccountId);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void handleTransfer() {
        System.out.print("Enter the account ID from which you will be sending money: ");
        int fromAccount = Integer.parseInt(sc.nextLine());
        System.out.print("Enter the account ID to which you want to send the money: ");
        int toAccount = Integer.parseInt(sc.nextLine());
        System.out.print("Enter the amount to transfer: ");
        int transferAmount = Integer.parseInt(sc.nextLine());

        try {
            bank.transfer(fromAccount, toAccount, transferAmount);
            System.out.println(transferAmount + "rs transferred from account " + fromAccount + " to account " + toAccount);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    private void handleTransactionHistory() {
        System.out.println("Enter the account ID to check its transaction history: ");
        int historyAccount = Integer.parseInt(sc.nextLine());
        try {
            ArrayList<Transaction> accountHistory = bank.transactionHistory(historyAccount);
            for (Transaction transaction : accountHistory) {
                System.out.println(transaction.toString());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
