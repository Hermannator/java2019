package inheritance;

public class SavingsAccount implements Account {
	private double balance, interestRate;
	public SavingsAccount(double interestRate) {
		this.interestRate = interestRate;
		balance = 0;
	}
	public double getBalance() {return balance;}
	public void deposit(double amount) {
		if(amount < 0) {
			throw new IllegalArgumentException("Deposit must be positive.");
		}
		balance += amount;
	}
	public void withdraw(double amount) {
		if(amount < 0) {
			throw new IllegalArgumentException("Withdrawal must be positive.");
		}
		if(balance - amount < 0) {
			throw new IllegalStateException("Withdrawal cannot exceed balance.");
		}
		balance -= amount;
	}
	public void endYearUpdate() {
		balance += balance * interestRate;
	}
}
