public class BasicAccount implements IAccount {
    private int accountNumber;
    private double balance;
    private double withdrawalLimit;

    // Constructor
    public BasicAccount(int accountNumber, double withdrawalLimit) {
        this.accountNumber = accountNumber;
        this.withdrawalLimit = Math.max(0, withdrawalLimit); // Ensure withdrawal limit is positive
        this.balance = 0; // Default balance
    }

    // Implement deposit method
    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    // Implement withdraw method
    @Override
    public double withdraw(double amount) {
        double maxWithdrawal = Math.min(withdrawalLimit, balance); // Limit by withdrawal limit and balance
        if (amount > maxWithdrawal) {
            balance -= maxWithdrawal;
            return maxWithdrawal;
        }
        balance -= amount;
        return amount;
    }

    // Implement getCurrentBalance method
    @Override
    public double getCurrentBalance() {
        return balance;
    }

    // Implement getAccountNumber method
    @Override
    public int getAccountNumber() {
        return accountNumber;
    }
}
