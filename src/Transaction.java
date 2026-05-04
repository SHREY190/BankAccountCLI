public class Transaction {
    private TransactionType type;
    private int amount;
    private long timestamp;
    private int targetAccountId;

    public Transaction(TransactionType type, int amount, long timestamp, int targetAccountId) {
        this.type = type;
        this.amount = amount;
        this.timestamp = timestamp;
        this.targetAccountId = targetAccountId;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "type=" + type +
                ", amount=" + amount +
                ", timestamp=" + timestamp +
                ", targetAccountId=" + targetAccountId +
                '}';
    }
}
