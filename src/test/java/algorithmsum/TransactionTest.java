package algorithmsum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TransactionTest {

    @Test
    public void testCreateTransaction() {
        Transaction transaction = new Transaction("1234-2345-1231", TransactionOperation.CREDIT, 100000);

        assertEquals(100000, transaction.getAmount());
        assertTrue(transaction.isCredit());
        assertFalse(transaction.isDebit());
    }

}