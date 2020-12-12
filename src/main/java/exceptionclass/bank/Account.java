package exceptionclass.bank;

public class Account {

    private final String accountNumber;
    private double balance;
    private double maxSubtract = 100_000;

    public Account(String accountNumber, double balance) {
        if (accountNumber == null) {
            throw new IllegalArgumentException("accountnumber is null");
        }
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void setMaxSubtract(double maxSubtract) {
        if (maxSubtract <= 0) {
            throw new InvalidBankOperationException("invalid amount", ErrorCode.INVALID_AMOUNT);
        }
        this.maxSubtract = maxSubtract;
    }

    public void subtract(double amount) {
        if (maxSubtract < amount || amount <= 0) {
            throw new InvalidBankOperationException("invalid amount", ErrorCode.INVALID_AMOUNT);
        }
        if (balance < amount) {
            throw new InvalidBankOperationException("low balance", ErrorCode.LOW_BALANCE);
        }
        balance -= amount;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new InvalidBankOperationException("invalid amount", ErrorCode.INVALID_AMOUNT);
        }
        balance += amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public double getMaxSubtract() {
        return maxSubtract;
    }
}
