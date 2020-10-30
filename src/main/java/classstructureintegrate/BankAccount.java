package classstructureintegrate;

public class BankAccount {

    private String accountNumber;
    private String owner;
    private int balance;

    public BankAccount(String accountNumber, String owner, int balance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
    }

    public void deposit(int amount) {
        this.balance += amount;
    }

    public void withdraw (int amount) {
        this.balance -= amount;
    }

    public void transfer (BankAccount to, int amount) {
        this.balance -= amount;
        to.balance += amount;
    }

    public String getInfo() {
        return this.owner + " (" + this.accountNumber + "): " + this.balance;
    }
}
