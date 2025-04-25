package myself;

public class SavingsAccount extends BankAccount {
    private static int savingsNumber = 0;
    private String accountNumber;

    public SavingsAccount(String name, double initialBalance) {
        super(name, initialBalance);
        this.accountNumber = super.getAccountNumber() + "-" + savingsNumber;
        this.savingsNumber++; 
    }

    public void postInterest() {
        double monthlyInterest = getBalance() * (2.5 / 100) / 12;
        deposit(monthlyInterest);  // Add interest to balance
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    public SavingsAccount(SavingsAccount original, double initialBalance) {
        super(original, initialBalance);
        this.accountNumber = super.getAccountNumber() + "-" + this.savingsNumber;
        this.savingsNumber++; 
    }
}
