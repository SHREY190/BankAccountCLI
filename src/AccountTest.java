import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {

    @Test
    public void depositIncreasesBalance() {
        Account account = new Account("John", 5000);

        account.depositAmount(500);
        assertEquals(5500, account.getBalance());
    }

    @Test
    public void withdrawDecreasesBalance() throws InsufficientBalanceException {
        Account account = new Account("John", 5000);
        account.withdrawAmount(550);
        assertEquals(4450, account.getBalance());
    }
}