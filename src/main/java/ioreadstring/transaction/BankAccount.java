package ioreadstring.transaction;

public class BankAccount {

    private final String name;
    private final String accountNumber;
    private int balance;

    public BankAccount(String name, String accountNumber, int initAmount) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = initAmount;
    }

    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int amount) {
        this.balance += amount;
    }
}
