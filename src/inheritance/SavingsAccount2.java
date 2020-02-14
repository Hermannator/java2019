package inheritance;

public class SavingsAccount2 extends AbstractAccount {
	private int withdrawals;
	private double extraWithdrawalFee;
	public SavingsAccount2(int withdrawals, double extraWithdrawalFee) {
		this.withdrawals = withdrawals;
		this.extraWithdrawalFee = extraWithdrawalFee;
	}
	public void internalWithdraw(double amount) {
		if(balance - amount < 0) {
			throw new IllegalStateException("Balance must be positive!");
		}
		if(withdrawals == 0) {
			if(balance - amount - extraWithdrawalFee < 0) {
				throw new IllegalStateException("You cannot afford the withdrawal fee!");
			}
			balance -= extraWithdrawalFee;
		}else {
			withdrawals--;
		}
		balance -= amount;
	}
}
