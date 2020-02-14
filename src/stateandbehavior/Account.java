package stateandbehavior;

public class Account {
	double balance, interestRate;
	public void deposit(double amount) {
		if(amount >= 0) {
			balance += amount;
		} else {
			System.out.println("Deposit must be positive.");
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
		interestRate = newRate;
	}
	public String toString() {
		return("Balance: " + this.getBalance() + "\nInterest Rate: " + this.getInterestRate() + "\n");
	}
	public static void main(String[] args) {
		Account a = new Account();
		a.deposit(5000);
		a.setInterestRate(1.5);
		System.out.println(a);
		a.addInterest();
		System.out.println(a);
	}
}