package algorithmsdecision.tranzakciok;

import algorithmsdecision.bankszamlak.BankAccount;
import algorithmsdecision.terheles.Transaction;
import algorithmsdecision.terheles.TransactionStatus;

import java.util.List;

public class TransactionExecutor {
    public void executeTransactions(List<Transaction> transactions, List<BankAccount> accounts) {
        for (Transaction transaction : transactions) {
            BankAccount account = findBankAccount(transaction.getAccountNumber(), accounts);

            if (transaction.isCredit()) {
                account.deposit(transaction.getAmount());
                transaction.setTransactionStatus(TransactionStatus.SUCCEEDED);
            } else {
                if (account.withdraw(transaction.getAmount())) {
                    transaction.setTransactionStatus(TransactionStatus.SUCCEEDED);
                } else {
                    transaction.setTransactionStatus(TransactionStatus.PENDING);
                }
            }
        }
    }

    private BankAccount findBankAccount(String accountNumber, List<BankAccount> accounts) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
}
