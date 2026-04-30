import java.util.HashMap;

public class Bank {
    private final HashMap<Integer, Account> AccountLookup = new HashMap<>();

    public HashMap<Integer, Account> getAccountLookup() {
        return AccountLookup;
    }

    public void createAccount(String name, int balance) {
        Account newAccount = new Account(name, balance);
        this.AccountLookup.put(newAccount.getAccountNo(), newAccount);
        System.out.println(getAccount(newAccount.getAccountNo()));
    }

    public Account getAccount(int accountNo) {
        return AccountLookup.get(accountNo);
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
        withdrawAccount.withdrawAmount(amount);
        depositAccount.depositAmount(amount);
    }
}
