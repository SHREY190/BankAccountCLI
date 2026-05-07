public class InvalidAmountValueException extends IllegalArgumentException {
    public InvalidAmountValueException() {
    }

    public InvalidAmountValueException(String message) {
        super(message);
    }

    public InvalidAmountValueException(Throwable cause) {
        super(cause);
    }

    public InvalidAmountValueException(String message, Throwable cause) {
        super(message, cause);
    }
}
