import java.util.ArrayList;
import java.util.HashMap;

public class Bank {
    private final HashMap<Integer, Account> AccountLookup = new HashMap<>();

    public HashMap<Integer, Account> getAccountLookup() {
        return AccountLookup;
    }

    public Account createAccount(String name, int balance) {
        Account newAccount = new Account(name, balance);
        this.AccountLookup.put(newAccount.getAccountNo(), newAccount);
        return getAccount(newAccount.getAccountNo());
    }

    public Account getAccount(int accountNo) {
        Account account = AccountLookup.get(accountNo);
        if (account == null) {
            throw new IllegalArgumentException("Account not found: " + accountNo);
        }
        return account;
    }

    public void deposit(int accountNo, int amount) {
        Account depositAccount = getAccount(accountNo);
        depositAccount.depositAmount(amount);
    }

    public void withdraw(int accountNo, int amount) {
        Account withdrawalAccount = getAccount(accountNo);
        withdrawalAccount.withdrawAmount(amount);
    }

    public void transfer(int fromAccount, int toAccount, int amount) {
        Account withdrawAccount = getAccount(fromAccount);
        Account depositAccount = getAccount(toAccount);
        withdrawAccount.withdrawForTransfer(amount);
        depositAccount.depositForTransfer(amount);
    }

    public ArrayList<Transaction> transactionHistory(int accountNo) {
        Account historyAccount = getAccount(accountNo);
        ArrayList<Transaction> transactions = historyAccount.getTransactions();
        return new ArrayList<>(transactions);
    }
}
