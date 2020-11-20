package algorithmscount.transactions;

import java.util.List;

public class TransactionCounter {


    public int countEntryLessThan(List<Transaction> transactions, int lessThanThis) {

        int count = 0;

        for (Transaction transaction : transactions) {
            if (transaction.getAmount() < lessThanThis) {
                count++;
            }
        }

        return count;
    }
}
