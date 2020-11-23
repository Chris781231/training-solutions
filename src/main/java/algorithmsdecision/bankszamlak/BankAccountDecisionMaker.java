package algorithmsdecision.bankszamlak;

import java.util.List;

public class BankAccountDecisionMaker {
    public boolean containsBalanceGreaterThan(List<BankAccount> accounts, int limit) {
        for (BankAccount account : accounts) {
            if (account.getBalance() >= limit) {
                return true;
            }
        }
        return false;
    }
}
