public class Transaction {
    private final TransactionType type;
    private final int amount;
    private final long timestamp;
    private int targetAccountId;

    public Transaction(TransactionType type, int amount, long timestamp) {
        this.type = type;
        this.amount = amount;
        this.timestamp = timestamp;
    }

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
