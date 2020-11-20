package algorithmscount.bankaccount;

import java.util.List;

public class BankAccountConditionCounter {


    public int countWithBalanceGreaterThan(List<BankAccount> bankAccounts, int greaterThanThis) {

        int count = 0;

        for (BankAccount bankAccount : bankAccounts) {
            if (bankAccount.getBalance() > greaterThanThis) {
                count++;
            }
        }

        return count;
    }
}
