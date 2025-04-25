package myself;

public class CheckingAccount extends BankAccount {
	private static double FEE = 0.15;
	
	public CheckingAccount(String name, double initialAmount) {
		super(name, initialAmount);
		setAccountNumber(getAccountNumber()+"-10");
	}
	
	public boolean withdraw(double amount) {
		if((amount + FEE) > getBalance()) {
			return false;
		}
		setBalance(getBalance() - (amount + FEE));
		return true;
	}
}
