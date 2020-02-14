package inheritance;

public class ForeldreSpar extends SavingsAccount {
	private final int withdrawalLimit;
	private int withdrawalsMade;
	public ForeldreSpar(double interestRate, int withdrawalLimit) {
		super(interestRate);
		this.withdrawalLimit = withdrawalLimit;
		this.withdrawalsMade = 0;
	}
	public int getRemainingWithdrawals() {return withdrawalLimit - withdrawalsMade;}
	public void withdraw(double amount) {
		if(getRemainingWithdrawals() == 0) {
			throw new IllegalStateException("No remaining withdrawals.");
		}
		super.withdraw(amount);
		withdrawalsMade++;
	}
	public void endYearUpdate() {
		super.endYearUpdate();
		withdrawalsMade = 0;
	}
}
