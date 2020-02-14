package inheritance;

public class BSU extends SavingsAccount {
	private final double depositLimit;
	private double currentYearDeposits;
	public BSU(double interestRate, double depositLimit) {
		super(interestRate);
		this.depositLimit = depositLimit;
		currentYearDeposits = 0;
	}
	public void deposit(double amount) {
		if(amount > depositLimit - currentYearDeposits) {
			throw new IllegalStateException("Deposit cannot exceed remaining deposits this year: " + depositLimit + " kr.");
		}
		super.deposit(amount);
		currentYearDeposits += amount;
	}
	public void withdraw(double amount) {
		if(amount > currentYearDeposits) {
			throw new IllegalStateException("Withdrawal cannot exceed deposits made this year: " + currentYearDeposits + " kr.");
		}
		super.withdraw(amount);
		currentYearDeposits -= amount;
	}
	public void endYearUpdate() {
		super.endYearUpdate();
		currentYearDeposits = 0;
	}
	public double getTaxDeduction() {
		return currentYearDeposits * 0.2;
	}
}
