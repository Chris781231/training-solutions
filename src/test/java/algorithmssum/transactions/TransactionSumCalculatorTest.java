package algorithmssum.transactions;

import algorithmssum.transactions.Transaction;
import algorithmssum.transactions.TransactionOperation;
import algorithmssum.transactions.TransactionSumCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class TransactionSumCalculatorTest {

    @Test
    public void testSumAmountOfCreditEntries() {

        TransactionSumCalculator calculator = new TransactionSumCalculator();

        List<Transaction> transactions = Arrays.asList(
                new Transaction("1234-2345-1231", TransactionOperation.CREDIT, 100000),
                new Transaction("1234-2345-1231", TransactionOperation.DEBIT, 500),
                new Transaction("1234-2345-1231", TransactionOperation.CREDIT, 0),
                new Transaction("1234-2345-1231", TransactionOperation.CREDIT, 1),
                new Transaction("1234-2345-1231", TransactionOperation.CREDIT, -200),
                new Transaction("1234-2345-1231", TransactionOperation.DEBIT, 100000)
        );

        Assertions.assertEquals(99801, calculator.sumAmountOfCreditEntries(transactions));

    }

}
