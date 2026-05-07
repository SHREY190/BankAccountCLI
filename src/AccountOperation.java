public interface AccountOperation {

    void depositAmount(int amount);

    void withdrawAmount(int amount) throws InsufficientBalanceException;
}
