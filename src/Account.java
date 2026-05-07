import java.util.ArrayList;
import java.util.Random;

public class Account {
    private final int accountNo;
    private final String holderName;
    private int balance;
    private final ArrayList<Transaction> transactions = new ArrayList<>();

    public int getAccountNo() {
        return accountNo;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void depositAmount(int amount) {
        if (amount <= 0) {
            throw new InvalidAmountValueException("Deposit amount should be greater than zero.");
        } else {
            long millis = System.currentTimeMillis();
            Transaction depositTransaction = new Transaction(TransactionType.DEPOSIT, amount, millis);
            this.transactions.add(depositTransaction);
            this.balance += amount;
        }
    }

    public void depositForTransfer(int amount) {
        if (amount <= 0) {
            throw new InvalidAmountValueException("Transfer amount should be greater than zero.");
        } else {
            long millis = System.currentTimeMillis();
            Transaction depositTransaction = new Transaction(TransactionType.TRANSFER, amount, millis, this.accountNo);
            this.transactions.add(depositTransaction);
            this.balance += amount;
        }
    }

    public void withdrawAmount(int amount) throws InsufficientBalanceException {
        if (amount <= 0) {
            throw new InvalidAmountValueException("Withdrawal amount should be greater than 0.");
        } else if (amount > this.balance) {
            throw new InsufficientBalanceException("Withdrawal amount cannot be greater than the balance.");
        } else {
            long millis = System.currentTimeMillis();
            Transaction withdrawTransaction = new Transaction(TransactionType.WITHDRAW, amount, millis);
            this.transactions.add(withdrawTransaction);
            this.balance -= amount;
        }
    }

    public void withdrawForTransfer(int amount) throws InsufficientBalanceException {
        if (amount <= 0) {
            throw new InvalidAmountValueException("Transfer amount should be greater than 0.");
        } else if (amount > this.balance) {
            throw new InsufficientBalanceException("Transfer amount cannot be greater than the balance.");
        } else {
            long millis = System.currentTimeMillis();
            Transaction withdrawTransaction = new Transaction(TransactionType.WITHDRAW, amount, millis, this.accountNo);
            this.transactions.add(withdrawTransaction);
            this.balance -= amount;
        }
    }

    public Account(String holderName, int initialBalance) {
        if (holderName.isEmpty()) {
            throw new IllegalArgumentException("Account holder name cannot be empty");
        } else if (initialBalance < 0) {
            throw new InvalidAmountValueException("Account balance cannot be empty");
        } else {
            this.holderName = holderName;
            this.accountNo = generateAccountNo(6);
            this.balance = initialBalance;
        }
    }

    private int generateAccountNo(int accountNoLength) {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder(accountNoLength);

        for (int i = 0; i < accountNoLength; i++) {
            if (i == 0) {
                sb.append(rand.nextInt(9) + 1);
            } else {
                sb.append(rand.nextInt(10));
            }
        }

        return Integer.parseInt(sb.toString());
    }
}
