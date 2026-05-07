public class Transaction {
    private final TransactionType type;
    private final int amount;
    private final long timestamp;
    private int cashTransactionId;
    private int receiverAccountId;
    private int senderAccountId;

    public Transaction(TransactionType type, int amount, long timestamp) {
        this.type = type;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public Transaction(TransactionType type, int amount, long timestamp, int cashTransactionId) {
        this.type = type;
        this.amount = amount;
        this.timestamp = timestamp;
        this.cashTransactionId = cashTransactionId;
    }

    public Transaction(TransactionType type, int amount, long timestamp, int receiverAccountId, int senderAccountId) {
        this.type = type;
        this.amount = amount;
        this.timestamp = timestamp;
        this.receiverAccountId = receiverAccountId;
        this.senderAccountId = senderAccountId;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "type=" + type +
                ", amount=" + amount +
                ", timestamp=" + timestamp +
                ", cashTransactionId=" + cashTransactionId +
                ", receiverAccountId=" + receiverAccountId +
                ", senderAccountId=" + senderAccountId +
                '}';
    }
}
