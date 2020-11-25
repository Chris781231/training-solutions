package staticattrmeth.banktransaction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BankTransactionTest {

    @Test
    public void testOneTransaction() {
        //Given
        BankTransaction.initTheDay();
        BankTransaction bankTransaction = new BankTransaction(10_000);
        //Then
        assertEquals(10_000L, bankTransaction.getTrxValue());
        assertEquals(10_000L, BankTransaction.getCurrentMinValue());
        assertEquals(10_000L, BankTransaction.getCurrentMaxValue());
        assertEquals(10_000L, BankTransaction.getSumOfTrxs());
        assertEquals(10_000L, BankTransaction.averageOfTransaction());
    }

    @Test
    public void testSeveralTransactions() {
        //Given
        BankTransaction.initTheDay();
        new BankTransaction(10_000);
        new BankTransaction(20_000);
        //Then
        assertEquals(10_000L, BankTransaction.getCurrentMinValue());
        assertEquals(20_000L, BankTransaction.getCurrentMaxValue());
        assertEquals(30_000L, BankTransaction.getSumOfTrxs());
        assertEquals(15_000L, BankTransaction.averageOfTransaction());
    }

    @Test
    public void testZeroTransaction() {
        //Given
        BankTransaction.initTheDay();
        //Then
        assertEquals(0L, BankTransaction.getCurrentMinValue());
        assertEquals(0L, BankTransaction.getCurrentMaxValue());
        assertEquals(0L, BankTransaction.getSumOfTrxs());
    }
}