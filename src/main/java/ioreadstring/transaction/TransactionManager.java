package ioreadstring.transaction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TransactionManager {

    private final List<BankAccount> bankAccounts = new ArrayList<>();

    public void uploadListFromFile(String path) {
        try {
            List<String> accounts = Files.readAllLines(Path.of(path));

            for (String account : accounts) {
                String[] temp = account.split(";");
                bankAccounts.add(new BankAccount(temp[0], temp[1], Integer.parseInt(temp[2])));
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Wrong path or filename", e);
        } catch (NumberFormatException e) {
            throw new IllegalStateException("Invalid initial amount in file", e);
        }
    }

    public void makeTransactions(String path) {
        try {
            List<String> transactions = Files.readAllLines(Path.of(path));

            for (String transaction : transactions) {
                String[] transactionDatas = transaction.split(";");
                BankAccount bankAccount = findAccount(transactionDatas[0]);
                if (bankAccount == null) {
                    throw new IllegalStateException("Invalid account number in file");
                }
                bankAccount.setBalance(Integer.parseInt(transactionDatas[1]));
            }

        } catch (IOException e) {
            throw new IllegalArgumentException("Invalid path or filename", e);
        } catch (NumberFormatException e) {
            throw new IllegalStateException("Invalid amount in file", e);
        } catch (NullPointerException e) {
            throw new IllegalStateException("Invalid account number in file", e);
        }
    }

    private BankAccount findAccount(String accountNumber) {
        for (BankAccount bankAccount : bankAccounts) {
            if (bankAccount.getAccountNumber().equals(accountNumber)) {
                return bankAccount;
            }
        }
        return null;
    }

    public List<BankAccount> getAccountList() {
        return new ArrayList<>(bankAccounts);
    }
}
