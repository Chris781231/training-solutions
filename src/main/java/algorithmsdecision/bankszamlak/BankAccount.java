package algorithmsdecision.bankszamlak;

public class BankAccount {

    private final String nameOfOwner;
    private final String accountNumber;
    private int balance;

    public BankAccount(String nameOfOwner, String accountNumber, int balance) {
        this.nameOfOwner = nameOfOwner;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public boolean withdraw(int amount) {
        boolean result = (balance >= amount);
        if (result) {
            balance -= amount;
        }
        return result;
    }

    public boolean deposit(int amount) {
        balance += amount;
        return true;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public String getNameOfOwner() {
        return nameOfOwner;
    }
}
