import java.util.List;

public interface IBank {
    void openAccount(IAccount account); // Add an account to the bank
    void closeAccount(int accountNumber); // Close an account based on its number
    List<IAccount> getAllAccounts(); // Get all accounts in the bank
    List<IAccount> getAllAccountsInDebt(); // Get all accounts with negative balance
    List<IAccount> getAllAccountsWithBalance(double minimumBalance); // Get accounts with balance above a threshold
}
