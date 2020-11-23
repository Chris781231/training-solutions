package algorithmsdecision.terheles;

import java.time.LocalDateTime;

public class Transaction {

    private final String accountNumber;
    private final TransactionOperation transactionOperation;
    private final int amount;
    private final LocalDateTime dateOfTransaction;
    private TransactionStatus transactionStatus;

    public Transaction(String accountNumber, TransactionOperation transactionOperation, int amount, LocalDateTime dateOfTransaction) {
        this.accountNumber = accountNumber;
        this.transactionOperation = transactionOperation;
        this.amount = amount;
        this.dateOfTransaction = dateOfTransaction;
        this.transactionStatus = TransactionStatus.CREATED;
    }

    public boolean isCredit() {
        return transactionOperation == TransactionOperation.CREDIT;
    }

    public boolean isDebit() {
        return transactionOperation == TransactionOperation.DEBIT;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDateTime getDateOfTransaction() {
        return dateOfTransaction;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public TransactionOperation getTransactionOperation() {
        return transactionOperation;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }
}
