package inheritancemethods.debitcreditaccounts;

public class DebitAccount {

    public static final double COST = 3.0;
    public static final long MIN_COST = 200;

    private final String accountNumber;
    private long balance;

    public DebitAccount(String accountNumber, long balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public long getBalance() {
        return balance;
    }

    public final long costOfTransaction(long amount) {
        long cost = (long) (amount * COST / 100);

        return Math.max(cost, MIN_COST);
    }

    public boolean transaction(long amount) {
        boolean success = false;
        long debit = amount + costOfTransaction(amount);

        if (debit <= balance) {
            balance -= debit;
            success = true;
        }

        return success;
    }

    public void balanceToZero() {
        balance = 0;
    }
}
