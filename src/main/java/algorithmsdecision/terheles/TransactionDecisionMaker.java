package algorithmsdecision.terheles;

import java.time.LocalDateTime;
import java.util.List;

public class TransactionDecisionMaker {

    public boolean containsCreditEntryGreaterThan(List<Transaction> transactions, LocalDateTime startTime, LocalDateTime endTime, int amount) {
        for (Transaction transaction : transactions) {
            if (transaction.getDateOfTransaction().isAfter(startTime) &&
                    transaction.getDateOfTransaction().isBefore(endTime) &&
                    transaction.getAmount() >= amount &&
            transaction.getTransactionOperation() == TransactionOperation.DEBIT) {
                return true;
            }
        }
        return false;
    }


}
