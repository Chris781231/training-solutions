package inheritancemethods.debitcreditaccounts;

public class CreditAccount extends DebitAccount {

    private long overdraftLimit;

    public CreditAccount(String accountNumber, long balance, long overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public long getOverdraftLimit() {
        return overdraftLimit;
    }

    @Override
    public boolean transaction(long amount) {
        boolean success = false;
        long debit = amount + costOfTransaction(amount);

        if (debit <= getBalance() + overdraftLimit) {
            if (amount <= getBalance()) {
                success = super.transaction(amount);
            } else {
                long creditAccountDebit = debit - getBalance();
                super.balanceToZero();
                overdraftLimit -= creditAccountDebit;
                success = true;
            }
        }

        return success;
    }
}
