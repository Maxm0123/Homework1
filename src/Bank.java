import java.util.ArrayList;
import java.util.List;

public class Bank implements IBank {
    private List<IAccount> accounts;

    // Constructor
    public Bank() {
        accounts = new ArrayList<>();
    }

    @Override
    public void openAccount(IAccount account) {
        accounts.add(account);
    }

    @Override
    public void closeAccount(int accountNumber) {
        for (IAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                if (account.getCurrentBalance() < 0) {
                    System.out.println("Cannot close account due to negative balance.");
                    return;
                }
                accounts.remove(account);
                return;
            }
        }
    }

    @Override
    public List<IAccount> getAllAccounts() {
        return new ArrayList<>(accounts);
    }

    @Override
    public List<IAccount> getAllAccountsInDebt() {
        List<IAccount> accountsInDebt = new ArrayList<>();
        for (IAccount account : accounts) {
            if (account.getCurrentBalance() < 0) {
                accountsInDebt.add(account);
            }
        }
        return accountsInDebt;
    }

    @Override
    public List<IAccount> getAllAccountsWithBalance(double minimumBalance) {
        List<IAccount> accountsWithBalance = new ArrayList<>();
        for (IAccount account : accounts) {
            if (account.getCurrentBalance() > minimumBalance) {
                accountsWithBalance.add(account);
            }
        }
        return accountsWithBalance;
    }
}
