package encapsulation;

public class Account {
	private double balance, interestRate;
	public Account(double balance,double interestRate) {
		if(this.valid(balance) && this.valid(interestRate)) {
			this.balance = balance;
			this.interestRate = interestRate;
		}
	}
	private boolean valid(double i) {
		if(i<0) {
			throw new IllegalArgumentException("Input must be positive.");
		}
		return true;
	}
	public void deposit(double amount) {
		if(this.valid(amount)) {
			balance += amount;
		}
	}
	public void withdraw(double amount) {
		if(this.valid(amount)) {
			if(balance - amount < 0) {
				throw new IllegalArgumentException("Withdrawal exceeds balance.");
			}else {
				balance -= amount;
			}
		}
	}
	public void addInterest() {
		balance += balance*interestRate/100;
	}
	public double getBalance() {
		return balance;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double newRate) {
		if(this.valid(newRate)) {
			interestRate = newRate;
		}
	}
	public String toString() {
		return("Balance: " + this.getBalance() + "\nInterest Rate: " + this.getInterestRate() + "\n");
	}
	public static void main(String[] args) {
		Account a = new Account(3000,1.5);
		System.out.println(a);
		a.addInterest();
		System.out.println(a);
		a.deposit(3000);
		System.out.println(a);
		a.withdraw(2000);
		System.out.println(a);
		a.setInterestRate(2);
		System.out.println(a);
		a.withdraw(5000);
		System.out.println(a);
	}
}