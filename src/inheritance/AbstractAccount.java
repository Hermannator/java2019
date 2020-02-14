package inheritance;

public abstract class AbstractAccount {
	protected double balance;
	protected AbstractAccount() {
		balance = 0;
	}
	protected double getBalance() {return balance;}
	protected void deposit(double amount) {
		if(amount < 0) {
			throw new IllegalArgumentException("Deposit must be positive.");
		}
		balance += amount;
	}
	protected void withdraw(double amount) {
		if(amount < 0) {
			throw new IllegalArgumentException("Withdrawal must be positive.");
		}
		internalWithdraw(amount);
	}
	protected abstract void internalWithdraw(double amount);
}
