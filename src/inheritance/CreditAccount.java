package inheritance;

public class CreditAccount extends AbstractAccount {
	private double creditLine;
	public CreditAccount(double creditLine) {
		setCreditLine(creditLine);
	}
	public double getCreditLine() {return creditLine;}
	public void setCreditLine(double creditLine) {
		if(creditLine < 0) {
			throw new IllegalArgumentException("Credit line must be positive.");
		}
		if(balance + creditLine < 0) {
			throw new IllegalStateException("Credit line must cover negative balance.");
		}
		this.creditLine = creditLine;
	}
	public void internalWithdraw(double amount) {
		if(balance - amount + creditLine < 0) {
			throw new IllegalStateException("Negative balance cannot exceed credit line.");
		}
		balance -= amount;
	}
}
