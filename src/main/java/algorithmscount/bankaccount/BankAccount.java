package algorithmscount.bankaccount;

public class BankAccount {

    private final String nameOfOwner;
    private final String accountNumber;
    private final double balance;

    public BankAccount(String nameOfOwner, String accountNumber, double balance) {
        this.nameOfOwner = nameOfOwner;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getNameOfOwner() {
        return nameOfOwner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
}
