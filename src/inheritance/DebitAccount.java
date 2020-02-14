package inheritance;

public class DebitAccount extends AbstractAccount {
	public void internalWithdraw(double amount) {
		if(balance - amount < 0) {
			throw new IllegalStateException("Balance must be positive.");
		}
		balance -= amount;
	}
}
