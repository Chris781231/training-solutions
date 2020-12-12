package exceptionclass.bank;

import java.util.List;

public class Bank {

    List<Account> accounts;

    public Bank(List<Account> accounts) {
        if (accounts == null) {
            throw new IllegalArgumentException("accountlist is null");
        }
        this.accounts = accounts;
    }


    public void payment(String accountNumber, double amount) {
        Account account = findAccountByAccountNumber(accountNumber);
        account.subtract(amount);
    }

    public void deposit(String accountNumber, double amount) {
        Account account = findAccountByAccountNumber(accountNumber);
        account.deposit(amount);
    }

    private Account findAccountByAccountNumber(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        throw new InvalidBankOperationException("invalid accountnumber", ErrorCode.INVALID_ACCOUNTNUMBER);
    }
}
