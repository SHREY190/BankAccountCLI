import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Bank {
    private final HashMap<Integer, Account> accountLookup = JsonStorageManager.getStoredAccounts();

    public Set<Integer> getAllAccounts() {
        return accountLookup.keySet();
    }

    public Account createAccount(String name, int balance) {
        Account newAccount = new Account(name, balance);
        accountLookup.put(newAccount.getAccountNo(), newAccount);
        JsonStorageManager.storeAccounts(accountLookup);
        return getAccount(newAccount.getAccountNo());
    }

    public Account getAccount(int accountNo) {
        Account account = accountLookup.get(accountNo);
        if (account == null) {
            throw new AccountNotFoundException("Could not find any account with Account No.: " + accountNo);
        }
        return account;
    }

    public void deposit(int accountNo, int amount) {
        Account depositAccount = getAccount(accountNo);
        depositAccount.depositAmount(amount);
        JsonStorageManager.updateAccount(accountNo, accountLookup.get(accountNo));
    }

    public void withdraw(int accountNo, int amount) throws InsufficientBalanceException {
        Account withdrawalAccount = getAccount(accountNo);
        withdrawalAccount.withdrawAmount(amount);
        JsonStorageManager.updateAccount(accountNo, accountLookup.get(accountNo));

    }

    public void transfer(int fromAccount, int toAccount, int amount) throws InsufficientBalanceException {
        Account withdrawAccount = getAccount(fromAccount);
        Account depositAccount = getAccount(toAccount);
        withdrawAccount.withdrawForTransfer(amount, toAccount);
        depositAccount.depositForTransfer(amount, fromAccount);
        JsonStorageManager.updateAccount(fromAccount, accountLookup.get(fromAccount));
        JsonStorageManager.updateAccount(toAccount, accountLookup.get(toAccount));
    }

    public ArrayList<Transaction> transactionHistory(int accountNo) {
        Account historyAccount = getAccount(accountNo);
        ArrayList<Transaction> transactions = historyAccount.getTransactions();
        return new ArrayList<>(transactions);
    }
}
