package algorithmsdecision.bankszamlak;

import java.util.List;

public class BankAccountDecisionMaker {
    public boolean containsBalanceGreaterThan(List<BankAccount> accounts, int limit) {
        boolean result = false;
        for (BankAccount account : accounts) {
            if (account.getBalance() >= limit) {
                result = true;
            }
        }
        return result;
    }
}
