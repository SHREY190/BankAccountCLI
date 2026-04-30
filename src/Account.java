import java.util.Random;

public class Account {
    private int accountNo;
    private String holderName;
    private int balance;

    public int getAccountNo() {
        return accountNo;
    }

    public void depositAmount(int amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }

    public void withdrawAmount(int amount) {
        if (amount > 0 && amount < this.balance) {
            this.balance -= amount;
        }
    }

    public Account(String holderName, int initialBalance) {
        if (!holderName.isEmpty() && !(initialBalance < 0)) {
            this.holderName = holderName;
            this.accountNo = generateAccountNo();
            this.balance = initialBalance;
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNo=" + accountNo +
                ", holderName='" + holderName + '\'' +
                ", balance=" + balance +
                '}';
    }

    private int generateAccountNo() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder(6);

        for (int i = 0; i < 6; i++) {
            if (i == 0) {
                sb.append(rand.nextInt(9) + 1);
            } else {
                sb.append(rand.nextInt(10));
            }
        }

        return Integer.parseInt(sb.toString());
    }
}
